package com.payment.module.sys.web;

import com.payment.common.config.AbstractController;
import com.payment.common.model.Result;
import com.payment.module.sys.entity.SysConfig;
import com.payment.module.sys.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 参数设置
 * 爪哇笔记：https://blog.52itstyle.vip
 * @author 小柒2012
 */
@RestController
@RequestMapping("/sys/config")
public class ConfigController extends AbstractController {

    @Autowired
    private SysConfigService sysConfigService;

    /**
     * 参数列表
     */
    @PostMapping("/list")
    public Result list(SysConfig config){
        return sysConfigService.list(config);
    }

    /**
     * 获取
     */
    @PostMapping("/get")
    public Result get(Long id){
        return sysConfigService.get(id);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody SysConfig config){
        return sysConfigService.save(config);
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public Result delete(Long id){
        return sysConfigService.delete(id);
    }

}
