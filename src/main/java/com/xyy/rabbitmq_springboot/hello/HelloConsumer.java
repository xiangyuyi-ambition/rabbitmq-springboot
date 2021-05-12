package com.xyy.rabbitmq_springboot.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: rabbitmq_springboot
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-09 15:23
 **/
@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello",durable = "true"))
public class HelloConsumer {
    @RabbitHandler
    public void getHello(String message){
        System.out.println("message " + message);
    }
}
