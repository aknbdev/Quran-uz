package io.quran.app.payload.juz;

import io.quran.app.payload.template.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JuzDto extends BaseDto {
    private Integer juzNumber;
    private List<JuzSurahDto> surahs = new ArrayList<>();
}
