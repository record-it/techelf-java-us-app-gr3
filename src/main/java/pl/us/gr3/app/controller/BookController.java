package pl.us.gr3.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.us.gr3.app.model.Comment;
import pl.us.gr3.app.service.BookService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/public/books")
public class BookController {
    // wstrzyknij BookService
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // zdefiniuj metodę pobierania komentarzy dla książki o podanym id
    // np. /api/v1/public/books/1/comments
    @GetMapping("/{id}/comments")
    public List<Comment> findCommentForBook(@PathVariable long id){
        return bookService.findAllCommentsForBook(id);
    }

    // zdefiniuj metodę dodawania komentarza do serwisu
    @PostMapping("/{id}/comments")
    public ResponseEntity<Comment> addComment(@PathVariable long id, @RequestBody Comment comment){
        final Optional<Comment> optionalComment = bookService.addComment(comment);
        if (optionalComment.isPresent()){
            return ResponseEntity.created(URI.create("")).body(optionalComment.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
