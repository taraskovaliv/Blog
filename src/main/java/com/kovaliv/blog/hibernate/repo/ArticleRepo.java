package com.kovaliv.blog.hibernate.repo;

import com.kovaliv.blog.hibernate.models.Article;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
@Repository
public interface ArticleRepo {

    void add(Article article);

    void delete(Article article);

    void delete(Integer id);

    Article get(Integer id);

    Article get(String name);
}
