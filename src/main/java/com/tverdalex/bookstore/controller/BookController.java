package com.tverdalex.bookstore.controller;

import com.tverdalex.bookstore.model.Book;
import com.tverdalex.bookstore.model.BookService;
import com.tverdalex.bookstore.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    Collection<Book> getAllBooks(){
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    Book getById(@PathVariable Long id){
        Book book = bookService.getById(id);
        logger.info(book.toString());
        return book;
    }

    @PostMapping
    ResponseEntity<?> addBook(@RequestBody Book input){
        //logger.info(String.valueOf(input.getAuthors()));
        Book result = bookService.add(input);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/books/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
