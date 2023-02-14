package io.quran.app.payload.filter;

import javax.validation.constraints.Min;

public class FilterParams {
    private String searchText;
    private int page = 0;
    @Min(value = 1, message = "filter.size.invalid")
    private int size = 16;

    public String getSearchText() {
        return searchText != null ? searchText : "";
    }
}
