package io.quran.app.controller;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.quran.app.config.ApiConfig;
import io.quran.app.service.AuthorService;

@RestController
@Tag(name = "Author APIs")
@RequestMapping(ApiConfig.AUTHOR_API)
public class AuthorController {
    
    private final Logger LOG = LoggerFactory.getLogger(AuthorController.class);
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/interpreters")
    public ResponseEntity<?> getInterpriters() {
        LOG.info("Rest request in AuthorController get interpreters");
        return ResponseEntity.ok(authorService.findAllInterpreters());
    }
    
    @GetMapping("/reciters")
    public ResponseEntity<?> getReciters() {
        LOG.info("Rest request in AuthorController get reciters");
        return ResponseEntity.ok(authorService.findAllReciters());
    }
}
