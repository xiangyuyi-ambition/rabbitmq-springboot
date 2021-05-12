package com.xyy.rabbitmq_springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: rabbitmq_springboot
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-09 15:14
 **/
@SpringBootTest(classes = RabbitmqSpringbootApplication.class)
@RunWith(SpringRunner.class)
public class TestRabbitmq {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //hello
    @Test
    public void helloworld(){
        rabbitTemplate.convertAndSend("hello","hello world");
    }

    @Test
    public void testWork(){
        for(int i=0; i<10; i++){
            rabbitTemplate.convertAndSend("work", "work模型");
        }
    }

    //广播
    @Test
    public void fanout(){
        rabbitTemplate.convertAndSend("logs","","fanout模型发送的消息");
    }

    //路由
    @Test
    public void testRoute(){
        rabbitTemplate.convertAndSend("directs","info","发送路由信息");
    }

    //动态路由 topic
    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("topics","user.save", "topic");
    }


}
