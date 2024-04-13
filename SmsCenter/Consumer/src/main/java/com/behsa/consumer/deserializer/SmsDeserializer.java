package com.behsa.consumer.deserializer;

import com.behsa.consumer.model.MessageRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

public class SmsDeserializer implements Deserializer<MessageRequest> {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public MessageRequest deserialize(String s, byte[] bytes) {
        try {
            if (bytes == null) {
                return null;
            }
            return objectMapper.readValue(bytes, MessageRequest.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
