package com.gg.microservicememberproviderhystrix.dao;

import com.gg.microservicecommon.entity.member.MembersAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (MembersAccount)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-12 20:53:41
 */
public interface MembersAccountDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MembersAccount queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MembersAccount> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param membersAccount 实例对象
     * @return 对象列表
     */
    List<MembersAccount> queryAll(MembersAccount membersAccount);

    /**
     * 新增数据
     *
     * @param membersAccount 实例对象
     * @return 影响行数
     */
    int insert(MembersAccount membersAccount);

    /**
     * 修改数据
     *
     * @param membersAccount 实例对象
     * @return 影响行数
     */
    int update(MembersAccount membersAccount);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}