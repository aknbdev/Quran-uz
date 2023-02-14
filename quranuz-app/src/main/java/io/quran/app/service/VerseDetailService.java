package io.quran.app.service;


import io.quran.app.payload.verse.VerseBeginEndReq;
import io.quran.app.payload.verse.VerseDto;
import io.quran.app.payload.verse.VerseSurahReq;
import io.quran.app.payload.verse.VersesAfterReq;
import io.quran.db.entity.VerseDetail;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VerseDetailService {

    List<VerseDetail> getVerseDetails(List<Integer> verseIds, Integer authorId, Integer langId);

    List<VerseDto> findAllByJuzRequest(VerseBeginEndReq req);

    List<VerseDto> getVersesAfter(VersesAfterReq req);

    List<VerseDto> getAllBySurahId(VerseSurahReq verseSurahReq);

    Page<VerseDto> getAllAsPageable(VerseSurahReq req);
}