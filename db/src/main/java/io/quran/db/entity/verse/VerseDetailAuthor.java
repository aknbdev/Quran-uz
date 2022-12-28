package io.quran.db.entity.verse;

import io.quran.db.entity.Author;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "verse_details_authors")
public class VerseDetailAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private Author author;

    @Column(name = "author_id")
    private Integer authorId;

    @ManyToOne
    @JoinColumn(name = "user_detail_id", updatable = false, insertable = false)
    private VerseDetail verseDetail;

    @Column(name = "verse_detail_id")
    private Integer verseDetailId;
}
