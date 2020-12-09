package com.payment.module.pay.web;

import com.payment.common.config.AbstractController;
import com.payment.common.model.Result;
import com.payment.module.pay.model.Product;
import com.payment.module.pay.service.AliPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 个人支付宝支付
 * 爪哇笔记 https://blog.52itstyle.vip
 * @author 小柒2012
 */
@RestController
@RequestMapping("/pay")
public class AliPayController extends AbstractController {

    @Autowired
    private AliPayService aliPayService;

    /**
     * 生成支付二维码
     * @return
     */
    @PostMapping(value="aliPay")
    public Result aliPay(Product product) {
        return aliPayService.aliPay(product);
    }

}
