package com.behsa.consumer.confg;

import com.behsa.consumer.deserializer.SmsDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;


public class KafkaConsumerConfig {
    public static Properties consumerConfig() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "172.18.60.159:9092");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", SmsDeserializer.class.getName());
        props.put("auto.offset.reset", "earliest");
        props.put("group.id", "Behsa");
        props.put("enable.auto.commit", "false");
        return props;
    }
}

