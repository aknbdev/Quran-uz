package io.quran.db.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.quran.db.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = ("surah_details"))
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE verses SET deleted = TRUE WHERE id = ?",  check = ResultCheckStyle.COUNT)
public class SurahDetail extends AbsEntity {

    @ManyToOne
    @JoinColumn(name = ("surah_id"), insertable = false, updatable = false)
    private Surah surah;

    @Column(name = ("surah_id"))
    private Integer surahId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ("language_id"), insertable = false, updatable = false)
    private Language language;

    @Column(name = ("language_id"))
    private Integer languageId;

    @Column(name = ("surah_name"))
    private String surahName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ("location"), insertable = false, updatable = false)
    private Location location;

    @Column(name = ("location_id"))
    private Integer locationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ("separator_text"), insertable = false, updatable = false)
    private SeparatorText separatorText;

    @Column(name = ("separator_text_id"))
    private Integer separatorTextId;
}

