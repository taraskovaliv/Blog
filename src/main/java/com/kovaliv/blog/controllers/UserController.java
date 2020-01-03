package com.kovaliv.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("user")
    public String getUser(Model model) {
        if (LoginController.getUser() != null) {
            model.addAttribute("login", LoginController.getUser().getLogin());
        }
        return "pages/user";
    }

}
