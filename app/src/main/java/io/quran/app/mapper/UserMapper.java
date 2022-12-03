package io.quran.app.mapper;

import io.quran.app.entity.User;
import io.quran.app.payload.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDTO(User user);

    User toUserEntity(UserDto userDto);
}
