package com.dev.leandro.tech_interview_two.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.leandro.tech_interview_two.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
    public Optional<User> findByEmail(String email);
}
