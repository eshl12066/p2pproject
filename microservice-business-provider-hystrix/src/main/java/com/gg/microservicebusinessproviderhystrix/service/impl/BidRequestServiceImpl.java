package com.gg.microservicebusinessproviderhystrix.service.impl;

import com.gg.microservicebusinessproviderhystrix.dao.BidRequestDao;
import com.gg.microservicebusinessproviderhystrix.service.BidRequestService;
import com.gg.microservicecommon.entity.business.BidRequest;
import com.gg.microservicecommon.entity.member.Members;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.management.Query;
import java.util.List;
import java.util.Map;

/**
 * (BidRequest)表服务实现类
 *
 * @author makejava
 * @since 2019-12-12 20:59:25
 */
@Service("bidRequestService")
public class BidRequestServiceImpl implements BidRequestService {
    @Resource
    private BidRequestDao bidRequestDao;

    /**
     * 新增数据
     *
     * @param bidRequest 实例对象
     * @return 实例对象
     */
    @Override
    public int insertBidRequest(BidRequest bidRequest) {
        int i = this.bidRequestDao.insertBidRequest(bidRequest);
        return i;
    }

    /**
     * 新增贷款数据后 需要修改 members 表中的一列数据状态
     *
     * @param map 实例对象
     * @return 影响行数
     */
    public int updateMembersId(Map<String,Object> map){
        int i = this.bidRequestDao.updateMembersId(map);
        return i;
    }

    /**
     * 投标界面 数据查询
     * @param query
     * @return
     */
    @Override
    public List<Map> queryAllBidRequest(Query query) {
        return this.bidRequestDao.queryAllBidRequest(query);
    }


    /**
     * 用户的投标数据信息
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public  List<Map<String,Object>> selectUserBidRequest(Integer id) {
        return this.bidRequestDao.selectUserBidRequest(id);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Map selectOneBidRequest(Integer id) {
        return this.bidRequestDao.selectOneBidRequest(id);
    }


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Members queryById(Integer id) {
        return this.bidRequestDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BidRequest> queryAllByLimit(int offset, int limit) {
        return this.bidRequestDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bidRequest 实例对象
     * @return 实例对象
     */
    @Override
    public BidRequest insert(BidRequest bidRequest) {
        this.bidRequestDao.insert(bidRequest);
        return bidRequest;
    }

    /**
     * 修改数据
     *
     * @param bidRequest 实例对象
     * @return 实例对象
     */
    @Override
    public BidRequest update(BidRequest bidRequest) {
        this.bidRequestDao.update(bidRequest);
        return this.update(bidRequest);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.bidRequestDao.deleteById(id) > 0;
    }
}