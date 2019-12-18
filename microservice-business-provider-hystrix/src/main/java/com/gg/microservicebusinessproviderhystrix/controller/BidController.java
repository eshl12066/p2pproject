package com.gg.microservicebusinessproviderhystrix.controller;

import com.gg.microservicebusinessproviderhystrix.service.BidRequestService;
import com.gg.microservicebusinessproviderhystrix.service.BidService;
import com.gg.microservicecommon.entity.business.Bid;
import com.gg.microservicecommon.entity.business.BidRequest;
import com.gg.microservicecommon.entity.member.Members;
import com.gg.microservicecommon.util.PageUtils;
import com.gg.microservicecommon.util.Query;
import com.gg.microservicecommon.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (Bid)表控制层
 *
 * @author makejava
 * @since 2019-12-12 20:59:02
 */
@RestController
@Api(description = "投标管理界面")
@RequestMapping("/bid")
public class BidController {
    /**
     * 服务对象
     */
    @Resource
    private BidService bidService;

    /**
     * 服务对象
     */
    @Resource
    private BidRequestService bidRequestService;

    /**
     *redis模板
     * required=false 是开启懒加载
     */
    @Autowired(required = false)
    private RedisTemplate redisTemplate;

    /**
     * 投标界面 查询所有投标，加上模糊查
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("bidQuery")
    @ApiOperation(value = "查询所有",notes = "查询到的数据是分页的，并且也可以传入参数进行查询")
    public PageUtils bidQuery(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp, BidRequest bidRequest) {
        Query query = new Query(params);
        List<Map<String,Object>> list = this.bidService.queryAllPager(query);
        for (Map<String,Object> m : list) {
            m.put("disable_date",m.get("disable_date").toString());//投标截止日期 转格式
            m.get("current_rate");
            m.get("bid_request_amount");
            if(Double.parseDouble(m.get("money")+"")==0.00){
                m.put("money","已满标");
            }
            if(Integer.parseInt(m.get("return_type")+"")==0){
                m.put("return_type","一次付清");
            }else if(Integer.parseInt(m.get("return_type")+"")==1){
                m.put("return_type","等额本息");
            }else if(Integer.parseInt(m.get("return_type")+"")==2){
                m.put("return_type","等额本金");
            }
            if(Integer.parseInt(m.get("bid_request_type")+"")==0){
                m.put("bid_request_type","信用贷");
            }else if(Integer.parseInt(m.get("bid_request_type")+"")==1){
                m.put("bid_request_type","车贷");
            }else if(Integer.parseInt(m.get("bid_request_type")+"")==2){
                m.put("bid_request_type","房贷");
            }
        }
        return new PageUtils(list, query.getTotal());
    }

    /**
     *  投标界面 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public Map<String, Object> selectOne(Integer id) {
        System.out.println("投标界面传过来的id："+id);
        return this.bidService.selectOne(id);
    }

    /**
     * 用户投标信息
     * @param params
     * @param id
     * @return
     */
    @RequestMapping("selectUserBid")
    public List<Map<String,Object>> selectUserBid(@RequestParam Map<String,Object> params,Integer id) {
        System.out.println("投标界面传过来的id："+id);
        List<Map<String, Object>> list = this.bidService.selectUserBid(id);
        for (Map<String,Object> m : list) {
            m.put("bid_time", m.get("bid_time").toString());//投标截止日期 转格式
        }
        return list;
    }

