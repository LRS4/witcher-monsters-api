package com.example.monsters.monster;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MonsterService {

    public List<Monster> getMonsters() {
        return List.of(
                new Monster(
                        "Bears",
                        "A bear",
                        "URL",
                        "Skellige",
                        "None",
                        "None",
                        LocalDate.now(),
                        1
                )
        );
    }

}
