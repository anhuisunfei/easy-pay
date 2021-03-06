package com.payment.module.pay.service.impl;

import cn.hutool.core.util.IdUtil;
import com.payment.common.constant.SystemConstant;
import com.payment.common.dynamicquery.DynamicQuery;
import com.payment.common.model.Result;
import com.payment.common.util.DateUtils;
import com.payment.common.util.ShiroUtils;
import com.payment.module.pay.entity.Order;
import com.payment.module.pay.model.Product;
import com.payment.module.pay.service.AliPayService;
import com.payment.module.pay.util.PayUtils;
import com.yungouos.pay.common.PayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AliPayServiceImpl implements AliPayService {

    @Autowired
    private DynamicQuery dynamicQuery;
    @Autowired
    private PayUtils payUtils;

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Result aliPay(Product product) {
        try {
            Long orderNo = IdUtil.getSnowflake(1,1).nextId();
            product.setOutTradeNo(orderNo+"");
            String result = payUtils.aliPay(product);
            Order order = new Order();
            order.setProductId(product.getProductId());
            order.setTotalFee(new BigDecimal(product.getTotalFee()));
            order.setStatus(SystemConstant.PAY_STATUS_NO);
            order.setType(SystemConstant.PAY_TYPE_ALI);
            order.setOrderNo(orderNo+"");
            order.setBody(product.getBody());
            order.setGmtCreate(DateUtils.getTimestamp());
            order.setGmtModified(order.getGmtCreate());
            order.setUserCreate(ShiroUtils.getUserId());
            dynamicQuery.save(order);
            return Result.ok(result);
        }catch (PayException e){
            return Result.error(e.getMessage());
        }
    }
}
