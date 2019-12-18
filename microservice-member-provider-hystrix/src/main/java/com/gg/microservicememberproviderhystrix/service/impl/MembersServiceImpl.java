package com.gg.microservicememberproviderhystrix.service.impl;

import com.gg.microservicecommon.entity.member.Members;
import com.gg.microservicecommon.util.PageBaen;
import com.gg.microservicememberproviderhystrix.dao.MembersDao;
import com.gg.microservicememberproviderhystrix.service.MembersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.management.Query;
import java.util.List;
import java.util.Map;

/**
 * (Members)表服务实现类
 *
 * @author makejava
 * @since 2019-12-12 20:53:15
 */
@Service("membersService")
public class MembersServiceImpl implements MembersService {
    @Resource
    private MembersDao membersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Members queryById(Integer id) {
        return this.membersDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Members> queryAllByLimit(int offset, int limit) {
        return this.membersDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param members 实例对象
     * @return 实例对象
     */
    @Override
    public Members insert(Members members) {
        this.membersDao.insert(members);
        return members;
    }

    /**
     * 修改数据
     *
     * @param members 实例对象
     * @return 实例对象
     */
    @Override
    public Members update(Members members) {
        this.membersDao.update(members);
        return this.queryById(members.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.membersDao.deleteById(id) > 0;
    }

    @Override
    public List<Map<String, Object>> getAllPager(PageBaen pageBaen) {
        return this.membersDao.getAllPager(pageBaen);
    }
}