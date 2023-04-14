package pl.us.gr3.app.service;

import org.springframework.stereotype.Service;
import pl.us.gr3.app.model.Book;
import pl.us.gr3.app.model.Comment;

import java.util.*;

@Service("BookServiceInMemory")
public class BookServiceInMemory implements BookService{
    private Map<Long, Book> books = new HashMap<>(Map.of(
            1L, Book
                    .builder()
                    .id(1)
                    .author("Bloch")
                    .title("Java")
                    .editionYear(2020)
                    .build(),
            2L, Book
                    .builder()
                    .id(2)
                    .author("Freeman")
                    .title("C#")
                    .editionYear(2021)
                    .build(),
            3L, Book
                    .builder()
                    .id(3)
                    .author("Spring")
                    .title("Pivotal")
                    .editionYear(2023)
                    .build()
            ));
    // zadeklaruj mapę na komentarze
    private Map<Long, Comment> comments = new HashMap<>();
    private long commentIndex = 0;
    @Override
    public List<Book> findAllBooks() {
        return books.values().stream().toList();
    }

    @Override
    public List<Comment> findAllCommentsForBook(long bookId) {
        // uzupełnij predykat w filter
        return comments.values().stream().filter(c -> true).toList();
    }

    @Override
    public Optional<Comment> addComment(Comment newComment) {
        if (newComment != null) {
            newComment.setId(++commentIndex);
            comments.putIfAbsent(newComment.getId(), newComment);
            return Optional.of(newComment);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteComment(long commentId) {
        return false;
    }

    @Override
    public Optional<Comment> updateComment(Comment comment) {
        comments.put(comment.getId(), comment);
        return Optional.of(comment);
    }
}
