package io.quran.app.payload.verse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VersesAfterReq {

    private Integer surahId;
    private Integer idAfter;
    private Integer langId;
}
