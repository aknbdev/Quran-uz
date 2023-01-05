package io.quran.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.quran.db.entity.template.AbsEntity;
import org.hibernate.annotations.ResultCheckStyle;
import javax.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "languages")
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE languages SET deleted = TRUE WHERE id = ?",  check = ResultCheckStyle.COUNT)
public class Language extends AbsEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;
}