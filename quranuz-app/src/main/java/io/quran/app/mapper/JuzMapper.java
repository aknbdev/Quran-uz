package io.quran.app.mapper;

import io.quran.app.payload.juz.JuzDto;
import io.quran.db.entity.Juz;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface JuzMapper {

    JuzDto toDto(Juz juz);

    Juz toEntity(JuzDto juzDto);
}
