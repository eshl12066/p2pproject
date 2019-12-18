package com.gg.microservicememberproviderhystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import com.gg.microservicecommon.entity.member.MembersMaterials;
import com.gg.microservicecommon.util.PageBaen;
import com.gg.microservicecommon.util.PageUtils;
import com.gg.microservicecommon.util.R;
import com.gg.microservicememberproviderhystrix.service.MembersMaterialsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * (MembersMaterials)表控制层
 *
 * @author makejava
 * @since 2019-12-12 20:54:17
 */
@RestController
@RequestMapping("membersMaterials")
public class MembersMaterialsController {
    /**
     * 服务对象
     */
    @Resource
    private MembersMaterialsService membersMaterialsService;

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
    public MembersMaterials selectOne(Integer id) {
        return this.membersMaterialsService.queryById(id);
    }

    /**
     * 查询所有&&，加上模糊查
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("membersMaterialsQuery")
    @ApiOperation(value = "查询所有",notes = "查询到的数据是分页的，并且也可以传入参数进行查询")
    public PageUtils membersMaterialsQuery(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {

        return null;
    }
    /**
     *  增加&&
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("membersMaterialsAdd")
    @ApiOperation(value = "增加单个",notes = "增加&&")
    public R membersMaterialsAdd(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp,MembersMaterials membersMaterials) {
        PageBaen pageBaen = new PageBaen(params);
        return this.membersMaterialsService.insert(pageBaen) > 0 ? R.ok("增加成功") : R.error(-1,"增加失败");

    }
    /**
     * 删除&&
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("membersMaterialsDel")
    @ApiOperation(value = "删除单个",notes = "删除&&")
    public R membersMaterialsDel(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
    /**
     * 修改&&
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("membersMaterialsUpdate")
    @ApiOperation(value = "修改单个",notes = "跟据传过来的id进行一个信息修改")
    public R membersMaterialsUpdate(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }

    /**
     * 模糊查
     * @param params
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("getCAll")
    @ApiOperation(value = "模糊查",notes = "默认查所有，输入参数即可查询")
    public PageUtils  getCLAll(@RequestParam Map<String,Object> params,HttpServletRequest request,HttpServletResponse response){
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
        List<Map<String,Object>> list = this.membersMaterialsService.getCLAllPager(pageBaen);
        for (Map<String,Object> map1 : list) {
            map1.put("apply_time",map1.get("apply_time").toString());
        }
        /*R r = new R();
        r.put("data",list);
        r.put("total",query.getTotal());*/
        return new PageUtils(list,pageBaen.getTotal());
    }

    @RequestMapping("updateState")
    @ApiOperation(value = "修改状态",notes = "修改状态,并加上审核人的备注与材料证明的合理得分")
    public R updateCState(@RequestParam Map<String,Object> params, HttpServletRequest request, HttpServletResponse response){
        PageBaen pageBaen = new PageBaen(params);
        return this.membersMaterialsService.updateState(pageBaen) >0 ? R.ok("修改成功") : R.error(-1,"修改失败");
    }

    @RequestMapping("getCLOne")
    @ApiOperation(value = "单个查",notes = "单个查询")
    public  Map<String,Object> getCLONE(@RequestParam Map<String,Object> params, HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        Map<String, Object> map = this.membersMaterialsService.queryByCLId(Integer.valueOf(id));
        return  map;
    }

    @RequestMapping("queryMnull")
    @ApiOperation(value = "单个查",notes = "单个查询")
    public MembersMaterials queryMnull(@RequestParam Integer id){
        return this.membersMaterialsService.queryMnull(id);
    }
}