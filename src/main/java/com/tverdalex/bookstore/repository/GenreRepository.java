package com.tverdalex.bookstore.repository;

import com.tverdalex.bookstore.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long>{
}
