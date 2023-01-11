package io.quran.app.service;
import io.quran.app.payload.verse.VerseDto;
import io.quran.app.payload.verse.VerseBeginEndReq;
import io.quran.app.payload.verse.VerseSurahReq;
import io.quran.app.payload.verse.VersesAfterReq;

import java.util.List;

public interface VerseService {
    List<VerseDto> getAllBySurahId(VerseSurahReq verseSurahReq);

    List<VerseDto> findAllByJuzRequest(VerseBeginEndReq verseJuzRequest);

    List<VerseDto> getVersesAfter(VersesAfterReq req);
}