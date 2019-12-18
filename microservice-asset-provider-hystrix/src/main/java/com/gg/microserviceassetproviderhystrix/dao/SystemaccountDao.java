package com.gg.microserviceassetproviderhystrix.dao;

import com.gg.microservicecommon.entity.asset.Systemaccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Systemaccount)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-12 20:49:20
 */
public interface SystemaccountDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Systemaccount queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Systemaccount> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param systemaccount 实例对象
     * @return 对象列表
     */
    List<Systemaccount> queryAll(Systemaccount systemaccount);

    /**
     * 新增数据
     *
     * @param systemaccount 实例对象
     * @return 影响行数
     */
    int insert(Systemaccount systemaccount);

    /**
     * 修改数据
     *
     * @param systemaccount 实例对象
     * @return 影响行数
     */
    int update(Systemaccount systemaccount);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}