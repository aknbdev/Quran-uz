package io.quran.app.entity;

import io.quran.app.entity.template.AbsEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends AbsEntity {

    private String firstname;

    private String lastname;

    private String username;

    private String password;

    private String email;
}
