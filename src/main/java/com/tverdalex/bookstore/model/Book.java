package com.tverdalex.bookstore.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private Double price;
    @OneToMany
    private Collection<Genre> genres;
    @ManyToMany
    private Collection<Author> authors;

    public Book() {
    }

    public Book(String title, String description, Double price) {
        this.title = title;
        this.description = description;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }
}
