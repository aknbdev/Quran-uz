package io.quran.app.payload.verse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerseBeginEndReq extends VerseSurahReq {
    private Integer begin;
    private Integer end;
}