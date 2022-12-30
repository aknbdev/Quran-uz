package io.quran.db.repository;

import io.quran.db.entity.SurahDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurahDetailRepository extends JpaRepository<SurahDetail, Integer> {

    Optional<SurahDetail> findBySurahIdAndLanguageId(Integer surahId, Integer languageId);

    List<SurahDetail> findAllByLanguageId(Integer languageId);

}
