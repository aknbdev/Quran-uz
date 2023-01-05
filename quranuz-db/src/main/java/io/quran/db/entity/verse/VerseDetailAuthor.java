package io.quran.db.entity.verse;

import io.quran.db.entity.Author;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@Entity
@Table(name = "verse_details_authors")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE verse_details_authors SET deleted = TRUE WHERE id = ?", check = ResultCheckStyle.COUNT)
public class VerseDetailAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = LAZY)
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