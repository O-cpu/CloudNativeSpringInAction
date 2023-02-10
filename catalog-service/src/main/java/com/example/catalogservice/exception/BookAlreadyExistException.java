package com.example.catalogservice.exception;

public class BookAlreadyExistException extends RuntimeException{
    public BookAlreadyExistException(String isbn) {
        super( "A Book with ISBN:" + isbn + " already exist." );
    }
}
