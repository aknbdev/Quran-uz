package io.quran.db.repository;

import io.quran.db.entity.SeparatorText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeparatorTextRepository extends JpaRepository<SeparatorText, Integer> {
}
