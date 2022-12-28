package io.quran.app.service;


import io.quran.app.payload.verse.VerseDetailSaveDto;

import java.util.List;

public interface VerseDetailService {

    VerseDetailSaveDto getOneBySurahIdVerseId(
            Integer surahId,
            Integer verseId,
            String lang
    );

    List<VerseDetailSaveDto> getVerseDetailBySurahId(Integer surahId, String lang);

    List<VerseDetailSaveDto> getAllVerseDetail(String lang);
}