package com.tverdalex.bookstore.controller;

import com.tverdalex.bookstore.model.Genre;
import com.tverdalex.bookstore.model.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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

    @GetMapping("/{id}")
    Genre getById(@PathVariable Long id){
        return genreService.getById(id);
    }

    @PostMapping
    ResponseEntity<?> addGenre(@Valid @RequestBody Genre genre){
        Genre result = genreService.add(genre);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/genres/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
