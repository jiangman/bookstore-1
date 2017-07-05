package com.tverdalex.bookstore;

import com.tverdalex.bookstore.model.Author;
import com.tverdalex.bookstore.model.AuthorService;
import com.tverdalex.bookstore.model.Genre;
import com.tverdalex.bookstore.model.GenreService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	CommandLineRunner init(AuthorService authorService,
						   GenreService genreService) {
		return (evt) ->
        {Arrays.asList("Pushkin,Dostoevskiy,Shekspere,Duma".split(","))
                .forEach(
                    a -> {
                        authorService.add(new Author(a));
                    });
            Arrays.asList("Romantic,Fiction,Sci fi,Fantasy".split(","))
                    .forEach(
                            a -> {
                                genreService.add(new Genre(a));
                            });
        };
	}
}
