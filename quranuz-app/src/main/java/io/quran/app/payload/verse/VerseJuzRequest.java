package io.quran.app.payload.verse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerseJuzRequest {
    private Integer surahId;
    private Integer begin;
    private Integer end;
    private Integer langId;
}