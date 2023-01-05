package io.quran.app.service;


import io.quran.app.payload.verse.VerseDetailSaveDto;
import io.quran.db.entity.verse.VerseDetail;

import java.util.List;

public interface VerseDetailService {

    VerseDetailSaveDto getOneBySurahIdVerseId(
            Integer surahId,
            Integer verseId,
            String lang
    );

    List<VerseDetailSaveDto> getVerseDetailBySurahId(Integer surahId, String lang);

    List<VerseDetailSaveDto> getAllVerseDetail(String lang);

    List<VerseDetail> getVerseDetails(List<Integer> verseIds);
}