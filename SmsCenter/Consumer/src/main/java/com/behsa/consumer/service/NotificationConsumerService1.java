package com.behsa.consumer.service;


import com.behsa.consumer.model.MessageRequest;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumerService1 {


    @KafkaListener(topics = "sms")
    public void consume(Acknowledgment ack, ConsumerRecord<String, MessageRequest> record) {
        System.out.println("The value of message is :" + record.value());
        System.out.println("The offset of message is : " + record.offset());
        ack.acknowledge();
    }
}
