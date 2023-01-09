package io.quran.app.service;

import io.quran.app.payload.filter.FilterDto;
import io.quran.app.payload.surah.SurahDetailDto;
import io.quran.app.payload.surah.SurahWithName;
import io.quran.core.response.ApiResult;

import java.util.List;

public interface SurahDetailService {
    ApiResult<SurahDetailDto> getSurahDetailById(Integer surahId, Integer languageId);

    ApiResult<?> getSurahs(Integer languageId);

    ApiResult<List<SurahWithName>> getAllSurahsWithFilter(FilterDto filter, Integer languageId);
}
