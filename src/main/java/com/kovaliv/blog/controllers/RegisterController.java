package com.kovaliv.blog.controllers;

import com.kovaliv.blog.hibernate.models.User;
import com.kovaliv.blog.hibernate.repo.Repos;
import com.kovaliv.blog.hibernate.repo.UserRepo;
import com.kovaliv.blog.hibernate.repo.UserRepoHibernate;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class RegisterController {

    @GetMapping(value = "/register")
    public String getRegister(Model model) {
        return "pages/register";
    }

    @PostMapping(value = "/register")
    public String register(@Validated User user, Model model) {
        UserRepo userRepo = Repos.getUserRepo();

        User user1 = userRepo.get(user.getLogin());
        if (user1 == null) {
            userRepo.add(user);
            return "redirect:/index";
        }
        return "pages/register";
    }
}
