package com.xyy.rabbitmq_springboot.route;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: rabbitmq_springboot
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-09 15:53
 **/
@Component
public class RoutrConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "directs",type = "direct"),
                    key = {"info","error","warning"}
            )
    })
    public void Consumer(String  message){
        System.out.println("Consumer1 " + message);
    }


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "directs",type = "direct"),
                    key = {"info"}
            )
    })
    public void Consumer2(String  message){
        System.out.println("Consumer2 " + message);
    }
}
