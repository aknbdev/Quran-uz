package io.quran.app.utils;

import io.quran.app.payload.SurahDto;
import io.quran.app.payload.api.ApiResponse;
import io.quran.app.payload.dto.api.SurahInfoList;
import io.quran.app.payload.dto.api.VerseIndopakList;
import io.quran.app.payload.dto.api.VesreByJuzList;
import io.quran.app.service.SurahDetailService;
import io.quran.app.service.SurahService;
import io.quran.db.entity.Surah;
import io.quran.db.entity.verse.Verse;
import lombok.RequiredArgsConstructor;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class QuranAPI {

    private final RestTemplate restTemplate;

    private final SurahService surahService;
    private final SurahDetailService surahDetailService;
    private final int SURAH_NUMBER = 114; // @TODO o'zgaradi
    private final static String SURAH_URL = "https://quranenc.com/api/v1/translation/sura/uzbek_mansour/";
    private final static String API_URL = "https://api.quran.com/api/v4";

    public void getSurahInfos() {
        // SURA NOMERI KIRITILISHI KERAK
        ResponseEntity<ApiResponse> responseEntity = restTemplate.getForEntity(SURAH_URL + SURAH_NUMBER,
                ApiResponse.class);

        ApiResponse response = responseEntity.getBody();

        // ============ Sura ma'lumotlari ============

        SurahDto surahDto = new SurahDto();
        surahDto.setVerseCount(response.getResult().length); // o'zgarmaydi

        surahDto.setName("النَّاس"); // @TODO o'zgaradi
        surahDto.setOrderNumber(SURAH_NUMBER);

        Surah surah = surahService.saveSurah(surahDto);
        // LOCATION ======> Makka = 3, Madina = 4 @TODO o'zgaradi @TODO o'zgaradi
        surahDetailService.saveSurahDetail(surah, "Наас", 2, 3, 2);

        // ========================

    }

    public Map<Integer, Verse> getVersesFromApi() {

        Map<Integer, Verse> verses = new HashMap<>();
        String temp = API_URL + "/quran/verses/indopak";

        VerseIndopakList verseIndopakList = restTemplate.getForObject(temp, VerseIndopakList.class);

        verseIndopakList.getVerses().forEach(verse -> {
            verses.put(verse.getId(), new Verse(verse.getVerse_key(), verse.getText_indopak()));
        });

        for (int i = 1; i <= 30; i++) {

            temp = API_URL + "/verses/by_juz/" + i + "?language=en&words=false&page=1&per_page=1000";

            VesreByJuzList vesreByJuzList = restTemplate.getForObject(temp, VesreByJuzList.class);

            vesreByJuzList.getVerses().forEach(verse -> {
                verses.get(verse.getId()).setJuzNumber(verse.getJuz_number());
                verses.get(verse.getId()).setPageNumber(verse.getPage_number());
                verses.get(verse.getId()).setOrderNumber(verse.getVerse_number());
            });

            SurahInfoList surahInfoList;
            temp = "https://quranenc.com/api/v1/translation/sura/uzbek_mansour/";
            for (int j = 1; j <= 114; j++) {

                surahInfoList = restTemplate.getForObject(temp + j, SurahInfoList.class);
                surahInfoList.getSurahInfoList().forEach(surah -> {
                    verses.get(surah.getId()).setSurahId(surah.getSurahId());
                });
            }
        }

        return verses;
    }
}
