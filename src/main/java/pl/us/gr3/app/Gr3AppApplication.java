package pl.us.gr3.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.us.gr3.app.model.Book;
import pl.us.gr3.app.model.User;
import pl.us.gr3.app.repository.BookRepository;
import pl.us.gr3.app.repository.UserRepository;

import java.util.List;

@SpringBootApplication
public class Gr3AppApplication implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public Gr3AppApplication(BookRepository bookRepository, UserRepository userRepository, PasswordEncoder encoder) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.encoder = encoder;
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
        userRepository.saveAll(List.of(
                User
                        .builder()
                        .id(1)
                        .roles("ROLE_USER;ROLE_ADMIN")
                        .email("karol@us.edu.pl")
                        .password(encoder.encode("12345"))
                        .build(),
                User
                        .builder()
                        .id(2)
                        .roles("ROLE_USER")
                        .email("ewa@us.edu.pl")
                        .password(encoder.encode("abcde"))
                        .build()
        ));
    }
}
