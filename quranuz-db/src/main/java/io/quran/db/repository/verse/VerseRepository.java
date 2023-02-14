package io.quran.db.repository.verse;

import io.quran.db.entity.Verse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerseRepository extends JpaRepository<Verse, Integer> {
    @Query("SELECT v, vd FROM Verse v INNER JOIN VerseDetail vd ON vd.verseId = v.id AND vd.languageId = :langId WHERE v.surahId = :surahId")
    List<Verse> findByIdAndLangId(@Param("surahId") Long surahId, @Param("langId") Long langId);

    @Query("select v from Verse v where v.surahId = ?1 ORDER BY v.id")
    List<Verse> findAllBySurahId(Integer surahId);

    @Query("SELECT v FROM Verse v WHERE v.surahId = ?1 AND v.orderNumber >= ?2 AND v.orderNumber <= ?3 ORDER BY v.id")
    List<Verse> findBySurahIdAndOrderNumberRange(Integer surahId, Integer begin, Integer end);

    @Query("select v from Verse v where v.surahId = ?1 and v.orderNumber > ?2")
    List<Verse> findBySurahIdAndOrderNumberGreaterThan(Integer surahId, Integer idAfter);
}