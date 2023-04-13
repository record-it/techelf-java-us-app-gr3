package pl.us.gr3.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.us.gr3.app.model.Book;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class AdminBookController {
    public List<Book> books = new ArrayList<>(List.of(
            Book
                    .builder()
                    .id(1)
                    .author("Bloch")
                    .title("Java")
                    .editionYear(2020)
                    .build(),
            Book
                    .builder()
                    .id(2)
                    .author("Freeman")
                    .title("C#")
                    .editionYear(2021)
                    .build()
    ));
    @GetMapping("")
    public List<Book> allBooks() {
        return books;
    }
}
