package io.quran.db.repository.verse;

import io.quran.db.entity.verse.VerseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerseDetailRepository extends JpaRepository<VerseDetail, Integer> {
    @Query("select v from VerseDetail v where v.verseId in ?1 order by v.verseId")
    List<VerseDetail> findAllByVerseIdIn(List<Integer> verseIds);
}