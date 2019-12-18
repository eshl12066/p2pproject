package com.gg.microservicememberproviderhystrix.controller;

import com.gg.microservicecommon.entity.member.MembersAccount;
import com.gg.microservicecommon.util.PageUtils;
import com.gg.microservicecommon.util.R;
import com.gg.microservicememberproviderhystrix.service.MembersAccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * (MembersAccount)表控制层
 *
 * @author makejava
 * @since 2019-12-12 20:53:41
 */
@RestController
@RequestMapping("membersAccount")
public class MembersAccountController {
    /**
     * 服务对象
     */
    @Resource
    private MembersAccountService membersAccountService;

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
    public MembersAccount selectOne(Integer id) {
        return this.membersAccountService.queryById(id);
    }

    /**
     * 查询所有&&，加上模糊查
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("membersAccountQuery")
    @ApiOperation(value = "查询所有",notes = "查询到的数据是分页的，并且也可以传入参数进行查询")
    public PageUtils membersAccountQuery(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {

        return null;
    }
    /**
     *  增加&&
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("membersAccountAdd")
    @ApiOperation(value = "增加单个",notes = "增加&&")
    public R membersAccountAdd(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
    /**
     * 删除&&
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("membersAccountDel")
    @ApiOperation(value = "删除单个",notes = "删除&&")
    public R membersAccountDel(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
    /**
     * 修改&&
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("membersAccountUpdate")
    @ApiOperation(value = "修改单个",notes = "跟据传过来的id进行一个信息修改")
    public R membersAccountUpdate(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }

}