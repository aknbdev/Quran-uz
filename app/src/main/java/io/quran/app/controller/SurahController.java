package io.quran.app.controller;

import io.quran.app.config.ApiConfig;
import io.quran.app.payload.api.ApiResult;
import io.quran.app.payload.surah.SurahDetailDto;
import io.quran.app.payload.surah.SurahWithName;
import io.quran.app.service.SurahDetailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static io.quran.app.config.ApiConfig.SURAH_API;

@RestController
@RequestMapping(SURAH_API)
public class SurahController {

    private final SurahDetailService surahDetailService;

    public SurahController(SurahDetailService surahDetailService) {
        this.surahDetailService = surahDetailService;
    }

    @GetMapping("/{surahId}/{languageId}")
    public ApiResult<SurahDetailDto> getSurahById(@PathVariable Integer surahId,
                                                  @PathVariable Integer languageId){
        ApiResult<SurahDetailDto> result = surahDetailService.getSurahDetailById(surahId, languageId);
        return result;
    }

    @GetMapping("/{languageId}")
    public ApiResult<?> getAllSurahs(@PathVariable Integer languageId){
        ApiResult<?> result = surahDetailService.getSurahs(languageId);
        return result;
    }

}
