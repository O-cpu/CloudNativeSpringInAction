package com.example.catalogservice;

import com.example.catalogservice.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest //Identifies a test class that focuses on JSON serialization
class BookJsonTests {

    @Autowired
    private JacksonTester<Book> json; // Utility class to assert JSON serialization and deserialization

    @Test
    void testSerialize() throws Exception {
        var book = Book.of("1234567890", "Title", "Author", 9.90, "AWS press");
        var jsonContent = json.write(book);

        //Verifying the parsing from Java to JSON, using the JsonPath format to navigate the JSON object
        assertThat(jsonContent).extractingJsonPathStringValue("@.isbn")
                .isEqualTo(book.isbn());
        assertThat(jsonContent).extractingJsonPathStringValue("@.title")
                .isEqualTo(book.title());
        assertThat(jsonContent).extractingJsonPathStringValue("@.author")
                .isEqualTo(book.author());
        assertThat(jsonContent).extractingJsonPathNumberValue("@.price")
                .isEqualTo(book.price());
        assertThat(jsonContent).extractingJsonPathStringValue("@.publisher")
                .isEqualTo(book.publisher());
    }

    @Test
    void testDeserialize() throws Exception {
        // Defines a JSON object using the Java text block feature
        var content = """
                {
                    "isbn": "1234567890",
                    "title": "Title",
                    "author": "Author",
                    "price": 9.90,
                    "publisher": "AWS press"
                }
                """;

        // Utility class to assert JSON serialization and deserialization
        assertThat(json.parse(content))
                .usingRecursiveComparison()
                .isEqualTo( Book.of("1234567890", "Title", "Author", 9.90, "AWS press"));
    }

}