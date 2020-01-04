package com.kovaliv.blog.hibernate.repo;

import com.kovaliv.blog.hibernate.models.Article;
import com.kovaliv.blog.hibernate.models.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ArticleRepo extends Repo {
    public static void delete(Integer id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Article article = session.load(Article.class, id);
            session.delete(article);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw ex;
        }
    }

    public static Article get(Integer id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Article article = session.load(Article.class, id);
            session.getTransaction().commit();
            session.close();
            return article;
        } catch (HibernateException ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw ex;
        }
    }

    public static Article get(String name) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            Article article = (Article) criteria.add(Restrictions.eq("NAME", name)).uniqueResult();
            session.getTransaction().commit();
            session.close();
            return article;
        } catch (HibernateException ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw ex;
        }
    }
}
