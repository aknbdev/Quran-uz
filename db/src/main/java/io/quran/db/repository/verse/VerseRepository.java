package io.quran.db.repository.verse;

import io.quran.db.entity.verse.Verse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerseRepository extends JpaRepository<Verse, Integer> {

//    @Query("select v from verses v where v.updatedDate > ?1 order by v.verseId asc")
//    List<Verse> findAllByUpdatedDateAfter(Instant time);
//
//    @Query("select v from verses v where v.surahId = ?1 and v.updatedDate > ?2 order by v.verseId asc")
//    List<Verse> findAllBySurahIdAndUpdatedDateAfter(Integer id, Instant time);
//
//    @Query(value = "select * from verses as v where v.juz_id = :juzId and v.updated_date > :time order by v.verse_id", nativeQuery = true)
//    List<Verse> getAllByJuzId(@Param("juzId") int juzId, @Param("time") Instant time);
//
//    @Query(value = "select * from verses as v where v.verse_id in (:versesId) and v.updated_date > :time order by v.verse_id", nativeQuery = true)
//    List<Verse> getAllByJuzId(@Param("versesId") int[] versesId, @Param("time") Instant time);
}


// DEPRECATED CODES


//    @Query("select v from verses v where v.verseId = ?1 and v.updatedDate > ?2")
//    Optional<Verse> findByVerseIdAndUpdatedDateAfter(Integer id, Instant time);