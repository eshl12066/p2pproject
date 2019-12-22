package com.gg.microservicebusinessproviderhystrix.controller;

import com.gg.microservicebusinessproviderhystrix.service.RefundDetailService;
import com.gg.microservicecommon.entity.business.Bid;
import com.gg.microservicecommon.entity.business.BidRequest;
import com.gg.microservicecommon.entity.business.RefundDetail;
import com.gg.microservicecommon.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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







}