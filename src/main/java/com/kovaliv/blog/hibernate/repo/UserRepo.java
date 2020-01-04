package com.kovaliv.blog.hibernate.repo;

import com.kovaliv.blog.hibernate.models.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class UserRepo extends Repo {

    public static void delete(Integer id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            User user = session.load(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            throw ex;
        }
    }

    public static User get(Integer id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            User user = session.load(User.class, id);
            session.getTransaction().commit();
            session.close();
            return user;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            throw ex;
        }
    }

}
