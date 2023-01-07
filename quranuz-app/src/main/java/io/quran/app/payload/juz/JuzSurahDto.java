package io.quran.app.payload.juz;

import io.quran.app.payload.surah.SurahWithName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JuzSurahDto {
    private Integer surahId;
    private Integer startOrderNumber;
    private Integer endOrderNumber;
    private String arabicName;
    private String surahName;
    private Integer surahOrderNumber;
//    private Integer verseCount;
}
