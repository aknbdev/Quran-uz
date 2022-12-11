package io.quran.app.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SurahDetailDto {
    private Integer id;
    private SurahDto surah;
    private Integer surahId;
    private String surahName;
    private Integer languageId;
    private LocationDto location;
    private Integer locationId;
    private SeparatorTextDto separatorText;
    private Integer separatorTextId;
}
