package com.gg.microservicememberproviderhystrix.service;

import com.gg.microservicecommon.entity.member.MembersRealname;
import com.gg.microservicecommon.util.PageBaen;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;
import java.util.Map;

/**
 * (MembersRealname)表服务接口
 *
 * @author makejava
 * @since 2019-12-12 20:54:39
 */
@Service
public interface MembersRealnameService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MembersRealname queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MembersRealname> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @return 实例对象
     */
    int insert(PageBaen pageBaen);

    /**
     * 修改数据
     *
     * @param membersRealname 实例对象
     * @return 实例对象
     */
    MembersRealname update(MembersRealname membersRealname);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    Map<String,Object> queryByRLId(Integer id);

    int updateState(PageBaen pageBaen);

    /**
     * 查看所有
     * @param pageBaen
     * @return
     */
    List<Map<String,Object>> getRAllPager(PageBaen pageBaen);

    MembersRealname queryRnull(Integer members_id);

}