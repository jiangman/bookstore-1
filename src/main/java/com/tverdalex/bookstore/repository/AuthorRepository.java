package com.tverdalex.bookstore.repository;

import com.tverdalex.bookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AuthorRepository extends JpaRepository<Author, Long>{
    Set<Author> findAllByOrderByName();

    //Set<Author> findAllByBook(Book book);
}
