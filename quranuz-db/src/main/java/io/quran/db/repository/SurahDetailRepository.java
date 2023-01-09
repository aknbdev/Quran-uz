package io.quran.db.repository;

import io.quran.db.entity.SurahDetail;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurahDetailRepository
        extends JpaRepository<SurahDetail, Integer>, JpaSpecificationExecutor<SurahDetail> {

    Optional<SurahDetail> findBySurahIdAndLanguageId(Integer surahId, Integer languageId);

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "surah_detail_entity_graph")
    List<SurahDetail> findAllByLanguageIdOrderByIdAsc(Integer languageId);

}
