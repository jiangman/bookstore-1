package com.tverdalex.bookstore.model;

import com.tverdalex.bookstore.repository.AuthorRepository;
import com.tverdalex.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Collection<Book> getAll(){
        return bookRepository.findAll();
    }

    public Book getById(Long id){
        return bookRepository.findOne(id);
    }

    public Book add(Book book){
        return bookRepository.save(book);
    }
}
