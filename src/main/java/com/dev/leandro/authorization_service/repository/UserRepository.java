package com.dev.leandro.authorization_service.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.leandro.authorization_service.entity.User;

public interface UserRepository extends JpaRepository<User, UUID>{
    public Optional<User> findByEmail(String email);
}
