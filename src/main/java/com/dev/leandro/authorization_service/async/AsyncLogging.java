package com.dev.leandro.authorization_service.async;

import org.springframework.stereotype.Service;

import com.dev.leandro.authorization_service.entity.UserNotification;
import com.dev.leandro.authorization_service.repository.UserNotificationRepository;
import com.dev.leandro.authorization_service.service.LoggingService;

@Service
public class AsyncLogging implements LoggingService{
    private UserNotificationRepository repository;

    public AsyncLogging(UserNotificationRepository repository){
        this.repository = repository;
    }

    @Override
    public void sendMessage(UserNotification userNotification) {
        try{
            this.repository.save(userNotification);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
