package pl.us.gr3.app.model;

import jakarta.persistence.*;
import lombok.*;

// Zdefiniuj klasę User z polami:
// email
// password
// id typu long
// Dodaj adnotacje JPA i Lombok, aby poprawnie zdefiniować encję
// Nadaj tabeli nazwę "users"
// Zdefiniuj repozytorium dla User
// Wstrzyknij repozytorium użytkowników do klasy Gr3AppApplication
// Dodaj dwóch użytkowników w klasie Gr3AppApplication
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    private String password;

    private String email;
}
