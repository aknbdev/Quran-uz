package io.quran.app.payload.dto.api;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class VerseIndopakList {
    private List<VerseIndopak> verses;

    public VerseIndopakList() {
        this.verses = new ArrayList<>();
    }
}
