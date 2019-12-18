package com.gg.microservicesettingproviderhystrix.service;

import com.gg.microservicecommon.entity.setting.SetScheduleTrigger;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (SetScheduleTrigger)表服务接口
 *
 * @author makejava
 * @since 2019-12-12 11:47:32
 */
@Service
public interface SetScheduleTriggerService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SetScheduleTrigger queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SetScheduleTrigger> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param setScheduleTrigger 实例对象
     * @return 实例对象
     */
    SetScheduleTrigger insert(SetScheduleTrigger setScheduleTrigger);

    /**
     * 修改数据
     *
     * @param setScheduleTrigger 实例对象
     * @return 实例对象
     */
    SetScheduleTrigger update(SetScheduleTrigger setScheduleTrigger);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}