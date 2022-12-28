package io.quran.app.mapper.verse;

import io.quran.app.payload.verse.VerseSaveDto;
import io.quran.db.entity.verse.Verse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VerseMapper {

    Verse toVerse(VerseSaveDto source);

    VerseSaveDto toVerseDto(Verse source);
}