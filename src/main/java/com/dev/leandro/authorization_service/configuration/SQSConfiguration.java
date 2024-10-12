package com.dev.leandro.authorization_service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;

@Configuration
public class SQSConfiguration {
    
    @Bean
    SqsClient sqsClient(){
        return SqsClient.builder()
                        .region(Region.US_EAST_1)
                        .credentialsProvider(ProfileCredentialsProvider.create())
                        .build();
    }
}