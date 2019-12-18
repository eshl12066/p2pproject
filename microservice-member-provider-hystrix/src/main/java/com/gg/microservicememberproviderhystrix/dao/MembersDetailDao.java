package com.gg.microservicememberproviderhystrix.dao;

import com.gg.microservicecommon.entity.member.MembersDetail;
import com.gg.microservicecommon.util.PageBaen;
import org.apache.ibatis.annotations.Param;

import javax.management.Query;
import java.util.List;

/**
 * (MembersDetail)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-12 20:54:03
 */
public interface MembersDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MembersDetail queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MembersDetail> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param membersDetail 实例对象
     * @return 对象列表
     */
    List<MembersDetail> queryAll(MembersDetail membersDetail);

    /**
     * 新增数据
     *
     * @return 影响行数
     */
    int insert(PageBaen pageBaen);

    /**
     * 修改数据
     *
     * @param membersDetail 实例对象
     * @return 影响行数
     */
    int update(MembersDetail membersDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    MembersDetail queryDnull(Integer members_id);

}