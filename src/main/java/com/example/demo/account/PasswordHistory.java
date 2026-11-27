package com.example.demo.account;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.ToString;

@Data
public class PasswordHistory {

    private String username;

    private LocalDateTime editedAt;

    @ToString.Exclude
    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
