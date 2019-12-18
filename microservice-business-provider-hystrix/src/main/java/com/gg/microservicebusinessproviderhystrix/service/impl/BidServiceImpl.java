package com.gg.microservicebusinessproviderhystrix.service.impl;

import com.gg.microservicebusinessproviderhystrix.dao.BidDao;
import com.gg.microservicebusinessproviderhystrix.service.BidService;
import com.gg.microservicecommon.entity.business.Bid;
import com.gg.microservicecommon.util.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Bid)表服务实现类
 *
 * @author makejava
 * @since 2019-12-12 20:59:02
 */
@Service("bidService")
public class BidServiceImpl implements BidService {
    @Resource
    private BidDao bidDao;

    /**
     * 投标界面 数据查询
     * @param query
     * @return
     */
    @Override
    public List<Map<String,Object>> queryAllPager(Query query) {
        return this.bidDao.queryAllPager(query);
    }


    /**
     * 用户登录后的投标数据
     * @param query
     * @return
     */
    @Override
    public List<Map<String,Object>> queryAllUserBid(Query query) {
        return this.bidDao.queryAllUserBid(query);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Map<String,Object> selectOne(Integer id) {
        return this.bidDao.selectOne(id);
    }

    /**
     * 用户的投标信息通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Map<String,Object> selectUserBidDetails(Integer id) {
        return this.bidDao.selectUserBidDetails(id);
    }


    /**
     * 用户的投标数据信息
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public  List<Map<String,Object>> selectUserBid(Integer id) {
        return this.bidDao.selectUserBid(id);
    }

    /**
     * 新增数据
     *
     * @param bid 实例对象
     * @return 实例对象
     */
    @Override
    public int bidAdd(Bid bid) {
        int i = this.bidDao.bidAdd(bid);
        return i;
    }


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Bid queryById(Integer id) {
        return this.bidDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Bid> queryAllByLimit(int offset, int limit) {
        return this.bidDao.queryAllByLimit(offset, limit);
    }


    /**
     * 修改数据
     *
     * @param bid 实例对象
     * @return 实例对象
     */
    @Override
    public Bid update(Bid bid) {
        this.bidDao.update(bid);
        return this.queryById(bid.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.bidDao.deleteById(id) > 0;
    }

    @Override
    public List<Map> selectAllPager(Query query) {
        return this.bidDao.selectAllPager(query);
    }

    @Override
    public Map selectRequestById(Integer id) {
        return this.bidDao.selectRequestById(id);
    }

    @Override
    public Map selectMembersById(Integer id) {
        return this.bidDao.selectMembersById(id);
    }
}