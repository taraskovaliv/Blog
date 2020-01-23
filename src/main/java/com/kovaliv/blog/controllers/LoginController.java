package com.kovaliv.blog.controllers;

import com.kovaliv.blog.exceptions.MessageException;
import com.kovaliv.blog.hibernate.models.User;
import com.kovaliv.blog.services.AuthorizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin(Model model) {
        return "pages/login";
    }

    @PostMapping("/login")
    public String authorization(@Validated User user, Model model){
        try {
            AuthorizationService.login(user);
        } catch (MessageException ex) {
            model.addAttribute("message", ex.getMessage());
            return getLogin(model);
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(){
        AuthorizationService.logout();
        return "redirect:/";
    }

}
