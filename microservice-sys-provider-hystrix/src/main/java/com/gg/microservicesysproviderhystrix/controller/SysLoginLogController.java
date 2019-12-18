package com.gg.microservicesysproviderhystrix.controller;

import com.gg.microservicecommon.entity.sys.SysLoginLog;
import com.gg.microservicesysproviderhystrix.service.SysLoginLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SysLoginLog)表控制层
 *
 * @author makejava
 * @since 2019-12-12 11:34:20
 */
@RestController
@RequestMapping("sysLoginLog")
public class SysLoginLogController {
    /**
     * 服务对象
     */
    @Resource
    private SysLoginLogService sysLoginLogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysLoginLog selectOne(Integer id) {
        return this.sysLoginLogService.queryById(id);
    }

}