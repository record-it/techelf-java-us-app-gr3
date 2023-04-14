package pl.us.gr3.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.us.gr3.app.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
