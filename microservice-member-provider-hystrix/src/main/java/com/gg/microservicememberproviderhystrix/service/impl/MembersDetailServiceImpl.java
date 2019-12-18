package com.gg.microservicememberproviderhystrix.service.impl;

import com.gg.microservicecommon.entity.member.MembersDetail;
import com.gg.microservicecommon.util.PageBaen;
import com.gg.microservicememberproviderhystrix.dao.MembersDetailDao;
import com.gg.microservicememberproviderhystrix.service.MembersDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.management.Query;
import java.util.List;

/**
 * (MembersDetail)表服务实现类
 *
 * @author makejava
 * @since 2019-12-12 20:54:03
 */
@Service("membersDetailService")
public class MembersDetailServiceImpl implements MembersDetailService {
    @Resource
    private MembersDetailDao membersDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MembersDetail queryById(Integer id) {
        return this.membersDetailDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MembersDetail> queryAllByLimit(int offset, int limit) {
        return this.membersDetailDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @return 实例对象
     */
    @Override
    public int insert(PageBaen pageBaen) {
        return   this.membersDetailDao.insert(pageBaen);
    }

    /**
     * 修改数据
     *
     * @param membersDetail 实例对象
     * @return 实例对象
     */
    @Override
    public MembersDetail update(MembersDetail membersDetail) {
        this.membersDetailDao.update(membersDetail);
        return this.queryById(membersDetail.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.membersDetailDao.deleteById(id) > 0;
    }

    @Override
    public MembersDetail queryDnull(Integer members_id) {
        return this.membersDetailDao.queryDnull(members_id);
    }
}