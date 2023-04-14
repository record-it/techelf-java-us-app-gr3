package pl.us.gr3.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.us.gr3.app.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);
}
