package io.quran.app.mapper;

import io.quran.app.entity.Surah;
import io.quran.app.payload.SurahDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface SurahMapper {

    Surah toEntity(SurahDto surahDto);

    SurahDto toDto(Surah surah);
}
