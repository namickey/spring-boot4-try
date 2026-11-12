package com.example.demo.account;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.common.messege.MessageConst;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {

    private final AccountMapper accountMapper;

    @Transactional(readOnly = true)
    public Account findByUsername(String username) {
        return accountMapper.findByUsername(username);
    }

    public void updatePassword(Account account) {
        int i = accountMapper.updatePassword(account);
        if (i == 0) {
            throw new OptimisticLockingFailureException(MessageConst.ME901);
        }
    }
}
