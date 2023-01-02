package io.quran.app.controller;

import io.quran.app.config.ApiConfig;
import io.quran.app.payload.LanguageDto;
import io.quran.app.service.LanguageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(ApiConfig.LANGUAGE_API)
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getOne(@RequestParam("name") String name) {
//        return ResponseEntity.ok(languageService.getLanguageById(name));
        return null;
    }

    @GetMapping("/get-all")
//    public ResponseEntity<?> getAll() {
//        return ResponseEntity.ok(languageService.getAllLanguages());
//    }

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
