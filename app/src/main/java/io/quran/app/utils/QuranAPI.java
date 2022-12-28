package io.quran.app.utils;

import io.quran.app.payload.api.ApiResponse;
import io.quran.app.payload.SurahDto;
import io.quran.app.service.SurahDetailService;
import io.quran.app.service.SurahService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Slf4j
@RequiredArgsConstructor
@Component
public class QuranAPI {

    private final RestTemplate restTemplate;

    private final SurahService surahService;

    private final SurahDetailService surahDetailService;

    private final static String SURAH_URL = "https://quranenc.com/api/v1/translation/sura/uzbek_mansour/1";

    public void getSurahInfos(){

        ResponseEntity<ApiResponse> responseEntity = restTemplate.getForEntity(SURAH_URL, ApiResponse.class);

        ApiResponse response = responseEntity.getBody();

        // ============ Sura ma'lumotlari ============

        SurahDto surahDto = new SurahDto();
        surahDto.setVerseCount(response.getResult().length); // o'zgarmaydi

        surahDto.setName("الفَاتِحَة"); // o'zgaradi
        surahDto.setOrderNumber(1); // o'zgaradi

        surahService.saveSurah(surahDto);

        // ========================

    }

}
