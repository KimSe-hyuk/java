package com.example.spring.catalogservice.domain;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository {

    Iterable<Book> findAll();
    Optional<Book> findById(String isbn);
    boolean existsById(String isbn);
    Book save(Book book);
    void deleteByIsbn(String isbn);
}
