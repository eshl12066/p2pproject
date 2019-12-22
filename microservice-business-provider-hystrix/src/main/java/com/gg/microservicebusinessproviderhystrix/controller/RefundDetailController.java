package com.gg.microservicebusinessproviderhystrix.controller;


import com.gg.microservicebusinessproviderhystrix.service.BidRequestService;
import com.gg.microservicebusinessproviderhystrix.service.RefundDetailService;
import com.gg.microservicecommon.entity.business.BidRequest;
import com.gg.microservicecommon.entity.business.RefundDetail;
import com.gg.microservicecommon.util.Query;
import com.gg.microservicecommon.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (RefundDetail)表控制层
 *
 * @author makejava
 * @since 2019-12-13 10:05:12
 */
@Api(description = "还款管理界面")
@RestController
@RequestMapping("refundDetail")
public class RefundDetailController {
    /**
     * 服务对象
     */
    @Resource
    private RefundDetailService refundDetailService;

    @Resource
    private BidRequestService bidRequestService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RefundDetail selectOne(Integer id) {
        return this.refundDetailService.queryById(id);
    }


    /**
     * 根据用户id查询未还款的还款信息selectrefdPager
     */
    @RequestMapping("selectrefdPager")
    @ApiOperation(value = "查询未还款",notes = "")
    public List<Map<String, Object>> selectrefd(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(params);
        List<Map<String, Object>> map = this.refundDetailService.selectrefd(query);
        return map;
    }


    /**
     *  增加还款
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("insertBidRequest")
    @ApiOperation(value = "增加单个",notes = "用户登录后，增加借贷")
    public void insertBidRequest(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp, RefundDetail refundDetail) {
        System.out.println("id"+params.get("id"));
        int id = Integer.parseInt(params.get("id").toString());
        System.err.println("id"+id);
        BidRequest bidRequest = bidRequestService.queryById(id);

        int ys = bidRequest.getMonthesReturn();

        for (int a = 1; a <= ys; a++){
            refundDetail.setTotalAmount((bidRequest.getBidRequestAmount()+bidRequest.getTotalRewardAmount())/ys);
            refundDetail.setMonthIndex(a);
            Date date = new Date();
            date.setMonth(date.getMonth()+a);
            refundDetail.setPayDate(date);
            refundDetail.setPrincipal(bidRequest.getBidRequestAmount()/ys);
            refundDetail.setInterest(bidRequest.getTotalRewardAmount()/ys);
            refundDetail.setState(1);
            refundDetail.setBidRequestTitle(bidRequest.getTitle());
            refundDetail.setMembersId(bidRequest.getMembersId());
            refundDetail.setBidRequestId(bidRequest.getId());
            System.out.println("还款表信息：+++++"+refundDetail);
            this.refundDetailService.insert(refundDetail);
        }
    }

    /**
     * 修改还款状态
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("updatehkzt")
    @ApiOperation(value = "修改单个",notes = "跟据传过来的id进行一个信息修改")
    public R setdictUpdate(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(params);
        int update = this.refundDetailService.updatestate(Integer.parseInt(params.get("id").toString()));


        int bid_request_id = Integer.parseInt(params.get("bid_request_id").toString());
        int n = 0;
        if(this.refundDetailService.selecthkys(bid_request_id) == this.refundDetailService.selectyhys(bid_request_id)){
            n = this.refundDetailService.updatebidreq(bid_request_id);
        }
        return update>0 ? R.ok("还款成功") : R.error(-1,"还款失败");
    }




}