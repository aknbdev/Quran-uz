package io.quran.db.repository.verse;

import io.quran.db.entity.verse.VerseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerseDetailRepository extends JpaRepository<VerseDetail, Integer> {
    @Query(value = "select * from verse_details v where v.verse_id in (?1) order by v.verse_id", nativeQuery = true)
    List<VerseDetail> findAllByVerseIdIn(List<Integer> verseIds);
}