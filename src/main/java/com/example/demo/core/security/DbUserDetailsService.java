package com.example.demo.core.security;

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

    private final AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountService.findByUsername(username);

        if (account == null) {
            throw new UsernameNotFoundException(username);
        }
        String roles = account.getRoles();
        return User.builder()
                .username(username)
                .password(account.getPassword())
                .roles(roles == null ? new String[0] : roles.split(","))
                .build();
    }
}
