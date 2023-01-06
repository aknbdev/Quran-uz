package io.quran.app.payload;

import io.quran.app.payload.template.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto extends BaseDto {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
}
