package com.kovaliv.blog.hibernate.repo;

import com.kovaliv.blog.hibernate.models.User;
import com.kovaliv.blog.services.HibernateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class UserRepoHibernate implements UserRepo {

    Logger logger = LogManager.getLogger(UserRepoHibernate.class);

    private SessionFactory sessionFactory;

    public UserRepoHibernate() {
        sessionFactory = HibernateService.getSessionFactory();
    }

    @Override
    public void add(User user) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
            session.close();
            logger.info("Added " + user.toString());
        } catch (HibernateException ex) {
            logger.warn(ex.getMessage());
            if (session != null) {
                session.getTransaction().rollback();
            }
        } catch (Exception ex) {
            logger.warn(ex.getMessage() + " exception");
        }
    }

    @Override
    public void plusView(User user) {
        Session session = null;
        user.setViews(user.getViews() + 1);
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
            session.close();
            logger.info("Plused views " + user.toString());
        } catch (HibernateException ex) {
            logger.warn(ex.getMessage());
            if (session != null) {
                session.getTransaction().rollback();
            }
        }
    }

    @Override
    public void delete(User user) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            session.close();
            logger.info("Deleted " + user.toString());
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
            User user = session.load(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
            session.close();
            logger.info("Deleted " + user.toString());
        } catch (HibernateException ex) {
            logger.warn(ex.getMessage());
            if (session != null) {
                session.getTransaction().rollback();
            }
        }
    }

    @Override
    public User get(Integer id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.getTransaction().commit();
            session.close();
            logger.info("Getted by id " + user.toString());
            return user;
        } catch (HibernateException ex) {
            logger.warn(ex.getMessage());
            if (session != null) {
                session.getTransaction().rollback();
            }
            return null;
        }
    }

    @Override
    public void edit(User user) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
            session.close();
            logger.info("Edited " + user.toString());
        } catch (HibernateException ex) {
            logger.warn(ex.getMessage());
            if (session != null) {
                session.getTransaction().rollback();
            }
        }
    }

    @Override
    public User get(String login) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            User user = (User) criteria.add(Restrictions.eq("login", login)).uniqueResult();
            session.getTransaction().commit();
            session.close();
            if (user != null) {
                logger.info("Getted by login " + user.toString());
            }
            return user;
        } catch (HibernateException ex) {
            logger.warn(ex.getMessage());
            if (session != null) {
                session.getTransaction().rollback();
            }
            return null;
        }
    }

    @Override
    public User getByEmail(String email) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            User user = (User) criteria.add(Restrictions.eq("email", email)).uniqueResult();
            session.getTransaction().commit();
            session.close();
            if (user != null) {
                logger.info("Getted by Email " + user.toString());
            }
            return user;
        } catch (HibernateException ex) {
            logger.warn(ex.getMessage());
            if (session != null) {
                session.getTransaction().rollback();
            }
            return null;
        }
    }
}
