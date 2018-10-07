package com.example.mq.springbootmq.example.rabbitTemplate;

import com.example.mq.springbootmq.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Blake on 2018/10/7
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitTemplateTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * 测试：点对点消息发送
     */
    @Test
    public void publishDirectMessage() {

//        rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news", "第一次发送消息");

        rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news", new Book("水浒传", "施耐庵"));

    }

    /**
     * 测试：点对点消息接收消费
     */
    @Test
    public void receiveDirectMessage() {

//        rabbitTemplate.receive("atguigu.news");

        Object obj = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(obj.getClass());
        System.out.println(obj);

    }

}
