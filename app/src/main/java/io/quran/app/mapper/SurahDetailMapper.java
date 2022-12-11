package io.quran.app.mapper;

import io.quran.app.payload.SurahDetailDto;
import io.quran.db.entity.SurahDetail;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface SurahDetailMapper {

    SurahDetail toEntity(SurahDetailDto SurahDetailDto);

    SurahDetailDto toDto(SurahDetail surahDetail);

}
