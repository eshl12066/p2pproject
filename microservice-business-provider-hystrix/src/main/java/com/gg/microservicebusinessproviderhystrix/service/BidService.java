package com.gg.microservicebusinessproviderhystrix.service;

import com.gg.microservicecommon.entity.business.Bid;
import com.gg.microservicecommon.util.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * (Bid)表服务接口
 *
 * @author makejava
 * @since 2019-12-12 20:59:02
 */
@Service
public interface BidService {

    /**
     * 投标界面  数据查找
     * @param query
     * @return
     */
    List<Map<String,Object>> queryAllPager(Query query);

    /**
     * 用户的投标
     * @param query
     * @return
     */
    List<Map<String,Object>> queryAllUserBid(Query query);

    /**
     * 投标界面 根据id查看某一投标详情
     * @param id
     * @return
     */
    Map<String,Object> selectOne(Integer id);

    /**
     * 用户的投标界面 根据id查看某一投标详情
     * @param id
     * @return
     */
    Map<String,Object> selectUserBidDetails(Integer id);


    /**
     * 用户的 投标 详情数据
     * @param id
     * @return
     */
    List<Map<String,Object>> selectUserBid(Integer id);


    /**
     * 新增数据
     *
     * @param bid 实例对象
     * @return 影响行数
     */
    int bidAdd(Bid bid);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Bid queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Bid> queryAllByLimit(int offset, int limit);


    /**
     * 修改数据
     *
     * @param bid 实例对象
     * @return 实例对象
     */
    Bid update(Bid bid);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    //查找bid表
    List<Map> selectAllPager(Query query);

    //根据ID查找借贷表bid_request
    Map selectRequestById(Integer id);

    //根据ID查找会员表
    Map selectMembersById(Integer id);
}