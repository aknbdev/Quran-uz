package io.quran.app.payload;

import java.util.LinkedList;
import java.util.List;

import lombok.Getter;

@Getter

public class JuzDto {
    
    private Integer juzNumber;
    private List<JuzSurahDto> juzSurahDtos = new LinkedList<>();
}