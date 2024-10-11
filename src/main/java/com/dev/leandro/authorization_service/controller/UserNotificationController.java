package com.dev.leandro.authorization_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.leandro.authorization_service.entity.UserNotification;
import com.dev.leandro.authorization_service.repository.UserNotificationRepository;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class UserNotificationController {
    private final UserNotificationRepository repository;
    
    public UserNotificationController(UserNotificationRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<UserNotification>  getNotification() {
        return this.repository.findAll();
    }   
}