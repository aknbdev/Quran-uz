package io.quran.app.controller;

import io.quran.app.constants.ApiConstants;
import io.quran.app.payload.LanguageDto;
import io.quran.app.service.LanguageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(ApiConstants.LANGUAGE_API)
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(languageService.getLanguageById(id));
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(languageService.getAllLanguages());
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody LanguageDto dto) {
        languageService.createLanguage(dto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/language/create").toUriString());
        return ResponseEntity.created(uri).body("Ok, Language created!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @Valid @RequestBody LanguageDto dto) {
        languageService.updateLanguage(id, dto);
        return ResponseEntity.ok("Ok, Language updated!");
    }
}
