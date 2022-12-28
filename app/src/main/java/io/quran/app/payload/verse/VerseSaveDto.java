package io.quran.app.payload.verse;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.quran.app.payload.SurahDto;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerseSaveDto {

    private Integer id;
    @NotBlank(message = "Verse arabic is mandatory!")
    private String arabic;
    @NotBlank(message = "VerseKey is mandatory!")
    private String verseKey;
    @NotNull(message = "JuzNumber is mandatory!")
    private Integer juzNumber;
    @NotNull(message = "OrderNumber is mandatory!")
    private Integer orderNumber;
    @NotNull(message = "PageNumber is mandatory!")
    private Integer pageNumber;
    private SurahDto surahDto;
    @NotBlank(message = "Surah id is mandatory!")
    private Integer surahId;
}


// DEPRECATED CODES
// private Integer languageId;

//    private Long milliseconds;
//private String translation;