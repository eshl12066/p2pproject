package com.gg.microservicememberproviderhystrix.service;

import com.gg.microservicecommon.entity.member.MembersAccount;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (MembersAccount)表服务接口
 *
 * @author makejava
 * @since 2019-12-12 20:53:41
 */
@Service
public interface MembersAccountService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MembersAccount queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MembersAccount> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param membersAccount 实例对象
     * @return 实例对象
     */
    MembersAccount insert(MembersAccount membersAccount);

    /**
     * 修改数据
     *
     * @param membersAccount 实例对象
     * @return 实例对象
     */
    MembersAccount update(MembersAccount membersAccount);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}