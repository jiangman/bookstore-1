package com.tverdalex.bookstore.repository;

import com.tverdalex.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{
}
