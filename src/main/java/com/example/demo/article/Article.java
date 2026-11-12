package com.example.demo.article;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Article {

    private Long id;

    @NotBlank
    @Length(max = 200)
    private String title;

    @NotBlank
    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Integer versionNo;
}
