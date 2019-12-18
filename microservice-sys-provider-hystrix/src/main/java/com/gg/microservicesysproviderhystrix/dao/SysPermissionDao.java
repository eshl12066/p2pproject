package com.gg.microservicesysproviderhystrix.dao;

import com.gg.microservicecommon.entity.sys.SysPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * (SysPermission)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-12 11:29:35
 */
@Repository
public interface SysPermissionDao {
    /**
     * 通过ID查询单条数据
     *
     * @param perid 主键
     * @return 实例对象
     */
    SysPermission queryById(Integer perid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysPermission> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysPermission 实例对象
     * @return 对象列表
     */
    List<SysPermission> queryAll(SysPermission sysPermission);

    /**
     * 新增数据
     *
     * @param sysPermission 实例对象
     * @return 影响行数
     */
    int insert(SysPermission sysPermission);

    /**
     * 修改数据
     *
     * @param sysPermission 实例对象
     * @return 影响行数
     */
    int update(SysPermission sysPermission);

    /**
     * 通过主键删除数据
     *
     * @param perid 主键
     * @return 影响行数
     */
    int deleteById(Integer perid);

    /**
     * 跟据uid查询树形菜单
     * @param uid
     * @param pid
     * @return
     */
    List<Map<String,Object>> getTreeNode(@Param("uid") String uid, @Param("pid") String pid);

    /**
     * 跟据角色id查询所有，用来赋值
     * @param roleid
     * @return
     */
    List<Map<String,Object>> getTreeNodeByRoleid(@Param("roleid") String roleid);


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
    int addRolePermission(@Param("roleid") String roleid,@Param("perid") String perid);

}