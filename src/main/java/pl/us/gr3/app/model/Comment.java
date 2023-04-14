package pl.us.gr3.app.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * Zdefiniuj klasę opisująca komentarz na temat książki
 * pola:
 * bookId   long
 * userId   long
 * content  String
 * created  LocalDateTime
 * Dodaj adnotacje Lombok jak w Book
 */
@Getter@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bookId")
    private Book book;

    @Column(name = "bookId", updatable = false, insertable = false)
    private long bookId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "authorId")
    private User author;

    @Column(name = "authorId", updatable = false, insertable = false)
    private long authorId;

    private String content;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime created;

    private int rate;
}
