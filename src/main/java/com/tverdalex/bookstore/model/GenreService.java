package com.tverdalex.bookstore.model;

import com.tverdalex.bookstore.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Collection<Genre> getAll(){
        return genreRepository.findAllByOrderByName();
    }

    public Genre getById(Long id){
        return genreRepository.findOne(id);
    }

    public Genre add(Genre genre){
        return genreRepository.save(genre);
    }
}
