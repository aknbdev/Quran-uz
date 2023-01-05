package io.quran.db.entity;

import io.quran.db.entity.template.AbsEntity;
import lombok.*;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = ("juz"))
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE verses SET deleted = TRUE WHERE id = ?",  check = ResultCheckStyle.COUNT)
public class Juz extends AbsEntity {

    @Column(name = "juz_number")
    private Integer juzNumber;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "surah_id", insertable = false, updatable = false)
//    private Surah surah;

    @Column(name = "surah_order_number")
    private Integer surahOrderNumber;

    @Column(name = "verses_order_number")
    private String versesOrderNumber;

    @Column(name = "verses_count")
    private Integer versesCount;
}
