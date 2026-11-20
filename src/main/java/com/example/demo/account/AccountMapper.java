package com.example.demo.account;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {

    Account findByUsername(@Param("username") String username);

    int updatePassword(Account account);

    int updateLoginSuccess(@Param("username") String username);

    int updateFailedCount(@Param("username") String username);

    int lockout(@Param("username") String username);
}
