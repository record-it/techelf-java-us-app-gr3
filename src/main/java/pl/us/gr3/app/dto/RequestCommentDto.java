package pl.us.gr3.app.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestCommentDto {
    @Length(min = 3, max = 256)
    private String content;
    @Min(value = 1, message = "Rate musi być w zakresie od 1 do 6 włącznie.")
    @Max(value = 6, message = "Rate musi być w zakresie od 1 do 6 włącznie.")
    private int rate;


}
