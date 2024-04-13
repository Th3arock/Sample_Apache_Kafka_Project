package com.behsa.consumer.model;

import lombok.Data;

@Data
public class MessageRequest {
    private String body;
    private String receiver;
}
