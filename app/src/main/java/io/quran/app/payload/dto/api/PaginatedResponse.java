package io.quran.app.payload.dto.api;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaginatedResponse {
    
    @JsonProperty("content")
    List<VesreByJuzList> content;

    public PaginatedResponse() {
        content = new ArrayList<>();
    }
}