package com.tverdalex.bookstore.model;

import com.tverdalex.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public Collection<Author> getAll(){
        return authorRepository.findAllByOrderByName();
    }

    public Author add(Author author){
        return authorRepository.save(author);
    }
}
