package com.example.demo.article;

import java.util.List;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleMapper articleMapper;

    @Transactional(readOnly = true)
    public List<Article> findAll() {
        return articleMapper.findAll();
    }

    @Transactional(readOnly = true)
    public Article getById(Long id) {
        Article article = articleMapper.findById(id);
        if (article == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article not found: " + id);
        }
        return article;
    }

    public void create(Article article) {
        articleMapper.insert(article);
    }

    public void update(Article article) {
        int i = articleMapper.update(article);
        if (i == 0) {
            throw new OptimisticLockingFailureException("ME901");
        }
    }

    public void deleteById(Long id, Integer versionNo) {
        int i = articleMapper.deleteById(id, versionNo);
        if (i == 0) {
            throw new OptimisticLockingFailureException("ME901");
        }
    }

}
