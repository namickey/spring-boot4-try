package com.example.demo.account;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.core.message.MessageConst;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {

    private final AccountMapper accountMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public Account getByUsername(String username) {
        Account account = accountMapper.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }
        return account;
    }

    public void updatePassword(Account account) {
        Account acc = new Account();
        BeanUtils.copyProperties(account, acc);
        acc.setPassword(passwordEncoder.encode(account.getPassword()));
        int i = accountMapper.updatePassword(acc);
        if (i == 0) {
            throw new OptimisticLockingFailureException(MessageConst.ME901);
        }
    }

    public void loginFailure(String username) {
        accountMapper.updateFailedCount(username);
    }
}
