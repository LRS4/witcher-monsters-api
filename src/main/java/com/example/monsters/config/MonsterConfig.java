package com.example.monsters.config;

import com.example.monsters.model.Monster;
import com.example.monsters.repository.MonsterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class MonsterConfig {

    @Bean
    CommandLineRunner commandLineRunner(MonsterRepository repository) {
        return args -> {
            Monster bear = new Monster(
                    "Bears",
                    "Know that ditty about the bear \"climbing the mountain, to see what he could see?\" Biggest load of rubbish I've ever heard. When a bear climbs a mountain, it's not to see. It's to hunt. To kill.\n" +
                            "– Jahne Oldak, royal huntsman\n\n" +
                            "Bears are omnivores – meaning men find a place in their diet beside berries, roots and salmon. When they snack on humans, they most frequently partake of the meat of travelers unwittingly trespassing on their territory, or else that of hunters for whom besting such a creature is a lifelong ambition.\n" +
                            "There are several subspecies of bears – black bears, polar bears and cave bears – which differ from one another in coloring as well as in size and strength. All share one trait in common, however: a near-unmatched ability to kill.",
                    "https://static.wikia.nocookie.net/witcher/images/0/07/Tw3_journal_bear.png/revision/latest?cb=20160304204324",
                    "Velen,Skellige,White Orchard,Toussaint",
                    "Beast oil,Quen",
                    "Bear fat,Bear hide,Raw meat,White bear hide",
                    LocalDate.now(),
                    1
            );

            Monster panther = new Monster(
                    "Panthers",
                    "Pussy cat, pussy cat, where have you been?\nI've been to Cintra to look at the queen\n" +
                            "Pussy cat, pussy cat, what did you there?\n" +
                            "Run, fool, that's not a cat but a panther!\n" +
                            "– rare variant of a traditional folk rhyme\n\n" +
                            "Panthers are dangerous predators found in forests and other woodlands. They are quick, agile and, like all cats, diabolically cunning. In many less-than-thoroughly-urbanized areas, folk still believe panthers are the stranded souls of those who die in their sleep. Superstition thus holds anyone perishing in this way should be dragged to the nearest woods and left there without a burial. The panther-spirit of the deceased may then devour its own body, thereby passing on to the nether realms.\n" +
                            "This belief must be eradicated by any means, for it leads to epidemics of cholera and other contagious diseases born of rotting corpses.\n" +
                            "Besides, it is patently ridiculous, given panthers are not necrophages and will not consume carrion of any sort. They prefer more spry and lively prey, such as deer or even humans, provided they are not ill and do not stink too badly.\n" +
                            "Panthers (and their tawny-coated cousins, mountain lions) are incredibly swift and able to sneak up on prey undetected to gain the advantage of surprise.\n" +
                            "As soon as they enter open terrain, they leap to attack with astonishing speed, mauling their prey with their sharp claws, long teeth and the sheer force of their momentum.\n" +
                            "Panthers are known to retreat mid-fight, yet do not let yourself be fooled into a false sense of security. This is but a ruse to allow them to attack again, by surprise. Never drop your guard until you see the animal drop dead.\n\n" +
                            "Panthers are vulnerable to the effects of all the Signs, as well as bombs and oils.",
                    "https://static.wikia.nocookie.net/witcher/images/d/da/Tw3_journal_panther.png/revision/latest/scale-to-width-down/350?cb=20160531173331",
                    "Toussaint",
                    "Beast oil",
                    "Fur scrap,Cured leather,Raw meat",
                    LocalDate.now(),
                    1
            );

            repository.saveAll(
                    List.of(bear,
                            panther)
            );
        };
    }
}
