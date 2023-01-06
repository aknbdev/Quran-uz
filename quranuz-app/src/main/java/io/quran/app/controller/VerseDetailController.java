package io.quran.app.controller;

import io.quran.app.config.ApiConfig;
import io.quran.app.service.VerseDetailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Verse Detail APIs")
@RequestMapping(ApiConfig.VERSE_DETAIL_API)
public class VerseDetailController {
    private final VerseDetailService verseDetailService;

    public VerseDetailController(VerseDetailService verseDetailService) {
        this.verseDetailService = verseDetailService;
    }

    @GetMapping("/get-one")
    public ResponseEntity<?> getOneBySurahIdAndVerseId(
            @RequestParam("surahId") Integer surahId,
            @RequestParam("verseId") Integer verseId,
            @RequestParam("languageId") String lang) {

        return ResponseEntity.ok(verseDetailService.getOneBySurahIdVerseId(surahId, verseId, lang));
    }

    @GetMapping("/get-by-surah")
    public ResponseEntity<?> getAllVerseDetailBySurahId(
            @RequestParam("surahId") Integer surahId,
            @RequestParam("lang") String lang) {

        return ResponseEntity.ok(verseDetailService.getVerseDetailBySurahId(surahId, lang));
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(@RequestParam("lang") String lang) {
        return ResponseEntity.ok(verseDetailService.getAllVerseDetail(lang));
    }
}