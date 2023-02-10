package com.example.catalogservice.repositiry;

import com.example.catalogservice.entity.Book;

import java.util.Optional;

public interface BookRepository {
    Iterable<Book> findAll();
    Optional<Book> findByIsbn(String isbn);
    boolean existByIsbn(String isbn);
    Book save(Book book);
    void deleteByIsbn(String isbn);
}
