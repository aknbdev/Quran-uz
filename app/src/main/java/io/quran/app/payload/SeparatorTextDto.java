package io.quran.app.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeparatorTextDto {
    private Integer id;
    private String name;
    private String arabic;
    private Boolean deleted;
}
