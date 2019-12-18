package com.gg.microservicesettingproviderhystrix.controller;

import com.gg.microservicecommon.entity.setting.SetSetting;
import com.gg.microservicecommon.util.Query;
import com.gg.microservicecommon.util.R;
import com.gg.microservicesettingproviderhystrix.service.SetSettingService;
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
 * (SetSetting)表控制层
 *
 * @author makejava
 * @since 2019-12-12 11:48:03
 */
@RestController
@RequestMapping("setSetting")
public class SetSettingController {
    /**
     * 服务对象
     */
    @Resource
    private SetSettingService setSettingService;

    /**
     *redis模板
     * required=false 是开启懒加载
     */
    @Autowired(required = false)
    private RedisTemplate redisTemplate;

    /**
     * 通过主键查询单条数据
     *
     * @param
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public SetSetting selectOne(HttpServletRequest req) {
        String id = req.getParameter("id");
        SetSetting setSetting = this.setSettingService.queryById(Integer.valueOf(id));
        int n = 0;
        return setSetting;
    }


    /**
     *  增加设置
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("sysSettingAdd")
    @ApiOperation(value = "增加单个",notes = "增加设置")
    public R sysSettingAdd(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }

    /**
     * 删除设置
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("sysSettingDel")
    @ApiOperation(value = "删除单个",notes = "删除设置")
    public R setSettingService(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }

    /**
     * 修改设置
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("sysSettingUpdate")
    @ApiOperation(value = "修改单个",notes = "跟据传过来的id进行一个信息修改")
    public int sysSettingUpdate(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(params);
        return this.setSettingService.update(query);
    }

    /**
     * 修改设置
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("sysSettingUpdateAll")
    @ApiOperation(value = "修改全部",notes = "")
    public int sysSettingUpdateAll(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(params);
        int i = this.setSettingService.updateAll(query);
        return i;
    }

    /**
     * 查询所有设置，加上模糊查
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("sysSettingQuery")
    @ApiOperation(value = "查询所有",notes = "查询到的数据是分页的，并且也可以传入参数进行查询")
    public R sysSettingQuery(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        List<SetSetting> sysSettings = this.setSettingService.queryAll();
        R r = new R();
        r.put("data",sysSettings);
        return r;
    }
}