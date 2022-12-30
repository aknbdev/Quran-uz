package io.quran.app.mapper;

import io.quran.db.entity.Surah;
import io.quran.app.payload.surah.SurahDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface SurahMapper {

    
    Surah toEntity(SurahDto surahDto);

    SurahDto toDto(Surah surah);

    List<SurahDto> toEntityList(List<Surah> surahList);
}
