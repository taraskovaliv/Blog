package com.kovaliv.blog.hibernate.repo;

import com.kovaliv.blog.enams.LoginStatus;
import com.kovaliv.blog.enams.UserValid;
import com.kovaliv.blog.hibernate.models.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
            if (session != null) {
                session.getTransaction().rollback();
            }
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
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw ex;
        }
    }

    public static void edit(User user) {
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

    public static User get(String login) {
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

    public static UserValid isValid(User user) {
        if (user.getName() == null) {
            return UserValid.NAMENULL;
        }
        if (user.getEmail() == null) {
            return UserValid.EMAILNULL;
        }
        if (user.getSurname() == null) {
            return UserValid.SURNAMENULL;
        }
        if (user.getPassword() == null) {
            return UserValid.PASSWORDNULL;
        }
        if (user.getLogin() == null) {
            return UserValid.LOGINNULL;
        } else {
            User user1 = get(user.getLogin());
            if (user1 != null) {
                return UserValid.LOGINNOTUNIQUE;
            }
        }
        return UserValid.VALID;
    }

    public static LoginStatus login(User user) {
        User user1 = get(user.getLogin());
        if (user1 == null) {
            return LoginStatus.USERNAMEIRRCORECT;
        }
        if (user1.getPassword().equals(user.getPassword())) {
            return LoginStatus.LOGIN;
        }
        return LoginStatus.PASSWORDIRRCORECT;
    }

}
