package com.payment.module.pay.web;

import com.payment.common.config.AbstractController;
import com.payment.common.model.Result;
import com.payment.module.pay.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统计
 */
@RestController
@RequestMapping("/statistic")
public class StatisticController extends AbstractController {

    @Autowired
    private StatisticService statisticService;

    @PostMapping(value="console")
    public Result console(){
        return statisticService.console();
    }
}
