package io.quran.app.mapper;

import io.quran.app.payload.LanguageDto;
import io.quran.db.entity.Language;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LanguageMapper {

    LanguageDto toLanguageDto(Language source);

    Language toLanguage(LanguageDto source);
}
