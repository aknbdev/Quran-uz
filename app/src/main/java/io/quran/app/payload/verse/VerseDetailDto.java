package io.quran.app.payload.verse;

import io.quran.app.payload.LanguageDto;
import io.quran.app.payload.surah.SurahDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerseDetailDto {

    private Integer verseId;
    private String arabic;
    private String verseKey;
    private Integer juzNumber;
    private Integer orderNumber;
    private Integer pageNumber;
    private SurahDto surah;
    private Integer surahId;


    private Integer verseDetailId;
    private String translation;
    private String description;
    private VerseSaveDto verse;
    private LanguageDto language;
    private Integer languageId;
}
