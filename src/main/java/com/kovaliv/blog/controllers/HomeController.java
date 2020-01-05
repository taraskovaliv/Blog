package com.kovaliv.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        if (LoginController.getUser() != null) {
            model.addAttribute("login", LoginController.getUser().getLogin());
            model.addAttribute("menu", 1);
        }
        return "index";
    }

    @GetMapping("index")
    public String getIndex(Model model) {
        if (LoginController.getUser() != null) {
            model.addAttribute("menu", 1);
            model.addAttribute("login", LoginController.getUser().getLogin());
        }
        return "index";
    }

}
