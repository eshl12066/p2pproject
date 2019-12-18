package com.gg.microservicebusinessproviderhystrix.dao;

import com.gg.microservicecommon.entity.business.Bid;
import com.gg.microservicecommon.util.Query;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * (Bid)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-12 20:59:01
 */
@Repository
public interface BidDao {

    /**
     * 投标界面 数据查询
     * @param query
     * @return
     */
    List<Map<String,Object>> queryAllPager(Query query);

    /**
     * 投标界面 根据id查询某一投标的详细信息
     * @param id
     * @return
     */
    Map<String,Object> selectOne(@Param("id") Integer id);

    /**
     * 用户投标界面 根据id查询某一投标的详细信息
     * @param id
     * @return
     */
    Map<String,Object> selectUserBidDetails(@Param("id") Integer id);

    /**
     * 用户的 投标
     * @param id
     * @return
     */
    List<Map<String,Object>> selectUserBid(@Param("id") Integer id);

    /**
     * 新增投标数据
     *
     * @param bid 实例对象
     * @return 影响行数
     */
    int bidAdd(Bid bid);


    /**
     * 用户的投标界面
     * @param query
     * @return
     */
    List<Map<String,Object>> queryAllUserBid(Query query);


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Bid queryById(@Param("id") Integer id);


    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Bid> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param bid 实例对象
     * @return 对象列表
     */
    List<Bid> queryAll(Bid bid);
    /**
     * 修改数据
     *
     * @param bid 实例对象
     * @return 影响行数
     */
    int update(Bid bid);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    //查找bid表
    List<Map> selectAllPager(Query query);

    //根据ID查找借贷表bid_request
    Map selectRequestById(Integer id);

    //根据ID查找会员表
    Map selectMembersById(Integer id);


}