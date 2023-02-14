package io.quran.app.controller;

import io.quran.app.config.ApiConfig;
import io.quran.app.payload.verse.VerseBeginEndReq;
import io.quran.app.payload.verse.VerseSurahReq;
import io.quran.app.payload.verse.VersesAfterReq;
import io.quran.app.service.VerseDetailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Tag(name = "Verse APIs")
@RequestMapping(ApiConfig.VERSE_API)
public class VerseController {
    private final Logger LOG = LoggerFactory.getLogger(VerseController.class);
    private final VerseDetailService verseDetailService;

    public VerseController(VerseDetailService verseDetailService) {
        this.verseDetailService = verseDetailService;
    }

    @GetMapping("/list-by/surah-lang-author")
    public ResponseEntity<?> getAllBySurahId(VerseSurahReq verseSurahReq) {

        LOG.info("Rest request to get all verses surahId: {} langId: {} authorId: {}",
                verseSurahReq.getSurahId(), verseSurahReq.getLangId(), verseSurahReq.getAuthorId());
        return ResponseEntity.ok(verseDetailService.getAllBySurahId(verseSurahReq));
    }

    @GetMapping("/list-by/begin-end")
    public ResponseEntity<?> getAllByJuzRequest(@Valid VerseBeginEndReq verseJuzRequest) {

        LOG.info("Rest request to get all verses by: {}", verseJuzRequest);
        return ResponseEntity.ok(verseDetailService.findAllByJuzRequest(verseJuzRequest));
    }

    @GetMapping("/list-by/after")
    public ResponseEntity<?> getAllAfter(@Valid VersesAfterReq req) {

        LOG.info("Rest request to get all surah id: {} verses after id: {}", req.getSurahId(), req.getIdAfter());
        return ResponseEntity.ok(verseDetailService.getVersesAfter(req));
    }

    @GetMapping("/list-as/page")
    public ResponseEntity<?> getAllAsPageable(@Valid VerseSurahReq req) {

        LOG.info("Rest request to get all verses as a Pageable surahId: {} langId: {} authorId: {}",
                req.getSurahId(), req.getLangId(), req.getAuthorId());
        return ResponseEntity.ok(verseDetailService.getAllAsPageable(req));
    }
}