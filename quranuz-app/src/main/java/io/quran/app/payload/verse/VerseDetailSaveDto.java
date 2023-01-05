package io.quran.app.payload.verse;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.quran.app.payload.LanguageDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerseDetailSaveDto {

    private Integer id;
    @NotBlank(message = "Translation is mandatory!")
    private String translation;
    @NotBlank(message = "Description is mandatory!")
    private String description;
    private VerseSaveDto verse;
    @NotNull(message = "Verse id is mandatory!")
    private Integer verseId;
    private LanguageDto language;
    @NotNull(message = "Language id is mandatory!")
    private Integer languageId;
}

/* DEPRECATED

    private Long milliseconds;

 */