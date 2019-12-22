package com.gg.microservicebusinessproviderhystrix.controller;

import com.gg.microservicebusinessproviderhystrix.service.RefundDetailService;
import com.gg.microservicecommon.entity.business.BidRequest;
import com.gg.microservicecommon.entity.business.Bid;
import com.gg.microservicecommon.entity.business.BidRequest;
import com.gg.microservicecommon.entity.business.RefundDetail;
import com.gg.microservicecommon.util.Query;
import com.gg.microservicecommon.util.R;
import io.swagger.annotations.ApiOperation;
import com.gg.microservicecommon.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @ApiOperation(value = "查找会员",notes = "")
    public R selectMembers(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp, Bid bid, BidRequest bidRequest) {
        String id = req.getParameter("id");
        Map map = this.refundDetailService.selectrefdPager(Integer.valueOf(id));
//        if(map.get("month_index")!=null){
//            if("1".equals(map.get("month_index").toString())){
//                map.put("month_index","第一期");
//            }
//            if("2".equals(map.get("month_index").toString())){
//                map.put("month_index","第二期");
//            }
//        }
        R r = new R();
        r.put("data",map);
        return r;
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
    public void insertBidRequest(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp, BidRequest bidRequest,RefundDetail refundDetail) {

        int ys = bidRequest.getMonthesReturn();

        for (int a = 1; a <= ys; a++){
            refundDetail.setTotalAmount((bidRequest.getBidRequestAmount()+bidRequest.getTotalRewardAmount())/ys);
            refundDetail.setMonthIndex(a);
            Date date = new Date();
            date.setMonth(date.getMonth()+a);
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
        int update = this.refundDetailService.update(query);
        int bid_request_id = (int)params.get("bid_request_id");
        int n = 0;
        if(this.refundDetailService.selecthkys(bid_request_id) == this.refundDetailService.selectyhys(bid_request_id)){
            n = this.refundDetailService.updatebidreq(bid_request_id);
        }
        return update>0 ? R.ok("还款成功") : R.error(-1,"还款失败");
    }


}