package io.quran.app.payload;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private QuranApiPojo[] result;
}
