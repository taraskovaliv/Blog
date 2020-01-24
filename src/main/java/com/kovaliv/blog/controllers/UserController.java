package com.kovaliv.blog.controllers;

import com.kovaliv.blog.hibernate.models.User;
import com.kovaliv.blog.hibernate.repo.ArticleRepo;
import com.kovaliv.blog.hibernate.repo.Repos;
import com.kovaliv.blog.hibernate.repo.UserRepo;
import com.kovaliv.blog.services.AuthorizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/myProfile")
    public String getMyProfile(Model model) {
        AuthorizationService.setUserAttributes(model);
        return "pages/user/myProfile";
    }

    @GetMapping("/user/{login}")
    public String getUser(@PathVariable String login, Model model){
        AuthorizationService.setUserAttributes(model);

        UserRepo userRepo = Repos.getUserRepo();
        model.addAttribute("user", userRepo.get(login));

        ArticleRepo articleRepo = Repos.getArticleRepo();
        model.addAttribute("list", articleRepo.getArticles(login));

        return "pages/user/user";
    }

    @GetMapping("/editProfile")
    public String editPage(Model model) {
        AuthorizationService.setUserAttributes(model);
        return "pages/user/editProfile";
    }

    @PostMapping("/editProfile")
    public String editProfile(@Validated User user, Model model) {
        UserRepo userRepo = Repos.getUserRepo();

        user.setLogin(AuthorizationService.getUser().getLogin());
        user.setUserId(AuthorizationService.getUser().getUserId());
        user.setRole(AuthorizationService.getUser().getRole());

        userRepo.edit(user);

        AuthorizationService.setUser(userRepo.get(user.getLogin()));
        AuthorizationService.setUserAttributes(model);

        return "pages/user/myProfile";
    }
}
