package io.quran.app.controller;

import io.quran.app.config.ApiConfig;
import io.quran.app.payload.filter.FilterDto;
import io.quran.app.payload.juz.JuzDto;
import io.quran.app.service.JuzService;
import io.quran.core.response.ApiResult;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@Tag(name = "Juz APIs")
@RequestMapping(ApiConfig.JUZ_API)
public class JuzController {

    private final JuzService juzService;

    @GetMapping("/{languageId}")
    public ApiResult<Collection<JuzDto>> getAllJuz(FilterDto filterDto,
                                                   @PathVariable Integer languageId){
        ApiResult<Collection<JuzDto>> result = juzService.getAllJuz(filterDto,
                languageId);
        return result;
    }
}
