package com.gg.microservicebusinessproviderhystrix.service;

import com.gg.microservicecommon.entity.business.ReturnDetail;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (ReturnDetail)表服务接口
 *
 * @author makejava
 * @since 2019-12-13 10:05:30
 */
@Service
public interface ReturnDetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ReturnDetail queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ReturnDetail> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param returnDetail 实例对象
     * @return 实例对象
     */
    ReturnDetail insert(ReturnDetail returnDetail);

    /**
     * 修改数据
     *
     * @param returnDetail 实例对象
     * @return 实例对象
     */
    ReturnDetail update(ReturnDetail returnDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}