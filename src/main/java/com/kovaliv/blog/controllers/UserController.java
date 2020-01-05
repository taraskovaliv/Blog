package com.kovaliv.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("user")
    public String getUser(Model model) {

        return "pages/user";
    }



}
