package com.example.demo.account;

import java.time.Duration;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Account {

    private static final Duration LOCKOUT_DURATION = Duration.ofMinutes(1);
    
    private String username;

    private String roles;

    private String password;

    private String email;

    private String lockout;

    private LocalDateTime lockedAt;

    private Integer failedCount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    
    private Integer versionNo;

    public boolean isLocked() {
        return "1".equals(this.lockout)
                    && this.lockedAt.isAfter(LocalDateTime.now().minus(LOCKOUT_DURATION));
    }
}
