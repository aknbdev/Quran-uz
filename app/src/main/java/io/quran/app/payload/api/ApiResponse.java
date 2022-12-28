package io.quran.app.payload.api;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private QuranApiPojo[] result;
}
