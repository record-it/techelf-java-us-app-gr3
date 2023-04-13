package pl.us.gr3.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.us.gr3.app.model.Book;
import pl.us.gr3.app.service.BookService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/books")
public class AdminBookController {

    private  final BookService bookService;
    private static final Random random = new Random();
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

    public AdminBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> allBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/bad/{id}")                                // uzupełnij
    public Book oneBook(@PathVariable long id){            // uzupełnij
//        for(var book: books){
//            if (book.getId() == id){
//                return book;
//            }
//        }
//        throw new IllegalArgumentException();
        final Optional<Book> first = books
                .stream()
                .filter(book -> book.getId() == id)
                .findFirst();

//        if (first.isPresent()){
//            return first.get();
//        }
//        throw new IllegalArgumentException();
        return first.orElse(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBook(@PathVariable long id){
        final Optional<Book> first = books
                .stream()
                .filter(book -> book.getId() == id)
                .findFirst();
        return ResponseEntity.of(first);
    }
    @PostMapping("/")
    public ResponseEntity<Book> addBook(@RequestBody Book newBook){
        newBook.setId(3 + random.nextInt(100000));
        books.add(newBook);
        return ResponseEntity
                .created(URI.create("http://localhost:9000/api/v1/books/" + newBook.getId()))
                .body(newBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable long id){
        final Optional<Book> first = books
                .stream()
                .filter(b -> b.getId() == id)
                .findFirst();
        if (first.isPresent()){
            books.remove(first.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable long id, @RequestBody Book book){
        final Optional<Book> first = books.stream()
                .filter(b -> b.getId() == id)
                .findFirst();
        if (book.getTitle().isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        if (first.isPresent()){
            final int index = books.indexOf(first.get());
            books.set(index, book);
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
