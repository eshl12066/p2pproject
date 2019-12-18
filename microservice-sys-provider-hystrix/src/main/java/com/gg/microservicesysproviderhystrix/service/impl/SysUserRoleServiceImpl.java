package com.gg.microservicesysproviderhystrix.service.impl;

import com.gg.microservicecommon.entity.sys.Query;
import com.gg.microservicecommon.entity.sys.SysUserRole;
import com.gg.microservicesysproviderhystrix.dao.SysUserRoleDao;
import com.gg.microservicesysproviderhystrix.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (SysUserRole)表服务实现类
 *
 * @author makejava
 * @since 2019-12-12 11:34:00
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Resource
    private SysUserRoleDao sysUserRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUserRole queryById(Integer id) {
        return this.sysUserRoleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysUserRole> queryAllByLimit(int offset, int limit) {
        return this.sysUserRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysUserRole insert(SysUserRole sysUserRole) {
        this.sysUserRoleDao.insert(sysUserRole);
        return sysUserRole;
    }

    /**
     * 修改数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysUserRole update(SysUserRole sysUserRole) {
        this.sysUserRoleDao.update(sysUserRole);
        return this.queryById(sysUserRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysUserRoleDao.deleteById(id) > 0;
    }

    @Override
    public List<Map<String, Object>> bidRequestPager(Query query) {
        return this.sysUserRoleDao.bidRequestPager(query);
    }

    @Override
    public int upBidRequest0(Query query) {
        return this.sysUserRoleDao.upBidRequest0(query);
    }

    @Override
    public int upBidRequest0T(Integer membersId) {
        return this.sysUserRoleDao.upBidRequest0T(membersId);
    }
}