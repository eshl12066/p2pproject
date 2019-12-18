package com.gg.microservicebusinessproviderhystrix.service;

import com.gg.microservicecommon.entity.business.RefundDetail;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (RefundDetail)表服务接口
 *
 * @author makejava
 * @since 2019-12-13 10:05:12
 */
@Service
public interface RefundDetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RefundDetail queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RefundDetail> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param refundDetail 实例对象
     * @return 实例对象
     */
    RefundDetail insert(RefundDetail refundDetail);

    /**
     * 修改数据
     *
     * @param refundDetail 实例对象
     * @return 实例对象
     */
    RefundDetail update(RefundDetail refundDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}