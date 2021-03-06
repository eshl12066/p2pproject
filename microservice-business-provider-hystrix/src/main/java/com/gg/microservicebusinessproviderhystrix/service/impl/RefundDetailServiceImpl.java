package com.gg.microservicebusinessproviderhystrix.service.impl;

import com.gg.microservicebusinessproviderhystrix.dao.RefundDetailDao;
import com.gg.microservicebusinessproviderhystrix.service.RefundDetailService;
import com.gg.microservicecommon.entity.business.RefundDetail;
import com.gg.microservicecommon.util.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (RefundDetail)表服务实现类
 *
 * @author makejava
 * @since 2019-12-13 10:05:12
 */
@Service("refundDetailService")
public class RefundDetailServiceImpl implements RefundDetailService {
    @Resource
    private RefundDetailDao refundDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RefundDetail queryById(Integer id) {
        return this.refundDetailDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<RefundDetail> queryAllByLimit(int offset, int limit) {
        return this.refundDetailDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param refundDetail 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(RefundDetail refundDetail) {
         return this.refundDetailDao.insert(refundDetail);
    }

    /**
     * 修改数据
     *
     * @return 实例对象
     */
    @Override
    public int update(Query query) {
        return this.refundDetailDao.update(query);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.refundDetailDao.deleteById(id) > 0;
    }

    @Override
    public List<Map<String, Object>> selectrefd(Query query) {
        return this.refundDetailDao.selectrefd(query);

    }
    public Map selectrefd(Integer id) {
        return this.refundDetailDao.selectrefd(id);
    }

    @Override
    public int selecthkys(Integer bid_request_id) {
        return this.refundDetailDao.selecthkys(bid_request_id);
    }

    @Override
    public int selectyhys(Integer bid_request_id) {
        return this.refundDetailDao.selectyhys(bid_request_id);
    }

    @Override
    public int updatebidreq(Integer bid_request_id) {
        return this.refundDetailDao.updatebidreq(bid_request_id);
    }

    @Override
    public int updatestate(Integer id) {
        return this.refundDetailDao.updatestate(id);
    }
}