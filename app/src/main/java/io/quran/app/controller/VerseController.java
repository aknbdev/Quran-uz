package io.quran.app.controller;

import io.quran.app.constants.ApiConstants;
import io.quran.app.payload.VerseDto;
import io.quran.app.service.VerseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(ApiConstants.VERSE_API)
public class VerseController {
    private final VerseService verseService;

    public VerseController(VerseService verseService) {
        this.verseService = verseService;
    }

    @PostMapping("/create")
    // TODO: 08/12/22
//    @ApiOperation(value = "Create new verse", notes = "Create new verse", response = String.class)
    public ResponseEntity<?> createVerse(@Valid @RequestBody VerseDto dto) {
        verseService.createVerse(dto);
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path(ApiConstants.VERSE_API + "/create")
                .toUriString());
        return ResponseEntity.created(uri).body("Ok, Verse created!");
    }


    @GetMapping("/surah-id/{id}/{millisecond}")
    public ResponseEntity<?> getAllBySurahId(@PathVariable("id") Integer id,
                                             @PathVariable long millisecond) {
        return ResponseEntity.ok(verseService.getAllBySurahId(id, millisecond));
    }

    @GetMapping("/by-juz-id/{juz-id}/{lang-id}/{millisecond}")
    public ResponseEntity<?> getAllByJuzId(@PathVariable("juz-id") Integer juzId,
                                           @PathVariable("lang-id") Integer languageId,
                                           @PathVariable("millisecond") long millisecond) {

        return ResponseEntity.ok(verseService.getAllByJuzId(juzId, languageId, millisecond));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateVerse(@PathVariable("id") Integer id,
                                         @Valid @RequestBody VerseDto dto) {
        verseService.updateVerse(id, dto);
        return ResponseEntity.ok("Ok, Updated!");
    }

    @GetMapping("/{millisecond}")
    public ResponseEntity<?> getAllVerses(@PathVariable long millisecond) {
        return ResponseEntity.ok(verseService.getAllVerses(millisecond));
    }
}


//    @GetMapping("/get-one/{verse-id}/{language-id}/{millisecond}")
//    public ResponseEntity<?> getVerseById(@PathVariable("verse-id") Integer verseId,
//                                          @PathVariable("language-id") Integer languageId,
//                                          @PathVariable long millisecond) {
//        return ResponseEntity.ok(verseService.getByVerseId(verseId, languageId, millisecond));
//    }


//    @GetMapping("/juz/{millisecond}")
//    public ResponseEntity<?> getAllVerseByJuz(@PathVariable long millisecond) {
//        return ResponseEntity.ok(verseService.getAllVerseByJuz(millisecond));
//    }