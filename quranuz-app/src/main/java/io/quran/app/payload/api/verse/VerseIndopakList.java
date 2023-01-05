package io.quran.app.payload.api.verse;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class VerseIndopakList {
    private List<VerseIndopak> verses;

    public VerseIndopakList() {
        this.verses = new ArrayList<>();
    }
}
