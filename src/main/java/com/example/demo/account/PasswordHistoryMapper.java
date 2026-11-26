package com.example.demo.account;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PasswordHistoryMapper {

    List<PasswordHistory> findRecentByUsername(@Param("username") String username, @Param("limit") int limit);

    int insert(@Param("username") String username, @Param("password") String password);

    int deleteOverLimit(@Param("username") String username, @Param("limit") int limit);
}
