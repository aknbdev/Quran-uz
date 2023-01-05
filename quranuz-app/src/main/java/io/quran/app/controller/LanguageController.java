package io.quran.app.controller;

import io.quran.app.config.ApiConfig;
import io.quran.app.payload.LanguageDto;
import io.quran.app.service.LanguageService;
import io.quran.core.response.ApiResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(ApiConfig.LANGUAGE_API)
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping
    public ApiResult<List<LanguageDto>> getAllLanguages() {
        ApiResult<List<LanguageDto>> result = languageService.getAllLanguages();
        return result;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody LanguageDto dto) {
//        languageService.createLanguage(dto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/language/create").toUriString());
        return ResponseEntity.created(uri).body("Ok, Language created!");
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestParam("name") String name, @Valid @RequestBody LanguageDto dto) {
//        languageService.updateLanguage(name, dto);
        return ResponseEntity.ok("Ok, Language updated!");
    }
}
