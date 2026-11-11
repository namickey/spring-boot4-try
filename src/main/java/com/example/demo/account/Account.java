package com.example.demo.account;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Account {
    private String username;
    private String roles;
    private String password;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer versionNo;
}
