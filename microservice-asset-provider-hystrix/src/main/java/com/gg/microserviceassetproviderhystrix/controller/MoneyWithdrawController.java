package com.gg.microserviceassetproviderhystrix.controller;

import com.gg.microserviceassetproviderhystrix.service.MoneyWithdrawService;
import com.gg.microservicecommon.entity.asset.MoneyWithdraw;
import com.gg.microservicecommon.util.PageUtils;
import com.gg.microservicecommon.util.Query;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * (MoneyWithdraw)表控制层
 *
 * @author makejava
 * @since 2019-12-12 11:59:22
 * 提现
 */
@RestController
@RequestMapping("moneyWithdraw")
public class MoneyWithdrawController {
    /**
     * 服务对象
     */
    @Resource
    private MoneyWithdrawService moneyWithdrawService;

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
    @RequestMapping("selectOne")
    public MoneyWithdraw selectOne(Integer id) {
        return this.moneyWithdrawService.queryById(id);
    }

    /**
     * 查询所有提现，加上模糊查
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("moneyWithdrawQuery")
    @ApiOperation(value = "查询所有",notes = "查询到的数据是分页的，并且也可以传入参数进行查询")
    public PageUtils moneyWithdrawQuery(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {

        return null;
    }
    /**
     *  增加提现
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("moneyWithdrawAdd")
    @ApiOperation(value = "增加单个",notes = "增加提现")
    public int moneyWithdrawAdd(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(params);
        int insert = this.moneyWithdrawService.insert(query);
        return insert;
    }
    /**
     * 删除提现
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("moneyWithdrawDel")
    @ApiOperation(value = "删除单个",notes = "删除提现")
    public boolean moneyWithdrawDel(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        return this.moneyWithdrawService.deleteById(Integer.valueOf(id));
    }
    /**
     * 修改提现
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("moneyWithdrawUpdate")
    @ApiOperation(value = "修改单个",notes = "跟据传过来的id进行一个信息修改")
    public int moneyWithdrawUpdate(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(params);
        int update = this.moneyWithdrawService.update(query);
        return update;
    }
    @RequestMapping("ListByuserPager")
    public PageUtils ListByuserPager(@RequestParam Map<String,Object> param, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(param);
        List<Map> maps = this.moneyWithdrawService.ListByuserPager(query);
        for (Map map : maps) {
            if(map.get("audit_time")!=null){
                map.put("audit_time",map.get("audit_time").toString());
            }
            if(map.get("apply_time")!=null){
                map.put("apply_time",map.get("apply_time").toString());
            }
        }
        System.err.println(query.getTotal());
        return new PageUtils(maps,query.getTotal());
    }

    @RequestMapping("ListBymemberPager")
    public PageUtils ListBymemberPager(@RequestParam Map<String,Object> param, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(param);
        List<Map> maps = this.moneyWithdrawService.ListBymemberPager(query);
        for (Map map : maps) {
            if(map.get("audit_time")!=null){
                map.put("audit_time",map.get("audit_time").toString());
            }
            if(map.get("apply_time")!=null){
                map.put("apply_time",map.get("apply_time").toString());
            }
        }
        return new PageUtils(maps,query.getTotal());
    }

    @RequestMapping("ListIdPager")
    public PageUtils ListIdPager(@RequestParam Map<String,Object> param, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(param);
        List<Map> maps = this.moneyWithdrawService.ListIdPager(query);
        return new PageUtils(maps,query.getTotal());
    }

}