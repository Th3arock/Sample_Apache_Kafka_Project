package com.behsa.producer.serializer;



import com.behsa.producer.model.MessageRequest;
import com.google.gson.Gson;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;

public class SmsSerializer implements Serializer<MessageRequest> {

    @Override
    public byte[] serialize(String s, MessageRequest request) {
        String emailAsJson = convertSmsToJson(request);
        return emailAsJson.getBytes(StandardCharsets.UTF_8);
    }

    public static String convertSmsToJson(MessageRequest request) {
        Gson gson = new Gson();
        return gson.toJson(request);
    }
}
