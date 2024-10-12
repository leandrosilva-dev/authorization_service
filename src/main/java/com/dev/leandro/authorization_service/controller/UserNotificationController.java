package com.dev.leandro.authorization_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.leandro.authorization_service.dto.UserNotificationDTO;
import com.dev.leandro.authorization_service.entity.UserNotification;
import com.dev.leandro.authorization_service.repository.UserNotificationRepository;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notification")
public class UserNotificationController {
    private final UserNotificationRepository repository;
    
    public UserNotificationController(UserNotificationRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<UserNotificationDTO>  getNotification() {
        List<UserNotification> notifications = this.repository.findAll();

        return notifications.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }   

    private UserNotificationDTO convertToDto(UserNotification userNotification){
        return new UserNotificationDTO(userNotification.getId(), userNotification.getUser().getName(), userNotification.getUser().getEmail(), userNotification.getNotification());
    }
}