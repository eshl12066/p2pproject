package com.gg.microservicesettingproviderhystrix.controller;

import com.gg.microservicecommon.entity.setting.SetScheduleTrigger;
import com.gg.microservicesettingproviderhystrix.service.SetScheduleTriggerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SetScheduleTrigger)表控制层
 *
 * @author makejava
 * @since 2019-12-12 11:47:32
 */
@RestController
@RequestMapping("setScheduleTrigger")
public class SetScheduleTriggerController {
    /**
     * 服务对象
     */
    @Resource
    private SetScheduleTriggerService setScheduleTriggerService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SetScheduleTrigger selectOne(Integer id) {
        return this.setScheduleTriggerService.queryById(id);
    }

}