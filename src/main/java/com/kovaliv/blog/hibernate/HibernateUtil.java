package com.kovaliv.blog.hibernate;

import com.kovaliv.blog.hibernate.models.Article;
import com.kovaliv.blog.hibernate.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Article.class);

            Properties properties = new Properties();
            properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
//            properties.put("hibernate.connection.url", "jdbc:mysql://db4free.net:3306/blogtaras");
//            properties.put("hibernate.connection.username", "taraskovaliv");
//            properties.put("hibernate.connection.password", "1111taras");

            properties.put("hibernate.connection.url", "jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2318381");
            properties.put("hibernate.connection.username", "sql2318381");
            properties.put("hibernate.connection.password", "gD1!iU4*");
            properties.put("hibernate.current_session_context_class", "thread");

            configuration.setProperties(properties);

            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory sessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }
}
