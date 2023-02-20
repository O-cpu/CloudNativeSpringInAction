package com.example.catalogservice;

import com.example.catalogservice.entity.Book;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Disabled("Disabled until bug has been fixed!")
class CatalogServiceApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void whenPostRequestThenBookCreated() {
        var expectedBook = Book.of("1231231231", "Title", "Author", 9.90);

        webTestClient
                .post()                                     //Prepare an HTTP POST request
                .uri("/books")                          //Sends the request to the "/books" endpoint
                .bodyValue(expectedBook)                    //Adds the book in the request body
                .exchange()                                 //Sends the request
                .expectStatus().isCreated()                 //Verifies that the HTTP response has status “201 Created”
                .expectBody(Book.class).value(actualBook -> {
                    assertThat(actualBook).isNotNull();     //Verifies that the HTTP response has a non-null body
                    assertThat(actualBook.isbn())
                            .isEqualTo(expectedBook.isbn());//Verifies that the created object is as expected
                });

    }

    @Test
    void contextLoads() {
    }

}
