package io.quran.app.service;
import io.quran.app.payload.LanguageDto;
import io.quran.app.payload.api.ApiResult;

import java.util.List;

public interface LanguageService {

    ApiResult<List<LanguageDto>> getAllLanguages();

    Integer getLanguageIdByCode(String code);

}
