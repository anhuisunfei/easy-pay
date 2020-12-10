package com.payment.common.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * rabbit mq 生产者
 *
 * @author sunf
 * @version 1.0
 * @date 2020/12/10 16:18
 */
@Component
public class RabbitProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;


    public void sendDemoQueue() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-mm-DD hh:MM:ss").format(date);
        System.out.println("[demoQueue] send msg" + dateString);
        amqpTemplate.convertAndSend("demoQueue", dateString);
    }

}
