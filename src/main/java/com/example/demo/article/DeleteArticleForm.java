package com.example.demo.article;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DeleteArticleForm {
    @NotNull
    private Integer versionNo;
}
