package com.example.demo.article;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NewArticleForm {

    @NotBlank
    @Length(max = 200)
    private String title;

    @NotBlank
    private String content;

    public Article toArticle() {
        Article article = new Article();
        BeanUtils.copyProperties(this, article);
        return article;
    }
}
