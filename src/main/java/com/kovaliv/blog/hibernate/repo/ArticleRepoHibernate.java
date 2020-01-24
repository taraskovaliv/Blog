package com.kovaliv.blog.hibernate.repo;

import com.kovaliv.blog.hibernate.models.Article;
import com.kovaliv.blog.services.HibernateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ArticleRepoHibernate implements ArticleRepo {

    private final Logger logger = LogManager.getLogger(ArticleRepoHibernate.class);

    private SessionFactory sessionFactory;

    public ArticleRepoHibernate() {
        sessionFactory = HibernateService.getSessionFactory();
    }

    @Override
    public void add(Article article) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(article);
            session.getTransaction().commit();
            session.close();
            logger.info("Added " + article.toString());
        } catch (HibernateException ex) {
            logger.warn(ex.getMessage());
            if (session != null) {
                session.getTransaction().rollback();
            }
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
            logger.info("Deleted " + article.toString());
        } catch (HibernateException ex) {
            logger.warn(ex.getMessage());
            if (session != null) {
                session.getTransaction().rollback();
            }
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
            logger.info("Deleted " + article.toString());
        } catch (HibernateException ex) {
            logger.warn(ex.getMessage());
            if (session != null) {
                session.getTransaction().rollback();
            }
        }
    }

    @Override
    public Article get(Integer id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Article article = session.get(Article.class, id);
            session.getTransaction().commit();
            session.close();
            logger.info("Getted by id" + article.toString());
            return article;
        } catch (HibernateException ex) {
            logger.warn(ex.getMessage());
            if (session != null) {
                session.getTransaction().rollback();
            }
            return null;
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
            logger.info("Getted by name" + article.toString());
            return article;
        } catch (HibernateException ex) {
            logger.warn(ex.getMessage());
            if (session != null) {
                session.getTransaction().rollback();
            }
            return null;
        }
    }

    @Override
    public List<Article> getArticles(String login) {
        Session session = null;
        List<Article> list;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Article.class);
            list = criteria.add(Restrictions.eq("author", login)).list();
            session.getTransaction().commit();
            session.close();
            logger.info("Getted articles by login" + login);
            return list;
        } catch (HibernateException ex) {
            logger.warn(ex.getMessage());
            if (session != null) {
                session.getTransaction().rollback();
            }
            return null;
        }
    }

    @Override
    public List<Article> getLast(Integer num) {
        Session session = null;
        List<Article> list;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            list = session.createQuery("from Article order by id DESC").setMaxResults(num).list();
            session.getTransaction().commit();
            session.close();
            logger.info("Getted last " + num.toString() + " articles");
            return list;
        } catch (HibernateException ex) {
            logger.warn(ex.getMessage());
            if (session != null) {
                session.getTransaction().rollback();
            }
            return null;
        }
    }
}
