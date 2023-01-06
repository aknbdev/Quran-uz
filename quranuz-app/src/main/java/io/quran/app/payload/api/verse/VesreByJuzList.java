package io.quran.app.payload.api.verse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class VesreByJuzList {

    @JsonProperty("verses")
    private List<VerseByJuz> verses;

    public VesreByJuzList() {
        this.verses = new ArrayList<>();
    }
}
