package com.tverdalex.bookstore.repository;

import com.tverdalex.bookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long>{
}
