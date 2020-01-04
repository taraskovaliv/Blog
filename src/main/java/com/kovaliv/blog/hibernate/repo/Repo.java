package com.kovaliv.blog.hibernate.repo;

import com.kovaliv.blog.hibernate.HibernateUtil;
import com.kovaliv.blog.hibernate.models.DataModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Repo {

    protected static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static void add(DataModel data) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(data);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            throw ex;
        }
    }

    public static void delete(DataModel data) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(data);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            throw ex;
        }
    }
}
