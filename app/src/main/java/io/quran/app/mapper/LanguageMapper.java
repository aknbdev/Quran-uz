package io.quran.app.mapper;

import org.mapstruct.Mapper;
import io.quran.app.payload.LanguageDto;
import io.quran.db.entity.Language;

@Mapper(componentModel = "spring")
public interface LanguageMapper {
    
    LanguageDto toLanguageDto(Language source);

    Language toLanguage(LanguageDto source);
}
