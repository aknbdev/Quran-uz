package io.quran.app.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDto {
    private Integer id;
    private String name;
    private Boolean deleted;
}
