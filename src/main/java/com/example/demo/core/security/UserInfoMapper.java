package com.example.demo.core.security;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {

    /**
     * 1件検索
     * @param username ユーザ名
     * @return UserInfo
     */
    UserInfo findByUsername(String username);
}
