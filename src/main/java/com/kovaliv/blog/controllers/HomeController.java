package com.kovaliv.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/index")
    public String getIndex(Model model){
        if (LoginController.getUser() != null) {
            model.addAttribute("login", LoginController.getUser().getLogin());
        }
        return "index";
    }
    
}
