package com.wolox.servingwebcontent.models;

import com.google.common.base.Preconditions;
import com.wolox.servingwebcontent.exceptions.BookAlreadyOwnedException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.apache.tomcat.jni.Local;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private LocalDate birthdate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_user",
        joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<Book> books;

    public Users() {
    }

    // Setter
    public void setName(String newName) {
        this.name = Preconditions.checkNotNull(newName);
    }

    public String getName() {
        return name;
    }

    // Setter
    public void setUsername(String newUsername) {
        this.username = Preconditions.checkNotNull(newUsername);
    }

    public String getUsername() {
        return username;
    }

    // Setter
    public void setBirthdate(LocalDate newBirthdate) {
        this.birthdate = Preconditions.checkNotNull(newBirthdate);
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    // Setter
    public void setBooks(List<Book> newBooks) {
        this.books = newBooks;
    }

    public List<Book> getBooks() {
        return (List<Book>) Collections.unmodifiableList(books);
    }
    public void addBookToCollection(Book newBook) {
        if(!this.books.contains(newBook)){
            this.books.add(newBook);
        } else {
            new BookAlreadyOwnedException();
        }
    }
    public void deleteBookFromCollection(Book bookToDelete) {
        if (this.books.contains(bookToDelete)){
            this.books.remove(bookToDelete);
        }
    }

    public Users(long id, String name, String username, LocalDate birthdate,
        List<Book> books) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.birthdate = birthdate;
        this.books = books;
    }

    public Long getId() {
        return this.id;
    }
}