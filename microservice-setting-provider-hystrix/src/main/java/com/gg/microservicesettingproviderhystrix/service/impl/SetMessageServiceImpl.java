package com.gg.microservicesettingproviderhystrix.service.impl;

import com.gg.microservicecommon.entity.setting.SetMessage;
import com.gg.microservicecommon.util.Query;
import com.gg.microservicesettingproviderhystrix.dao.SetMessageDao;
import com.gg.microservicesettingproviderhystrix.service.SetMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (SetMessage)表服务实现类
 *
 * @author makejava
 * @since 2019-12-12 11:47:09
 */
@Service("setMessageService")
public class SetMessageServiceImpl implements SetMessageService {
    @Resource
    private SetMessageDao setMessageDao;

    /**
     * 通过ID查询单条数据
     *
     *
     * @return 实例对象
     */


    @Override
    public SetMessage queryById(Integer id) {
        return this.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SetMessage> queryAllByLimit(int offset, int limit) {
        return this.setMessageDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     *
     * @return 实例对象
     */
    @Override
    public int insert(Query query) {
        return this.setMessageDao.insert(query);
    }

    /**
     * 修改数据
     *
     *
     * @return 实例对象
     */
    @Override
    public int update(Query query) {
        return this.setMessageDao.update(query);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.setMessageDao.deleteById(id) > 0;
    }



    @Override
    public List<Map> queryAllPager(Query query) {
        return this.setMessageDao.queryAllPager(query);
    }


}