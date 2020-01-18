package com.kovaliv.blog.hibernate.repo;

import com.kovaliv.blog.hibernate.models.Article;


public interface ArticleRepo {

    void add(Article article);

    void delete(Article article);

    void delete(Integer id);

    Article get(Integer id);

    Article get(String name);
}
