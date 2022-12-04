package io.quran.app.repository;

import io.quran.app.entity.Surah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface SurahRepository extends JpaRepository<Surah, Integer> {

}
