package com.kovaliv.blog.controllers;

import com.kovaliv.blog.hibernate.models.Article;
import com.kovaliv.blog.hibernate.models.User;
import com.kovaliv.blog.hibernate.repo.Repo;
import com.kovaliv.blog.hibernate.repo.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticlesController {

    @GetMapping(value = "myArticles")
    public static String getMyArticles(Model model) {

        model.addAttribute("user", LoginController.getUser());

        return "pages/articles";
    }

    @PostMapping(value = "articles")
    public static String getArticles(@Validated Integer id, Model model) {
        User user = UserRepo.get(id);

        model.addAttribute("user", user);

        return "pages/articles";
    }

    @PostMapping(value = "addArticle")
    public static String addArticles(@Validated Article article, Model model) {

        article.setAuthor(LoginController.getUser().getUserId());
        Repo.add(article);

        return getMyArticles(model);
    }

    @GetMapping(value = "addArticle")
    public static String newArticle() {
        return "pages/newArticle";
    }

}
