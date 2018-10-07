package com.example.mq.springbootmq.example.AmqpAdmin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Blake on 2018/10/7
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AmqpAdminTests {

    @Autowired
    private AmqpAdmin amqpAdmin;

    /**
     * 测试：创建交换器
     */
    @Test
    public void createExchangeAndQueueAndBindings() {

        // delete exchange
        amqpAdmin.deleteExchange("amqpAdmin.direct");

        // create exchange
        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));

        // create queue
        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue", true));

        // create binding between exchange and queue
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue", Binding.DestinationType.QUEUE, "amqpAdmin.exchange", "amqpAdmin.exqueue", null));

    }


}
