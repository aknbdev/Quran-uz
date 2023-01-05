package io.quran.app.service;

import io.quran.app.payload.surah.SurahDetailDto;
import io.quran.core.response.ApiResult;

public interface SurahDetailService {
    ApiResult<SurahDetailDto> getSurahDetailById(Integer surahId, Integer languageId);

    ApiResult<?> getSurahs(Integer languageId);
}
