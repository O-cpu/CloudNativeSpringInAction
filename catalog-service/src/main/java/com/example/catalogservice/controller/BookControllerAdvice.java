package com.example.catalogservice.controller;

import com.example.catalogservice.exception.BookAlreadyExistException;
import com.example.catalogservice.exception.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BookControllerAdvice {
    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> bookNotFoundHandler(BookNotFoundException e) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("message", e.getMessage());
        return hashMap;
    }

    @ExceptionHandler(BookAlreadyExistException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public Map<String, String> bookAlreadyExistHandler(BookAlreadyExistException e) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("message", e.getMessage());
        return hashMap;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException e) {
        HashMap<String, String> hashMap = new HashMap<>();
        StringBuilder errorMessage = new StringBuilder();
        e.getBindingResult().getAllErrors().forEach(
                error -> errorMessage.append(((FieldError) error).getField()).append(": ").append(error.getDefaultMessage()).append("; ")
        );
        hashMap.put("message", errorMessage.toString());
        return hashMap;
/*
            var errors = new HashMap<String, String>();
            e.getBindingResult().getAllErrors().forEach(
                    error -> errors.put(((FieldError)error).getField(), error.getDefaultMessage())
            );
*/
    }
}
