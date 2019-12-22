package com.gg.microservicesysproviderhystrix.dao;

import com.gg.microservicecommon.util.Query;
import com.gg.microservicecommon.entity.sys.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * (SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-12 11:33:23
 */
@Repository
public interface SysUserDao {
    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    SysUser queryById(Integer userid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 分页查询
     * @param query
     * @return
     */
    List<SysUser> queryPager(Query query);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUser 实例对象
     * @return 对象列表
     */
    List<SysUser> queryAll(SysUser sysUser);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 影响行数
     */
    int deleteById(Integer userid);

    /**
     * 后台管理登录
     * @param uname 名字
     * @return
     */
    SysUser sysLogin(@Param("uname") String uname);


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
    Map<String,Object> membersLogin(@Param("name") String name,@Param("password")String password);

    /**
     * 前台用户注册
     * @param
     * @return
     */
    int addMembers(Map<String,Object> map );

}