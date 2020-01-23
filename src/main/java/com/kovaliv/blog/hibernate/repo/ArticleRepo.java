package com.kovaliv.blog.hibernate.repo;

import com.kovaliv.blog.hibernate.models.Article;

import java.util.List;


public interface ArticleRepo {

    void add(Article article);

    void delete(Article article);

    void delete(Integer id);

    Article get(Integer id);

    Article get(String name);

    List<Article> getArticles(String login);

    List<Article> getLast(int num);
}
