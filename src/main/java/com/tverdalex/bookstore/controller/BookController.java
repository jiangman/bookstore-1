package com.tverdalex.bookstore.controller;

import com.tverdalex.bookstore.model.Book;
import com.tverdalex.bookstore.model.BookService;
import com.tverdalex.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/books")
public class BookController{
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    Collection<Book> getAllBooks(){
        return bookService.getAll();
    }

    @PostMapping
    ResponseEntity<?> addBook(@RequestBody Book input){
        System.out.println(input);
        Book result = bookService.add(input);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/books/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
