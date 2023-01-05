package io.quran.app.payload.juz;

import io.quran.app.payload.surah.SurahWithName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JuzSurahDto {
    private Integer versesCount;
    private Integer startOrderNumber;
    private Integer endOrderNumber;
    private SurahWithName surahWithName;
}
