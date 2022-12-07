package io.quran.db.repository;

import io.quran.db.entity.Surah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurahRepository extends JpaRepository<Surah, Integer> {

}
