package com.example.catalogservice.demodata;

import com.example.catalogservice.entity.Book;
import com.example.catalogservice.repositiry.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("testdata")
public class BookDataLoader {

    private final BookRepository repo;

    public BookDataLoader(BookRepository repo) {
        this.repo = repo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        repo.save(new Book("1234567890", "Northern Lights",
                "Lyra Silverstar", 9.90));
        repo.save(new Book("1234567892", "Polar Journey",
                "Iorek Polarson", 12.90));
    }
}