    /**
     *  用户投标界面 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectUserBidDetails")
    public Map<String, Object> selectUserBidDetails(Integer id) {
        System.out.println("用户的某一个投标信息的id："+id);
        return this.bidService.selectUserBidDetails(id);
    }


    /**
     *  增加投标
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("bidAdd")
    @ApiOperation(value = "增加单个",notes = "增加投标表,修改借款表，修改用户表")
    public R bidAdd(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp, Bid bid,BidRequest bidRequest) {

        //投标表的增加
        Date date = new Date();
        bid.setAvailableAmount(bid.getAvailableAmount());
        bid.setBidRequestId(bid.getBidRequestId());
        bid.setMembersId(bid.getMembersId());
        date.setDate(Integer.parseInt(date.getDate() + ""));
        bid.setBidTime(date);
        int i = this.bidService.bidAdd(bid);

        //修改借贷表
        bidRequest.setId(bid.getBidRequestId());
        bidRequest.setBidCount(bidRequest.getBidCount()+1);//投标人数 +1
        bidRequest.setCurrentSum(bidRequest.getCurrentSum()+bid.getAvailableAmount());//借贷表的当前投资总数 增加
        if(bidRequest.getBidRequestAmount() == bidRequest.getCurrentSum()){
            bidRequest.setBidRequestState(3);
        }else{
            bidRequest.setBidRequestState(2);
        }
        BidRequest update = this.bidRequestService.update(bidRequest);
        System.out.println(bidRequest.toString());
        return i > 0 ? R.ok("增加成功") : R.error(-1,"增加失败");
    }


    @RequestMapping("bidUserQuery")
    @ApiOperation(value = "查询所有",notes = "查询到的数据不分页，但可以传入参数进行查询")
    public PageUtils bidUserQuery(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp, BidRequest bidRequest, Members members) {
        Query query = new Query(params);

        members = new Members();//模拟用户登录
        members .setId(1);//模拟用户登录
        List<Map<String,Object>> list = this.bidService.queryAllUserBid(query);
        for (Map<String,Object> m : list) {
            m.put("disable_date",m.get("disable_date").toString());//投标截止日期 转格式
            m.get("current_rate");
            m.get("bid_request_amount");
            if(Double.parseDouble(m.get("money")+"")==0.00){
                m.put("money","已满标");
            }
            if(Integer.parseInt(m.get("return_type")+"")==0){
                m.put("return_type","一次付清");
            }else if(Integer.parseInt(m.get("return_type")+"")==1){
                m.put("return_type","等额本息");
            }else if(Integer.parseInt(m.get("return_type")+"")==2){
                m.put("return_type","等额本金");
            }
            if(Integer.parseInt(m.get("bid_request_type")+"")==0){
                m.put("bid_request_type","信用贷");
            }else if(Integer.parseInt(m.get("bid_request_type")+"")==1){
                m.put("bid_request_type","车贷");
            }else if(Integer.parseInt(m.get("bid_request_type")+"")==2){
                m.put("bid_request_type","房贷");
            }
        }
        return new PageUtils(list, query.getTotal());
    }





    /**
     * 删除投标
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("bidDel")
    @ApiOperation(value = "删除单个",notes = "删除投标")
    public R bidDel(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
    /**
     * 修改投标
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("bidUpdate")
    @ApiOperation(value = "修改单个",notes = "跟据传过来的id进行一个信息修改")
    public R bidUpdate(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }


    @RequestMapping("selectAllPager")
    @ApiOperation(value = "查找所有",notes = "")
    public R selectAllPager(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp, Bid bid,BidRequest bidRequest) {
        Query query = new Query(params);
        List<Map> maps = this.bidService.selectAllPager(query);
        for (Map map : maps) {
            if(map.get("bid_time")!=null){
                map.put("bid_time",map.get("bid_time").toString());
            }
        }
        R r = new R();
        r.put("data",maps);
        return r;
    }

    @RequestMapping("selectRequest")
    @ApiOperation(value = "查找借贷",notes = "")
    public R selectRequest(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp, Bid bid,BidRequest bidRequest) {
        String id = req.getParameter("id");
        Map map = this.bidService.selectRequestById(Integer.valueOf(id));
        if(map.get("return_type")!=null){
            if(map.get("return_type").toString().equals("0")){
                map.put("return_type","一次付清");
            }
            if(map.get("return_type").toString().equals("1")){
                map.put("return_type","等额本息");
            }
            if(map.get("return_type").toString().equals("2")){
                map.put("return_type","等额本金");
            }
        }
        if(map.get("bid_request_type")!=null){
            if(map.get("bid_request_type").toString().equals("0")){
                map.put("bid_request_type","信用贷");
            }
            if(map.get("bid_request_type").toString().equals("1")){
                map.put("bid_request_type","车贷");
            }
            if(map.get("bid_request_type").toString().equals("2")){
                map.put("bid_request_type","房贷");
            }
        }
        if(map.get("bid_request_state")!=null){
            if(map.get("bid_request_state").toString().equals("0")){
                map.put("bid_request_state","审核通过");
            }
            if(map.get("bid_request_state").toString().equals("1")){
                map.put("bid_request_state"," 审核失败");
            }
            if(map.get("bid_request_state").toString().equals("2")){
                map.put("bid_request_state","审核中");
            }
            if(map.get("bid_request_state").toString().equals("3")){
                map.put("bid_request_state","满标");
            }
            if(map.get("bid_request_state").toString().equals("4")){
                map.put("bid_request_state","还款中");
            }
            if(map.get("bid_request_state").toString().equals("5")){
                map.put("bid_request_state","逾期");
            }
            if(map.get("bid_request_state").toString().equals("6")){
                map.put("bid_request_state","投标超时");
            }
            if(map.get("bid_request_state").toString().equals("7")){
                map.put("bid_request_state","完成");
            }
        }

        R r = new R();
        r.put("data",map);
        return r;
    }

    @RequestMapping("selectMembers")
    @ApiOperation(value = "查找会员",notes = "")
    public R selectMembers(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp, Bid bid,BidRequest bidRequest) {
        String id = req.getParameter("id");
        Map map = this.bidService.selectMembersById(Integer.valueOf(id));
        if(map.get("is_identity_authentication")!=null){
            if("0".equals(map.get("is_identity_authentication").toString())){
                map.put("is_identity_authentication","YES");
            }
            if("1".equals(map.get("is_identity_authentication").toString())){
                map.put("is_identity_authentication","NO");
            }
        }
        if(map.get("members_state")!=null){
            if("0".equals(map.get("members_state").toString())){
                map.put("members_state","可用");
            }
            if("1".equals(map.get("members_state").toString())){
                map.put("members_state","不可用");
            }
        }
        R r = new R();
        r.put("data",map);
        return r;
    }



}