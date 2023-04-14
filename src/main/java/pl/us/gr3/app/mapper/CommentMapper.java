package pl.us.gr3.app.mapper;

import pl.us.gr3.app.dto.RequestCommentDto;
import pl.us.gr3.app.model.Comment;

public class CommentMapper {
    public static Comment toComment(RequestCommentDto dto, long bookId, long userId){
        return Comment
                .builder()
                .bookId(bookId)
                .content(dto.getContent())
                .authorId(userId)
                .rate(dto.getRate())
                .build();
    }
}
