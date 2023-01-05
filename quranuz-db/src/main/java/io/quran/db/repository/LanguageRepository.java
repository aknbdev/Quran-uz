package io.quran.db.repository;

import io.quran.db.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
    // @Query("select l from languages l where l.code = ?1")
    // Optional<Language> findByCode(String code);
}
