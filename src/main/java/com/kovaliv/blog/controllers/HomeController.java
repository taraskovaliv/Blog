package com.kovaliv.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping("")
    public String index(Principal principal) {
        return "index";
    }

    @GetMapping("index")
    public String getIndex(Principal principal) {
        return "index";
    }

}
