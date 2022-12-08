package io.quran.app.service;
import io.quran.app.payload.LanguageDto;
import java.util.List;

public interface LanguageService {

    void createLanguage(LanguageDto dto);

    LanguageDto getLanguageById(Integer id);

    List<LanguageDto> getAllLanguages();

    void updateLanguage(Integer id, LanguageDto dto);
}
