package com.gg.microserviceassetproviderhystrix.controller;

import com.gg.microserviceassetproviderhystrix.service.SystemaccountDetailService;
import com.gg.microservicecommon.entity.asset.SystemaccountDetail;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SystemaccountDetail)表控制层
 *
 * @author makejava
 * @since 2019-12-12 20:49:46
 */
@RestController
@RequestMapping("systemaccountDetail")
public class SystemaccountDetailController {
    /**
     * 服务对象
     */
    @Resource
    private SystemaccountDetailService systemaccountDetailService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SystemaccountDetail selectOne(Integer id) {
        return this.systemaccountDetailService.queryById(id);
    }

}