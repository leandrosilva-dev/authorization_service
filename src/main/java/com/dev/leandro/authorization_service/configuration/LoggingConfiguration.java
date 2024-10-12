package com.dev.leandro.authorization_service.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import com.dev.leandro.authorization_service.async.AsyncLogging;
import com.dev.leandro.authorization_service.aws.sqs.SQSProducer;
import com.dev.leandro.authorization_service.service.LoggingService;

@Configuration
@EnableAsync
public class LoggingConfiguration {
    @Value("${logging.mode}")
    private String loggingMode;

    @Bean
    LoggingService loggingService(SQSProducer sqsProducer, AsyncLogging asyncLogging){
        return "sqs".equalsIgnoreCase(this.loggingMode) ? sqsProducer : asyncLogging;
    }
}
