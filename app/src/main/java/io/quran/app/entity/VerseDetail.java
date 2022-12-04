package io.quran.app.entity;

import io.quran.app.entity.template.AbsEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "verse_details")
@Where(clause = "deleted = FALSE")
@SQLDelete(sql = "UPDATE verse_details SET deleted = TRUE WHERE id = ?",  check = ResultCheckStyle.COUNT)
public class VerseDetail extends AbsEntity {

    @ManyToOne
    @JoinColumn(name = "verse_id", insertable = false, updatable = false)
    private Verse verse;

    @Column(name = "verse_id")
    private Integer verseId;

//    @ManyToOne
//    @JoinColumn(name = "language_id", insertable = false, updatable = false)
//    private Language language;

    @Column(name = "language_id")
    private Integer languageId;

//    @ManyToOne
//    @JoinColumn(name = "surah_id", insertable = false, updatable = false)
//    private Surah surah;

    @Column(name = "surah_id")
    private Integer surahId;

    @Column(name = "transcript")
    private String transcript;

    @Column(name = "translation")
    private String translation;

    @Column(name = "description")
    private String description;
}