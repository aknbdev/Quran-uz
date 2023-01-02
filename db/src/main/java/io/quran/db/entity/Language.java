package io.quran.db.entity;

import io.quran.db.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "languages")
public class Language extends AbsEntity {

    public Language(Integer id){
        super.setId(id);
    }

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;
}
