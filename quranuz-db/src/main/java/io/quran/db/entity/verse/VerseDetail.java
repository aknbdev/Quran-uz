package io.quran.db.entity.verse;

import io.quran.db.entity.Language;
import io.quran.db.entity.template.AbsEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static org.hibernate.annotations.ResultCheckStyle.COUNT;

@Getter
@Setter
@Entity
@Table(name = "verse_details")
@Where(clause = "deleted = FALSE")
@SQLDelete(sql = "UPDATE verse_details SET deleted = TRUE WHERE id = ?", check = COUNT)
public class VerseDetail extends AbsEntity {

    @Column(name = "translation", columnDefinition = "text")
    private String translation;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "verse_id", insertable = false, updatable = false)
    private Verse verse;

    @Column(name = "verse_id")
    private Integer verseId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "language_id", insertable = false, updatable = false)
    private Language language;

    @Column(name = "language_id")
    private Integer languageId;
}