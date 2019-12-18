package com.gg.microservicememberproviderhystrix.service;

import com.gg.microservicecommon.entity.member.MembersMaterials;
import com.gg.microservicecommon.util.PageBaen;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;
import java.util.Map;

/**
 * (MembersMaterials)表服务接口
 *
 * @author makejava
 * @since 2019-12-12 20:54:17
 */
@Service
public interface MembersMaterialsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MembersMaterials queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MembersMaterials> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @return 实例对象
     */
    int insert(PageBaen pageBaen);

    /**
     * 修改数据
     *
     * @param membersMaterials 实例对象
     * @return 实例对象
     */
    MembersMaterials update(MembersMaterials membersMaterials);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 模糊查
     * @param pageBaen
     * @return
     */
    List<Map<String,Object>> getCLAllPager(PageBaen pageBaen);

    /**
     * 修改状态
     * @return
     */
    int updateState(PageBaen pageBaen);
    /**
     * 查询连表单个
     * @param id
     * @return
     */
    Map<String,Object> queryByCLId(Integer id);

    MembersMaterials queryMnull(Integer members_id);

}