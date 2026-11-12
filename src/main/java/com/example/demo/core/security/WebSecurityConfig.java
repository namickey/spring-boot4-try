package com.example.demo.core.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .formLogin(login -> login
            .defaultSuccessUrl("/", true)
            .permitAll()
        ).logout(logout -> logout
            .logoutSuccessUrl("/")
        ).authorizeHttpRequests(authz -> authz
            .requestMatchers("/").permitAll()
            .requestMatchers("/articles/new/**").authenticated()
            .requestMatchers("/articles/*/edit").authenticated()
            .requestMatchers("/articles/*/delete").authenticated()
            .requestMatchers("/articles/*").permitAll()
            .anyRequest().authenticated()
        ).headers(headers -> headers
            .frameOptions(frameOptions -> frameOptions
                .sameOrigin())
        );
        return http.build();
    }
}
