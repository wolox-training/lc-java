package com.wolox.servingwebcontent;

import com.wolox.servingwebcontent.exceptions.BookIdMismatchException;
import com.wolox.servingwebcontent.exceptions.BookNotFoundException;
import com.wolox.servingwebcontent.exceptions.UserIdMismatchException;
import com.wolox.servingwebcontent.exceptions.UserNotFoundException;
import com.wolox.servingwebcontent.models.Book;
import com.wolox.servingwebcontent.models.User;
import com.wolox.servingwebcontent.packages.UserRepository;
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
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findOne(@PathVariable Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.findById(id)
            .orElseThrow(() -> new BookNotFoundException("User not found"));
        userRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public User updateBook(@RequestBody User user, @PathVariable Long id) {
        if (user.getId() != id) {
            throw new UserIdMismatchException("Invalid id for this operation");
        }
        userRepository.findById(id)
            .orElseThrow(() -> new BookNotFoundException("User not found"));
        return userRepository.save(user);
    }

    @PutMapping("/{id}/addBookToCollection")
    public User addBookToCollection(@RequestBody User user, Book book, @PathVariable Long id) {
        if (user.getId() != id) {
            throw new UserIdMismatchException("Invalid id for this operation");
        }
        userRepository.findById(id)
            .orElseThrow( ()-> new BookNotFoundException("User not found"));
        user.addBookToCollection(book);
        return userRepository.save(user);
    }

    @PutMapping("/{id}/removeBookFromCollection")
    public User removeBookFromCollection(@RequestBody User user, Book book, @PathVariable Long id) {
        if (user.getId() != id) {
            throw new UserIdMismatchException("Invalid id for this operation");
        }
        userRepository.findById(id)
            .orElseThrow( ()-> new BookNotFoundException("User not found"));
        user.deleteBookFromCollection(book);
        return userRepository.save(user);
    }
}
