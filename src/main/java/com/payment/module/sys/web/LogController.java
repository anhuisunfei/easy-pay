package com.payment.module.sys.web;

import com.payment.common.config.AbstractController;
import com.payment.common.model.Result;
import com.payment.module.sys.entity.SysLog;
import com.payment.module.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志管理
 * 爪哇笔记：https://blog.52itstyle.vip
 * @author 小柒2012
 */
@RestController
@RequestMapping("/sys/log")
public class LogController extends AbstractController {

    @Autowired
    private SysLogService sysLogService;

    /**
     * 日志列表
     */
    @PostMapping("/list")
    public Result list(SysLog log){
        return sysLogService.list(log);
    }

}
