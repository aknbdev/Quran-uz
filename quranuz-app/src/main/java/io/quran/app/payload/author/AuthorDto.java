package io.quran.app.payload.author;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.quran.core.enums.AuthorType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorDto {

    private Integer id;
    private String fullName;
    private AuthorType type;
}