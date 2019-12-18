package com.gg.microserviceassetproviderhystrix.service;

import com.gg.microservicecommon.entity.asset.MoneyRecharge;
import com.gg.microservicecommon.util.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * (MoneyRecharge)表服务接口
 *
 * @author makejava
 * @since 2019-12-12 11:58:53
 * 充值
 */
@Service
public interface MoneyRechargeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MoneyRecharge queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MoneyRecharge> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     *
     * @return 实例对象
     */
    int insert(Query query);

    /**
     * 修改数据
     *
     * @param moneyRecharge 实例对象
     * @return 实例对象
     */
    MoneyRecharge update(MoneyRecharge moneyRecharge);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    //分页查找全部
    List<Map> ListAllPager(Query query);

    Map selectZFB(Integer id);

    int updateJE(Query query);
}