package io.quran.app.service;

import io.quran.app.payload.api.ApiResult;
import io.quran.app.payload.SurahDto;
import io.quran.db.entity.Surah;

public interface SurahService {
    ApiResult<SurahDto> getSurahById(Integer id, Integer languageId);

    ApiResult<?> getAllSurahs();

    Surah saveSurah(SurahDto surahDto);
}
