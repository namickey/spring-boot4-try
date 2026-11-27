package com.example.demo.account;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.core.exception.AppException;
import com.example.demo.core.message.MessageConst;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {

    private final AccountMapper accountMapper;
    private final PasswordEncoder passwordEncoder;
    private final PasswordHistoryMapper passwordHistoryMapper;

    private static final int PASSWORD_HISTRY_LIMIT = 3;

    @Transactional(readOnly = true)
    public Account getByUsername(String username) {
        Account account = accountMapper.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }
        return account;
    }

    public void updatePassword(Account account) {

        List<PasswordHistory> list = passwordHistoryMapper.findRecentByUsername(account.getUsername(),
                PASSWORD_HISTRY_LIMIT);
        for (PasswordHistory passwordHistory : list) {
            if (passwordEncoder.matches(account.getPassword(), passwordHistory.getPassword())){
                throw new AppException("ME904");
            }
        }

        Account acc = new Account();
        BeanUtils.copyProperties(account, acc);
        acc.setPassword(passwordEncoder.encode(account.getPassword()));
        int i = accountMapper.updatePassword(acc);
        if (i == 0) {
            throw new OptimisticLockingFailureException(MessageConst.ME901);
        }
        passwordHistoryMapper.insert(acc.getUsername(), acc.getPassword());
        passwordHistoryMapper.deleteOverLimit(acc.getUsername(), PASSWORD_HISTRY_LIMIT);
    }

    public LocalDateTime loginSuccess(String username) {
        LocalDateTime lastLoginAt = accountMapper.findByUsername(username).getLastLoginAt();
        accountMapper.updateLoginSuccess(username);
        return lastLoginAt;
    }

    public void loginFailure(String username) {
        Account account = accountMapper.findByUsername(username);
        if (account != null && !account.isLocked()) {
            if (account.getFailedCount() >= 2) {
                accountMapper.lockout(username);
            } else {
                accountMapper.updateFailedCount(username);
            }
        }
    }
}
