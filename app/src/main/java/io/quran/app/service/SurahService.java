package io.quran.app.service;

import io.quran.app.payload.ApiResult;
import io.quran.app.payload.SurahDto;

public interface SurahService {
    ApiResult<SurahDto> getSurahById(Integer id);
}
