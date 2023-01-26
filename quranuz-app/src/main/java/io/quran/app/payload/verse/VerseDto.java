package io.quran.app.payload.verse;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class VerseDto {

    @NotNull(message = "id.required")
    private Integer verseId;
    private Integer verseDetailId;
    private String verseKey;
    private String arabic;
    private Integer orderNumber;
    private Integer pageNumber;
    private String translation;
    private String description;
}