package com.gg.microserviceassetproviderhystrix.service;

import com.gg.microservicecommon.entity.asset.MoneyWithdraw;
import com.gg.microservicecommon.util.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * (MoneyWithdraw)表服务接口
 *
 * @author makejava
 * @since 2019-12-12 11:59:22
 * 提现
 */
@Service
public interface MoneyWithdrawService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MoneyWithdraw queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MoneyWithdraw> queryAllByLimit(int offset, int limit);

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
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    List<Map> ListIdPager(Query query);
    List<Map> ListBymemberPager(Query query);

    List<Map> ListByuserPager(Query query);
}