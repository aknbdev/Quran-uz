package io.quran.db.entity.verse;

import io.quran.db.entity.Surah;
import io.quran.db.entity.template.AbsEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "verses")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE verses SET deleted = TRUE WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Verse extends AbsEntity {

    @Column(name = "arabic", columnDefinition = "text")
    private String arabic;

    @Column(name = "verse_key")
    private String verseKey;

    @Column(name = "juz_number")
    private Integer juzNumber;

    @Column(name = "order_number")
    private Integer orderNumber;

    @Column(name = "page_number")
    private Integer pageNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surah_id", insertable = false, updatable = false)
    private Surah surah;

    @Column(name = "surah_id")
    private Integer surahId;

    public Verse(String verseKey, String arabic) {
        this.arabic = arabic;
        this.verseKey = verseKey;
    }

    public Verse(Integer juzNumber, Integer orderNumber, Integer pageNumber, Integer surahId) {
        this.juzNumber = juzNumber;
        this.orderNumber = orderNumber;
        this.pageNumber = pageNumber;
        this.surahId = surahId;
    }
}