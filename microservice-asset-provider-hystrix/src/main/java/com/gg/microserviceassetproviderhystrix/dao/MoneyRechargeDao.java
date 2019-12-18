package com.gg.microserviceassetproviderhystrix.dao;

import com.gg.microservicecommon.entity.asset.MoneyRecharge;
import com.gg.microservicecommon.util.Query;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * (MoneyRecharge)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-12 11:58:52
 *
 *充值
 */
@Repository
public interface MoneyRechargeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MoneyRecharge queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MoneyRecharge> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param moneyRecharge 实例对象
     * @return 对象列表
     */
    List<MoneyRecharge> queryAll(MoneyRecharge moneyRecharge);

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
     * @param moneyRecharge 实例对象
     * @return 影响行数
     */
    int update(MoneyRecharge moneyRecharge);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Map> ListAllPager(Query query);


    Map selectZFB(Integer id);

    int updateJE(Query query);

}