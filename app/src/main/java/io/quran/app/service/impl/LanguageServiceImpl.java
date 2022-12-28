package io.quran.app.service.impl;
import io.quran.app.payload.LanguageDto;
import io.quran.app.service.LanguageService;
import io.quran.db.entity.Language;
import io.quran.db.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepository languageRepository;

    @Override
    public void createLanguage(LanguageDto dto) {
        Language language = dtoToEntity(dto);
        language.setUpdatedAt(Timestamp.from(Instant.now()));
        saveToDatabase(language);
    }

    @Override
    public LanguageDto getLanguageById(Integer id) {
        return entityToDto(getEntity(id));
    }

    @Override
    public List<LanguageDto> getAllLanguages() {
        return getAllEntity()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void updateLanguage(Integer id, LanguageDto dto) {
        getEntity(id);
        Language language = dtoToEntity(dto);
        language.setId(id);
        language.setUpdatedAt(Timestamp.from(Instant.now()));
        saveToDatabase(language);
    }

    // |- SECONDARY FUNCTIONS -|

    void saveToDatabase(Language language){
        try {
            languageRepository.save(language);
        } catch (Exception e){
            // TODO: 08/12/22
//            throw new ServerBadRequestException(e.getMessage());
        }
    }

    Language getEntity(Integer id){
        return languageRepository.findById(id)
                .orElse(null);
    }

    List<Language> getAllEntity(){
        List<Language> languages = languageRepository.findAll();

        if (languages.isEmpty()) return Collections.emptyList();
        return languages;
    }

    public Language dtoToEntity(LanguageDto dto){
        Language entity = new Language();

        entity.setId(dto.getLanguageId());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        // TODO: 08/12/22
//        entity.setUpdatedDate(TimeConverter.convertToLocalDateTime(dto.getUpdatedDate()));
        return entity;
    }

    public LanguageDto entityToDto(Language entity){
        LanguageDto dto = new LanguageDto();

        dto.setLanguageId(entity.getId());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        // TODO: 08/12/22
//        dto.setUpdatedDate(TimeConverter.convertMilliseconds(entity.getUpdatedDate()));
        return dto;
    }
}


// DEPRECATED THINGS
//          throw new ServerBadRequestException("Language not found!")
//          throw new ServerBadRequestException("Languages not found!");