package io.quran.db.entity;

import io.quran.db.entity.template.AbsEntity;
import jdk.jfr.Name;
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
@Table(name = ("surah_details"))
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE verses SET deleted = TRUE WHERE id = ?",  check = ResultCheckStyle.COUNT)
@NamedEntityGraph(name = "surah_detail_entity_graph", attributeNodes = @NamedAttributeNode("surah"))
public class SurahDetail extends AbsEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "surah_id", insertable = false, updatable = false)
    private Surah surah;

    @Column(name = "surah_id")
    private Integer surahId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", insertable = false, updatable = false)
    private Language language;

    @Column(name = "language_id")
    private Integer languageId;

    @Column(name = "surah_name")
    private String surahName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", insertable = false, updatable = false)
    private Location location;

    @Column(name = ("location_id"))
    private Integer locationId;

}

