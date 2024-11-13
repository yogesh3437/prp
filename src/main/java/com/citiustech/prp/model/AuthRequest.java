package com.citiustech.prp.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AuthRequest {
    private String username;
    private String password;

    // Getters and Setters
}