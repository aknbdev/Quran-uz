package io.quran.app.service.impl;

import io.quran.app.mapper.LanguageMapper;
import io.quran.app.payload.LanguageDto;
import io.quran.app.service.LanguageService;
import io.quran.db.repository.LanguageRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;
    private final LanguageMapper languageMapper;

    public LanguageServiceImpl(LanguageRepository languageRepository,
            LanguageMapper languageMapper) {
        this.languageRepository = languageRepository;
        this.languageMapper = languageMapper;
    }

    @Override
    public void createLanguage(LanguageDto dto) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public LanguageDto getLanguageById(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<LanguageDto> getAllLanguages() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateLanguage(String name, LanguageDto dto) {
        // TODO Auto-generated method stub
        
    }
}