package com.kovaliv.blog.hibernate.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User", uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class User implements DataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID", nullable = false, unique = true)
    private int userId;

    @Column(name = "LOGIN", nullable = false, unique = true)
    private String login;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "author")
    private Set<Article> articles = new HashSet<Article>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "User { " + surname + ' ' + name + " }";
    }
}
