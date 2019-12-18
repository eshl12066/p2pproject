package com.gg.microservicememberproviderhystrix.dao;

import com.gg.microservicecommon.entity.member.Members;
import com.gg.microservicecommon.util.Query;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * (Members)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-12 20:53:14
 */
public interface MembersDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Members queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Members> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param members 实例对象
     * @return 对象列表
     */
    List<Members> queryAll(Members members);

    /**
     * 新增数据
     *
     * @param members 实例对象
     * @return 影响行数
     */
    int insert(Members members);

    /**
     * 修改数据
     *
     * @param members 实例对象
     * @return 影响行数
     */
    int update(Members members);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查询所有
     * @return
     */
    List<Map<String,Object>> getAllPager(Query query);

}