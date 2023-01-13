package io.quran.app.mapper;
import io.quran.app.payload.verse.VerseDto;
import io.quran.app.payload.verse.VerseSaveDto;
import io.quran.db.entity.verse.Verse;
import io.quran.db.entity.verse.VerseDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VerseMapper {

    Verse toVerse(VerseSaveDto source);

    @Mapping(target = "verseId", source = "verse.id")
    @Mapping(target = "verseDetailId", source = "id")
    @Mapping(target = "verseKey", source = "verse.verseKey")
    @Mapping(target = "arabic", source = "verse.arabic")
    @Mapping(target = "orderNumber", source = "verse.orderNumber")
    @Mapping(target = "pageNumber", source = "verse.pageNumber")
    VerseDto toVerseDto(VerseDetail verseDetail);
}