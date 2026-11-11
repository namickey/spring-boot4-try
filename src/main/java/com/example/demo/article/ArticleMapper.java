package com.example.demo.article;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {

    List<Article> findAll();

    Article findById(@Param("id") Long id);

    void insert(Article article);

    int update(Article article);

    int deleteById(@Param("id") Long id, @Param("versionNo") Integer versionNo);

}
