package com.kovaliv.blog.controllers;

import com.kovaliv.blog.enams.UserValid;
import com.kovaliv.blog.hibernate.models.User;
import com.kovaliv.blog.hibernate.repo.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private static User user;

    @GetMapping("login")
    public String getLogin() {
        return "pages/login";
    }

    @PostMapping(value = "login")
    public String login(@Validated User user, Model model) {
        setUser(user);
        model.addAttribute("name", user.getName());
        model.addAttribute("menu", 1);
        return "index";
    }

    @GetMapping(value = "register")
    public String getRegister() {
        return "pages/register";
    }

    @PostMapping(value = "register")
    public String register(@Validated User user, Model model) {
        setUser(user);
        if(UserRepo.isValid(user) == UserValid.VALID){
            UserRepo.add(user);
            model.addAttribute("name", user.getName());
            model.addAttribute("menu", 1);
            return "index";
        }

        return "pages/register";
    }

    @GetMapping(value = "logout")
    public String logout() {
        setUser(null);
        return "pages/login";
    }

    private static String getMessage(UserValid userValid){
        if(userValid == UserValid.EMAILNULL){
            return "Input EMAIL";
        }
        if(userValid == UserValid.NAMENULL){
            return "Input Name";
        }
        if(userValid == UserValid.LOGINNULL){
            return "Input USERNAME";
        }
        if(userValid == UserValid.SURNAMENULL){
            return "Input Surname";
        }
        if(userValid == UserValid.PASSWORDNULL ){
            return "Input PASSWORD";
        }
        return "Username is not available";
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        LoginController.user = user;
    }
}
