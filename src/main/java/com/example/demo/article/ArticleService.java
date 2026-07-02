package com.example.demo.article;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArticleService {

    private final ArticleMapper articleMapper;

    public ArticleService(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Transactional(readOnly = true)
    public List<Article> findAll() {
        return articleMapper.findAll();
    }

    @Transactional(readOnly = true)
    public Article findById(Long id) {
        return articleMapper.findById(id);
    }

    public void create(Article article) {
        LocalDateTime now = LocalDateTime.now();
        article.setCreatedAt(now);
        article.setUpdatedAt(now);
        articleMapper.insert(article);
    }

    public void update(Article article) {
        article.setUpdatedAt(LocalDateTime.now());
        articleMapper.update(article);
    }

    public void deleteById(Long id) {
        articleMapper.deleteById(id);
    }

}
