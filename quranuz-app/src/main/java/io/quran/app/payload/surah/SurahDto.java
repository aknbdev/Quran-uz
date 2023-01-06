package io.quran.app.payload.surah;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.quran.app.payload.template.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SurahDto extends BaseDto {
    private String name;
    private Integer verseCount;
    private Integer orderNumber;
}