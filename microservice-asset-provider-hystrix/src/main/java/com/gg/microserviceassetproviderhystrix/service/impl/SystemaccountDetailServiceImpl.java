package com.gg.microserviceassetproviderhystrix.service.impl;

import com.gg.microserviceassetproviderhystrix.dao.SystemaccountDetailDao;
import com.gg.microserviceassetproviderhystrix.service.SystemaccountDetailService;
import com.gg.microservicecommon.entity.asset.SystemaccountDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SystemaccountDetail)表服务实现类
 *
 * @author makejava
 * @since 2019-12-12 20:49:46
 */
@Service("systemaccountDetailService")
public class SystemaccountDetailServiceImpl implements SystemaccountDetailService {
    @Resource
    private SystemaccountDetailDao systemaccountDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SystemaccountDetail queryById(Integer id) {
        return this.systemaccountDetailDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SystemaccountDetail> queryAllByLimit(int offset, int limit) {
        return this.systemaccountDetailDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param systemaccountDetail 实例对象
     * @return 实例对象
     */
    @Override
    public SystemaccountDetail insert(SystemaccountDetail systemaccountDetail) {
        this.systemaccountDetailDao.insert(systemaccountDetail);
        return systemaccountDetail;
    }

    /**
     * 修改数据
     *
     * @param systemaccountDetail 实例对象
     * @return 实例对象
     */
    @Override
    public SystemaccountDetail update(SystemaccountDetail systemaccountDetail) {
        this.systemaccountDetailDao.update(systemaccountDetail);
        return this.queryById(systemaccountDetail.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.systemaccountDetailDao.deleteById(id) > 0;
    }
}