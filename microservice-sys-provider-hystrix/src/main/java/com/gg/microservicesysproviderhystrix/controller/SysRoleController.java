package com.gg.microservicesysproviderhystrix.controller;

import com.gg.microservicecommon.util.Query;
import com.gg.microservicecommon.entity.sys.SysRole;
import com.gg.microservicecommon.util.PageUtils;
import com.gg.microservicecommon.util.R;
import com.gg.microservicesysproviderhystrix.service.SysRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (SysRole)表控制层
 *
 * @author makejava
 * @since 2019-12-12 11:31:56
 */
@RestController
@RequestMapping("sysRole")
public class SysRoleController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleService sysRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param roleid 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    @ApiOperation(value = "查询单个",notes = "一般是用来指定的角色回调")
    public SysRole selectOne(Integer roleid) {
        return this.sysRoleService.queryById(roleid);
    }

    /**
     * 查询所有角色，加上模糊查
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("roleQuery")
    @ApiOperation(value = "查询所有",notes = "查询到的数据是分页的，并且也可以传入参数进行查询")
    public PageUtils roleQuery(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        Query query = new Query(params);
        List<SysRole> sysRoles = this.sysRoleService.queryPager(query);
        List<Map<String,Object>> list =new ArrayList<>();
        Map<String,Object> map ;
        for(SysRole s : sysRoles){
            map = new HashMap<>();
            map.put("roleid",s.getRoleid());
            map.put("rolename",s.getRolename());
            map.put("description",s.getDescription());
            if(s.getRolestate()==0){
                map.put("rolestate","可用");
            }
            else{
                map.put("rolestate","不可用");
            }
            list.add(map);
        }

        return new PageUtils(list,query.getTotal());
    }
    /**
     *  增加角色
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("roleAdd")
    @ApiOperation(value = "增加单个",notes = "增加角色")
    public R roleAdd(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp,SysRole sysrole) {
        if(this.sysRoleService.selectByName(sysrole.getRolename())!=null){
            return R.error(-2,"名字重复,请换个名字");
        }
        sysrole.setRolestate(0);
        return this.sysRoleService.insert(sysrole) > 0 ? R.ok("增加成功") : R.error(-1,"增加失败");
    }
    /**
     * 删除角色
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("roleDel")
    @ApiOperation(value = "删除单个",notes = "删除角色")
    public R roleDel(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp, SysRole sysrole) {
        return this.sysRoleService.deleteById(sysrole.getRoleid()) ? R.ok("删除成功") : R.error(-1,"删除失败");
    }
    /**
     * 修改角色
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("roleUpdate")
    @ApiOperation(value = "修改单个",notes = "跟据穿过来的id进行一个信息修改")
    public R roleUpdate(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp,SysRole sysrole) {
        return this.sysRoleService.update(sysrole) >0 ? R.ok("修改成功") : R.error(-1,"修改失败");
    }

    /**
     * 获取所有角色下拉
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("roleSelect")
    @ApiOperation(value = "获取角色下拉",notes = "获取所有的角色下拉来放入到下拉框中")
    public List<SysRole> roleSelect(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        return this.sysRoleService.roleSelect();
    }

}