package io.quran.db.entity.verse;

import io.quran.db.entity.Language;
import io.quran.db.entity.template.AbsEntity;
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
@SQLDelete(sql = "UPDATE verse_details SET deleted = TRUE WHERE id = ?", check = ResultCheckStyle.COUNT)
public class VerseDetail extends AbsEntity {

    @Column(name = "translation")
    private String translation;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "verse_id", insertable = false, updatable = false)
    private Verse verse;

    @Column(name = "verse_id")
    private Integer verseId;

    @ManyToOne
    @JoinColumn(name = "language_id", insertable = false, updatable = false)
    private Language language;

    @Column(name = "language_id")
    private Integer languageId;
}