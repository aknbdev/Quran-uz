package io.quran.app.payload.verse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VersesAfterReq extends VerseSurahReq {

    private Integer idAfter;
}