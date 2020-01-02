package com.kovaliv.blog.hibernate.models;

import javax.persistence.*;

@Entity
@Table(name = "User", uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
