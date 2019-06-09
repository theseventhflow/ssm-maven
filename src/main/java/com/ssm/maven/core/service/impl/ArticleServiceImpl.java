package com.ssm.maven.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.ssm.maven.core.mapper.ArticleMapper;
import com.ssm.maven.core.pojo.Article;
import com.ssm.maven.core.service.ArticleService;
import org.springframework.stereotype.Service;


@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public List<Article> findArticle(Map<String, Object> map) {
        return articleMapper.findArticles(map);
    }

    @Override
    public Long getTotalArticle(Map<String, Object> map) {
        return articleMapper.getTotalArticles(map);
    }

    @Override
    public int addArticle(Article article) {
        if (article.getArticleTitle() == null || article.getArticleContent() == null || getTotalArticle(null) > 90 || article.getArticleContent().length() > 50000) {
            return 0;
        }
        return articleMapper.insertArticle(article);
    }

    @Override
    public int updateArticle(Article article) {
        if (article.getArticleTitle() == null || article.getArticleContent() == null || getTotalArticle(null) > 90 || article.getArticleContent().length() > 50000) {
            return 0;
        }
        return articleMapper.updArticle(article);
    }

    @Override
    public int deleteArticle(String id) {
        return articleMapper.delArticle(id);
    }

    @Override
    public Article findById(String id) {
        return articleMapper.getArticleById(id);
    }

}
