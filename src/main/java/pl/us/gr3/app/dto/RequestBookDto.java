package pl.us.gr3.app.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

// zdefiniuj klasę RequestBookDto z polami:
// authors jako lista łańcuchów
// title jako łańcuch
// editionYear jako int
// dodaj walidację:
// tytuł co najmiej 1 znak i nie dłuższy od 200
// editionYear nie mniejszy od 1950
// authors co najmniej jeden element
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestBookDto {

    @Size(min = 1)
    private List<String> authors = new ArrayList<>();
    @Length(min = 1, max = 200)
    private String title;
    @Min(1950)
    private int editionYear;
}
