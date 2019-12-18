package com.gg.microservicesettingproviderhystrix.service.impl;

import com.gg.microservicecommon.entity.setting.SetDictitem;
import com.gg.microservicecommon.util.Query;
import com.gg.microservicesettingproviderhystrix.dao.SetDictitemDao;
import com.gg.microservicesettingproviderhystrix.service.SetDictitemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (SetDictitem)表服务实现类
 *
 * @author makejava
 * @since 2019-12-12 11:46:42
 */
@Service("setDictitemService")
public class SetDictitemServiceImpl implements SetDictitemService {
    @Resource
    private SetDictitemDao setDictitemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SetDictitem queryById(Integer id) {
        return this.setDictitemDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SetDictitem> queryAllByLimit(int offset, int limit) {
        return this.setDictitemDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     *
     * @return 实例对象
     */
    @Override
    public int insert(Query query) {
        return this.setDictitemDao.insert(query);
    }

    /**
     * 修改数据
     *
     *
     * @return 实例对象
     */
    @Override
    public int update(Query query) {
        return this.setDictitemDao.update(query);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.setDictitemDao.deleteById(id) > 0;
    }

    @Override
    public List<Map> queryByDictId(Query query) {
        return this.setDictitemDao.queryByDictId(query);
    }

    @Override
    public int deleteByParentId(Integer parentId) {
        return this.setDictitemDao.deleteByParentId(parentId);
    }


}