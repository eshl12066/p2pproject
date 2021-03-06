package com.gg.microservicesysproviderhystrix.service;

import com.gg.microservicecommon.util.Query;
import com.gg.microservicecommon.entity.sys.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (SysRole)表服务接口
 *
 * @author makejava
 * @since 2019-12-12 11:31:56
 */
@Service
public interface SysRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param roleid 主键
     * @return 实例对象
     */
    SysRole queryById(Integer roleid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysRole> queryAllByLimit(int offset, int limit);

    /**
     * 分页查询
     * @param query
     * @return
     */
    List<SysRole> queryPager(Query query);

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    int insert(SysRole sysRole);

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    int update(SysRole sysRole);

    /**
     * 通过主键删除数据
     *
     * @param roleid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer roleid);

    /**
     * 跟据名字查询
     *
     * @param rolename 角色名字
     * @return 影响行数
     */
    SysRole selectByName(String rolename);

    /**
     * 获取所有角色下拉
     *
     * @return 影响行数
     */
    List<SysRole> roleSelect();

    /**
     * 跟据userid去查询所有的角色
     *
     * @return 影响行数
     */
    List<SysRole> userRoleSelect(@Param("userid") String userid);

    /**
     * 跟据userid去查询所有的角色
     *
     * @return 影响行数
     */
    int addUserRole(@Param("userid") String userid,@Param("roleid") String roleid);

    /**
     * 删除(sys_user_role)
     *
     * @return 影响行数
     */
    int delUserRole(@Param("userid") String userid);

    /**
     * 通过管理员id获取多条数据
     *yx6d vg4
     * @param userid 主键
     * @return 实例对象
     */
    List<SysRole> getRoleByUserid(Integer userid);


}