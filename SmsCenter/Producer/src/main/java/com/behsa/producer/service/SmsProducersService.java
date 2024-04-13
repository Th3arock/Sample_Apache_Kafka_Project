package com.behsa.producer.service;

import com.behsa.producer.model.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SmsProducersService {

    @Autowired
    private KafkaTemplate<String, MessageRequest> emailKafkaTemplate;

    public void sendSms(MessageRequest request) {
        emailKafkaTemplate.send("sms", request);
    }
}
