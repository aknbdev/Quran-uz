package io.quran.app.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JuzSurahDto {

    private Integer surahOrderNumber;
    private Integer versesCount;
    private Integer versesOrderNumber;
    // private SurahWithName surahWithName;
}