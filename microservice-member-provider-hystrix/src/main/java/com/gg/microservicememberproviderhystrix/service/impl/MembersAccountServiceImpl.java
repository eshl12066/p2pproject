package com.gg.microservicememberproviderhystrix.service.impl;

import com.gg.microservicecommon.entity.member.MembersAccount;
import com.gg.microservicememberproviderhystrix.dao.MembersAccountDao;
import com.gg.microservicememberproviderhystrix.service.MembersAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MembersAccount)表服务实现类
 *
 * @author makejava
 * @since 2019-12-12 20:53:41
 */
@Service("membersAccountService")
public class MembersAccountServiceImpl implements MembersAccountService {
    @Resource
    private MembersAccountDao membersAccountDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MembersAccount queryById(Integer id) {
        return this.membersAccountDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MembersAccount> queryAllByLimit(int offset, int limit) {
        return this.membersAccountDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param membersAccount 实例对象
     * @return 实例对象
     */
    @Override
    public MembersAccount insert(MembersAccount membersAccount) {
        this.membersAccountDao.insert(membersAccount);
        return membersAccount;
    }

    /**
     * 修改数据
     *
     * @param membersAccount 实例对象
     * @return 实例对象
     */
    @Override
    public MembersAccount update(MembersAccount membersAccount) {
        this.membersAccountDao.update(membersAccount);
        return this.queryById(membersAccount.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.membersAccountDao.deleteById(id) > 0;
    }
}