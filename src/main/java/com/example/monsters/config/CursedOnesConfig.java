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
public class CursedOnesConfig {

    @Bean
    CommandLineRunner cursedOnesCommandLineRunner(MonsterRepository repository) {
        return args -> {
            Category cursedOnes = new Category("cursedones", "Cursed Ones");

            Monster archespores = new Monster(
                    "archespores",
                    "Archespores",
                    "Looks like a flower to me. A hideous, disgusting flower.\n" +
                            "– Blasco Tennerbe, last words\n" +
                            "Archespores look like gigantic, aesthetically unpleasing flowers with some of the traits of exceptionally cruel and bloodthirsty sundews. They are, however, far more dangerous that even the most colossal sundew. Their peculiar appearance makes them practically impossible to discern amidsts other plants. By the time one draws close enough to realize what they are, it is often too late to flee.\n" +
                            "According to popular belief, archespores are cursed plants grown in soil fertilized by the blood of the dying. They are most often found in places which in the past saw pogroms, bloody rituals or cruel murders Four types of archespore have been catalogued to date, differing from one another in terms of coloring: brown (the least dangerous), green and purple (the most dangerous). The final variant, said to have been cultivated by mages from Ban Ard, is the yellow archespore, whose strength is similar to that of its green-colored-cousins.\n" +
                            "Regardless of color, all archespores fight using similar methods: attacking with powerful, jaw-like leaves. If their victim is out of reach, they can also spray caustic acid which if it makes any contact whatsoever with the skin, can provoke a reaction similar to that caused by severe poisoning.\n" +
                            "Like other plants, all archespores are extremely vulnerable to fire, which is one of the most effective methods of fighting them. Silver also works well, as does any sort of shock wave. Archespores do not like strong vibrations, which cause them to flee underground at once. Due to the nature of their origins, oil damaging to cursed beings can also be useful against them.",
                    "https://static.wikia.nocookie.net/witcher/images/c/cd/Tw3_journal_echinops.png/revision/latest/scale-to-width-down/654?cb=20160605082337",
                    "Toussaint",
                    "Cursed oil,Aard,Igni",
                    "Archespore juice,Archespore tendril,Green mutagen,Monster spore,Venom extract",
                    LocalDate.now(),
                    cursedOnes
            );

            Monster berserkers = new Monster(
                    "berserkers",
                    "Berserkers",
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
                    cursedOnes
            );

            repository.saveAll(
                    List.of(archespores,
                            berserkers)
            );
        };
    }
}
