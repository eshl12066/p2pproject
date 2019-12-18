package com.gg.microservicebusinessproviderhystrix.controller;

import com.gg.microservicebusinessproviderhystrix.service.ReturnDetailService;
import com.gg.microservicecommon.entity.business.ReturnDetail;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ReturnDetail)表控制层
 *
 * @author makejava
 * @since 2019-12-13 10:05:30
 */
@RestController
@RequestMapping("returnDetail")
public class ReturnDetailController {
    /**
     * 服务对象
     */
    @Resource
    private ReturnDetailService returnDetailService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ReturnDetail selectOne(Integer id) {
        return this.returnDetailService.queryById(id);
    }

}