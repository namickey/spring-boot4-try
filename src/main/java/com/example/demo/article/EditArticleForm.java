package com.example.demo.article;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EditArticleForm {

    @NotBlank
    @Length(max = 200)
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private Integer versionNo;

    public EditArticleForm(Article article) {
        BeanUtils.copyProperties(article, this);
    }

    public Article toArticle() {
        Article article = new Article();
        BeanUtils.copyProperties(this, article);
        return article;
    }
}
