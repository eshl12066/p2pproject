package com.gg.microserviceassetproviderhystrix.service;

import com.gg.microservicecommon.entity.asset.Systemaccount;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Systemaccount)表服务接口
 *
 * @author makejava
 * @since 2019-12-12 20:49:20
 */
@Service
public interface SystemaccountService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Systemaccount queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Systemaccount> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param systemaccount 实例对象
     * @return 实例对象
     */
    Systemaccount insert(Systemaccount systemaccount);

    /**
     * 修改数据
     *
     * @param systemaccount 实例对象
     * @return 实例对象
     */
    Systemaccount update(Systemaccount systemaccount);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}