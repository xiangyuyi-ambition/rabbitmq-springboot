package com.xyy.rabbitmq_springboot.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: rabbitmq_springboot
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-09 15:34
 **/
@Component
public class workConsumer {

    @RabbitListener(queuesToDeclare = @Queue(value = "work"))
    public void consumer1(String message){
        System.out.println("consumer1 " + message);
    }

    @RabbitListener(queuesToDeclare = @Queue(value = "work"))
    public void consumer2(String message){
        System.out.println("consumer2 " + message);
    }
}
