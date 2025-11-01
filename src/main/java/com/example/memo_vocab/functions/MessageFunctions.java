package com.example.memo_vocab.functions;

import com.example.memo_vocab.dto.UserMessageDto;
import com.example.memo_vocab.service.NotificationService;
import com.example.memo_vocab.util.AsyncUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class MessageFunctions {

    public final NotificationService notificationService;

    @Bean
    public Function<UserMessageDto, UserMessageDto> emailMessage() {
        return userMessageDto -> {
            // Simulate sending an email
            log.info("Sending email to: " + userMessageDto.email());
            notificationService.sendEmailNotification("Hello " + userMessageDto.name() + ", this is a test email.", userMessageDto.email()).join();
            // Return the original message DTO
            return userMessageDto;
        };
    }

    @Bean
    public Function<UserMessageDto, UserMessageDto> allNotificationMessage() {
        return userMessageDto -> {
            // Simulate sending both email and SMS
            log.info("Sending all notifications to: " + userMessageDto.email() + " and phone: " + userMessageDto.phoneNumber());

            AsyncUtil.startTimer();
            notificationService.sendAllNotifications("Hello " + userMessageDto.name() + ", this is a test notification.", userMessageDto.email(), userMessageDto.phoneNumber()).join();
            AsyncUtil.timeTaken();
            // Return the original message DTO
            return userMessageDto;
        };
    }


}
