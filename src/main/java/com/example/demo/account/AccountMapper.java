package com.example.demo.account;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {

    Account findByUsername(String username);

    int update(String username, String password, Integer versionNo);
}
