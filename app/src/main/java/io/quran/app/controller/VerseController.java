package io.quran.app.controller;

import io.quran.app.config.ApiConfig;
import io.quran.app.service.VerseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConfig.VERSE_API)
public class VerseController {
    private final VerseService verseService;

    public VerseController(VerseService verseService) {
        this.verseService = verseService;
    }

    @GetMapping("/get-by-surah")
    public ResponseEntity<?> getAllBySurahId(@RequestParam("surah-id") Integer surahId,
                                             @RequestParam("lang") String lang) {

        return ResponseEntity.ok(verseService.getAllBySurahId(surahId, lang));
    }

    @GetMapping("/get-by-juz")
    public ResponseEntity<?> getAllByJuzId(@RequestParam("juzNumber") Integer juzNumber,
                                           @RequestParam("lang-id") String lang) {

        return ResponseEntity.ok(verseService.getAllByJuzId(juzNumber, lang));
    }
}