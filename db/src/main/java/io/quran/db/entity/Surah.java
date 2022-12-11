package io.quran.db.entity;

import io.quran.db.entity.template.AbsEntity;
import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = ("surahs"))
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE verses SET deleted = TRUE WHERE id = ?",  check = ResultCheckStyle.COUNT)
public class Surah extends AbsEntity {

    @Column(name = ("name"))
    private String name;

    @Column(name = ("verse_count"))
    private Integer verseCount;

    @Column(name = ("order_number"))
    private Integer orderNumber;

}
