package com.kovaliv.blog.controllers;

import com.kovaliv.blog.hibernate.models.User;
import com.kovaliv.blog.hibernate.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/user")
    public String getUser() {

        return "pages/user";
    }

    @GetMapping("/editProfile")
    public String editPage() {
        return "pages/editProfile";
    }

    @PostMapping("/editProfile")
    public String editProfile(@Validated User user, Model model) {
        userRepo.edit(user);
        return "pages/user";
    }
}
