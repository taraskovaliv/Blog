package com.kovaliv.blog.services;

import com.kovaliv.blog.exceptions.MessageException;
import com.kovaliv.blog.hibernate.enams.LoginStatus;
import com.kovaliv.blog.hibernate.models.User;
import com.kovaliv.blog.hibernate.repo.UserRepo;
import com.kovaliv.blog.hibernate.repo.UserRepoHibernate;
import org.springframework.ui.Model;

public class AuthorizationService {

    private static User user = null;

    private static LoginStatus loginStatus = LoginStatus.NOT_AUTHORIZED;

    public static void login(User user) throws MessageException {
        UserRepo userRepo = new UserRepoHibernate();
        User user1 = userRepo.get(user.getLogin());
        if (user1 == null) {
            user1 = userRepo.getByEmail(user.getLogin());
            if (user1 == null) {
                throw new MessageException("Incorrect login");
            }
        }
        if (user1.getPassword().equals(user.getPassword())) {
            AuthorizationService.setUser(user1);
            AuthorizationService.setLoginStatus(LoginStatus.AUTHORIZED);
            return;
        }
        throw new MessageException("Incorrect password");
    }

    public static void logout() {
        AuthorizationService.setUser(null);
        AuthorizationService.setLoginStatus(LoginStatus.NOT_AUTHORIZED);
    }

    public static Model setUserAttributes(Model model) {
        User user = AuthorizationService.getUser();
        model.addAttribute("id", user.getUserId());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("login", user.getLogin());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("name", user.getName());
        model.addAttribute("surname", user.getSurname());
        return model;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        AuthorizationService.user = user;
    }

    public static LoginStatus getLoginStatus() {
        return loginStatus;
    }

    public static void setLoginStatus(LoginStatus loginStatus) {
        AuthorizationService.loginStatus = loginStatus;
    }

}
