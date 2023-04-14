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
        return commentRepository.findCommentsByBookId(bookId);
    }

    @Override
    public Optional<Comment> addComment(Comment newComment) {
        try {
            return Optional.of(commentRepository.save(newComment));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteComment(long commentId) {
        try {
            commentRepository.deleteById(commentId);
            return true;
        } catch (Exception e){
            return false;
        }
    }
    @Override
    public Optional<Comment> updateComment(Comment comment) {
        try {
            return Optional.of(commentRepository.save(comment));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
