package io.quran.app.controller;

import io.quran.app.config.ApiConfig;
import io.quran.app.payload.verse.VerseJuzRequest;
import io.quran.app.payload.verse.VersesAfterReq;
import io.quran.app.service.VerseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Tag(name = "Verse APIs")
@RequestMapping(ApiConfig.VERSE_API)
public class VerseController {
    private final Logger LOG = LoggerFactory.getLogger(VerseController.class);
    private final VerseService verseService;

    public VerseController(VerseService verseService) {
        this.verseService = verseService;
    }

    @GetMapping("/by-surah-lang")
    public ResponseEntity<?> getAllBySurahId(@RequestParam("surah-id") Integer surahId,
                                             @RequestParam("lang-id") Integer langId) {
        LOG.info("Rest request to get all verses surahId: {} langId: {}", surahId, langId);
        return ResponseEntity.ok(verseService.getAllBySurahId(surahId, langId));
    }

    @PostMapping("/begin-end-request")
    public ResponseEntity<?> getAllByJuzRequest(@Valid @RequestBody VerseJuzRequest verseJuzRequest) {
        LOG.info("Rest request to get all verses by: {}", verseJuzRequest);
        return ResponseEntity.ok(verseService.findAllByJuzRequest(verseJuzRequest));
    }

    @PostMapping("/by-after")
    public ResponseEntity<?> getAllAfter(@Valid @RequestBody VersesAfterReq req) {
        LOG.info("Rest request to get all surah id: {} verses after id: {}", req.getSurahId(), req.getIdAfter());
        return ResponseEntity.ok(verseService.getVersesAfter(req));
    }
}