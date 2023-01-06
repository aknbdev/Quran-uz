package io.quran.app.payload.api.verse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SurahInfo {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("sura")
    private Integer surahId;
}
