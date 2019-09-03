package com.speaya.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    String KafkaTopic = "javainuse-topic";

    public void send(String message) {
        this.kafkaTemplate.send(KafkaTopic, message);
    }
}
