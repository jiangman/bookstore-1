package com.tverdalex.bookstore.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private Double price;
    @ManyToMany
    private List<Author> author;
    @OneToMany
    private List<Genre> genre;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public Double getPrice() {
        return price;
    }

}
