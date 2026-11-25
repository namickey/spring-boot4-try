package com.example.demo.account;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PasswordHistory {

    private String username;

    private LocalDateTime editedAt;

    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
