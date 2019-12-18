package com.gg.microservicesettingproviderhystrix.service;

import com.gg.microservicecommon.entity.setting.SetDictitem;
import com.gg.microservicecommon.util.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * (SetDictitem)表服务接口
 *
 * @author makejava
 * @since 2019-12-12 11:46:42
 */
@Service
public interface SetDictitemService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SetDictitem queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SetDictitem> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param query 实例对象
     * @return 实例对象
     */
    int insert(Query query);

    /**
     * 修改数据
     *
     * @param query 实例对象
     * @return 实例对象
     */
    int update(Query query);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<Map> queryByDictId(Query query);

    //根据父删除所有子
    int deleteByParentId(Integer parentId);
}