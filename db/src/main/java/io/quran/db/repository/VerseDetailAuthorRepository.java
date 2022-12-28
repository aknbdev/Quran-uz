package io.quran.db.repository;

import io.quran.db.entity.verse.VerseDetailAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerseDetailAuthorRepository extends JpaRepository<VerseDetailAuthor, Integer> {
}