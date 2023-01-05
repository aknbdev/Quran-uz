package io.quran.app.service.impl;

import io.quran.app.mapper.LanguageMapper;
import io.quran.app.payload.LanguageDto;
import io.quran.app.service.LanguageService;
import io.quran.core.exception.RestException;
import io.quran.core.response.ApiResult;
import io.quran.db.entity.Language;
import io.quran.db.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepository languageRepository;
    private final LanguageMapper languageMapper;

    @Override
    public ApiResult<List<LanguageDto>> getAllLanguages() {
        List<Language> languageList = languageRepository.findAll();
        List<LanguageDto> languageDtoList = languageMapper.toDtoList(languageList);

        return ApiResult.successResponse(languageDtoList);
    }

    @Override
    public Integer getLanguageIdByCode(String code) {
        Optional<Language> optional = languageRepository.findByCode(code);
        if(optional.isEmpty())
            throw RestException.restThrow("Language not found with this code", HttpStatus.NOT_FOUND);
        return optional.get().getId();
    }
}