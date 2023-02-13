package com.example.catalogservice.controller;

import com.example.catalogservice.entity.Book;
import com.example.catalogservice.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Iterable<Book> get() {
        return bookService.viewBookList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book post(@RequestBody @Valid Book book) {
        return bookService.addBookToCatalog(book);
    }

    @GetMapping("{isbn}")
    @ResponseStatus(HttpStatus.OK)
    public Book get(@PathVariable String isbn) {
        return bookService.viewBookDetail(isbn);
    }

    @PutMapping("{isbn}")
    @ResponseStatus(HttpStatus.OK)
    public Book put(@PathVariable String isbn, @RequestBody @Valid Book book) {
        return bookService.editBookDetails(isbn, book);
    }

    @DeleteMapping("{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String isbn) {
        bookService.removeBookFromCatalog(isbn);
    }

}
