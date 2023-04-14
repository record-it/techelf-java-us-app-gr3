package pl.us.gr3.app.service;

import org.springframework.stereotype.Service;
import pl.us.gr3.app.model.Book;
import pl.us.gr3.app.model.Comment;
import pl.us.gr3.app.repository.BookRepository;
import pl.us.gr3.app.repository.CommentRepository;

import java.util.List;
import java.util.Optional;

@Service("BookServiceJpa")
public class BookServiceJpa implements BookService{
    private final BookRepository bookRepository;
    private final CommentRepository commentRepository;

    public BookServiceJpa(BookRepository bookRepository, CommentRepository commentRepository) {
        this.bookRepository = bookRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Comment> findAllCommentsForBook(long bookId) {
        return commentRepository.f;
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
    public Optional<Comment> updateComment(Comment comment) {
        return Optional.empty();
    }
}
