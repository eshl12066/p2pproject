package com.gg.microservicesettingproviderhystrix.dao;

import com.gg.microservicecommon.entity.setting.SetSetting;
import com.gg.microservicecommon.util.Query;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SetSetting)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-12 11:48:03
 */
public interface SetSettingDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SetSetting queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SetSetting> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<SetSetting> queryAll();

    /**
     * 新增数据
     *
     * @param setSetting 实例对象
     * @return 影响行数
     */
    int insert(SetSetting setSetting);

    /**
     * 修改数据
     *
     * @param query 实例对象
     * @return 影响行数
     */
    int update(Query query);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);




    /**
     * 修改所有
     *
     * @param query
     * @return
     */
    int updateAll(Query query);
}