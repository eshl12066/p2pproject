package com.gg.microservicebusinessproviderhystrix.controller;

import com.gg.microservicebusinessproviderhystrix.service.RefundDetailService;
import com.gg.microservicecommon.entity.business.RefundDetail;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RefundDetail)表控制层
 *
 * @author makejava
 * @since 2019-12-13 10:05:12
 */
@RestController
@RequestMapping("refundDetail")
public class RefundDetailController {
    /**
     * 服务对象
     */
    @Resource
    private RefundDetailService refundDetailService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RefundDetail selectOne(Integer id) {
        return this.refundDetailService.queryById(id);
    }

}