package io.quran.app.payload.verse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerseSurahReq {

    private Integer authorId;
    private Integer langId;
    private Integer surahId;
}
