package io.quran.db.entity;
import io.quran.core.enums.AuthorType;
import io.quran.db.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authors")
@Where(clause = "deleted = false")
public class Author extends AbsEntity {

    @Column(name = "full_name")
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private AuthorType type;
}