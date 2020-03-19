package com.wolox.servingwebcontent.packages;

import com.wolox.servingwebcontent.models.Book;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findFirstByAuthor(String author);

    Optional<Book> findByTitle(String title);

    Optional<Book> findById(String id);

}