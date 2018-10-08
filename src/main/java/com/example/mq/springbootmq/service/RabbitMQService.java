package com.example.mq.springbootmq.service;

import com.example.mq.springbootmq.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Created by Blake on 2018/10/8
 */
@Service
public class RabbitMQService {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQService.class);

    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book) {

        logger.info("============= 从消息队列接收的书本信息：[{}] ============= ", book);
    }

}
