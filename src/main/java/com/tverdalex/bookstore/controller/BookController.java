package com.tverdalex.bookstore.controller;

import com.tverdalex.bookstore.model.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/books")
public class BookController{
    @RequestMapping(method = RequestMethod.GET)
    Collection<Book> getBooks(){
        Collection<Book> list = new ArrayList<>();
        list.add(new Book("book1", "desc", 1.23));
        return list;
    }
}
