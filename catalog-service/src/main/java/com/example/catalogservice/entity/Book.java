package com.example.catalogservice.entity;

public record Book (
    String isbn,
    String title,
    String author,
    Double price
){}
