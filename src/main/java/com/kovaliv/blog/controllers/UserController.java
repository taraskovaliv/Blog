package com.kovaliv.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("user")
    public String getUser(Model model) {
        if (LoginController.getUser() != null) {
            model.addAttribute("menu", 1);
            model.addAttribute("login", LoginController.getUser().getLogin());
            model.addAttribute("id", LoginController.getUser().getUserId());
            model.addAttribute("name", LoginController.getUser().getName());
            model.addAttribute("surname", LoginController.getUser().getSurname());
            model.addAttribute("email", LoginController.getUser().getEmail());
        } else {
            model.addAttribute("menu", 0);
        }
        return "pages/user";
    }

}
