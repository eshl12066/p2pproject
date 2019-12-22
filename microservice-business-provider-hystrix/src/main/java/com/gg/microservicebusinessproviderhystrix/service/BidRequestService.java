package com.gg.microservicebusinessproviderhystrix.service;

import com.gg.microservicecommon.entity.business.BidRequest;
import com.gg.microservicecommon.entity.member.Members;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;
import java.util.Map;

/**
 * (BidRequest)表服务接口
 *
 * @author makejava
 * @since 2019-12-12 20:59:25
 */
@Service
public interface BidRequestService {

    /**
     * 新增贷款数据
     *
     * @param bidRequest 实例对象
     * @return 实例对象
     */
    int insertBidRequest(BidRequest bidRequest);

    /**
     * 新增贷款数据后 需要修改 members 表中的一列数据状态
     *
     * @param map 实例对象
     * @return 影响行数
     */
    int updateMembersId(Map<String,Object> map);

    /**
     * 用户的 借贷 详情数据
     * @param id
     * @return
     */
    List<Map<String,Object>> selectUserBidRequest(Integer id);

    /**
     * 借贷界面  数据查找
     * @param query
     * @return
     */
    List<Map> queryAllBidRequest(Query query);

    /**
     * 借贷界面 根据id查看某一借贷详情
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
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BidRequest> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bidRequest 实例对象
     * @return 实例对象
     */
    BidRequest insert(BidRequest bidRequest);

    /**
     * 修改数据
     *
     * @param bidRequest 实例对象
     * @return 实例对象
     */
    BidRequest update(BidRequest bidRequest);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}