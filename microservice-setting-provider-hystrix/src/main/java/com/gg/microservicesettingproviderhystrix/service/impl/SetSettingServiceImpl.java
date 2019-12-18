package com.gg.microservicesettingproviderhystrix.service.impl;

import com.gg.microservicecommon.entity.setting.SetSetting;
import com.gg.microservicecommon.util.Query;
import com.gg.microservicesettingproviderhystrix.dao.SetSettingDao;
import com.gg.microservicesettingproviderhystrix.service.SetSettingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SetSetting)表服务实现类
 *
 * @author makejava
 * @since 2019-12-12 11:48:03
 */
@Service("setSettingService")
public class SetSettingServiceImpl implements SetSettingService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Resource
    private SetSettingDao setSettingDao;

    @Override
    public SetSetting queryById(Integer id) {
        return this.setSettingDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SetSetting> queryAllByLimit(int offset, int limit) {
        return this.setSettingDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param setSetting 实例对象
     * @return 实例对象
     */
    @Override
    public SetSetting insert(SetSetting setSetting) {
        this.setSettingDao.insert(setSetting);
        return setSetting;
    }

    /**
     * 修改数据
     *
     *
     * @return 实例对象
     */
    @Override
    public int update(Query query) {
        return this.setSettingDao.update(query);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.setSettingDao.deleteById(id) > 0;
    }

    @Override
    public List<SetSetting> queryAll() {
        return this.setSettingDao.queryAll();
    }

    @Override
    public int updateAll(Query query) {
        return this.setSettingDao.updateAll(query);
    }




}