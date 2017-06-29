package com.tverdalex.bookstore.controller;

import com.fasterxml.jackson.databind.node.BooleanNode;
import com.tverdalex.bookstore.model.Book;
import com.tverdalex.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/books")
public class BookController{
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<Book> getBooks(){
        return bookRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> addBook(@RequestBody Book input){
        Book result = bookRepository.save(new Book(input.getTitle(), input.getDescription(), input.getPrice()));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/books/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
