package com.example.monsters.config;

import com.example.monsters.model.Category;
import com.example.monsters.model.Monster;
import com.example.monsters.repository.MonsterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class ElementaConfig {

    @Bean
    CommandLineRunner elementaCommandLineRunner(MonsterRepository repository) {
        return args -> {
            Category elementa = new Category("elementa", "Elementa");

            //region Populate monsters

            Monster iceElemental = new Monster(
                    "ice-elemental",
                    "Ice Elemental",
                    "I thought to myself - what's a hunk of ice doing in the middle of some lab? And then that hunk of ice got up and broke my legs.\n" +
                            "– Yannick Lovt, burglar\n" +
                            "An ice elemental is a mass of frozen water animated by magic. Deprived of consciousness or independent will, this elemental is boundlessly obedient to the orders of the mage who created it. Those orders usually contain but one syllable: kill.\n" +
                            "Ice elementals have no qualms about carrying out this order nor any particular difficulty in doing so. Gifted with incredible strength, they are completely invulnerable to poison and fire, deprived of sensitive organs, hard as permafrost and all in all incredibly difficult opponents. A witcher's only chance at tipping the scales towards victory is to toss a dimeritium bomb – shrapnel made of this metal interferes with the workings of the spell that gives this creature life. Beyond that remains only prayer.",
                    "https://static.wikia.nocookie.net/witcher/images/c/c6/Tw3_journal_iceelemental.png/revision/latest/scale-to-width-down/350?cb=20160409141539",
                    "Skellige",
                    "Dimeritium bomb,Elementa oil",
                    "Elemental essence",
                    LocalDate.now(),
                    elementa
            );

            //endregion

            repository.saveAll(
                    List.of(iceElemental)
            );
        };
    }
}
