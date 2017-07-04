package com.tverdalex.bookstore.controller;

import com.tverdalex.bookstore.model.Genre;
import com.tverdalex.bookstore.model.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/genres")
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    Collection<Genre> getAll(){
        return genreService.getAll();
    }

    @PostMapping
    ResponseEntity<?> addGenre(@RequestBody Genre genre){
        Genre result = genreService.add(new Genre(genre.getName()));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/genres/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
