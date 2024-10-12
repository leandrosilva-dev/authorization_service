package com.dev.leandro.authorization_service.aws.sqs;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dev.leandro.authorization_service.entity.UserNotification;
import com.dev.leandro.authorization_service.service.LoggingService;

import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
public class SQSProducer implements LoggingService{
    private final SqsClient sqsClient;

    @Value("${aws.sqs.url}")
    private String url;


    public SQSProducer(SqsClient sqsClient){
        this.sqsClient = sqsClient;
    }

    public void sendMessage(UserNotification userNotification){
        SendMessageRequest request = SendMessageRequest.builder()
            .queueUrl(url)
            .messageBody(userNotification.getNotification())
            .messageGroupId("authorization-service-group-id")
            .messageDeduplicationId(UUID.randomUUID().toString())
            .build();

        this.sqsClient.sendMessage(request);
    }
}