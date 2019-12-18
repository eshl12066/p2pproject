package com.gg.microservicememberproviderhystrix.service.impl;

import com.gg.microservicecommon.entity.member.MembersRealname;
import com.gg.microservicecommon.util.PageBaen;
import com.gg.microservicememberproviderhystrix.dao.MembersRealnameDao;
import com.gg.microservicememberproviderhystrix.service.MembersRealnameService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.management.Query;
import java.util.List;
import java.util.Map;

/**
 * (MembersRealname)表服务实现类
 *
 * @author makejava
 * @since 2019-12-12 20:54:39
 */
@Service("membersRealnameService")
public class MembersRealnameServiceImpl implements MembersRealnameService {
    @Resource
    private MembersRealnameDao membersRealnameDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MembersRealname queryById(Integer id) {
        return this.membersRealnameDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MembersRealname> queryAllByLimit(int offset, int limit) {
        return this.membersRealnameDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @return 实例对象
     */
    @Override
    public int insert(PageBaen pageBaen) {
        return this.membersRealnameDao.insert(pageBaen);
    }

    /**
     * 修改数据
     *
     * @param membersRealname 实例对象
     * @return 实例对象
     */
    @Override
    public MembersRealname update(MembersRealname membersRealname) {
        this.membersRealnameDao.update(membersRealname);
        return this.queryById(membersRealname.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.membersRealnameDao.deleteById(id) > 0;
    }

    @Override
    public Map<String, Object> queryByRLId(Integer id) {
        return this.membersRealnameDao.queryByRLId(id);
    }

    @Override
    public int updateState(PageBaen pageBaen) {
        return this.membersRealnameDao.updateState(pageBaen);
    }

    @Override
    public List<Map<String, Object>> getRAllPager(PageBaen pageBaen) {
        return this.membersRealnameDao.getRAllPager(pageBaen);
    }

    @Override
    public MembersRealname queryRnull(Integer members_id) {
        return this.membersRealnameDao.queryRnull(members_id);
    }
}