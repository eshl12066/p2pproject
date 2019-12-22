package com.gg.microservicesysproviderhystrix.service;

import com.gg.microservicecommon.util.Query;
import com.gg.microservicecommon.entity.sys.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2019-12-12 11:33:23
 */
@Service
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    SysUser queryById(Integer userid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit(int offset, int limit);

    /**
     * 分页查询
     * @param query
     * @return
     */
    List<SysUser> queryPager(Query query);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    int insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    int update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userid);

    /**
     * 后台管理登录
     * @param uname 名字
     * @return
     */
    SysUser sysLogin( String uname);

    /**
     * 后台管理登录
     * @param uname 名字
     * @return
     */
    Map<String,Object> getUser(@Param("uname") String uname);

    Set<String> getRolesByUserId(Integer userid);

    Set<String> getPersByUserId(Integer userid);

    /**
     * 前台用户登陆
     * @param
     * @return
     */
    Map<String,Object> membersLogin(@Param("name") String name, @Param("password")String password);

    /**
     * 前台用户注册
     * @param
     * @return
     */
    int addMembers(Map<String,Object> map );


}