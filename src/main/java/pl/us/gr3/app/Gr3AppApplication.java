package pl.us.gr3.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Gr3AppApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Gr3AppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Spring started ...");
    }
}
