package com.example.demo.core.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.core.security.PasswordInitInterceptor;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final PasswordInitInterceptor passwordInitInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(passwordInitInterceptor)
        .addPathPatterns("/**")
        .excludePathPatterns("/account/password/edit", "/login", "/error", "/h2-console/**");
    }
}
