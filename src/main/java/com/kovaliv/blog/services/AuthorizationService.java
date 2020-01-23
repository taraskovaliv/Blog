package com.kovaliv.blog.services;

import com.kovaliv.blog.exceptions.MessageException;
import com.kovaliv.blog.hibernate.enams.LoginStatus;
import com.kovaliv.blog.hibernate.enams.Role;
import com.kovaliv.blog.hibernate.models.User;
import com.kovaliv.blog.hibernate.repo.Repos;
import com.kovaliv.blog.hibernate.repo.UserRepo;
import com.kovaliv.blog.hibernate.repo.UserRepoHibernate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ui.Model;

public class AuthorizationService {

    private static Logger logger = LogManager.getLogger(AuthorizationService.class);

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
            logger.info("Logged user " + getUser().toString());
            return;
        }
        throw new MessageException("Incorrect password");
    }

    public static void registration(User user) throws MessageException {

        user.setRole(Role.USER.name());

        UserRepo userRepo = Repos.getUserRepo();
        User user1 = userRepo.getByEmail(user.getEmail());
        User user2 = userRepo.get(user.getLogin());

        if (user1 == null) {
            if (user2 == null) {
                userRepo.add(user);
                setUser(user);
                setLoginStatus(LoginStatus.AUTHORIZED);
                logger.info("Registered user " + user.toString());
            } else {
                throw new MessageException("Email unavailable");
            }
        } else {
            throw new MessageException("Login unavailable");
        }
    }

    public static void logout() {
        AuthorizationService.setUser(null);
        AuthorizationService.setLoginStatus(LoginStatus.NOT_AUTHORIZED);
    }

    public static void setUserAttributes(Model model) {
        User user = AuthorizationService.getUser();
        model.addAttribute("id", user.getUserId());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("login", user.getLogin());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("name", user.getName());
        model.addAttribute("surname", user.getSurname());
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
