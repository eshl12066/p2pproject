package com.gg.microservicesettingproviderhystrix.controller;

import com.gg.microservicecommon.entity.setting.SetDictitem;
import com.gg.microservicecommon.util.Query;
import com.gg.microservicecommon.util.R;
import com.gg.microservicesettingproviderhystrix.service.SetDictitemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * (SetDictitem)表控制层
 *
 * @author makejava
 * @since 2019-12-12 11:46:42
 */
@RestController
@Api(description = "字典详细管理界面")
@RequestMapping("setDictitem")
public class SetDictitemController {
    /**
     * 服务对象
     */
    @Resource
    private SetDictitemService setDictitemService;

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
    public SetDictitem selectOne(Integer id) {
        return this.setDictitemService.queryById(id);
    }

    /**
     *  增加字典详细
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("setdictitemAdd")
    @ApiOperation(value = "增加单个",notes = "增加字典详细")
    public int setdictitemAdd(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(params);
        int insert = this.setDictitemService.insert(query);
        return insert;
    }

    /**
     * 删除字典详细
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("setdictitemDel")
    @ApiOperation(value = "删除单个",notes = "删除字典详细")
    public boolean setdictitemDel(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        boolean b = this.setDictitemService.deleteById(Integer.valueOf(id));
        return b;
    }


    /**
     * 根据父删除字典详细
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("setdictitemDelByParentId")
    @ApiOperation(value = "根据父删除多个子",notes = "删除字典详细")
    public int setdictitemDelByParentId(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        int i = this.setDictitemService.deleteByParentId(Integer.valueOf(id));
        return i;
    }

    /**
     * 修改字典详细
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("setdictitemUpdate")
    @ApiOperation(value = "修改单个",notes = "跟据传过来的id进行一个信息修改")
    public int setdictitemUpdate(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(params);
        int update = this.setDictitemService.update(query);
        return update;
    }


    /**
     *查看详情  根据dictID查看dictitem详情
     * @param param
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("selectByDictId")
    @ApiOperation(value = "数据字典查看单个详情",notes = "查询")
    public R selectAll(@RequestParam Map<String,Object> param, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(param);
        List<Map> maps = this.setDictitemService.queryByDictId(query);
        R r = new R();
        List<Map<String,Object>> ha8 = new ArrayList<>();
        List<Map<String,Object>> ha9 = new ArrayList<>();
        List<Map<String,Object>> ha10 = new ArrayList<>();
        List<Map<String,Object>> ha11 = new ArrayList<>();
        List<Map<String,Object>> ha12 = new ArrayList<>();
        for(Map s : maps){
            if(Integer.parseInt(s.get("parentId")+"")==8){
                ha8.add(s);
            }
            else if(Integer.parseInt(s.get("parentId")+"")==9){
                ha9.add(s);
            }
            else if(Integer.parseInt(s.get("parentId")+"")==10){
                ha10.add(s);
            }
            else if(Integer.parseInt(s.get("parentId")+"")==11){
                ha11.add(s);
            }
            else if(Integer.parseInt(s.get("parentId")+"")==12){
                ha12.add(s);
            }
        }
        r.put("ha8",ha8);
        r.put("ha9",ha9);
        r.put("ha10",ha10);
        r.put("ha11",ha11);
        r.put("ha12",ha12);
        return r;
    }
    
}