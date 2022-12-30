package io.quran.app.payload.dto.api;

import lombok.Getter;

@Getter
public class VerseByJuz {
    
    private Integer id;
    private Integer verse_number;
    private Integer page_number;
    private Integer juz_number;
}
