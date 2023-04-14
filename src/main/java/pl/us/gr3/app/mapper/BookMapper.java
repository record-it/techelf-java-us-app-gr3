package pl.us.gr3.app.mapper;

import pl.us.gr3.app.dto.RequestBookDto;
import pl.us.gr3.app.model.Book;

public class BookMapper {
    public static Book toBook(RequestBookDto dto){
        return Book
                .builder()
                .title(dto.getTitle())
                .author(dto.getAuthors().get(0))
                .editionYear(dto.getEditionYear())
                .build();
    }
}
