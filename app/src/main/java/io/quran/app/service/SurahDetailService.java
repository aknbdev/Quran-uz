package io.quran.app.service;

import io.quran.app.payload.ApiResult;
import io.quran.app.payload.SurahDetailDto;
import io.quran.db.entity.Surah;

public interface SurahDetailService {
    ApiResult<SurahDetailDto> getSurahDetailById(Integer surahId, Integer languageId);

    void saveSurahDetail(Surah surah, String surahName, Integer languageId, Integer locationId, Integer separatorTextId);
}
