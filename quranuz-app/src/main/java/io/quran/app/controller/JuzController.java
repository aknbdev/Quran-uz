package io.quran.app.controller;

import io.quran.app.config.ApiConfig;
import io.quran.app.payload.juz.JuzDto;
import io.quran.app.service.JuzService;
import io.quran.core.response.ApiResult;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@Tag(name = "Juz APIs")
@RequestMapping(ApiConfig.JUZ_API)
public class JuzController {

    private final JuzService juzService;

    @GetMapping("/{languageId}")
    public ApiResult<Collection<JuzDto>> getAllJuz(@PathVariable Integer languageId){
        ApiResult<Collection<JuzDto>> result = juzService.getAllJuz(languageId);
        return result;
    }
}
