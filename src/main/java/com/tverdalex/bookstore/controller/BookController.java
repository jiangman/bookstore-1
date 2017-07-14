package com.tverdalex.bookstore.controller;

import com.tverdalex.bookstore.model.Book;
import com.tverdalex.bookstore.model.BookService;
import com.tverdalex.bookstore.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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
    ResponseEntity<?> getById(@PathVariable Long id){
        if(bookService.exists(id)){
            Book book = bookService.getById(id);
            return new ResponseEntity(book, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    ResponseEntity<?> addBook(@Valid @RequestBody Book input, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else {
            Book result = bookService.add(input);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/books/{id}").buildAndExpand(result.getId()).toUri();
            return ResponseEntity.created(location).build();
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delBook(@PathVariable Long id){
        if(bookService.exists(id)){
            bookService.delById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<?> editBook(@PathVariable Long id, @Valid @RequestBody Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else {
            Book result = bookService.editBook(id, book);
            if(result != null){
                URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/books/{id}").buildAndExpand(result.getId()).toUri();
                return ResponseEntity.created(location).build();
            } else {
                return new ResponseEntity(HttpStatus.OK);
            }
        }
    }


}
