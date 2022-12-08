package io.quran.app.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LanguageDto {

    private Integer languageId;
    @NotBlank(message = "Language name is mandatory!")
    private String name;
    @NotBlank(message = "Language code is mandatory!")
    private String code;
    private Long updatedDate;
}
