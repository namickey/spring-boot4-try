package com.example.demo.article;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EditArticleForm(

        @NotNull Long id,

        @NotBlank @Length(max = 200) String title,

        @NotBlank String content,

        @NotNull Integer versionNo) {
    public static EditArticleForm from(Article article) {
        return new EditArticleForm(article.getId(), article.getTitle(), article.getContent(), article.getVersionNo());
    }

    public Article toArticle() {
        Article article = new Article();
        BeanUtils.copyProperties(this, article);
        return article;
    }
};
