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

    public void delById(Long id){
        bookRepository.delete(id);
    }

    public boolean exists(Long id){
        return bookRepository.exists(id);
    }

    public Book editBook(Long id, Book book){
        if(exists(id)){
            Book existedBook = bookRepository.getOne(id);
            existedBook.setTitle(book.getTitle());
            existedBook.setDescription(book.getDescription());
            existedBook.setGenre(book.getGenre());
            existedBook.setAuthor(book.getAuthor());
            existedBook.setPrice(book.getPrice());
            bookRepository.save(existedBook);
            return null;
        } else {
            return bookRepository.save(book);
        }
    }
}
