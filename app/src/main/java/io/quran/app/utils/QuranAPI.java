package io.quran.app.utils;

import io.quran.app.payload.surah.SurahDto;
import io.quran.app.payload.api.ApiResponse;
import io.quran.app.service.JuzService;
import io.quran.app.service.SurahDetailService;
import io.quran.app.service.SurahService;
import io.quran.db.entity.Juz;
import io.quran.db.entity.Surah;
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
    private final JuzService juzService;

    private final SurahDetailService surahDetailService;
    private final int SURAH_NUMBER = 114; // @TODO o'zgaradi

    private final static String SURAH_URL = "https://quranenc.com/api/v1/translation/sura/uzbek_mansour/";

    public void getSurahInfos(){
        // SURA NOMERI KIRITILISHI KERAK
        ResponseEntity<ApiResponse> responseEntity = restTemplate.getForEntity(SURAH_URL + SURAH_NUMBER, ApiResponse.class);

        ApiResponse response = responseEntity.getBody();

        // ============ Sura ma'lumotlari ============

        SurahDto surahDto = new SurahDto();
        surahDto.setVerseCount(response.getResult().length); // o'zgarmaydi

        surahDto.setName("النَّاس"); // @TODO o'zgaradi
        surahDto.setOrderNumber(SURAH_NUMBER);

        Surah surah = surahService.saveSurah(surahDto);
        // LOCATION ======>    Makka = 3, Madina = 4         @TODO o'zgaradi       @TODO o'zgaradi
//        surahDetailService.saveSurahDetail(surah,  "Наас", 2, 3, 2);

        // ========================

    }

    public void saveJuz(){
        System.out.println("Hello !!!");
        Juz juz = new Juz();

        juz.setJuzNumber(30); // @Todo Juz Order Number o'zgaradi
        juz.setSurahOrderNumber(114); // @Todo Surah Order Number o'zgaradi
        juz.setVersesOrderNumber("1-6"); // @Todo Verses Order Number o'zgaradi
        juz.setVersesCount(6); // @Todo Verses Count o'zgaradi

//        juzService.saveJuz(juz);
    }

}