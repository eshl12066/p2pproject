package com.gg.microservicememberproviderhystrix.dao;

import com.gg.microservicecommon.entity.member.MembersRealname;
import com.gg.microservicecommon.util.PageBaen;
import org.apache.ibatis.annotations.Param;

import javax.management.Query;
import java.util.List;
import java.util.Map;

/**
 * (MembersRealname)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-12 20:54:39
 */
public interface MembersRealnameDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MembersRealname queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MembersRealname> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param membersRealname 实例对象
     * @return 对象列表
     */
    List<MembersRealname> queryAll(MembersRealname membersRealname);

    /**
     * 新增数据
     *
     * @return 影响行数
     */
    int insert(PageBaen pageBaen);

    /**
     * 修改数据
     *
     * @param membersRealname 实例对象
     * @return 影响行数
     */
    int update(MembersRealname membersRealname);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查询单个
     * @param id
     * @return
     */
    Map<String,Object> queryByRLId(Integer id);

    /**
     * 修改状态
     * @param pageBaen
     * @return
     */
    int updateState(PageBaen pageBaen);

    /**
     * 查看所有
     * @param pageBaen
     * @return
     */
    List<Map<String,Object>> getRAllPager(PageBaen pageBaen);

    /**
     *
     * @param members_id 是空的
     * @return
     */
    MembersRealname queryRnull(Integer members_id);

}