package com.gg.microserviceassetproviderhystrix.service.impl;

import com.gg.microserviceassetproviderhystrix.dao.SystemaccountDao;
import com.gg.microserviceassetproviderhystrix.service.SystemaccountService;
import com.gg.microservicecommon.entity.asset.Systemaccount;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Systemaccount)表服务实现类
 *
 * @author makejava
 * @since 2019-12-12 20:49:20
 */
@Service("systemaccountService")
public class SystemaccountServiceImpl implements SystemaccountService {
    @Resource
    private SystemaccountDao systemaccountDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Systemaccount queryById(Integer id) {
        return this.systemaccountDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Systemaccount> queryAllByLimit(int offset, int limit) {
        return this.systemaccountDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param systemaccount 实例对象
     * @return 实例对象
     */
    @Override
    public Systemaccount insert(Systemaccount systemaccount) {
        this.systemaccountDao.insert(systemaccount);
        return systemaccount;
    }

    /**
     * 修改数据
     *
     * @param systemaccount 实例对象
     * @return 实例对象
     */
    @Override
    public Systemaccount update(Systemaccount systemaccount) {
        this.systemaccountDao.update(systemaccount);
        return this.queryById(systemaccount.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.systemaccountDao.deleteById(id) > 0;
    }
}