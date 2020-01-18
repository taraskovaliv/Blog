package com.kovaliv.blog.hibernate.repo;

import com.kovaliv.blog.hibernate.models.Article;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class ArticleRepoHibernate implements ArticleRepo {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void add(Article article) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(article);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw ex;
        }
    }

    @Override
    public void delete(Article article) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
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

    @Override
    public void delete(Integer id) {
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

    @Override
    public Article get(Integer id) {
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

    @Override
    public Article get(String name) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Article.class);
            Article article = (Article) criteria.add(Restrictions.eq("name", name)).uniqueResult();
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
