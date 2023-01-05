package io.quran.app.service;
import io.quran.app.payload.verse.VerseDto;
import io.quran.app.payload.verse.VerseJuzRequest;
import io.quran.app.payload.verse.VersesAfterReq;

import java.util.List;

public interface VerseService {
    List<VerseDto> getAllBySurahId(Integer surahId, Integer langId);

    List<VerseDto> findAllByJuzRequest(VerseJuzRequest verseJuzRequest);

    List<VerseDto> getVersesAfter(VersesAfterReq req);
}