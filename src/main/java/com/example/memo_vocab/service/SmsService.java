package com.example.memo_vocab.service;

import org.springframework.stereotype.Service;

import static com.example.memo_vocab.util.AsyncUtil.delay;


@Service
public class SmsService {
    public String sendSms(String message, String phoneNumber) {
        // Placeholder for SMS sending logic
        delay(500); // Simulate delay
        return "SMS sent to: " + phoneNumber + ": " + message;
    }
}
