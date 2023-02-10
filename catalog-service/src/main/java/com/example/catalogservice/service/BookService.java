package com.example.catalogservice.service;

import com.example.catalogservice.entity.Book;
import com.example.catalogservice.exception.BookAlreadyExistException;
import com.example.catalogservice.exception.BookNotFoundException;
import com.example.catalogservice.repositiry.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> viewBookList()
    {
        return bookRepository.findAll();
    }

    public Book viewBookDetail(String isbn)
    {
        return bookRepository.findByIsbn(isbn).orElseThrow(() -> new BookNotFoundException(isbn));
    }

    public Book addBookToCatalog(Book book)
    {
        if (bookRepository.existByIsbn(book.isbn()))
        {
            throw new BookAlreadyExistException(book.isbn());
        }
        return bookRepository.save(book);
    }

    public void removeBookFromCatalog(String isbn)
    {
        if (!bookRepository.existByIsbn(isbn))
        {
            throw new BookNotFoundException(isbn);
        }
        bookRepository.deleteByIsbn(isbn);
    }

    public Book editBookDetails(String isbn, Book book)
    {
        removeBookFromCatalog(isbn);
        return addBookToCatalog(book);
    }
}
