package io.quran.app.service.impl;

import io.quran.app.mapper.AuthorMapper;
import io.quran.app.payload.author.AuthorDto;
import io.quran.app.service.AuthorService;
import io.quran.core.enums.AuthorType;
import io.quran.core.response.ApiResult;
import io.quran.db.entity.Author;
import io.quran.db.repository.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final Logger LOG = LoggerFactory.getLogger(AuthorServiceImpl.class);
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository,
                             AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public List<AuthorDto> listByAuthorType(AuthorType authorType) {

        return findAllAuthorsByType(authorType)
                .stream()
                .map(authorMapper::toAuthorDto)
                .collect(Collectors.toList());
    }

    // -> SECONDARY FUNCTIONS

    private List<Author> findAllAuthorsByType(AuthorType authorType) {
        List<Author> authors = authorRepository.findAllByType(authorType.name());
        if (authors.isEmpty()) {
            ApiResult.errorResponse("Authors not found", 404);
            LOG.error("Authors not found with this type: {}", authorType.name());
        }
        return authors;
    }
}
