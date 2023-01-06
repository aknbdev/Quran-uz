package io.quran.app.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LanguageDto {

    @NotBlank(message = "Language name is mandatory!")
    private String name;

    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean deleted;
}
