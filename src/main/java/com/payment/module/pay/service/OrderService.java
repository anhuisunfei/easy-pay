package com.payment.module.pay.service;

import com.payment.common.model.Result;
import com.payment.module.pay.entity.Order;

/**
 * 订单管理
 * 爪哇笔记 https://blog.52itstyle.vip
 * @author 小柒2012
 */
public interface OrderService {

    Result list(Order order);

    Order updateStatus(String orderNo);

}
