package io.quran.app.mapper;
import org.mapstruct.Mapper;
import io.quran.app.payload.author.AuthorDto;
import io.quran.db.entity.Author;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    
    
    Author toAuthor(AuthorDto dto);

    AuthorDto toAuthorDto(Author author);
}