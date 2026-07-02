package com.example.demo.article;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Article {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
