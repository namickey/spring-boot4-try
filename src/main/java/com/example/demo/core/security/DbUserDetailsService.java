package com.example.demo.core.security;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.account.Account;
import com.example.demo.account.AccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DbUserDetailsService implements UserDetailsService {

    private static final Duration LOCKOUT_DURATION = Duration.ofMinutes(1);

    private final AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.getByUsername(username);

        boolean isLockout = "1".equals(account.getLockout())
                && account.getLockedAt().isAfter(LocalDateTime.now().minus(LOCKOUT_DURATION));

        String roles = account.getRoles();
        return User.builder()
                .accountLocked(isLockout)
                .username(username)
                .password(account.getPassword())
                .roles(roles == null ? new String[0] : roles.split(","))
                .build();
    }
}
