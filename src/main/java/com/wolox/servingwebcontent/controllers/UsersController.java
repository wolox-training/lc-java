package com.wolox.servingwebcontent.controllers;

import com.wolox.servingwebcontent.exceptions.BookNotFoundException;
import com.wolox.servingwebcontent.exceptions.UsersIdMismatchException;
import com.wolox.servingwebcontent.exceptions.UsersNotFoundException;
import com.wolox.servingwebcontent.models.Book;
import com.wolox.servingwebcontent.models.Users;
import com.wolox.servingwebcontent.packages.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersRepository userRepository;

    @GetMapping("/{id}")
    public Users findOne(@PathVariable Long id) {
        return userRepository.findById(id)
            .orElseThrow(UsersNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Users create(@RequestBody Users user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.findById(id)
            .orElseThrow(BookNotFoundException::new);
        userRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Users updateBook(@RequestBody Users user, @PathVariable Long id) {
        if (user.getId() != id) {
            throw new UsersIdMismatchException();
        }
        userRepository.findById(id)
            .orElseThrow(BookNotFoundException::new);
        return userRepository.save(user);
    }

    @PutMapping("/{id}/addBookToCollection")
    public Users addBookToCollection(@RequestBody Users user, Book book, @PathVariable Long id) {
        if (user.getId() != id) {
            throw new UsersIdMismatchException();
        }
        userRepository.findById(id)
            .orElseThrow(BookNotFoundException::new);
        user.addBookToCollection(book);
        return userRepository.save(user);
    }

    @PutMapping("/{id}/removeBookFromCollection")
    public Users removeBookFromCollection(@RequestBody Users user, Book book, @PathVariable Long id) {
        if (user.getId() != id) {
            throw new UsersIdMismatchException();
        }
        userRepository.findById(id)
            .orElseThrow(BookNotFoundException::new);
        user.deleteBookFromCollection(book);
        return userRepository.save(user);
    }
}
