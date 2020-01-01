package com.kovaliv.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("user")
    public String getUser() {
        return "pages/user";
    }

}
