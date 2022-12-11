package io.quran.app.mapper;

import io.quran.app.payload.SeparatorTextDto;
import io.quran.db.entity.SeparatorText;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface SeparatorTextMapper {

    SeparatorText toEntity(SeparatorTextDto separatorTextDto);

    SeparatorTextDto toDto(SeparatorText separatorText);

}
