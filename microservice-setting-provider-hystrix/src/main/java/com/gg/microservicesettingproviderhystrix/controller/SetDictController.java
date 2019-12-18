package com.gg.microservicesettingproviderhystrix.controller;

import com.gg.microservicecommon.entity.setting.SetDict;
import com.gg.microservicecommon.util.PageUtils;
import com.gg.microservicecommon.util.Query;
import com.gg.microservicesettingproviderhystrix.service.SetDictService;
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
 * (SetDict)表控制层
 *
 * @author makejava
 * @since 2019-12-12 11:44:54
 */
@RestController
@Api(description = "字典管理界面")
@RequestMapping("setDict")
public class SetDictController {
    /**
     * 服务对象
     */
    @Resource
    private SetDictService setDictService;

    /**
     * 通过主键查询单条数据
     *
     * @param
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public SetDict selectOne(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        return this.setDictService.queryById(Integer.valueOf(id));
    }


    /**
     *redis模板
     * required=false 是开启懒加载
     */
    @Autowired(required = false)
    private RedisTemplate redisTemplate;




    /**
     *  增加字典
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("setdictAdd")
    @ApiOperation(value = "增加单个",notes = "增加字典")
    public int setdictAdd(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(params);
        return this.setDictService.insert(query);
    }

    /**
     * 删除字典
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("setdictDel")
    @ApiOperation(value = "删除单个",notes = "删除字典")
    public boolean setdictDel(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        boolean b = this.setDictService.deleteById(Integer.valueOf(id));
        return b;
    }

    /**
     * 修改字典
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("setdictUpdate")
    @ApiOperation(value = "修改单个",notes = "跟据传过来的id进行一个信息修改")
    public int setdictUpdate(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(params);
        int update = this.setDictService.update(query);
        return update;
    }


    /**
     * 查询出所有数据
     * @param param
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("selectAll")
    @ApiOperation(value = "数据字典分页模糊查询所有",notes = "查询")
    public PageUtils selectAll(@RequestParam Map<String,Object> param, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(param);
        List<Map> maps = this.setDictService.selectAllPager(query);
        return new PageUtils(maps,query.getTotal());
    }


}