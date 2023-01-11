package io.quran.app.service;
import java.util.List;
import io.quran.app.payload.author.AuthorDto;
import io.quran.core.enums.AuthorType;

public interface AuthorService {

    List<AuthorDto> listByAuthorType(AuthorType authorType);
}