package pl.us.gr3.app.mapper;

import pl.us.gr3.app.dto.RequestCommentDto;
import pl.us.gr3.app.model.Book;
import pl.us.gr3.app.model.Comment;
import pl.us.gr3.app.model.User;

public class CommentMapper {
    public static Comment toComment(RequestCommentDto dto, long bookId, long userId){
        return Comment
                .builder()
                .book(Book.builder().id(bookId).build())
                .content(dto.getContent())
                .author(User.builder().id(userId).build())
                .rate(dto.getRate())
                .build();
    }
}
