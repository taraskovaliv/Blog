package com.kovaliv.blog.hibernate.models;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Article", uniqueConstraints = {@UniqueConstraint(columnNames = "Article_ID")})
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Article_ID", nullable = false, unique = true)
    private int articleId;

    @Column(name = "name")
    private String name;

    @Column(name = "text")
    private String text;

    @Column(name = "reads")
    @ColumnDefault("0")
    private int reads;

    @Column(name = "author")
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

}
