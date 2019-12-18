package com.gg.microservicesysproviderhystrix.dao;

import com.gg.microservicecommon.entity.sys.SysLoginLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (SysLoginLog)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-12 11:34:20
 */
@Repository
public interface SysLoginLogDao {
    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 实例对象
     */
    SysLoginLog queryById(Integer logId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysLoginLog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysLoginLog 实例对象
     * @return 对象列表
     */
    List<SysLoginLog> queryAll(SysLoginLog sysLoginLog);

    /**
     * 新增数据
     *
     * @param sysLoginLog 实例对象
     * @return 影响行数
     */
    int insert(SysLoginLog sysLoginLog);

    /**
     * 修改数据
     *
     * @param sysLoginLog 实例对象
     * @return 影响行数
     */
    int update(SysLoginLog sysLoginLog);

    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 影响行数
     */
    int deleteById(Integer logId);

}