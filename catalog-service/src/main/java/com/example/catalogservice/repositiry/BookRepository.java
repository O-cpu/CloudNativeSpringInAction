package com.example.catalogservice.repositiry;

import com.example.catalogservice.entity.Book;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {
    @NonNull Iterable<Book> findAll();

    Optional<Book> findByIsbn(String isbn);

    boolean existsByIsbn(@NonNull String isbn);

    @Modifying
    @Transactional
    @NonNull Book save(@NonNull Book book);

    @Modifying
    @Transactional
    @Query("delete FROM Book where isbn = :isbn")
    void deleteByIsbn(String isbn);
}
