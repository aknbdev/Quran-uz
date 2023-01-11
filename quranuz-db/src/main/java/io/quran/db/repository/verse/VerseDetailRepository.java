package io.quran.db.repository.verse;

import io.quran.db.entity.verse.VerseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerseDetailRepository extends JpaRepository<VerseDetail, Integer> {
    @Query(value = "select * from verse_details v where v.verse_id in (?1) and v.author_id = ?2 and v.language_id = ?3 order by v.verse_id", nativeQuery = true)
    List<VerseDetail> findAllByVerseIdInAndAuthorId(List<Integer> verseIds, Integer authorId, Integer langId);
}