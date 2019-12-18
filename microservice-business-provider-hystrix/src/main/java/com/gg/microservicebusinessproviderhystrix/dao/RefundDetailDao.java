package com.gg.microservicebusinessproviderhystrix.dao;

import com.gg.microservicecommon.entity.business.RefundDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (RefundDetail)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-13 10:05:12
 */
public interface RefundDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RefundDetail queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RefundDetail> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param refundDetail 实例对象
     * @return 对象列表
     */
    List<RefundDetail> queryAll(RefundDetail refundDetail);

    /**
     * 新增数据
     *
     * @param refundDetail 实例对象
     * @return 影响行数
     */
    int insert(RefundDetail refundDetail);

    /**
     * 修改数据
     *
     * @param refundDetail 实例对象
     * @return 影响行数
     */
    int update(RefundDetail refundDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}