package com.example.memo_vocab.service;

import com.example.memo_vocab.util.AsyncUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service @RequiredArgsConstructor @Slf4j public class NotificationService {

    public final EmailService emailService;
    public final SmsService smsService;

    public CompletableFuture<String> sendEmailNotification(String message, String email) {
        // Placeholder for email notification logic
        return CompletableFuture.supplyAsync(() -> emailService.sendEmail(message, email)).thenAccept((result) -> {
            log.info("email result: {}", result);
        }).thenApply((v) -> "Email Notification Sent Successfully");
    }

    public CompletableFuture<String> sendSMSNotification(String message, String phoneNumber) {
        // Placeholder for SMS notification logic
        return CompletableFuture.supplyAsync(() -> smsService.sendSms(message, phoneNumber)).thenAccept((result) -> {
            ;
            log.info("sms result: {}", result);
        }).thenApply((v) -> "SMS Notification Sent Successfully");
    }

    public CompletableFuture<String> sendAllNotifications(String message, String email, String phoneNumber) {
        // Placeholder for sending all notifications logic

        CompletableFuture<String> emailFuture = sendEmailNotification(message, email);
        CompletableFuture<String> smsFuture = sendSMSNotification(message, phoneNumber);

        return emailFuture.thenCombine(smsFuture, (emailResult, smsResult) -> {
            log.info("Both notifications sent: {}, {}", emailResult, smsResult);
            return "All Notifications Sent Successfully";
        });
    }
}
