package com.example.demo.account;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {

    private final AccountMapper accountMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public Account findByUsername(String username) {
        return accountMapper.findByUsername(username);
    }

    public void update(String username, String newPassword){
        accountMapper.update(username, passwordEncoder.encode(newPassword));
    }
}
