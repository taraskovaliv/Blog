package com.kovaliv.blog.hibernate.repo;

import com.kovaliv.blog.hibernate.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface UserRepo {

    void add(User user);

    void delete(User user);

    void delete(Integer id);

    User get(Integer id);

    User get(String login);

    User getByEmail(String email);

    void edit(User user);

}
