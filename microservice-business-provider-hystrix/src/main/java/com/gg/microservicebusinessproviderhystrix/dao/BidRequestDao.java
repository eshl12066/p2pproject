package com.gg.microservicebusinessproviderhystrix.dao;

import com.gg.microservicecommon.entity.business.BidRequest;
import com.gg.microservicecommon.entity.member.Members;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.util.List;
import java.util.Map;

/**
 * (BidRequest)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-12 20:59:25
 */
@Repository
public interface BidRequestDao {

    /**
     *  新增数据
     *
     * @param bidRequest 实例对象
     * @return 影响行数
     */
    int insertBidRequest(BidRequest bidRequest);

    /**
     * 借贷界面 数据查询
     * @param query
     * @return
     */
    List<Map> queryAllBidRequest(Query query);

    /**
     * 借贷界面 根据id查询某一借贷的详细信息
     * @param id
     * @return
     */
    Map selectOneBidRequest(Integer id);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BidRequest queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     *
     */
    List<BidRequest> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 用户的 贷款界面
     * @param id
     * @return
     */
    List<Map<String,Object>> selectUserBidRequest(@Param("id") Integer id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param bidRequest 实例对象
     * @return 对象列表
     */
    List<BidRequest> queryAll(BidRequest bidRequest);

    /**
     * 新增数据
     *
     * @param bidRequest 实例对象
     * @return 影响行数
     */
    int insert(BidRequest bidRequest);

    /**
     * 修改数据
     *
     * @param bidRequest 实例对象
     * @return 影响行数
     */
    int update(BidRequest bidRequest);

    /**
     * 修改数据
     *
     * @param map 实例对象
     * @return 影响行数
     */
    int updateMembersId(Map<String,Object> map);


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}