package io.quran.db.repository;

import io.quran.db.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
    @Query("select l from languages l where l.name = ?1")
    Optional<Language> findByName(String name);

    @Query(value = "select new io.quran.db.entity.Language(l.id) from languages l where l.code = ?1")
    Optional<Language> findByCode(String code);
}
