package com.gg.microservicesettingproviderhystrix.service;

import com.gg.microservicecommon.entity.setting.SetSetting;
import com.gg.microservicecommon.util.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (SetSetting)表服务接口
 *
 * @author makejava
 * @since 2019-12-12 11:48:03
 */
@Service
public interface SetSettingService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SetSetting queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SetSetting> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param setSetting 实例对象
     * @return 实例对象
     */
    SetSetting insert(SetSetting setSetting);

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


    List<SetSetting> queryAll();

    /**
     * 修改所有
     *
     * @param query
     * @return
     */
    int updateAll(Query query);

}