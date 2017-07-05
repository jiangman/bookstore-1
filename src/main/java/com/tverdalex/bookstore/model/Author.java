package com.tverdalex.bookstore.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Author {
    private Long id;
    private String name;

    @ManyToMany
    private Set<Book> book;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
