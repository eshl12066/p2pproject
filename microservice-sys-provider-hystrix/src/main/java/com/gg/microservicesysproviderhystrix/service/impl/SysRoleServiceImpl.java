package com.gg.microservicesysproviderhystrix.service.impl;

import com.gg.microservicecommon.util.Query;
import com.gg.microservicecommon.entity.sys.SysRole;
import com.gg.microservicecommon.util.Query;
import com.gg.microservicesysproviderhystrix.dao.SysRoleDao;
import com.gg.microservicesysproviderhystrix.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (SysRole)表服务实现类
 *
 * @author makejava
 * @since 2019-12-12 11:31:56
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleDao sysRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param roleid 主键
     * @return 实例对象
     */
    @Override
    public SysRole queryById(Integer roleid) {
        return this.sysRoleDao.queryById(roleid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysRole> queryAllByLimit(int offset, int limit) {
        return this.sysRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 分页查询
     * @param query
     * @return
     */
    @Override
    public List<SysRole> queryPager(Query query) {
        return this.sysRoleDao.queryPager(query);
    }


    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(SysRole sysRole) {
        return this.sysRoleDao.insert(sysRole);
    }

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public int update(SysRole sysRole) {
        return this.sysRoleDao.update(sysRole);
    }

    /**
     * 通过主键删除数据
     *
     * @param roleid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer roleid) {
        return this.sysRoleDao.deleteById(roleid) > 0;
    }

    /**
     * 跟据名字查询
     * @param rolename 角色名字
     * @return 影响行数
     */
    @Override
    public SysRole selectByName(String rolename) {
        return this.sysRoleDao.selectByName(rolename);
    }

    @Override
    public List<SysRole> roleSelect() {
        return this.sysRoleDao.roleSelect();
    }

    @Override
    public List<SysRole> userRoleSelect(String userid) {
        return this.sysRoleDao.userRoleSelect(userid);
    }

    @Override
    public int addUserRole(String userid, String roleid) {
        return this.sysRoleDao.addUserRole(userid,roleid);
    }

    @Override
    public int delUserRole(String userid) {
        return this.sysRoleDao.delUserRole(userid);
    }

    @Override
    public List<SysRole> getRoleByUserid(Integer userid) {
        return this.sysRoleDao.getRoleByUserid(userid);
    }
}