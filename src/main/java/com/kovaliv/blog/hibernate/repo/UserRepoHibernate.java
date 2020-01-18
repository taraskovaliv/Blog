package com.kovaliv.blog.hibernate.repo;

import com.kovaliv.blog.hibernate.models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepoHibernate implements UserRepo {

    Logger logger = LogManager.getLogger(UserRepoHibernate.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        Session session = null;
        logger.info(user.toString());
        try {
            if (sessionFactory == null) {
                logger.warn("factory null");
            }
            session = sessionFactory.openSession();
            if (session == null) {
                logger.warn("session null");
            } else {
                logger.info("session open");
            }
            session.beginTransaction();
            if (session.getTransaction() == null) {
                logger.warn("trans null");
            } else {
                logger.info("start trans");
            }
            session.persist(user);

            session.getTransaction().commit();
            session.close();
        } catch (HibernateException ex) {
            logger.warn(ex.getMessage());
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw ex;
        } catch (Exception ex) {
            logger.warn(ex.getMessage() + " except");
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
            User user = session.load(User.class, id);
            session.delete(user);
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
    public User get(Integer id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            User user = session.load(User.class, id);
            session.getTransaction().commit();
            session.close();
            return user;
        } catch (HibernateException ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw ex;
        }
    }

    @Override
    public void edit(User user) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            User user1 = session.load(User.class, user.getId());
            session.delete(user1);
            session.save(user);
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
    public User get(String login) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            User user = (User) criteria.add(Restrictions.eq("login", login)).uniqueResult();
            session.getTransaction().commit();
            session.close();
            return user;
        } catch (HibernateException ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw ex;
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
            return user;
        } catch (HibernateException ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw ex;
        }
    }
}
