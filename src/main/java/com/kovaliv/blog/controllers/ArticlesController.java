package com.kovaliv.blog.controllers;

import com.kovaliv.blog.hibernate.models.Article;
import com.kovaliv.blog.hibernate.repo.ArticleRepo;
import com.kovaliv.blog.hibernate.repo.Repos;
import com.kovaliv.blog.services.AuthorizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;

@Controller
public class ArticlesController {

    @GetMapping(value = "/myArticles")
    public static String getMyArticles(Model model) {
        AuthorizationService.setUserAttributes(model);
        ArticleRepo articleRepo = Repos.getArticleRepo();
        model.addAttribute("list", articleRepo.getArticles(AuthorizationService.getUser().getLogin()));
        return "pages/article/articles";
    }

    @PostMapping(value = "/articles")
    public static String getArticles(@Validated Integer id) {


        return "pages/article/articles";
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
        return "pages/article/newArticle";
    }

    @GetMapping(value = "/deleteArticle/{id}")
    public static String deleteArticle(@PathVariable Integer id) {
        ArticleRepo articleRepo = Repos.getArticleRepo();

        articleRepo.delete(id);

        return "redirect:/myArticles";
    }

    @GetMapping(value = "/editArticle/{id}")
    public static String editArticle(@PathVariable Integer id, Model model) {
        ArticleRepo articleRepo = Repos.getArticleRepo();

        Article article = articleRepo.get(id);

        model.addAttribute("article", article);

        return "pages/article/editArticle";
    }

    @PostMapping(value = "/editArticle")
    public static String edit(@Validated Article article) {
        ArticleRepo articleRepo = Repos.getArticleRepo();

        article.setAuthor(AuthorizationService.getUser().getLogin());
        article.setDate(new Date(System.currentTimeMillis()));

        articleRepo.edit(article);

        return "redirect:/myArticles";
    }

}
