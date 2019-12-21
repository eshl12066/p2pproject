package com.gg.microservicesysproviderhystrix.service;

import com.gg.microservicecommon.util.Query;
import com.gg.microservicecommon.entity.sys.SysUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * (SysUserRole)表服务接口
 *
 * @author makejava
 * @since 2019-12-12 11:34:00
 */
@Service
public interface SysUserRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUserRole queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysUserRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    SysUserRole insert(SysUserRole sysUserRole);

    /**
     * 修改数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    SysUserRole update(SysUserRole sysUserRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 查询所有状态的集合
     * @param query
     * @return
     */
    List<Map<String,Object>> bidRequestPager(Query query);

    int upBidRequest0 (Query query);//通过初审
    int upBidRequest0T(@Param("membersId") Integer membersId);

}