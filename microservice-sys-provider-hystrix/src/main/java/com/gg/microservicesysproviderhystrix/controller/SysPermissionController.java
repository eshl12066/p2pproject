package com.gg.microservicesysproviderhystrix.controller;

import com.gg.microservicecommon.entity.sys.SysPermission;
import com.gg.microservicecommon.entity.sys.TreeNode;
import com.gg.microservicecommon.util.R;
import com.gg.microservicesysproviderhystrix.service.SysPermissionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * (SysPermission)表控制层
 *
 * @author makejava
 * @since 2019-12-12 11:29:40
 */
@RestController
@RequestMapping("sysPermission")
public class SysPermissionController {
    /**
     * 服务对象
     */
    @Resource
    private SysPermissionService sysPermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysPermission selectOne(Integer id) {
        return this.sysPermissionService.queryById(id);
    }

    @RequestMapping("selectTreeNode")
    @ApiOperation(value = "查询指定uid的树形菜单",notes = "跟据uid来查询")
    public List<TreeNode> selectTreeNode(int uid){
        return this.sysPermissionService.getTreeNode(""+uid);
    }

    @RequestMapping("selectTreeNodeRoleid")
    @ApiOperation(value = "查询指定roleid的树形菜单",notes = "跟据角色id来查询")
    public List<Map<String,Object>> selectTreeNodeByRoleid(int roleid){
        return this.sysPermissionService.getTreeNodeByRoleid(""+roleid);
    }

    @RequestMapping("delRolePermission")
    @ApiOperation(value = "删除角色权限表的数据",notes = "删除所有role_permission的数据")
    public R delRolePermission(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp){
        return this.sysPermissionService.delRolePermission(req.getParameter("roleid")) > 0 ? R.ok("清空成功") : R.error(-1,"清空失败");
    }

    @RequestMapping("addRolePermission")
    @ApiOperation(value = "授权",notes = "给其他的角色授权")
    public R addRolePermission(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp){
        String roleid = req.getParameter("roleid");
        String roleids = req.getParameter("roleids");
        String[] split = roleids.split(",");

        if(roleid!=null){
            int r = this.sysPermissionService.delRolePermission(req.getParameter("roleid"));
            for (String s : split){
                int i = this.sysPermissionService.addRolePermission(roleid, s);
            }
            return R.ok("授权成功");
        }
        return R.error(-1,"授权失败");
    }
}