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
public class RegisterController {

    @GetMapping(value = "/register")
    public String getRegister(Model model) {
        return "pages/register";
    }

    @PostMapping(value = "/register")
    public String register(@Validated User user, Model model) {
        try {
            AuthorizationService.registration(user);
            return "redirect:/";
        } catch (MessageException ex) {
            model.addAttribute("message", ex.getMessage());
            return getRegister(model);
        }
    }
}
