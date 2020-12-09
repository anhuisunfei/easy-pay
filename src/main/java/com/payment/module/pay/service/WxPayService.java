package com.payment.module.pay.service;

import com.payment.common.model.Result;
import com.payment.module.pay.model.Product;

/**
 * 微信支付
 * 爪哇笔记 https://blog.52itstyle.vip
 * @author 小柒2012
 */
public interface WxPayService {

    Result wxPay(Product product);

    Result jsApiPay(Product product);

}
