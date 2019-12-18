package com.gg.microservicesysproviderhystrix.service.impl;

import com.gg.microservicecommon.entity.sys.Query;
import com.gg.microservicecommon.entity.sys.SysUser;
import com.gg.microservicesysproviderhystrix.dao.SysUserDao;
import com.gg.microservicesysproviderhystrix.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2019-12-12 11:33:23
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(Integer userid) {
        return this.sysUserDao.queryById(userid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysUser> queryAllByLimit(int offset, int limit) {
        return this.sysUserDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<SysUser> queryPager(Query query) {
        return this.sysUserDao.queryPager(query);
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(SysUser sysUser) {
        return this.sysUserDao.insert(sysUser);
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public int update(SysUser sysUser) {
        return this.sysUserDao.update(sysUser);
    }

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userid) {
        return this.sysUserDao.deleteById(userid) > 0;
    }

    /**
     * 后台管理登录
     * @param uname 名字

     * @return
     */
    @Override
    public SysUser sysLogin(String uname){
        return this.sysUserDao.sysLogin(uname);
    }

    @Override
    public Map<String,Object> getUser(String uname) {
        return this.sysUserDao.getUser(uname);
    }

    @Override
    public Set<String> getRolesByUserId(Integer userid) {
        return this.sysUserDao.getRolesByUserId(userid);
    }

    @Override
    public Set<String> getPersByUserId(Integer userid) {
        return this.sysUserDao.getPersByUserId(userid);
    }

    /**
     * 后台管理登录
     * @param
     * @return
     */
    @Override
    public Map<String, Object> membersLogin(String name, String password) {
        return this.sysUserDao.membersLogin(name,password);
    }

    @Override
    public int addMembers(Map<String, Object> map) {
        return this.sysUserDao.addMembers(map);
    }
}