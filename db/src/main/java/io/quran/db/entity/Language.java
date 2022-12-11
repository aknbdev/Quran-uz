package io.quran.db.entity;

<<<<<<< HEAD

import io.quran.db.entity.template.AbsEntity;
=======
import com.fasterxml.jackson.annotation.JsonFormat;
>>>>>>> origin/main
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
<<<<<<< HEAD
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
=======
import javax.persistence.*;
import java.time.Instant;
>>>>>>> origin/main

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
<<<<<<< HEAD
@Entity(name = ("languages"))
public class Language extends AbsEntity {

    @Column(name = ("name"))
    private String name;

    @Column(name = ("code"))
    private String code;
}

=======
@Entity(name = "languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;
}
>>>>>>> origin/main
