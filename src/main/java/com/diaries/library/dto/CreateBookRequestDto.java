package com.diaries.library.dto;


import jakarta.validation.constraints.NotBlank;

public class CreateBookRequestDto {
    @NotBlank
    String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    @NotBlank private String author;
    @NotBlank private String isbn;
}
