package com.example.memo_vocab.service;

import org.springframework.stereotype.Service;

import static com.example.memo_vocab.util.AsyncUtil.delay;

@Service
public class EmailService {
    public String sendEmail(String message, String email) {
        // Placeholder for email sending logic
        delay(1000); // Simulate delay
        return "Email sent to: " + email + ": " + message;
    }
}
