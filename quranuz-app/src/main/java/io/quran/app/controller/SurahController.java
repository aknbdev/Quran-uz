package io.quran.app.controller;

import io.quran.app.payload.surah.SurahDetailDto;
import io.quran.app.service.SurahDetailService;
import io.quran.core.response.ApiResult;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static io.quran.app.config.ApiConfig.SURAH_API;

@RestController
@Tag(name = "Surah APIs")
@RequestMapping(SURAH_API)
public class SurahController {

    private final SurahDetailService surahDetailService;

    public SurahController(SurahDetailService surahDetailService) {
        this.surahDetailService = surahDetailService;
    }

    @GetMapping("/{surahId}/{languageId}")
    public ApiResult<SurahDetailDto> getSurahById(@PathVariable Integer surahId,
                                                  @PathVariable Integer languageId) {
        ApiResult<SurahDetailDto> result = surahDetailService.getSurahDetailById(surahId, languageId);
        return result;
    }

    @GetMapping("/{languageId}")
    public ApiResult<?> getAllSurahs(@PathVariable Integer languageId) {
        ApiResult<?> result = surahDetailService.getSurahs(languageId);
        return result;
    }

}
