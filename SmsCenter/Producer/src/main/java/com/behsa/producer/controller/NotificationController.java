package com.behsa.producer.controller;
import com.behsa.producer.model.MessageRequest;
import com.behsa.producer.service.SmsProducersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NotificationController {

    @Autowired
    private SmsProducersService smsProducersService;

    @PostMapping(value = "/sendSms")
    public String sendSms(@RequestBody MessageRequest messageRequest) {
        smsProducersService.sendSms(messageRequest);
        return "Message sent successfully";
    }
}