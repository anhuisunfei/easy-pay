package com.payment.module.sys.mq;

import com.payment.module.sys.entity.SysUser;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author sunf
 * @version 1.0
 * @date 2020/12/10 17:24
 */
@Component
@RabbitListener(queues = "user.queue")
public class UserMqConsumer {
    @RabbitHandler
    public void recieved(String user) {
        System.out.println("[demoQueue] recived message:" + user);
    }
}
