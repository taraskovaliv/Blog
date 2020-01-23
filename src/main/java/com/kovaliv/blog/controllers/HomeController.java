package com.kovaliv.blog.controllers;

import com.kovaliv.blog.hibernate.enams.LoginStatus;
import com.kovaliv.blog.services.AuthorizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/index"})
    public String getIndex(Model model) {
        if (AuthorizationService.getLoginStatus() == LoginStatus.AUTHORIZED) {
            AuthorizationService.setUserAttributes(model);
        }
        return "index";
    }

}
