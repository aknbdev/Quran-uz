package io.quran.app.service;

import io.quran.app.payload.api.ApiResult;
import io.quran.app.payload.SurahDto;

public interface SurahService {
    ApiResult<SurahDto> getSurahById(Integer id, Integer languageId);

    ApiResult<?> getAllSurahs();

    void saveSurah(SurahDto surahDto);
}
