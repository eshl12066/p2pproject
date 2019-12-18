package com.gg.microservicememberproviderhystrix.controller;

import com.gg.microservicecommon.entity.member.MembersDetail;
import com.gg.microservicecommon.util.PageBaen;
import com.gg.microservicecommon.util.PageUtils;
import com.gg.microservicecommon.util.R;
import com.gg.microservicememberproviderhystrix.service.MembersDetailService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * (MembersDetail)表控制层
 *
 * @author makejava
 * @since 2019-12-12 20:54:03
 */
@RestController
@RequestMapping("membersDetail")
public class MembersDetailController {
    /**
     * 服务对象
     */
    @Resource
    private MembersDetailService membersDetailService;

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
    public MembersDetail selectOne(Integer id) {
        return this.membersDetailService.queryById(id);
    }

    /**
     * 查询所有&&，加上模糊查
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("membersDetailQuery")
    @ApiOperation(value = "查询所有",notes = "查询到的数据是分页的，并且也可以传入参数进行查询")
    public PageUtils membersDetailQuery(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {

        return null;
    }
    /**
     *  增加&&
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("membersDetailAdd")
    @ApiOperation(value = "增加单个",notes = "增加&&")
    public R membersDetailAdd(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp,MembersDetail membersDetail) {
        PageBaen pageBaen = new PageBaen(params);
        int insert = this.membersDetailService.insert(pageBaen);
        return  insert > 0 ? R.ok("增加成功") : R.error(-1,"增加失败");
    }

    /**
     * 删除&&
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("membersDetailDel")
    @ApiOperation(value = "删除单个",notes = "删除&&")
    public R membersDetailDel(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
    /**
     * 修改&&
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("membersDetailUpdate")
    @ApiOperation(value = "修改单个",notes = "跟据传过来的id进行一个信息修改")
    public R membersDetailUpdate(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }

    @RequestMapping("queryDnull")
    @ApiOperation(value = "单个查",notes = "单个查询")
    public MembersDetail  queryDnull(@RequestParam Integer id){
        return this.membersDetailService.queryDnull(id);
    }

}