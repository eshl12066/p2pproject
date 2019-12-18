package com.gg.microservicesettingproviderhystrix.controller;

import com.gg.microservicecommon.util.Query;
import com.gg.microservicecommon.util.R;
import com.gg.microservicesettingproviderhystrix.service.SetMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * (SetMessage)表控制层
 *
 * @author makejava
 * @since 2019-12-12 11:47:09
 */
@RestController
@Api(description = "消息管理界面")
@RequestMapping("setMessage")
public class SetMessageController {
    /**
     * 服务对象
     */
    @Resource
    private SetMessageService setMessageService;

    /**
     *redis模板
     * required=false 是开启懒加载
     */
    @Autowired(required = false)
    private RedisTemplate redisTemplate;


    /**
     * 通过主键查询单条数据
     *
     *
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public Map selectOne( HttpServletRequest req) {
        String id = req.getParameter("id");
        return (Map) this.setMessageService.queryById(Integer.valueOf(id));
    }

    /**
     * 查询所有消息，加上模糊查
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("selectAll")
    @ApiOperation(value = "查询所有",notes = "查询到的数据是分页的，并且也可以传入参数进行查询")
    public R selectAll(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(params);
        List<Map> maps = this.setMessageService.queryAllPager(query);
        R r = new R();
        r.put("data",maps);
        return r;
    }

    /**
     *  增加消息
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("messageAdd")
    @ApiOperation(value = "增加单个",notes = "增加消息")
    public int messageAdd(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(params);
        int n = this.setMessageService.insert(query);
        return n;
    }

    /**
     * 删除消息
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("messageDel")
    @ApiOperation(value = "删除单个",notes = "删除消息")
    public boolean messageDel(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        return this.setMessageService.deleteById(Integer.valueOf(id));
    }

    /**
     *  修改消息
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("messageEdit")
    @ApiOperation(value = "修改状态",notes = "修改消息")
    public int messageEdit(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(params);
        int n = this.setMessageService.update(query);
        return n;
    }

}