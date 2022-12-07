package io.quran.db.entity;

import io.quran.db.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = ("surahs"))
public class Surah extends AbsEntity {

    @Column(name = ("name"))
    private String name;

    @Column(name = ("verse_count"))
    private Integer verseCount;

    @Column(name = ("order_number"))
    private Integer orderNumber;

    @Column(name = ("separator_arabic"))
    private String separatorArabic;

    @Column(name = ("updated_date"))
    private Instant updatedDate;
}
