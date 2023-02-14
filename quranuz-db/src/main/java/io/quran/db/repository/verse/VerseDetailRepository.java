package io.quran.db.repository.verse;

import io.quran.db.entity.VerseDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerseDetailRepository extends JpaRepository<VerseDetail, Integer> {
    @Query("""
            SELECT vd
            FROM VerseDetail vd
            WHERE vd.verseId
            IN (?1)
            AND vd.authorId = ?2
            AND vd.languageId = ?3
            AND vd.deleted = false
            ORDER BY vd.verse.orderNumber""")
    List<VerseDetail> findAllByVerseIdInAndAuthorId(List<Integer> verseIds, Integer authorId, Integer langId);


    @Query(value = """
            SELECT *
            FROM verse_details vd
            INNER JOIN verses v on v.id = vd.verse_id
            WHERE v.surah_id = ?1
            AND vd.author_id = ?2
            AND vd.language_id = ?3
            AND vd.deleted = false
            ORDER BY v.order_number""", nativeQuery = true)
    List<VerseDetail> findAllByVerseSurahIdAndAndAuthorIdAndLanguageId(Integer surahId, Integer authorId, Integer langId);

    @Query(value = """
            SELECT *
            FROM verse_details vd
            INNER JOIN verses v ON v.id = vd.verse_id
            WHERE v.surah_id = ?1
            AND vd.author_id = ?2
            AND vd.language_id = ?3
            AND v.deleted = FALSE""", nativeQuery = true)
    Page<VerseDetail> findAllByVerseSurahIdAndAndAuthorIdAndLanguageId(Integer surahId, Integer authorId, Integer langId, Pageable pageable);

    @Query(value = """
            SELECT *
            FROM verse_details vd
            INNER JOIN verses v on vd.verse_id = v.id
            WHERE v.surah_id = ?1
            AND v.order_number >= ?2
            AND v.order_number <= ?3
            AND vd.author_id = ?4
            AND vd.language_id = ?5
            AND vd.deleted = false
            ORDER BY v.order_number""", nativeQuery = true)
    List<VerseDetail> findBySurahIdAndOrderNumberRange(Integer surahId, Integer begin, Integer end, Integer authorId, Integer langId);

    @Query(value = """
            SELECT *
            FROM verse_details vd
            INNER JOIN verses v on v.id = vd.verse_id
            WHERE v.surah_id = ?1
            AND v.order_number > ?2
            AND vd.author_id = ?3
            AND vd.language_id = ?4
            AND vd.deleted = false
            ORDER BY v.order_number""", nativeQuery = true)
    List<VerseDetail> findBySurahIdAndOrderNumberGreaterThan(Integer surahId, Integer idAfter, Integer authorId, Integer langId);
}