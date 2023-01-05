package io.quran.app.service;
import java.util.List;
import io.quran.app.payload.author.AuthorDto;

public interface AuthorService {
    
    List<AuthorDto> findAllInterpreters();
    List<AuthorDto> findAllReciters();
}