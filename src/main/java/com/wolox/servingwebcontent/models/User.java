package com.wolox.servingwebcontent.models;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.tomcat.jni.Local;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Column(nullable = false)
    private List<Book> books;

    public User() {
    }

    // Setter
    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return name;
    }

    // Setter
    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public String getUsername() {
        return username;
    }

    // Setter
    public void setBirthdate(LocalDate newBirthdate) {
        this.birthdate = newBirthdate;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    // Setter
    public void setBooks(List<Book> newBooks) {
        this.books = newBooks;
    }

    public List<Book> getBooks() {
        return books;
    }

    public User(long id, String name, String username, LocalDate birthdate,
        List<Book> books) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.birthdate = birthdate;
        this.books = books;
    }
}