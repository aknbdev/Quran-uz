package io.quran.db.entity;

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
@Table(name = "verses")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE verses SET deleted = TRUE WHERE id = ?",  check = ResultCheckStyle.COUNT)
public class Verse extends AbsEntity {

//    @ManyToOne
//    @JoinColumn(name = "surah_id", insertable = false, updatable = false)
//    private Surah surah;

    @Column(name = "surah_id")
    private Integer surahId;

    @Column(name = "verse_text")
    private String verseText;

    @Column(name = "juz_id")
    private Integer juzId;

    @Column(name = "order_number")
    private Integer orderNumber;
}