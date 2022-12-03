package io.quran.app.entity.template;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class AbsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Timestamp createdAt;//OBJECT YANGI OCHIGANDA ISHLATILADI

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;//OBJECT O'ZGARGANDA ISHLAYDI

}
