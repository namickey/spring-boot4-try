package com.example.demo.core.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SpringSecurity設定
 */
@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        // ログイン
        .formLogin(login -> login
            .defaultSuccessUrl("/", true)
            .permitAll()
        // ログアウト
        ).logout(logout -> logout
            .logoutSuccessUrl("/")
        ).authorizeHttpRequests(authz -> authz
            .requestMatchers("/").permitAll()
            .requestMatchers("/articles/new/**").authenticated()
            .requestMatchers("/articles/*/edit").authenticated()
            .requestMatchers("/articles/*/delete").authenticated()
            .requestMatchers("/articles/*").permitAll()
            // その他画面は認証済みが必須
            .anyRequest().authenticated()
        ).headers(headers -> headers
            .frameOptions(frameOptions -> frameOptions
                .sameOrigin())
        );
        return http.build();
    }
}
