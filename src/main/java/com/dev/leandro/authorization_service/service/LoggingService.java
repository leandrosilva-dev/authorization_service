package com.dev.leandro.authorization_service.service;

import com.dev.leandro.authorization_service.entity.UserNotification;

public interface LoggingService {
    void sendMessage(UserNotification userNotification);
}
