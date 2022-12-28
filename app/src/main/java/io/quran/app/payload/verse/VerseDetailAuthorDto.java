package io.quran.app.payload.verse;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.quran.db.entity.Author;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerseDetailAuthorDto {

    private Integer id;
    private Author author;
    private Integer authorId;
    private VerseDetailDto verseDetail;
    private Integer verseDetailId;
}
