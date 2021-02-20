package com.example.monsters.service;

import com.example.monsters.model.Category;
import com.example.monsters.model.Monster;
import com.example.monsters.repository.CategoryRepository;
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

    //region Private properties

    @Value("${MONSTERS_API_ADMIN_KEY}")
    private String apiAdminKey;

    private final MonsterRepository monsterRepository;
    private final CategoryRepository categoryRepository;

    //endregion

    //region Constructor

    @Autowired
    public MonsterService(MonsterRepository monsterRepository,
                          CategoryRepository categoryRepository) {
        this.monsterRepository = monsterRepository;
        this.categoryRepository = categoryRepository;
    }

    //endregion

    //region Service methods

    public List<Monster> getMonsters() {
        return monsterRepository.findAll();
    }

    public List<Monster> getMonstersByCategoryName(String categoryName) {
        return monsterRepository.findByCategoryName(categoryName);
    }

    public Optional<Monster> getMonsterByName(String monsterName) {
        Optional<Monster> monster = monsterRepository
                .findMonsterByName(monsterName);

        if (monster.isEmpty()) {
            throw new IllegalStateException("Monster with name " +
                    monsterName +
                    " does not exist.");
        }

        return monster;
    }

    public String addNewMonster(Monster monster,
                                String categoryName,
                                String apiKey) {
        if (apiKey == null) {
            return "Admin API key must be provided.";
        }

        if (apiKey.equals(apiAdminKey)) {
            checkIfMonsterAlreadyExists(monster);
            Category monsterCategory = getMonsterCategory(categoryName);
            monster.setCategory(monsterCategory);

            monsterRepository.save(monster);
            return String.format("Monster (%s) added.", monster.getDisplayName());
        } else {
            return "Admin API key is invalid.";
        }
    }

    public String deleteMonster(Long monsterId,
                                String apiKey) {
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
    public String updateMonster(Long monsterId,
                                Long categoryId,
                                Monster updatedMonster,
                                String apiKey) {
        if (apiKey == null) {
            return "Admin API key must be provided.";
        }

        if (apiKey.equals(apiAdminKey)) {
            Monster monster = monsterRepository.findById(monsterId)
                .orElseThrow(() -> new IllegalStateException((
                        "Monster with ID " + monsterId + " does not exist.")));

            applyUpdatesToMonster(updatedMonster, monster, categoryId);

            return "Monster with ID " + monsterId + " updated.";
        } else {
            return "Admin API key is invalid.";
        }
    }

    public List<Category> getMonsterCategories() {
        return categoryRepository.findAll();
    }

    //endregion

    //region Private methods

    private void applyUpdatesToMonster(Monster updatedMonster,
                                       Monster monster,
                                       Long categoryId) {
        if (categoryId != null) {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new IllegalStateException((
                            "Category with ID " + categoryId + " does not exist.")));

            if (!Objects.equals(monster.getCategory(), category)) {
                monster.setCategory(category);
            }
        }

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

    private void checkIfMonsterAlreadyExists(Monster monster) {
        Optional<Monster> monsterByName = monsterRepository
                .findMonsterByName(monster.getName());

        Optional<Monster> monsterByDisplayName = monsterRepository
                .findMonsterByDisplayName(monster.getDisplayName());

        if (monsterByName.isPresent() || monsterByDisplayName.isPresent()) {
            throw new IllegalStateException("Monster already exists.");
        }
    }

    private Category getMonsterCategory(String categoryName) {
        Category monsterCategory = categoryRepository
                .findCategoryByName(categoryName);

        if (monsterCategory == null) {
            throw new IllegalStateException(
                    "Category with name " + categoryName + " is invalid. " +
                    "/api/v1/monster/categories/all returns valid category names.");
        }

        return monsterCategory;
    }

    //endregion
}
