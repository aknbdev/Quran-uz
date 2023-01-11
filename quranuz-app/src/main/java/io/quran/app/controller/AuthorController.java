package io.quran.app.controller;
import io.quran.app.payload.author.AuthorDto;
import io.quran.core.enums.AuthorType;
import io.quran.db.repository.AuthorRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.quran.app.config.ApiConfig;
import io.quran.app.service.AuthorService;

import java.util.List;

@RestController
@Tag(name = "Author APIs")
@RequestMapping(ApiConfig.AUTHOR_API)
public class AuthorController {
    
    private final Logger LOG = LoggerFactory.getLogger(AuthorController.class);
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping
    public ResponseEntity<List<AuthorDto>> authors(AuthorType authorType) {
        LOG.info("Rest request in Author get: {}", authorType);
        return ResponseEntity.ok(authorService.listByAuthorType(authorType));
    }
}
