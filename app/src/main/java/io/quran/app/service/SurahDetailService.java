package io.quran.app.service;

import io.quran.app.payload.api.ApiResult;
import io.quran.app.payload.surah.SurahDetailDto;
import io.quran.app.payload.surah.SurahWithName;
import io.quran.db.entity.Surah;

import java.util.List;

public interface SurahDetailService {
    ApiResult<SurahDetailDto> getSurahDetailById(Integer surahId, Integer languageId);

    ApiResult<List<SurahWithName>> getSurahs(Integer languageId);
}
