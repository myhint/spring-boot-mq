package com.example.mq.springbootmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class SpringBootMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMqApplication.class, args);
    }
}
