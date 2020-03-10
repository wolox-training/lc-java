package com.wolox.servingwebcontent.packages;

import com.wolox.servingwebcontent.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE LOWER(b.author) = LOWER(:author)")
    Book findFirstByAuthor(String author);

    @Query("SELECT b FROM Book b WHERE LOWER(b.title) = LOWER(:title)")
    Book findByTitle(String title);

}