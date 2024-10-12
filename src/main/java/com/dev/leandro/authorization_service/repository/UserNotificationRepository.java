package com.dev.leandro.authorization_service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.leandro.authorization_service.entity.UserNotification;

public interface UserNotificationRepository extends JpaRepository<UserNotification, UUID>{
    
}
