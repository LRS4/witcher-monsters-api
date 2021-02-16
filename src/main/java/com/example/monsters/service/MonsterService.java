package com.example.monsters.service;

import com.example.monsters.model.Monster;
import com.example.monsters.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.example.monsters.util.StringUtils.capitalise;

@Service
public class MonsterService {

    @Value("${MONSTERS_API_ADMIN_KEY}")
    private String apiAdminKey;

    private final MonsterRepository monsterRepository;

    @Autowired
    public MonsterService(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    public List<Monster> getMonsters() {
        return monsterRepository.findAll();
    }

    public List<Monster> getMonstersByCategoryName(String categoryName) {
        return monsterRepository.findByCategoryName(capitalise(categoryName));
    }

    public Optional<Monster> getMonsterByName(String monsterName) {
        Optional<Monster> monster = monsterRepository
                .findMonsterByName(capitalise(monsterName));

        if (monster.isEmpty()) {
            throw new IllegalStateException("Monster with name " +
                    monsterName +
                    " does not exist.");
        }

        return monster;
    }

    public String addNewMonster(Monster monster, String apiKey) {
        if (apiKey == null) {
            return "Admin API key must be provided.";
        }

        if (apiKey.equals(apiAdminKey)) {
            String monsterName = monster.getName();
            Optional<Monster> monsterOptional = monsterRepository
                    .findMonsterByName(monsterName);

            if (monsterOptional.isPresent()) {
                throw new IllegalStateException("Monster already exists.");
            }

            monsterRepository.save(monster);

            return String.format("Monster (%s) added.", monsterName);
        } else {
            return "Admin API key is invalid.";
        }
    }

    public String deleteMonster(Long monsterId, String apiKey) {
        if (apiKey == null) {
            return "Admin API key must be provided.";
        }

        if (apiKey.equals(apiAdminKey)) {
            boolean monsterExists = monsterRepository.existsById(monsterId);

            if (!monsterExists) {
                throw new IllegalStateException(
                        "Monster with ID " + monsterId + " does not exist.");
            }

            monsterRepository.deleteById(monsterId);

            return "Monster with ID " + monsterId + " deleted.";
        } else {
            return "Admin API key is invalid.";
        }
    }

    @Transactional
    public String updateMonster(Long monsterId, Monster updatedMonster, String apiKey) {
        if (apiKey == null) {
            return "Admin API key must be provided.";
        }

        if (apiKey.equals(apiAdminKey)) {
            Monster monster = monsterRepository.findById(monsterId)
                .orElseThrow(() -> new IllegalStateException((
                        "Monster with ID " + monsterId + " does not exist.")));

            applyUpdatesToMonster(updatedMonster, monster);

            return "Monster with ID " + monsterId + " updated.";
        } else {
            return "Admin API key is invalid.";
        }
    }

    private void applyUpdatesToMonster(Monster updatedMonster, Monster monster) {
        if (updatedMonster.getName() != null &&
                updatedMonster.getName().length() > 0 &&
                !Objects.equals(updatedMonster.getName(), monster.getName())) {
            monster.setName(updatedMonster.getName());
        }

        if (updatedMonster.getEntry() != null &&
                updatedMonster.getEntry().length() > 0 &&
                !Objects.equals(updatedMonster.getEntry(), monster.getEntry())) {
            monster.setEntry(updatedMonster.getEntry());
        }

        if (updatedMonster.getImageUrl() != null &&
                updatedMonster.getImageUrl().length() > 0 &&
                !Objects.equals(updatedMonster.getImageUrl(), monster.getImageUrl())) {
            monster.setImageUrl(updatedMonster.getImageUrl());
        }

        if (updatedMonster.getOccurrence() != null &&
                updatedMonster.getOccurrence().length() > 0 &&
                !Objects.equals(updatedMonster.getOccurrence(), monster.getOccurrence())) {
            monster.setOccurrence(updatedMonster.getOccurrence());
        }

        if (updatedMonster.getSusceptibility() != null &&
                updatedMonster.getSusceptibility().length() > 0 &&
                !Objects.equals(updatedMonster.getSusceptibility(), monster.getSusceptibility())) {
            monster.setSusceptibility(updatedMonster.getSusceptibility());
        }

        if (updatedMonster.getLoot() != null &&
                updatedMonster.getLoot().length() > 0 &&
                !Objects.equals(updatedMonster.getLoot(), monster.getLoot())) {
            monster.setLoot(updatedMonster.getLoot());
        }
    }
}
