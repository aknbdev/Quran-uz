package io.quran.app.service.impl;

import io.quran.app.exception.RestException;
import io.quran.app.mapper.LanguageMapper;
import io.quran.app.service.LanguageService;
import io.quran.db.entity.Language;
import io.quran.db.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepository languageRepository;
    private final LanguageMapper languageMapper;

    @Override
    public Integer getLanguageIdByCode(String code) {
        Optional<Language> optional = languageRepository.findByCode(code);
        if(optional.isEmpty())
            throw RestException.restThrow("Language not found with this code", HttpStatus.NOT_FOUND);
        return optional.get().getId();
    }

}