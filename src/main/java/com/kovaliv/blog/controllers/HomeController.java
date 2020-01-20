package com.kovaliv.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/index"})
    public String index(Principal principal) {
        return "index";
    }

}
