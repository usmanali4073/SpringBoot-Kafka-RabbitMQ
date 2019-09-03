package com.speaya.contact.service;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${RabbitMQ-exchangeName}")
    private String exchange;

    @Value("${RabbitMQ-routing-keyName}")
    private String routingkey;

    public void send(String message) {
        rabbitTemplate.convertAndSend(exchange, routingkey, message);
        System.out.println("Send msg = " + message);

    }
}
