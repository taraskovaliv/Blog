package com.kovaliv.blog.controllers;

import com.kovaliv.blog.hibernate.models.User;
import com.kovaliv.blog.hibernate.repo.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("user")
    public String getUser() {

        return "pages/user";
    }

    @GetMapping("editProfile")
    public String editPage() {
        return "pages/editProfile";
    }

    @PostMapping("editProfile")
    public String editProfile(@Validated User user, Model model){
        if(!user.getLogin().equals(LoginController.getUser().getLogin())){
            User user1 = UserRepo.get(user.getLogin());
            if(user1 != null){
                model.addAttribute("message", "login is not available");
                return "pages/user";
            }
        }
        user.setId(LoginController.getUser().getId());
        UserRepo.edit(user);
        return "pages/user";
    }
}
