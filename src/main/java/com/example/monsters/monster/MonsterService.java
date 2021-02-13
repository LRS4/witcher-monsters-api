package com.example.monsters.monster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public String addNewMonster(Monster monster, String apiKey) {
        if (apiKey == null) {
            return "Admin API key must be provided.";
        }

        if (apiKey.equals(apiAdminKey)) {
            System.out.println(monster);
            return "Monster added.";
        } else {
            return "Admin API key is invalid.";
        }
    }
}
