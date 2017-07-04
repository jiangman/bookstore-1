package com.tverdalex.bookstore.controller;

import com.tverdalex.bookstore.model.Author;
import com.tverdalex.bookstore.model.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    Collection<Author> getAll(){
        return authorService.getAll();
    }

    @PostMapping
    ResponseEntity<?> addAuthor(@RequestBody Author author){
        Author result = authorService.add(new Author(author.getName()));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/authors/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
