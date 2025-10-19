package com.example.memo_vocab.functions;

import com.example.memo_vocab.dto.UserMessageDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MessageFunctions {

    @Bean
    public Function<UserMessageDto, UserMessageDto> emailMessage() {
        return userMessageDto -> {
            // Simulate sending an email
            log.info("Sending email to: " + userMessageDto.email());
            log.info("Email content: Hello " + userMessageDto.name() + ", this is a test email.");
            // Return the original message DTO
            return userMessageDto;
        };
    }


}
