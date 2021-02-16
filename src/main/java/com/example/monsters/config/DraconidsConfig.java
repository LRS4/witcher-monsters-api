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
public class DraconidsConfig {
    @Bean
    CommandLineRunner draconidsCommandLineRunner(MonsterRepository repository) {
        return args -> {
            Category draconids = new Category("draconids", "Draconids");

            Monster basilisks = new Monster(
                    "basilisks",
                    "Basilisks",
                    "In memory of the noble knight Roderick, slain during a valiant struggle against a basilisk. Let's hope the beast choked on his bones.\n" +
                            "– Gravestone inscription, Vizima cemetery.\n" +
                            "Contrary to popular belief, basilisks cannot turn anything to stone with their gaze. That is small comfort, however, given that their acid, venom, claws and teeth provide them many other ways to kill.\nBasilisks love dark, damp places such as cellars, caves and city sewers. They hunt by day, waiting patiently in hiding for their prey to come, then jump out in a flash to unleash a deadly attack.\n" +
                            "When preparing to fight such a creature one should drink Golden Oriole, which will provide resistance to its venom, and also prepare Dancing Star or shrapnel bombs, which work particularly well against basilisks.\nBasilisk leather is a highly-valued material used to make fashionable shoes and women's handbags. For this reason many men, their courage girded by goldlust, take to hunting them. Most of these hunts end in disaster, " +
                            "but some do manage to bag their prey, which has led to a drastic decline in this creature's numbers in recent years. " +
                            "Some mages and druids are of the opinion that basilisks should be included in programs meant to safeguard dying species. Everyone else thinks those mages and druids have gone completely mad.",
                    "https://static.wikia.nocookie.net/witcher/images/b/bc/Tw3_journal_basilisk.png/revision/latest/scale-to-width-down/350?cb=20160408164921",
                    "Velen",
                    "Golden Oriole,Grapeshot,Draconid oil,Aard",
                    "Basilisk venom,Basilisk hide,Basilisk mutagen",
                    LocalDate.now(),
                    draconids
            );



            repository.saveAll(
                    List.of(basilisks)
            );
        };
    }
}