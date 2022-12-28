package io.quran.app.service;

import io.quran.app.payload.api.ApiResult;
import io.quran.app.payload.SurahDetailDto;

public interface SurahDetailService {
    ApiResult<SurahDetailDto> getSurahDetailById(Integer surahId, Integer languageId);
}
