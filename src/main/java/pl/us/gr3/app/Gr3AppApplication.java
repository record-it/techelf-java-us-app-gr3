package pl.us.gr3.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.us.gr3.app.model.Book;
import pl.us.gr3.app.repository.BookRepository;

import java.util.List;

@SpringBootApplication
public class Gr3AppApplication implements CommandLineRunner {
    private final BookRepository bookRepository;

    public Gr3AppApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Gr3AppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Spring started ...");
        System.out.println("Inserting books ..");
        bookRepository.saveAll(
                List.of(
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
                )
        );
    }
}
