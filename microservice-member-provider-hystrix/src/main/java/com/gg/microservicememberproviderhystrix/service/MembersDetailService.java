package com.gg.microservicememberproviderhystrix.service;

import com.gg.microservicecommon.entity.member.MembersDetail;
import com.gg.microservicecommon.util.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (MembersDetail)表服务接口
 *
 * @author makejava
 * @since 2019-12-12 20:54:03
 */
@Service
public interface MembersDetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MembersDetail queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MembersDetail> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @return 实例对象
     */
    int insert(Query query);

    /**
     * 修改数据
     *
     * @param membersDetail 实例对象
     * @return 实例对象
     */
    MembersDetail update(MembersDetail membersDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    MembersDetail queryDnull(Integer members_id);

}