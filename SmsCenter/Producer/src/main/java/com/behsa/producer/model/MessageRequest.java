package com.behsa.producer.model;

import lombok.Data;

@Data
public class MessageRequest {
    private String body;
    private String receiver;
}
