package com.example.monsters.monster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/monster")
public class MonsterController {

    @Value("${MONSTERS_API_ADMIN_KEY}")
    private String apiAdminKey;

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
    public String addNewMonster(@RequestBody Monster monster, String apiKey) {
        if (apiKey.equals(apiAdminKey)) {
            return monsterService.addNewMonster(monster);
        } else {
            return "Admin API key is invalid.";
        }
    }
}
