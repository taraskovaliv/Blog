package com.kovaliv.blog.hibernate.models;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "Article", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class Article implements DataModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ArticleID", nullable = false, unique = true)
    private int articleId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "READS")
    @ColumnDefault("0")
    private int reads;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private int author;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
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
}
