package io.quran.db.repository;

import io.quran.db.entity.VerseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface VerseDetailRepository extends JpaRepository<VerseDetail, Integer> {

//    @Query("select v from verse_details v where v.languageId = ?1 and v.updatedDate > ?2 ORDER BY v.verseDetailId ASC")
//    List<VerseDetail> findAllByUpdatedDateAfter(Integer languageId, Instant time);
//
//    @Query("select v from verse_details v where v.surahId = ?1 and v.languageId = ?2 and v.updatedDate > ?3")
//    List<VerseDetail> findAllBySurahIdAndUpdatedDateAfter(Integer surahId, Integer languageId, Instant time);
//
//    @Query("select v from verse_details v where v.surahId = ?1 and v.verseId = ?2 and v.languageId = ?3 and v.updatedDate > ?4")
//    Optional<VerseDetail> findBySurahIdAndVerseIdAndUpdatedDateAfter(Integer surahId, Integer verseId, Integer languageId, Instant time);
//
//    @Query("select v.translation from verse_details v where v.verseId >= ?1 and v.verseId <= ?2 and v.surahId = ?3 and v.languageId = ?4 order by v.verseId")
//    List<String> findAllVerseDetailByVerseIdAndSurahId(Integer min, Integer max, Integer surahId, Integer languageId);
}

// DEPRECATED CODES

//    @Query("select v from verse_details v where v.verseDetailId = ?1 and v.updatedDate > ?2")
//    Optional<VerseDetail> findByVerseDetailIdAndUpdatedDateAfter(Integer id, Instant time);