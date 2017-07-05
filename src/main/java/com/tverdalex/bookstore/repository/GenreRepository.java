package com.tverdalex.bookstore.repository;

import com.tverdalex.bookstore.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface GenreRepository extends JpaRepository<Genre, Long>{
    Set<Genre> findAllByOrderByName();
}
