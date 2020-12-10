package com.payment.common.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * demoMq 消费者
 *
 * @author sunf
 * @version 1.0
 * @date 2020/12/10 16:21
 */
@Component
@RabbitListener(queues = "demoQueue")
public class DemoQueueConsumer {

    @RabbitHandler
    public void recieved(String msg) {
        System.out.println("[demoQueue] recived message:" + msg);
    }
}
