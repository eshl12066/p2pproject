package com.gg.microservicesettingproviderhystrix.service.impl;

import com.gg.microservicecommon.entity.setting.SetScheduleTrigger;
import com.gg.microservicesettingproviderhystrix.dao.SetScheduleTriggerDao;
import com.gg.microservicesettingproviderhystrix.service.SetScheduleTriggerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SetScheduleTrigger)表服务实现类
 *
 * @author makejava
 * @since 2019-12-12 11:47:32
 */
@Service("setScheduleTriggerService")
public class SetScheduleTriggerServiceImpl implements SetScheduleTriggerService {
    @Resource
    private SetScheduleTriggerDao setScheduleTriggerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SetScheduleTrigger queryById(Integer id) {
        return this.setScheduleTriggerDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SetScheduleTrigger> queryAllByLimit(int offset, int limit) {
        return this.setScheduleTriggerDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param setScheduleTrigger 实例对象
     * @return 实例对象
     */
    @Override
    public SetScheduleTrigger insert(SetScheduleTrigger setScheduleTrigger) {
        this.setScheduleTriggerDao.insert(setScheduleTrigger);
        return setScheduleTrigger;
    }

    /**
     * 修改数据
     *
     * @param setScheduleTrigger 实例对象
     * @return 实例对象
     */
    @Override
    public SetScheduleTrigger update(SetScheduleTrigger setScheduleTrigger) {
        this.setScheduleTriggerDao.update(setScheduleTrigger);
        return this.queryById(setScheduleTrigger.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.setScheduleTriggerDao.deleteById(id) > 0;
    }
}