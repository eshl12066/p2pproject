package com.gg.microservicesettingproviderhystrix.service.impl;

import com.gg.microservicecommon.entity.setting.SetDict;
import com.gg.microservicecommon.util.Query;
import com.gg.microservicesettingproviderhystrix.dao.SetDictDao;
import com.gg.microservicesettingproviderhystrix.service.SetDictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (SetDict)表服务实现类
 *
 * @author makejava
 * @since 2019-12-12 11:44:53
 */
@Service("setDictService")
public class SetDictServiceImpl implements SetDictService {
    @Resource
    private SetDictDao setDictDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SetDict queryById(Integer id) {
        return this.setDictDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SetDict> queryAllByLimit(int offset, int limit) {
        return this.setDictDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     *
     * @return 实例对象
     */
    @Override
    public int insert(Query query) {
        return  this.setDictDao.insert(query);
    }

    /**
     * 修改数据
     *
     *
     * @return 实例对象
     */
    @Override
    public int update(Query query) {
        return this.setDictDao.update(query);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.setDictDao.deleteById(id) > 0;
    }

    @Override
    public List<Map> selectAllPager(Query query) {
        return this.setDictDao.selectAllPager(query);
    }


}