package com.kovaliv.blog.hibernate.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "User", uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class User implements DataModel, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private int id;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy = "author")
//    private Set<Article> articles = new HashSet<Article>();


    public int getId() {
        return id;
    }

    public void setId(int іd) {
        this.id = іd;
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

    @Override
    public String toString() {
        return "User { " + surname + ' ' + name + " }";
    }
}
