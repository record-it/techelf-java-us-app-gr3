package pl.us.gr3.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private long id;

    private long bookId;

    private long userId;

    private String content;

    private LocalDateTime created;

    private int rate;
}
