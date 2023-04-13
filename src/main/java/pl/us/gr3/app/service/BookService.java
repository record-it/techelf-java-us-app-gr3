package pl.us.gr3.app.service;
import pl.us.gr3.app.model.*;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> findAllBooks();
    public List<Comment> findAllCommentsForBook(long bookId);
    public Optional<Comment> addComment(Comment newComment);
    public boolean deleteComment(long commentId);
    public Optional<Comment> updateComment(long commentId);
}
