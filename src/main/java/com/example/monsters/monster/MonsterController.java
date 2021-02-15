package com.example.monsters.monster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/monster")
public class MonsterController {

    private final MonsterService monsterService;

    @Autowired
    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @GetMapping
    public List<Monster> getMonsters() {
        return monsterService.getMonsters();
    }

    @PostMapping
    public String addNewMonster(@RequestBody Monster monster,
                                @RequestHeader(value="x-api-key", required=false) String apiKey) {
        return monsterService.addNewMonster(monster, apiKey);
    }

    @DeleteMapping(path = "{monsterId}")
    public String deleteMonster(@PathVariable("monsterId") Long monsterId,
                                @RequestHeader(value="x-api-key", required=false) String apiKey) {
        return monsterService.deleteMonster(monsterId, apiKey);
    }
}
