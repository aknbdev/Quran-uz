package io.quran.app.service;


import io.quran.app.payload.VerseDto;

import java.util.List;

public interface VerseService {

    void updateVerse(Integer id, VerseDto verseDto);

    List<VerseDto> getAllVerses(long millisecond);

    List<VerseDto> getAllBySurahId(Integer id, long millisecond);

    List<VerseDto> getAllByJuzId(Integer juzId, Integer languageId, long millisecond);

    void createVerse(VerseDto verseDto);
}


// DEPRECATED CODES
//    VerseDto getByVerseId(Integer verseId, Integer languageId, long millisecond);
