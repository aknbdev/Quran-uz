package io.quran.app.service;

import io.quran.app.payload.surah.SurahDto;
import io.quran.core.response.ApiResult;
import io.quran.db.entity.Surah;

public interface SurahService {
    ApiResult<SurahDto> getSurahById(Integer id, Integer languageId);

    ApiResult<?> getAllSurahs();

    Surah saveSurah(SurahDto surahDto);
}
