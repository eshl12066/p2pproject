package com.gg.microservicesysproviderhystrix.service;

import com.gg.microservicecommon.entity.sys.SysLoginLog;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (SysLoginLog)表服务接口
 *
 * @author makejava
 * @since 2019-12-12 11:34:20
 */
@Service
public interface SysLoginLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 实例对象
     */
    SysLoginLog queryById(Integer logId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysLoginLog> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysLoginLog 实例对象
     * @return 实例对象
     */
    int insert(SysLoginLog sysLoginLog);

    /**
     * 修改数据
     *
     * @param sysLoginLog 实例对象
     * @return 实例对象
     */
    SysLoginLog update(SysLoginLog sysLoginLog);

    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer logId);

}