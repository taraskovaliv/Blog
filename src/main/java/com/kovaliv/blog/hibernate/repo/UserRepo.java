package com.kovaliv.blog.hibernate.repo;

import com.kovaliv.blog.hibernate.models.User;


public interface UserRepo {

    void add(User user);

    void plusView(User user);

    void delete(User user);

    void delete(Integer id);

    User get(Integer id);

    User get(String login);

    User getByEmail(String email);

    void edit(User user);

}
