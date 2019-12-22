package com.gg.microserviceassetproviderhystrix.dao;

import com.gg.microservicecommon.entity.asset.MoneyWithdraw;
import com.gg.microservicecommon.util.Query;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * (MoneyWithdraw)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-12 11:59:22
 *
 * 提现
 */
@Repository
public interface MoneyWithdrawDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MoneyWithdraw queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MoneyWithdraw> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param moneyWithdraw 实例对象
     * @return 对象列表
     */
    List<MoneyWithdraw> queryAll(MoneyWithdraw moneyWithdraw);

    /**
     * 新增数据
     *
     *
     * @return 影响行数
     */
    int insert(Query query);

    /**
     * 修改数据
     *
     *
     * @return 影响行数
     */
    int update(Query query);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     *
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Map> ListIdPager(Query query);

    List<Map> ListBymemberPager(Query query);

    List<Map> ListByuserPager(Query query);

}