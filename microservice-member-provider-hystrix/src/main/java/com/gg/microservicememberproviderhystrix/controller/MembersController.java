package com.gg.microservicememberproviderhystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import com.gg.microservicecommon.entity.member.Members;
import com.gg.microservicecommon.util.PageBaen;
import com.gg.microservicecommon.util.PageUtils;
import com.gg.microservicecommon.util.R;
import com.gg.microservicememberproviderhystrix.service.MembersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * (Members)表控制层
 *
 * @author makejava
 * @since 2019-12-12 20:53:16
 */
@RestController
@RequestMapping("members")
public class MembersController {
    /**
     * 服务对象
     */
    @Resource
    private MembersService membersService;

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
    public Members selectOne(Integer id) {
        return this.membersService.queryById(id);
    }

    /**
     * 查询所有&&，加上模糊查
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("membersQuery")
    @ApiOperation(value = "查询所有",notes = "查询到的数据是分页的，并且也可以传入参数进行查询")
    public PageUtils membersQuery(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {

        return null;
    }
    /**
     *  增加&&
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("membersAdd")
    @ApiOperation(value = "增加单个",notes = "增加&&")
    public R membersAdd(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
    /**
     * 删除&&
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("membersDel")
    @ApiOperation(value = "删除单个",notes = "删除&&")
    public R membersDel(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
    /**
     * 修改&&
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("membersUpdate")
    @ApiOperation(value = "修改单个",notes = "跟据传过来的id进行一个信息修改")
    public R membersUpdate(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }

    @RequestMapping("getAll")
    @ApiOperation(value = "模糊查",notes = "默认查所有，输入参数即可查询")
    public PageUtils  getAll(@RequestParam Map<String,Object> params, HttpServletRequest request, HttpServletResponse response){
        String start=null;
        String stop = null;
        if(!StringUtils.isEmpty(request.getParameter("start"))){
            String[] split = request.getParameter("start").split("T");
            start = split[0];
            String[] split1 = request.getParameter("stop").split("T");
            stop  = split1[0];
        }
        PageBaen pageBaen = new PageBaen(params);
        if(!StringUtils.isEmpty(start)){
            pageBaen.put("start",start);
            pageBaen.put("stop",stop);
        }
        List<Map<String,Object>> list = this.membersService.getAllPager(pageBaen);
        for (Map<String,Object> map1 : list) {
            map1.put("audit_time",map1.get("audit_time").toString());
        }
        return new PageUtils(list,pageBaen.getTotal());
    }
}