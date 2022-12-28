package io.quran.app.payload.verse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerseDto {

    private Integer id;
    private String verseKey;
    private String arabic;
    private Integer juzNumber;
    private Integer orderNumber;
    private Integer surahId;
}