package com.dev.leandro.authorization_service.dto;

public record RegisterRequestDTO(
    String name, String email, String password
) {
    
}
