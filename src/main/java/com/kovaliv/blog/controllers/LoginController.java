package com.kovaliv.blog.controllers;

import com.kovaliv.blog.hibernate.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    private static User user;

    @RequestMapping("login")
    public String getLogin(){
        return "pages/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@Validated User user, Model model){
        setUser(user);
        model.addAttribute("login", user.getLogin());
        model.addAttribute("password", user.getPassword());
        return "index";
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        LoginController.user = user;
    }
}
