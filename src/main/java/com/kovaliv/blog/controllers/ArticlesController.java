package com.kovaliv.blog.controllers;

import com.kovaliv.blog.hibernate.models.Article;
import com.kovaliv.blog.hibernate.repo.ArticleRepo;
import com.kovaliv.blog.hibernate.repo.Repos;
import com.kovaliv.blog.services.AuthorizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;

@Controller
public class ArticlesController {

    @GetMapping(value = "/myArticles")
    public static String getMyArticles(Model model) {
        AuthorizationService.setUserAttributes(model);
        ArticleRepo articleRepo = Repos.getArticleRepo();
        model.addAttribute("list", articleRepo.getArticles(AuthorizationService.getUser().getLogin()));
        return "pages/articles";
    }

    @PostMapping(value = "/articles")
    public static String getArticles(@Validated Integer id) {


        return "pages/articles";
    }

    @PostMapping(value = "/addArticle")
    public static String addArticles(@Validated Article article, Model model) {
        ArticleRepo articleRepo = Repos.getArticleRepo();
        article.setDate(new Date(System.currentTimeMillis()));
        article.setAuthor(AuthorizationService.getUser().getLogin());
        articleRepo.add(article);
        return "redirect:/myArticles";
    }

    @GetMapping(value = "/addArticle")
    public static String newArticle() {
        return "pages/newArticle";
    }

}
