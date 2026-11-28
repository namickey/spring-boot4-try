package com.example.demo.article;

import jakarta.validation.constraints.NotNull;

public record DeleteArticleForm(

                @NotNull Integer versionNo

) {
}