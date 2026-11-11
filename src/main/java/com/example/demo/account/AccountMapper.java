package com.example.demo.account;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {

    /**
     * 1件検索
     * @param username ユーザ名
     * @return Account
     */
    Account findByUsername(String username);

    int update(String username, String password, Integer versionNo);
}
