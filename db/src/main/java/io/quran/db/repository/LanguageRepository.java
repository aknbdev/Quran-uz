package io.quran.db.repository;

import io.quran.db.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
    @Query("select l from languages l where l.name = ?1")
    Optional<Language> findByName(String name);
}
