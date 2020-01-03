package com.kovaliv.blog.hibernate.repo;

import com.kovaliv.blog.hibernate.HibernateUtil;
import com.kovaliv.blog.hibernate.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserRepo {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static void add(User user){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(Integer id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.load(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

}
