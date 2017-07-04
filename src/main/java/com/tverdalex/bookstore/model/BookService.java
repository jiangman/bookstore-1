package com.tverdalex.bookstore.model;

import com.tverdalex.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Collection<Book> getAll(){
        return bookRepository.findAll();
    }

    public Book add(Book book){
        System.out.println(book);
        return bookRepository.save(book);
    }
}
