package com.kovaliv.blog.controllers;

import com.kovaliv.blog.hibernate.enams.Role;
import com.kovaliv.blog.hibernate.models.User;
import com.kovaliv.blog.hibernate.repo.UserRepo;
import com.kovaliv.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

public class RegisterController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/register")
    public String getRegister() {
        return "pages/register";
    }

    @PostMapping(value = "/register")
    public String register(@Validated User user, Model model) {
        User user1 = (User) userService.loadUserByUsername(user.getLogin());
        if (user1 == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Collections.singleton(Role.USER));
            userRepo.add(user);
            return "redirect:/index";
        }
        return "pages/register";
    }
}
