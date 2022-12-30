package io.quran.app.payload.dto.api;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SurahInfoList {

    @JsonProperty("result")
    List<SurahInfo> surahInfoList;

    public SurahInfoList() {
        this.surahInfoList = new ArrayList<>();
    }
}
