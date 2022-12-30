package io.quran.app.payload.dto.api;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class VesreByJuzList {
    
    @JsonProperty("verses")
    private List<VerseByJuz> verses;

    public VesreByJuzList() {
        this.verses = new ArrayList<>();
    }
}
