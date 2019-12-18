package com.gg.microserviceassetproviderhystrix.service.impl;

import com.gg.microserviceassetproviderhystrix.dao.MoneyWithdrawDao;
import com.gg.microserviceassetproviderhystrix.service.MoneyWithdrawService;
import com.gg.microservicecommon.entity.asset.MoneyWithdraw;
import com.gg.microservicecommon.util.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (MoneyWithdraw)表服务实现类
 *
 * @author makejava
 * @since 2019-12-12 11:59:22
 */
@Service("moneyWithdrawService")
public class MoneyWithdrawServiceImpl implements MoneyWithdrawService {
    @Resource
    private MoneyWithdrawDao moneyWithdrawDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MoneyWithdraw queryById(Integer id) {
        return this.moneyWithdrawDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MoneyWithdraw> queryAllByLimit(int offset, int limit) {
        return this.moneyWithdrawDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     *
     * @return 实例对象
     */
    @Override
    public int insert(Query query) {
        return this.moneyWithdrawDao.insert(query);
    }

    /**
     * 修改数据
     *
     *
     * @return 实例对象
     */
    @Override
    public int update(Query query) {

        return this.moneyWithdrawDao.update(query);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.moneyWithdrawDao.deleteById(id) > 0;
    }

    @Override
    public List<Map> ListBymemberPager(Query query) {
        return this.moneyWithdrawDao.ListBymemberPager(query);
    }

    @Override
    public List<Map> ListByuserPager(Query query) {
        return this.moneyWithdrawDao.ListByuserPager(query);
    }
}