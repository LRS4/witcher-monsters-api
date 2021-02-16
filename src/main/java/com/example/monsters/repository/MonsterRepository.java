package com.example.monsters.repository;

import com.example.monsters.model.Monster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Long> {

    @Query("SELECT m FROM Monster m WHERE m.name = ?1")
    Optional<Monster> findMonsterByName(String name);

    List<Monster> findByCategoryId(Long categoryId);

    List<Monster> findByCategoryName(String categoryName);
}
