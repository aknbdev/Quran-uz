package io.quran.app.mapper;

import io.quran.app.payload.LocationDto;
import io.quran.db.entity.Location;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface LocationMapper {

    Location toEntity(LocationDto locationDto);

    LocationDto toDto(Location location);
}
