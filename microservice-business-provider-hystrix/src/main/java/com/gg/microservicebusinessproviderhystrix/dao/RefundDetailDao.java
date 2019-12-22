package com.gg.microservicebusinessproviderhystrix.dao;

import com.gg.microservicecommon.entity.business.BidRequest;
import com.gg.microservicecommon.entity.business.RefundDetail;
import com.gg.microservicecommon.util.Query;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * (RefundDetail)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-13 10:05:12
 */
public interface RefundDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RefundDetail queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RefundDetail> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param refundDetail 实例对象
     * @return 对象列表
     */
    List<RefundDetail> queryAll(RefundDetail refundDetail);

    /**
     * 新增数据
     *
     * @param refundDetail 实例对象
     * @return 影响行数
     */
    int insert(RefundDetail refundDetail);

    /**
     * 修改数据
     *
     * @return 影响行数
     */
    int update(Query query);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

//    <!--根据用户id查询未还款的还款信息（前台展示：加操作还款）-->

    List<Map<String, Object>> selectrefd(Query query);

    Map selectrefd(@Param("id") Integer id);


// <!--根据借款表id查询还款月数-->
    int selecthkys(@Param("bid_request_id") Integer bid_request_id);

//     <!--按照还款明细表借贷表id,还款状态查询已还款的期数-->
    int selectyhys(@Param("bid_request_id") Integer bid_request_id);


    int updatebidreq(@Param("bid_request_id") Integer bid_request_id);
}