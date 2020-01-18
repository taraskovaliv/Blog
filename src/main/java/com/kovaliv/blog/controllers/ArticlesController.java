package com.kovaliv.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticlesController {

    @GetMapping(value = "/myArticles")
    public static String getMyArticles(Model model) {


        return "pages/articles";
    }

    @PostMapping(value = "/articles")
    public static String getArticles(@Validated Integer id) {

        return "pages/articles";
    }

//    @PostMapping(value = "/addArticle")
//    public static String addArticles(@Validated Article article, Model model) {
//
//        article.setAuthor(LoginController.getUser().getUserId());
//        Repo.add(article);
//
//        return getMyArticles(model);
//    }

    @GetMapping(value = "/addArticle")
    public static String newArticle() {
        return "pages/newArticle";
    }

}
