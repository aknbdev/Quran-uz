package io.quran.db.entity;

import io.quran.db.entity.template.AbsEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Where(clause = "deleted=false")
@SQLDelete(sql = "update users set deleted=true where id =?")
public class User extends AbsEntity {

    private String firstname;

    private String lastname;

    private String username;

    private String password;

    private String email;
}
