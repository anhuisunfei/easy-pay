package com.payment.module.sys.mq;

import com.alibaba.fastjson.JSON;
import com.payment.module.sys.entity.SysUser;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author sunf
 * @version 1.0
 * @date 2020/12/10 17:23
 */
@Component
public class UserMqProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;


    public void sendUser(SysUser user) {
        String json= JSON.toJSONString(user);
        amqpTemplate.convertAndSend("user.queue", json);
    }
}
