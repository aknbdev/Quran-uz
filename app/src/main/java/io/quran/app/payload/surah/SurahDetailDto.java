package io.quran.app.payload.surah;

import io.quran.app.payload.LocationDto;
import io.quran.app.payload.SeparatorTextDto;
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
