package io.quran.app.controller;

import io.quran.app.constants.ApiConstants;
import io.quran.app.payload.VerseDetailDto;
import io.quran.app.service.VerseDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping(ApiConstants.VERSE_DETAIL_API)
public class VerseDetailController {
    private final VerseDetailService verseDetailService;

    public VerseDetailController(VerseDetailService verseDetailService) {
        this.verseDetailService = verseDetailService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody VerseDetailDto dto) {
        verseDetailService.createVerseDetail(dto);
        return new ResponseEntity<>("Ok, Verse Detail created!", HttpStatus.CREATED);
    }

    @GetMapping("/by-surah-id-and-verse-id/{surah-id}/{verse-id}/{language-id}/{millisecond}")
    public ResponseEntity<?> getOneBySurahIdAndVerseId(@PathVariable("surah-id") Integer surahId,
                                                       @PathVariable("verse-id") Integer verseId,
                                                       @PathVariable("language-id") Integer languageId,
                                                       @PathVariable("millisecond") long millisecond) {
        return ResponseEntity.ok(verseDetailService.getOneBySurahIdVerseId(surahId, verseId, languageId, millisecond));
    }

    @GetMapping("/get-all-by-surah-id/{surah-id}/{language-id}/{millisecond}")
    public ResponseEntity<?> getAllVerseDetailBySurahId(@PathVariable("surah-id") Integer surahId,
                                                        @PathVariable("language-id") Integer languageId,
                                                        @PathVariable("millisecond") long millisecond) {

        return ResponseEntity.ok(verseDetailService.getVerseDetailBySurahId(surahId, languageId, millisecond));
    }

    @GetMapping("/get-all/{language-id}/{millisecond}")
    public ResponseEntity<?> getAll(@PathVariable("language-id") Integer languageId,
                                    @PathVariable("millisecond") long millisecond) {
        return ResponseEntity.ok(verseDetailService.getAllVerseDetail(languageId, millisecond));
    }

    @PutMapping("/update/{verse-detail-id}")
    public ResponseEntity<?> update(@PathVariable("verse-detail-id") Integer id,
                                    @Valid @RequestBody VerseDetailDto dto) {
        verseDetailService.updateVerseDetail(id, dto);
        return ResponseEntity.ok("Ok, Verse Detail updated!");
    }
}
