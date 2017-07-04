package com.tverdalex.bookstore.repository;

import com.tverdalex.bookstore.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface GenreRepository extends JpaRepository<Genre, Long>{
    Collection<Genre> findAllByOrderByName();
}
