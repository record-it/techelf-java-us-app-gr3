package pl.us.gr3.app.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pl.us.gr3.app.dto.RequestCommentDto;
import pl.us.gr3.app.mapper.CommentMapper;
import pl.us.gr3.app.model.Comment;
import pl.us.gr3.app.service.BookService;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public List<Comment> findCommentForBook(@PathVariable long id) {
        return bookService.findAllCommentsForBook(id);
    }

    // zdefiniuj metodę dodawania komentarza do serwisu
    @PostMapping("/{bookId}/comments")
    public ResponseEntity<Comment> addComment(@PathVariable long bookId, @Valid @RequestBody RequestCommentDto dto) {
        var comment = CommentMapper.toComment(dto, bookId, 1);
        final Optional<Comment> optionalComment = bookService.addComment(comment);
        if (optionalComment.isPresent()) {
            return ResponseEntity.created(URI.create("")).body(optionalComment.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{bookId}/comments/{commentId}")
    public ResponseEntity<Comment> patchComment(
            @PathVariable long bookId,
            @PathVariable long commentId,
            @RequestBody JsonPatch patch
    ) {
        final Optional<Comment> first = bookService.findAllCommentsForBook(bookId)
                .stream()
                .filter(c -> c.getId() == commentId)
                .findFirst();
        if (first.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var comment = first.get();
        var mapper = new ObjectMapper();
        var json = mapper.convertValue(comment, JsonNode.class);
        try {
            final JsonNode updatedJson = patch.apply(json);
            final Comment updatedComment = mapper.convertValue(updatedJson, Comment.class);
            return ResponseEntity.of(bookService.updateComment(updatedComment));
        } catch (JsonPatchException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
