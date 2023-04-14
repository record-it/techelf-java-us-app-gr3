package pl.us.gr3.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.us.gr3.app.model.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentsByBookId(long bookId);

    @Query("select c from Comment c where c.authorId = :authorId")
    List<Comment> findCommentsByUserId(long authorId);
}
