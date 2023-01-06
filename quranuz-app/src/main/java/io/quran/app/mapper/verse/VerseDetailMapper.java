package io.quran.app.mapper.verse;

import io.quran.app.payload.verse.VerseDetailSaveDto;
import io.quran.db.entity.verse.VerseDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VerseDetailMapper {

    VerseDetail toVerseDetail(VerseDetailSaveDto source);

    VerseDetailSaveDto toVerseDetailDto(VerseDetail source);
}
