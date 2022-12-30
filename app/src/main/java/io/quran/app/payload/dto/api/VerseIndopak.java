package io.quran.app.payload.dto.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerseIndopak {
    
    private Integer id;
    private String verse_key;
    private String text_indopak;
}