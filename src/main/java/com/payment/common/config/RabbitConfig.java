package com.payment.common.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Rabbit Mq 配置信息
 *
 * @author sunf
 * @version 1.0
 * @date 2020/12/10 16:16
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue domeString(){
        return new Queue("demoQueue");
    }

    @Bean
    public Queue userQueue(){
        return new Queue("user.queue");
    }
}
