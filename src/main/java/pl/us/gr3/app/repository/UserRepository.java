package pl.us.gr3.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.us.gr3.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
