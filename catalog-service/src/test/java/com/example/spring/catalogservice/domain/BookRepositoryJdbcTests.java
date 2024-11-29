package com.example.spring.catalogservice.domain;

import com.example.spring.catalogservice.config.DataConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.AutoConfigureDataJdbc;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
@Import(DataConfig.class) // Make sure DataConfig is correctly imported
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Don't replace database settings
@ActiveProfiles("integration") // Use the integration profile for testing
public class BookRepositoryJdbcTests {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private JdbcAggregateTemplate jdbcAggregateTemplate;

    @Test
    void findBookByIsbnWhenExisting() {
        // Arrange: Create a book object and insert it into the database
        String bookIsbn = "1234561237";
        Book book = Book.builder()
                .isbn(bookIsbn)
                .title("Title")
                .author("Author")
                .price(12.90)
                .build();

        // Insert book into the database using JdbcAggregateTemplate
        jdbcAggregateTemplate.insert(book);

        // Act: Retrieve the book from the repository
        Optional<Book> actualBook = bookRepository.findById(Long.valueOf(bookIsbn));

        // Assert: Check that the book is present and the ISBN matches
        assertThat(actualBook).isPresent();
        assertThat(actualBook.get().isbn()).isEqualTo(book.isbn());
    }
}
