package io.quran.db.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import io.quran.db.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
    
    @Query(value = "SELECT * FROM authors WHERE type = ?1", nativeQuery = true)
    List<Author> findAllByType(String type);
}