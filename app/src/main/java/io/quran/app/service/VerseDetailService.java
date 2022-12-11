package io.quran.app.service;


import io.quran.app.payload.VerseDetailDto;

import java.util.List;

public interface VerseDetailService {

    VerseDetailDto getOneBySurahIdVerseId(Integer surahId, Integer verseId, Integer languageId, long millisecond);

    List<VerseDetailDto> getVerseDetailBySurahId(Integer surahId, Integer languageId, long millisecond);

    List<VerseDetailDto> getAllVerseDetail(Integer languageId, long millisecond);

    void createVerseDetail(VerseDetailDto dto);

    void updateVerseDetail(Integer id, VerseDetailDto dto);
}
