package io.quran.app.payload.surah;

import io.quran.app.payload.LocationDto;
import io.quran.app.payload.SeparatorTextDto;
import io.quran.app.payload.template.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SurahDetailDto extends BaseDto {
    private SurahDto surah;
    private Integer surahId;
    private String surahName;
    private Integer languageId;
    private LocationDto location;
    private Integer locationId;
}
