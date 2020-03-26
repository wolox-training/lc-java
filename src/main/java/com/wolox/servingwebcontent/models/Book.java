package com.wolox.servingwebcontent.models;

import com.google.common.base.Preconditions;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@ApiModel(description = "Books from the OpenLibraryAPI")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @ApiModelProperty(notes = "the book genre: could be horror, romance, comedy, etc")
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

    @ManyToMany(mappedBy = "books")
    private List<Users> users;

    public Book(String newGenre, String newAuthor, String newImage, String newTitle,
        String newSubtitle, String newPublisher, Integer newYear, Integer newPages,
        String newIsbn, List<Users> users) {
        this.genre = newGenre;
        this.author = newAuthor;
        this.image = newImage;
        this.title = newTitle;
        this.subtitle = newSubtitle;
        this.publisher = newPublisher;
        this.year = newYear;
        this.pages = newPages;
        this.isbn = newIsbn;
        this.users = users;
    }

    public Book() {
    }

    // Setter
    public void setGenre(String newGenre) {
        this.genre = Preconditions.checkNotNull(newGenre);
    }

    public String getGenre() {
        return genre;
    }

    // Setter
    public void setAuthor(String newAuthor) {
        this.author = Preconditions.checkNotNull(newAuthor);
    }

    public String getAuthor() {
        return author;
    }

    // Setter
    public void setImage(String newImage) {
        this.image = Preconditions.checkNotNull(newImage);
    }

    public String getImage() {
        return image;
    }

    // Setter
    public void setTitle(String newTitle) {
        this.title = Preconditions.checkNotNull(newTitle);
    }

    public String getTitle() {
        return title;
    }

    // Setter
    public void setSubtitle(String newSubtitle) {
        this.subtitle = Preconditions.checkNotNull(newSubtitle);
    }

    public String getSubtitle() {
        return subtitle;
    }

    // Setter
    public void setPublisher(String newPublisher) {
        this.publisher = Preconditions.checkNotNull(newPublisher);
    }

    public String getPublisher() {
        return publisher;
    }

    // Setter
    public void setYear(Integer newYear) {
        this.year = Preconditions.checkNotNull(newYear);
    }

    public Integer getYear() {
        return year;
    }

    // Setter
    public void setPages(Integer newPages) {
        this.pages = Preconditions.checkNotNull(newPages);
    }

    public Integer getPages() {
        return pages;
    }

    // Setter
    public void setIsbn(String newIsbn) {
        this.isbn = Preconditions.checkNotNull(newIsbn);
    }

    public String getIsbn() {
        return isbn;
    }

    public long getId() { return id; }


}