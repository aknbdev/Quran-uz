package io.quran.app.mapper.verse;
import io.quran.app.payload.verse.VerseDto;
import io.quran.app.payload.verse.VerseSaveDto;
import io.quran.db.entity.verse.Verse;
import io.quran.db.entity.verse.VerseDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VerseMapper {

    Verse toVerse(VerseSaveDto source);

    @Mapping(target = "id", source = "verseDetail.id")
    VerseDto toVerseDto(Verse source, VerseDetail verseDetail);
}