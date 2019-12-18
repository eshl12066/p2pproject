package com.gg.microservicememberproviderhystrix.dao;

import com.gg.microservicecommon.entity.member.MembersMaterials;
import com.gg.microservicecommon.util.Query;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * (MembersMaterials)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-12 20:54:17
 */
public interface MembersMaterialsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MembersMaterials queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MembersMaterials> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param membersMaterials 实例对象
     * @return 对象列表
     */
    List<MembersMaterials> queryAll(MembersMaterials membersMaterials);

    /**
     * 新增数据
     *
     * @return 影响行数
     */
    int insert(Query query);

    /**
     * 修改数据
     *
     * @param membersMaterials 实例对象
     * @return 影响行数
     */
    int update(MembersMaterials membersMaterials);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 模糊查
     * @return
     */
    List<Map<String,Object>> getCLAllPager(Query query);

    /**
     * 改变状态
     * @return
     */
    int updateState(Query query);

    /**
     * 连表单个查
     * @param id
     * @return
     */
    Map<String,Object> queryByCLId(Integer id);

    MembersMaterials queryMnull(Integer members_id);

}