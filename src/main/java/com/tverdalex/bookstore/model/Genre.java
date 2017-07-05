package com.tverdalex.bookstore.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Genre {

    private Long id;
    private String name;

    @ManyToMany
    private List<Book> book;

    public Genre() {
    }

    public Genre(String name) {
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
