package com.kovaliv.blog.hibernate.models;

import javax.persistence.*;

@Entity
@Table(name = "Article", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class Article implements DataModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TEXT")
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
