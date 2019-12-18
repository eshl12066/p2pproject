package com.gg.microservicesysproviderhystrix.controller;

import com.gg.microservicecommon.entity.sys.Query;
import com.gg.microservicecommon.entity.sys.SysUserRole;
import com.gg.microservicecommon.util.PageUtils;
import com.gg.microservicecommon.util.R;
import com.gg.microservicesysproviderhystrix.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (SysUserRole)表控制层
 *
 * @author makejava
 * @since 2019-12-12 11:34:00
 */
@RestController
@RequestMapping("sysUserRole")
public class SysUserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserRoleService sysUserRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysUserRole selectOne(Integer id) {
        return this.sysUserRoleService.queryById(id);
    }

    /**
     *redis模板
     * required=false 是开启懒加载
     */
    @Autowired(required = false)
    private RedisTemplate redisTemplate;

    /**
     * 查询所有，加上模糊查
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("bidRequestSelect")
    public R bidRequestSelect(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        R r = new R();
        Query query = new Query(params);
//        List<Map<String, Object>> sysRoles = this.sysUserRoleService.bidRequestPager(query);
        query.put("bidRequestState",0);
        List<Map<String, Object>> list0 = this.sysUserRoleService.bidRequestPager(query);
        r.put("r0",new PageUtils(list0,query.getTotal()));

        query.put("bidRequestState",3);
        List<Map<String, Object>> list3 = this.sysUserRoleService.bidRequestPager(query);
        r.put("r3",new PageUtils(list3,query.getTotal()));

        query.put("bidRequestState",1);
        List<Map<String, Object>> list1 = this.sysUserRoleService.bidRequestPager(query);
        r.put("r1",new PageUtils(list1,query.getTotal()));

        query.put("bidRequestState",7);
        List<Map<String, Object>> list7 = this.sysUserRoleService.bidRequestPager(query);
        r.put("r7",new PageUtils(list7,query.getTotal()));
        return r;
    }
    /**
     * 单个的
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("bidRequestSelect0")
    public PageUtils bidRequestSelect0(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {

        Query query = new Query(params);
        List<Map<String, Object>> list0 = this.sysUserRoleService.bidRequestPager(query);

        return new PageUtils(list0,query.getTotal());
    }
    /**
     * 单个的
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("bidRequestSelect3")
    public PageUtils bidRequestSelect3(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {

        Query query = new Query(params);
        List<Map<String, Object>> list = this.sysUserRoleService.bidRequestPager(query);

        return new PageUtils(list,query.getTotal());
    }
    /**
     * 单个的
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("bidRequestSelect1")
    public PageUtils bidRequestSelect1(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {

        Query query = new Query(params);
        List<Map<String, Object>> list = this.sysUserRoleService.bidRequestPager(query);

        return new PageUtils(list,query.getTotal());
    }
    /**
     * 单个的
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("bidRequestSelect7")
    public PageUtils bidRequestSelect7(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {

        Query query = new Query(params);
        List<Map<String, Object>> list = this.sysUserRoleService.bidRequestPager(query);

        return new PageUtils(list,query.getTotal());
    }

    /**
     * 单个的
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("upBidRequest0")
    public R upBidRequest0(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(params);
        query.put("auditTime",new Date());
        query.put("bidRequestState",2);

        String membersId = req.getParameter("membersId");
        this.sysUserRoleService.upBidRequest0T(Integer.parseInt(membersId));

        return this.sysUserRoleService.upBidRequest0(query)>0 ? R.ok("审核成功") : R.error(-1,"审核失败");
    }

    /**
     * 单个的
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("noupBidRequest0")
    public R noupBidRequest0(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(params);
        query.put("auditTime",new Date());
        query.put("bidRequestState",1);

        return this.sysUserRoleService.upBidRequest0(query)>0 ? R.ok("劝退成功") : R.error(-1,"劝退失败");
    }



    /**
     * 单个的
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("manUpdate3")
    public R manUpdate3(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(params);
        query.put("auditTime",new Date());
        query.put("bidRequestState",4);

        return this.sysUserRoleService.upBidRequest0(query)>0 ? R.ok("审核成功") : R.error(-1,"审核失败");
    }

    /**
     * 单个的
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("nomanUpdate3")
    public R nomanUpdate3(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(params);
        query.put("auditTime",new Date());
        query.put("bidRequestState",1);

        return this.sysUserRoleService.upBidRequest0(query)>0 ? R.ok("审核成功") : R.error(-1,"审核失败");
    }

}