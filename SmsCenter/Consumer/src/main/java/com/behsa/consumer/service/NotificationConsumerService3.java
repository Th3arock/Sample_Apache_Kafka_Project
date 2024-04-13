package com.behsa.consumer.service;


import com.behsa.consumer.confg.KafkaConsumerConfig2;
import com.behsa.consumer.model.MessageRequest;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Collections;

public class NotificationConsumerService3 {
    private static KafkaConsumer<String, MessageRequest> consumer;

    public NotificationConsumerService3() {
        consumer = new KafkaConsumer<String, MessageRequest>(KafkaConsumerConfig2.consumerConfig());
        consumer.subscribe(Collections.singletonList("sms"));
    }

    public void consumeEmails(KafkaConsumer<String, MessageRequest> consumer) {
        while (true) {
            ConsumerRecords<String, MessageRequest> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, MessageRequest> record : records) {
                try {
                    MessageRequest email = record.value();
                    System.out.println("MessageRequest consumed: " + email);
                    consumer.commitSync(Collections.singletonMap(
                            new TopicPartition(record.topic(), record.partition()),
                            new OffsetAndMetadata(record.offset() + 1)
                    ));
                    System.out.println("Offset committed: " + (record.offset() + 1));
                } catch (Exception e) {
                    System.err.println("Error processing message: " + e.getMessage());
                }
            }
        }
    }


    public static void main(String[] args) {
        NotificationConsumerService3 service = new NotificationConsumerService3();
        service.consumeEmails(consumer);
    }
}
