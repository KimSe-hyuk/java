package com.example.spring.catalogservice.domain;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String isbn) {
        super("The bookt with ISBN " +isbn+ "was not found.");
    }
}
