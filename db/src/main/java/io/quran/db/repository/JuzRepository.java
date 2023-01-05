package io.quran.db.repository;

import io.quran.db.entity.Juz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JuzRepository extends JpaRepository<Juz, Integer> {
    @Query(value = "select * from juz where deleted = false order by id", nativeQuery = true)
    List<Juz> findAll();
}
