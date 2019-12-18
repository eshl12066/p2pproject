package com.gg.microservicesysproviderhystrix.service.impl;

import com.gg.microservicecommon.entity.sys.SysLoginLog;
import com.gg.microservicesysproviderhystrix.dao.SysLoginLogDao;
import com.gg.microservicesysproviderhystrix.service.SysLoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysLoginLog)表服务实现类
 *
 * @author makejava
 * @since 2019-12-12 11:34:20
 */
@Service("sysLoginLogService")
public class SysLoginLogServiceImpl implements SysLoginLogService {
    @Resource
    private SysLoginLogDao sysLoginLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 实例对象
     */
    @Override
    public SysLoginLog queryById(Integer logId) {
        return this.sysLoginLogDao.queryById(logId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysLoginLog> queryAllByLimit(int offset, int limit) {
        return this.sysLoginLogDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysLoginLog 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(SysLoginLog sysLoginLog) {
        return  this.sysLoginLogDao.insert(sysLoginLog);
    }

    /**
     * 修改数据
     *
     * @param sysLoginLog 实例对象
     * @return 实例对象
     */
    @Override
    public SysLoginLog update(SysLoginLog sysLoginLog) {
        this.sysLoginLogDao.update(sysLoginLog);
        return this.queryById(sysLoginLog.getLogId());
    }

    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer logId) {
        return this.sysLoginLogDao.deleteById(logId) > 0;
    }
}