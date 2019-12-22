package com.gg.microservicebusinessproviderhystrix.controller;

import com.gg.microservicebusinessproviderhystrix.service.BidRequestService;
import com.gg.microservicecommon.entity.business.BidRequest;
import com.gg.microservicecommon.entity.member.Members;
import com.gg.microservicecommon.util.PageUtils;
import com.gg.microservicecommon.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (BidRequest)表控制层
 *
 * @author makejava
 * @since 2019-12-12 20:59:25
 */
@Api(description = "借贷管理界面")
@RestController
@RequestMapping("bidRequest")
public class BidRequestController {

    /**
     * 服务对象
     */
    @Resource
    private BidRequestService bidRequestService;

//    /**
//     *redis模板
//     * required=false 是开启懒加载
//     */
//    @Autowired(required = false)
//    private RedisTemplate redisTemplate;

    /**
     *  增加借贷
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("insertBidRequest")
    @ApiOperation(value = "增加单个",notes = "用户登录后，增加借贷")
    public R insertBidRequest(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp,BidRequest bidRequest) {

        //投标表增加
        Date date = new Date();
        bidRequest.setDisableDays(14);
        bidRequest.setApplyTime(date);
        date.setDate(Integer.parseInt(date.getDate() + "")+14);
        bidRequest.setDisableDate(date);
        int i = this.bidRequestService.insertBidRequest(bidRequest);

        Map<String,Object> map = new HashMap<>();
        map.put("membersId",bidRequest.getMembersId());
        this.bidRequestService.updateMembersId(map);

        return i > 0 ? R.ok("增加成功") : R.error(-1,"增加失败");
    }

    /**
     * 在用户登录后，贷款之前，先判断该用户是否符合条件
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public BidRequest selectOne(Integer id) {
        return this.bidRequestService.queryById(id);
    }


    /**
     * 用户贷款信息
     * @param params
     * @param id
     * @return
     */
    @RequestMapping("selectUserBidRequest")
    public List<Map<String,Object>> selectUserBidRequest(@RequestParam Map<String,Object> params, Integer id) {
        System.out.println("投标界面传过来的id："+id);
        List<Map<String, Object>> list = this.bidRequestService.selectUserBidRequest(id);
        return list;
    }


    /**
     * 查询所有借贷，加上模糊查
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("bidRequestQuery")
    @ApiOperation(value = "查询所有",notes = "查询到的数据是分页的，并且也可以传入参数进行查询")
    public PageUtils bidRequestQuery(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {

        return null;
    }



    /**
     * 删除借贷
     * @param params 前台传过来的参数集
     * @param req
     * @param resp 全局的respons相应全局的request请求
     * @return
     */
    @RequestMapping("bidRequestDel")
    @ApiOperation(value = "删除单个",notes = "删除借贷")
    public R bidRequestDel(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
    /**
     * 修改借贷
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("bidRequestUpdate")
    @ApiOperation(value = "修改单个",notes = "跟据传过来的id进行一个信息修改")
    public R bidRequestUpdate(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }




}