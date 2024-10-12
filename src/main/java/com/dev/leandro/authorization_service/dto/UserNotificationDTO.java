package com.dev.leandro.authorization_service.dto;

import java.util.UUID;

public record UserNotificationDTO(
    UUID id, String userName, String email, String notification) {
    
}
