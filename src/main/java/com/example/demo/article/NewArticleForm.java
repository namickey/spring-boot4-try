package com.example.demo.article;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import jakarta.validation.constraints.NotBlank;

public record NewArticleForm(

        @NotBlank @Length(max = 200) String title,
        @NotBlank String content

) {
    public static NewArticleForm empty(){
        return new NewArticleForm(null, null);
    }
    public Article toArticle() {
        Article article = new Article();
        BeanUtils.copyProperties(this, article);
        return article;
    }
}
