package com.example.demo.account;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Account {
    private String username;
    private String roles;
    private String password;
    private String email;
    private LocalDate registDate;
    private Integer versionNo;
}
