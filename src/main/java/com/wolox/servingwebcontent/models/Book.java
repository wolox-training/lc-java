package com.wolox.servingwebcontent.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String genre;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String subtitle;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer pages;

    @Column(nullable = false)
    private String isbn;

    public Book(String newGenre, String newAuthor, String newImage, String newTitle,
        String newSubtitle, String newPublisher, Integer newYear, Integer newPages,
        String newIsbn) {
        this.id = id;
        this.genre = newGenre;
        this.author = newAuthor;
        this.image = newImage;
        this.title = newTitle;
        this.subtitle = newSubtitle;
        this.publisher = newPublisher;
        this.year = newYear;
        this.pages = newPages;
        this.isbn = newIsbn;
    }

    // Setter
    public void setGenre(String newGenre) {
        this.genre = newGenre;
    }

    public String getGenre() {
        return genre;
    }

    // Setter
    public void setAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    public String getAuthor() {
        return author;
    }

    // Setter
    public void setImage(String newImage) {
        this.image = newImage;
    }

    public String getImage() {
        return image;
    }

    // Setter
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public String getTitle() {
        return title;
    }

    // Setter
    public void setSubtitle(String newSubtitle) {
        this.subtitle = newSubtitle;
    }

    public String getSubtitle() {
        return subtitle;
    }

    // Setter
    public void setPublisher(String newPublisher) {
        this.publisher = newPublisher;
    }

    public String getPublisher() {
        return publisher;
    }

    // Setter
    public void setYear(Integer newYear) {
        this.year = newYear;
    }

    public Integer getYear() {
        return year;
    }

    // Setter
    public void setPages(Integer newPages) {
        this.pages = newPages;
    }

    public Integer getPages() {
        return pages;
    }

    // Setter
    public void setIsbn(String newIsbn) {
        this.isbn = newIsbn;
    }

    public String getIsbn() {
        return isbn;
    }
}
