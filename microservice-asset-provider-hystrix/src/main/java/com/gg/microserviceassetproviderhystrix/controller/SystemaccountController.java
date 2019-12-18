package com.gg.microserviceassetproviderhystrix.controller;

import com.gg.microserviceassetproviderhystrix.service.SystemaccountService;
import com.gg.microservicecommon.entity.asset.Systemaccount;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Systemaccount)表控制层
 *
 * @author makejava
 * @since 2019-12-12 20:49:20
 */
@RestController
@RequestMapping("systemaccount")
public class SystemaccountController {
    /**
     * 服务对象
     */
    @Resource
    private SystemaccountService systemaccountService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Systemaccount selectOne(Integer id) {
        return this.systemaccountService.queryById(id);
    }

}