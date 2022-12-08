package io.quran.app.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerseDetailDto {

    private Integer verseDetailId;

    private VerseDto verseDto;
    @NotNull(message = ("Verse id is mandatory!"))
    private Integer verseId;
    private Integer surahId;

    private LanguageDto languageDto;
    @NotNull(message = ("Language id is mandatory!"))
    private Integer languageId;
    //    @NotBlank(message = ("Transcript is mandatory!"))
    private String transcript;
    @NotBlank(message = ("Translation is mandatory!"))
    private String translation;
    //    @NotBlank(message = ("Description is mandatory!"))
    private String description;
    private Long milliseconds;
}
