package com.diaries.library.entity;

import jakarta.persistence.*;
@Entity
@Table(name="Book")

public class BookEntity {
    //3.Every class annoted with @Entity gonna have id filed @Id
    @Id
    @GeneratedValue
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column
    private String author;
    @Column
    private String isbn;
}
