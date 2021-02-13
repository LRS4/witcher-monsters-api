package com.example.monsters.monster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}
