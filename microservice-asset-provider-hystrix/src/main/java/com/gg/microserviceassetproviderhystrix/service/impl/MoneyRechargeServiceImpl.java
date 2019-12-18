package com.gg.microserviceassetproviderhystrix.service.impl;

import com.gg.microserviceassetproviderhystrix.dao.MoneyRechargeDao;
import com.gg.microserviceassetproviderhystrix.service.MoneyRechargeService;
import com.gg.microservicecommon.entity.asset.MoneyRecharge;
import com.gg.microservicecommon.util.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (MoneyRecharge)表服务实现类
 *
 * @author makejava
 * @since 2019-12-12 11:58:54
 */
@Service("moneyRechargeService")
public class MoneyRechargeServiceImpl implements MoneyRechargeService {
    @Resource
    private MoneyRechargeDao moneyRechargeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MoneyRecharge queryById(Integer id) {
        return this.moneyRechargeDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MoneyRecharge> queryAllByLimit(int offset, int limit) {
        return this.moneyRechargeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     *
     * @return 实例对象
     */
    @Override
    public int insert(Query query) {
        return this.moneyRechargeDao.insert(query);
    }

    /**
     * 修改数据
     *
     * @param moneyRecharge 实例对象
     * @return 实例对象
     */
    @Override
    public MoneyRecharge update(MoneyRecharge moneyRecharge) {
        this.moneyRechargeDao.update(moneyRecharge);
        return this.queryById(moneyRecharge.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.moneyRechargeDao.deleteById(id) > 0;
    }


    @Override
    public List<Map>  ListAllPager(Query query) {
        return this.moneyRechargeDao.ListAllPager(query);
    }

    @Override
    public Map selectZFB(Integer id) {
        return this.moneyRechargeDao.selectZFB(id);
    }

    @Override
    public int updateJE(Query query) {
        return this.moneyRechargeDao.updateJE(query);
    }
}