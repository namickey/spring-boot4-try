package com.example.demo.article;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {

    List<Article> findAll();

    Article findById(@Param("id") Long id);

    void insert(Article article);

    void update(Article article);

    void deleteById(@Param("id") Long id);

}
