package com.gg.microservicememberproviderhystrix.service;

import com.gg.microservicecommon.entity.member.Members;
import com.gg.microservicecommon.util.PageBaen;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;
import java.util.Map;

/**
 * (Members)表服务接口
 *
 * @author makejava
 * @since 2019-12-12 20:53:15
 */
@Service
public interface MembersService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Members queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Members> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param members 实例对象
     * @return 实例对象
     */
    Members insert(Members members);

    /**
     * 修改数据
     *
     * @param members 实例对象
     * @return 实例对象
     */
    Members update(Members members);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 查询所有
     * @param pageBaen
     * @return
     */
    List<Map<String,Object>> getAllPager(PageBaen pageBaen);

}