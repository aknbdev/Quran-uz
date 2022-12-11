package io.quran.app.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerseDto {

    private Integer verseId;

    private SurahDto surahDto;
    @NotBlank(message = ("Surah id is mandatory!"))
    private Integer surahId;
    @NotBlank(message = ("Verse text is mandatory!"))
    private String verseText;
    private String translation;
    @NotNull(message = ("Order number is mandatory!"))
    private Integer order_number;
    @NotNull(message = ("Juz id is mandatory!"))
    private Integer juzId;
    private Long milliseconds;
}


// DEPRECATED CODES
// private Integer languageId;
