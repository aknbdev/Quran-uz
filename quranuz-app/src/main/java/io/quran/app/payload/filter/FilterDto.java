package io.quran.app.payload.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterDto {
    private String value;
    private String sortDirection;
}
