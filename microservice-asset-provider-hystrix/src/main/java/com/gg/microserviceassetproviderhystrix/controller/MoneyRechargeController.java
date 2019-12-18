package com.gg.microserviceassetproviderhystrix.controller;

import com.gg.microserviceassetproviderhystrix.service.MoneyRechargeService;
import com.gg.microservicecommon.entity.asset.MoneyRecharge;
import com.gg.microservicecommon.util.PageUtils;
import com.gg.microservicecommon.util.Query;
import com.gg.microservicecommon.util.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * (MoneyRecharge)表控制层
 *
 * @author makejava
 * @since 2019-12-12 11:58:54
 * 充值
 */
@RestController
@RequestMapping("moneyRecharge")
public class MoneyRechargeController {
    /**
     * 服务对象
     */
    @Resource
    private MoneyRechargeService moneyRechargeService;


    /**
     *redis模板
     * required=false 是开启懒加载
     */
    @Autowired(required = false)
    private RedisTemplate redisTemplate;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MoneyRecharge selectOne(Integer id) {
        return this.moneyRechargeService.queryById(id);
    }

    /**
     * 查询所有充值，加上模糊查
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("moneyRechargeQuery")
    @ApiOperation(value = "查询所有",notes = "查询到的数据是分页的，并且也可以传入参数进行查询")
    public PageUtils moneyRechargeQuery(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {

        return null;
    }

    @RequestMapping("selectAll")
    @ApiOperation(value = "分页模糊查询所有",notes = "查询")
    public PageUtils selectAll(@RequestParam Map<String,Object> param, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(param);
        List<Map> maps = this.moneyRechargeService.ListAllPager(query);
        for (Map map : maps) {
            map.put("trade_time",map.get("trade_time").toString());
        }
        return new PageUtils(maps,query.getTotal());
    }
    /**
     *  增加充值
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("moneyRechargeAdd")
    @ApiOperation(value = "增加单个",notes = "增加充值")
    public int moneyRechargeAdd(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(params);
        int insert = this.moneyRechargeService.insert(query);
        return insert;
    }

    /**
     * 删除充值
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("moneyRechargeDel")
    @ApiOperation(value = "删除单个",notes = "删除充值")
    public R moneyRechargeDel(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }


    /**
     * 修改充值
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("moneyRechargeUpdate")
    @ApiOperation(value = "修改单个",notes = "跟据传过来的id进行一个信息修改")
    public R moneyRechargeUpdate(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
    /**
     * 充值成功
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("moneyok")
    @ApiOperation(value = "修改单个",notes = "跟据传过来的id进行一个信息修改")
    public R moneyok(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        redisTemplate.opsForValue().set("userMembers","1");
        String total_amount = req.getParameter("total_amount");
        return null;
    }

    @RequestMapping("selectZFB")
    @ApiOperation(value = "根据ID查找支付宝账户",notes = "查询")
    public Map selectZFB(@RequestParam Map<String,Object> param, HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("members_id");
        Map membersAccount = this.moneyRechargeService.selectZFB(Integer.valueOf(id));
        return membersAccount;
    }

    @RequestMapping("updateJE")
    @ApiOperation(value = "根据ID修改账户金额",notes = "修改")
    public int updateJE(@RequestParam Map<String,Object> param, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(param);
        int update = this.moneyRechargeService.updateJE(query);
        return update;
    }
}