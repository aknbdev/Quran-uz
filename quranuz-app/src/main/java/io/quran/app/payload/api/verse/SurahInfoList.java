package io.quran.app.payload.api.verse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SurahInfoList {

    @JsonProperty("result")
    List<SurahInfo> surahInfoList;

    public SurahInfoList() {
        this.surahInfoList = new ArrayList<>();
    }
}
