package com.gg.microservicesysproviderhystrix.dao;

import com.gg.microservicecommon.entity.sys.Query;
import com.gg.microservicecommon.entity.sys.SysUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * (SysUserRole)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-12 11:34:00
 */
@Repository
public interface SysUserRoleDao {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUserRole queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysUserRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUserRole 实例对象
     * @return 对象列表
     */
    List<SysUserRole> queryAll(SysUserRole sysUserRole);

    /**
     * 新增数据
     *
     * @param sysUserRole 实例对象
     * @return 影响行数
     */
    int insert(SysUserRole sysUserRole);

    /**
     * 修改数据
     *
     * @param sysUserRole 实例对象
     * @return 影响行数
     */
    int update(SysUserRole sysUserRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查询所有状态的集合
     * @param query
     * @return
     */
    List<Map<String,Object>> bidRequestPager(Query query);

    int upBidRequest0 (Query query);
    int upBidRequest0T(@Param("membersId") Integer membersId);

}