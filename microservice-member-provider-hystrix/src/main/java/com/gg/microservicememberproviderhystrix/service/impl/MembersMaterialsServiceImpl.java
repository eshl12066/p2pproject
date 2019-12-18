package com.gg.microservicememberproviderhystrix.service.impl;

import com.gg.microservicecommon.entity.member.MembersMaterials;
import com.gg.microservicecommon.util.Query;
import com.gg.microservicememberproviderhystrix.dao.MembersMaterialsDao;
import com.gg.microservicememberproviderhystrix.service.MembersMaterialsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (MembersMaterials)表服务实现类
 *
 * @author makejava
 * @since 2019-12-12 20:54:17
 */
@Service("membersMaterialsService")
public class MembersMaterialsServiceImpl implements MembersMaterialsService {
    @Resource
    private MembersMaterialsDao membersMaterialsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MembersMaterials queryById(Integer id) {
        return this.membersMaterialsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MembersMaterials> queryAllByLimit(int offset, int limit) {
        return this.membersMaterialsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @return 实例对象
     */
    @Override
    public int insert(Query query) {
        return   this.membersMaterialsDao.insert(query);
    }

    /**
     * 修改数据
     *
     * @param membersMaterials 实例对象
     * @return 实例对象
     */
    @Override
    public MembersMaterials update(MembersMaterials membersMaterials) {
        this.membersMaterialsDao.update(membersMaterials);
        return this.queryById(membersMaterials.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.membersMaterialsDao.deleteById(id) > 0;
    }

    @Override
    public List<Map<String, Object>> getCLAllPager(Query query) {
        return this.membersMaterialsDao.getCLAllPager(query);
    }

    @Override
    public int updateState(Query query) {
        return this.membersMaterialsDao.updateState(query);
    }


    @Override
    public Map<String, Object> queryByCLId(Integer id) {
        return this.membersMaterialsDao.queryByCLId(id);
    }

    @Override
    public MembersMaterials queryMnull(Integer members_id) {
        return this.membersMaterialsDao.queryMnull(members_id);
    }
}