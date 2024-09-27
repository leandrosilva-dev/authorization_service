package com.dev.leandro.tech_interview_two.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/user")
public class UserController {
    
    @GetMapping
    public ResponseEntity<String> getUser(){
        return ResponseEntity.ok("success");
    }
}
