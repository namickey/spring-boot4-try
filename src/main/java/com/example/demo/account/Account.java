package com.example.demo.account;

import java.time.Duration;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.ToString;

@Data
public class Account {

    private static final Duration LOCKOUT_DURATION = Duration.ofMinutes(1);
    
    private String username;

    private String roles;

    @ToString.Exclude
    private String password;

    private Integer passwordInit;

    private String email;

    private Integer lockout;

    private LocalDateTime lockedAt;

    private Integer failedCount;

    private LocalDateTime lastLoginAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    
    private Integer versionNo;

    public boolean isLocked() {
        return this.lockout == 1
                    && this.lockedAt.isAfter(LocalDateTime.now().minus(LOCKOUT_DURATION));
    }
}
