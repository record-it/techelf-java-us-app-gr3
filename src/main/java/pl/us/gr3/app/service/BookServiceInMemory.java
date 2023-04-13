package pl.us.gr3.app.service;

import pl.us.gr3.app.model.Book;
import pl.us.gr3.app.model.Comment;

import java.util.*;

public class BookServiceInMemory implements BookService{
    public Map<Long, Book> books = new HashMap<>(Map.of(
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
                    .build()
    ));
    // zadeklaruj mapę na komentarze

    @Override
    public List<Book> findAllBooks() {
        return null;
    }

    @Override
    public List<Comment> findAllCommentsForBook(long bookId) {
        return null;
    }

    @Override
    public Optional<Comment> addComment(Comment newComment) {
        return Optional.empty();
    }

    @Override
    public boolean deleteComment(long commentId) {
        return false;
    }

    @Override
    public Optional<Comment> updateComment(long commentId) {
        return Optional.empty();
    }
}
