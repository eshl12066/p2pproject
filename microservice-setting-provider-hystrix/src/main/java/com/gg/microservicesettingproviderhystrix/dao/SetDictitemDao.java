package com.gg.microservicesettingproviderhystrix.dao;

import com.gg.microservicecommon.entity.setting.SetDictitem;
import com.gg.microservicecommon.util.Query;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * (SetDictitem)表数据库访问层
 *
 * @author makejava
 * @since 2019-12-12 11:46:42
 */
public interface SetDictitemDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SetDictitem queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SetDictitem> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param setDictitem 实例对象
     * @return 对象列表
     */
    List<SetDictitem> queryAll(SetDictitem setDictitem);

    /**
     * 新增数据
     *
     * @param query 实例对象
     * @return 影响行数
     */
    int insert(Query query);

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

//    根据dictID查看dictitem详情
    List<Map> queryByDictId(Query Query);

    //根据父删除所有子
    int deleteByParentId(Integer parentId);

}