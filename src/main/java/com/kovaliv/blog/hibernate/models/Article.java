package com.kovaliv.blog.hibernate.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Article", uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "text")
    private String text;

    @Column(name = "reads")
    private int reads;

    @Column(name = "author")
    private int author;

    @Column(name = "date")
    private Date date;

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

    public int getReads() {
        return reads;
    }

    public void setReads(int reads) {
        this.reads = reads;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", reads=" + reads +
                ", author=" + author +
                '}';
    }
}
