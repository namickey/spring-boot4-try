package com.example.demo.article;

import java.util.List;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.common.messege.MessageConst;
import com.example.demo.core.exception.AppException;

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
            throw new AppException(MessageConst.ME404);
        }
        return article;
    }

    public void create(Article article) {
        articleMapper.insert(article);
    }

    public void update(Article article) {
        int i = articleMapper.update(article);
        if (i == 0) {
            throw new OptimisticLockingFailureException(MessageConst.ME901);
        }
    }

    public void deleteById(Long id, Integer versionNo) {
        int i = articleMapper.deleteById(id, versionNo);
        if (i == 0) {
            throw new OptimisticLockingFailureException(MessageConst.ME901);
        }
    }
}
