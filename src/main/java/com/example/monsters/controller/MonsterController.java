package com.example.monsters.controller;

import com.example.monsters.model.Category;
import com.example.monsters.model.Monster;
import com.example.monsters.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/monster")
public class MonsterController {

    //region Private properties

    private final MonsterService monsterService;

    //endregion

    //region Constructor

    @Autowired
    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    //endregion

    //region Routes

    @GetMapping
    public List<Monster> getMonsters() {
        return monsterService.getMonsters();
    }

    @GetMapping(path = "/category/{categoryName}")
    public List<Monster> getMonstersByCategory(@PathVariable("categoryName") String categoryName) {
        return monsterService.getMonstersByCategoryName(categoryName);
    }

    @GetMapping(path = "/{monsterName}")
    public Optional<Monster> getMonster(@PathVariable("monsterName") String monsterName) {
        return monsterService.getMonsterByName(monsterName);
    }

    @GetMapping(path = "/categories/all")
    public List<Category> getMonsterCategories() {
        return monsterService.getMonsterCategories();
    }

    @PostMapping(path = "/category/{categoryName}")
    public String addNewMonster(@RequestBody Monster monster,
                                @PathVariable("categoryName") String categoryName,
                                @RequestHeader(value="x-api-key", required=false) String apiKey) {
        return monsterService.addNewMonster(monster, categoryName, apiKey);
    }

    @DeleteMapping(path = "{monsterId}")
    public String deleteMonster(@PathVariable("monsterId") Long monsterId,
                                @RequestHeader(value="x-api-key", required=false) String apiKey) {
        return monsterService.deleteMonster(monsterId, apiKey);
    }

    @PutMapping(path = "{monsterId}/{categoryId}")
    public String updateMonster(@PathVariable("monsterId") Long monsterId,
                                @PathVariable(value = "categoryId", required = false) Long categoryId,
                                @RequestBody Monster updatedMonster,
                                @RequestHeader(value="x-api-key", required=false) String apiKey) {
        return monsterService.updateMonster(monsterId, categoryId, updatedMonster, apiKey);
    }

    //endregion
}
