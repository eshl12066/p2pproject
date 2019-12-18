package com.gg.microservicebusinessproviderhystrix.service.impl;

import com.gg.microservicebusinessproviderhystrix.dao.ReturnDetailDao;
import com.gg.microservicebusinessproviderhystrix.service.ReturnDetailService;
import com.gg.microservicecommon.entity.business.ReturnDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ReturnDetail)表服务实现类
 *
 * @author makejava
 * @since 2019-12-13 10:05:30
 */
@Service("returnDetailService")
public class ReturnDetailServiceImpl implements ReturnDetailService {
    @Resource
    private ReturnDetailDao returnDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ReturnDetail queryById(Integer id) {
        return this.returnDetailDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ReturnDetail> queryAllByLimit(int offset, int limit) {
        return this.returnDetailDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param returnDetail 实例对象
     * @return 实例对象
     */
    @Override
    public ReturnDetail insert(ReturnDetail returnDetail) {
        this.returnDetailDao.insert(returnDetail);
        return returnDetail;
    }

    /**
     * 修改数据
     *
     * @param returnDetail 实例对象
     * @return 实例对象
     */
    @Override
    public ReturnDetail update(ReturnDetail returnDetail) {
        this.returnDetailDao.update(returnDetail);
        return this.queryById(returnDetail.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.returnDetailDao.deleteById(id) > 0;
    }
}