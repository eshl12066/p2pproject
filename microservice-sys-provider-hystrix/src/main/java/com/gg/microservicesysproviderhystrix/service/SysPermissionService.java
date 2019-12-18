package com.gg.microservicesysproviderhystrix.service;

import com.gg.microservicecommon.entity.sys.SysPermission;
import com.gg.microservicecommon.entity.sys.TreeNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * (SysPermission)表服务接口
 *
 * @author makejava
 * @since 2019-12-12 11:29:37
 */
@Service
public interface SysPermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param perid 主键
     * @return 实例对象
     */
    SysPermission queryById(Integer perid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysPermission> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    SysPermission insert(SysPermission sysPermission);

    /**
     * 修改数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    SysPermission update(SysPermission sysPermission);

    /**
     * 通过主键删除数据
     *
     * @param perid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer perid);

    public List<TreeNode> getTreeNode(String uid);

    public List<TreeNode> getTreeNodePlus(String uid ,String pid);

    /**
     * 跟据角色id查询所有，用来赋值
     * @param roleid
     * @return
     */
    List<Map<String,Object>> getTreeNodeByRoleid(String roleid);

    /**
     * 删除所有这个角色id的权限
     * @param roleid
     * @return
     */
    int delRolePermission(@Param("roleid") String roleid);


    /**
     * 增加所有这个角色的权限
     * @param roleid
     * @param perid
     * @return
     */
    int addRolePermission(String roleid,String perid);

}