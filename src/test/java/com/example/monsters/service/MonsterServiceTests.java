package com.example.monsters.service;

import com.example.monsters.model.Category;
import com.example.monsters.model.Monster;
import com.example.monsters.repository.CategoryRepository;
import com.example.monsters.repository.MonsterRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
public class MonsterServiceTests {

    //region Mock dependencies

    @Autowired
    MonsterService monsterService;

    @MockBean
    MonsterRepository monsterRepository;

    @MockBean
    CategoryRepository categoryRepository;

    //endregion

    //region Private properties

    private static List<Monster> testMonsters = new ArrayList<>();

    @Value("${MONSTERS_API_ADMIN_KEY}")
    private String apiAdminKey;

    //endregion

    //region Setup

    @BeforeAll
    static void setUp() {
        //region Arrange

        Category beasts = new Category("beasts", "Beasts");

        Monster bear = new Monster(
                1L,
                "bears",
                "Bears",
                "Know that ditty about the bear \"climbing the mountain, to see what he could see?\" Biggest load of rubbish I've ever heard. When a bear climbs a mountain, it's not to see. It's to hunt. To kill.\n" +
                        "– Jahne Oldak, royal huntsman\n\n" +
                        "Bears are omnivores – meaning men find a place in their diet beside berries, roots and salmon. When they snack on humans, they most frequently partake of the meat of travelers unwittingly trespassing on their territory, or else that of hunters for whom besting such a creature is a lifelong ambition.\n" +
                        "There are several subspecies of bears – black bears, polar bears and cave bears – which differ from one another in coloring as well as in size and strength. All share one trait in common, however: a near-unmatched ability to kill.",
                "https://res.cloudinary.com/dayqxxsip/image/upload/v1613822220/App%20Images/Witcher%203%20Bestiary/Beasts/654_brssrh.png",
                "Velen,Skellige,White Orchard,Toussaint",
                "Beast oil,Quen",
                "Bear fat,Bear hide,Raw meat,White bear hide",
                LocalDate.now(),
                beasts
        );

        Monster panther = new Monster(
                2L,
                "panthers",
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
                "https://res.cloudinary.com/dayqxxsip/image/upload/v1613822259/App%20Images/Witcher%203%20Bestiary/Beasts/654_tavvhb.png",
                "Toussaint",
                "Beast oil",
                "Fur scrap,Cured leather,Raw meat",
                LocalDate.now(),
                beasts
        );

        Category cursedOnes = new Category("cursedones", "Cursed Ones");

        Monster archespores = new Monster(
                3L,
                "archespores",
                "Archespores",
                "Looks like a flower to me. A hideous, disgusting flower.\n" +
                        "– Blasco Tennerbe, last words\n" +
                        "Archespores look like gigantic, aesthetically unpleasing flowers with some of the traits of exceptionally cruel and bloodthirsty sundews. They are, however, far more dangerous that even the most colossal sundew. Their peculiar appearance makes them practically impossible to discern amidsts other plants. By the time one draws close enough to realize what they are, it is often too late to flee.\n" +
                        "According to popular belief, archespores are cursed plants grown in soil fertilized by the blood of the dying. They are most often found in places which in the past saw pogroms, bloody rituals or cruel murders Four types of archespore have been catalogued to date, differing from one another in terms of coloring: brown (the least dangerous), green and purple (the most dangerous). The final variant, said to have been cultivated by mages from Ban Ard, is the yellow archespore, whose strength is similar to that of its green-colored-cousins.\n" +
                        "Regardless of color, all archespores fight using similar methods: attacking with powerful, jaw-like leaves. If their victim is out of reach, they can also spray caustic acid which if it makes any contact whatsoever with the skin, can provoke a reaction similar to that caused by severe poisoning.\n" +
                        "Like other plants, all archespores are extremely vulnerable to fire, which is one of the most effective methods of fighting them. Silver also works well, as does any sort of shock wave. Archespores do not like strong vibrations, which cause them to flee underground at once. Due to the nature of their origins, oil damaging to cursed beings can also be useful against them.",
                "https://res.cloudinary.com/dayqxxsip/image/upload/v1613822459/App%20Images/Witcher%203%20Bestiary/Cursed%20Ones/654_ycgfrc.png",
                "Toussaint",
                "Cursed oil,Aard,Igni",
                "Archespore juice,Archespore tendril,Green mutagen,Monster spore,Venom extract",
                LocalDate.now(),
                cursedOnes
        );

        testMonsters.add(bear);
        testMonsters.add(panther);
        testMonsters.add(archespores);

        //endregion
    }

    //endregion

    //region Tests

    @Test
    void itShouldGetAllMonsters() {
        // Act
        when(monsterRepository.findAll()).thenReturn(testMonsters);

        List<Monster> monsters = monsterService.getMonsters();

        // Assert
        assertThat(monsters).isNotNull();
        assertThat(monsters.get(0).getDisplayName()).isEqualTo("Bears");
        assertThat(monsters.get(2).getDisplayName()).isEqualTo("Archespores");
        assertThat(monsters.size()).isEqualTo(3);
    }

    @Test
    void itShouldGetMonsterByName() {
        // Act
        String monsterName = "archespores";
        when(monsterRepository.findMonsterByName(monsterName)).thenReturn(
                testMonsters
                        .stream()
                        .filter(m -> m.getName().equals(monsterName))
                        .findFirst()
        );

        Optional<Monster> monster = monsterService.getMonsterByName(monsterName);

        // Assert
        assertThat(monster.get().getName()).isEqualTo(monsterName);
        System.out.println(monster.toString());
    }

    @Test
    void itShouldGetMonstersByCategoryName() {
        // Act
        String categoryName = "cursedones";
        when(monsterRepository.findByCategoryName(categoryName)).thenReturn(
                testMonsters
                        .stream()
                        .filter(m -> m.getCategory().getName().equals(categoryName))
                        .collect(Collectors.toList())
        );

        List<Monster> monsters = monsterService.getMonstersByCategoryName(categoryName);

        // Assert
        assertThat(monsters).isNotNull();
        System.out.println(monsters.toString());
    }

    @Test
    void itShouldAddANewMonster() {
        // Arrange
        Category elementa = new Category("elementa", "Elementa");
        String categoryName = "elementa";

        Monster djinn = new Monster(
                4L,
                "djinn",
                "Djinn",
                "The pitcher emitted a puff of glowing red smoke. The smoke pulsated, then gathered up into an irregular sphere floating in front of the poet's head...\n" +
                        "–The First Longing, a Tale Fantastic in All Ways.\n" +
                        "A djinn is a powerful air spirit, a condensation of the power of that element endowed with consciousness and character - the latter usually nasty. According to legend, djinn can grant even the most far-fetched wishes, though they do so very begrudgingly.\n" +
                        "Unusually powerful mages can capture and tame these beings. The mage can then draw on its energy, using it to cast spells without having to call on Power from traditional sources. Only a sparse handful have managed this feat, however, for djinn fight to avoid such a fate with stubborn determination. To imprison a djinn and bend it to one's will, one must first weaken it - and that is no easy feat.\n" +
                        "Fighting a djinn is extraordinarily difficult. They can fling off spells in an instant that the most accomplished human mages could never cast with years of preparation. What's more, by manipulating the element of air they can summon powerful storms, hurricanes, and gales. Luckily, as magic beings, they are vulnerable to silver - yet steel will do them no harm.\n",
                "https://res.cloudinary.com/dayqxxsip/image/upload/v1613823133/App%20Images/Witcher%203%20Bestiary/Elementa/654_mcahr5.png",
                "N/A",
                "Dimeritium bomb,Elementa oil",
                "None",
                LocalDate.now(),
                elementa
        );

        // Act
        when(categoryRepository.findCategoryByName(categoryName)).thenReturn(elementa);
        when(monsterRepository.save(djinn)).thenReturn(djinn);

        String saveResponse = monsterService.addNewMonster(djinn, categoryName, apiAdminKey);

        // Assert
        assertThat(saveResponse).contains("Monster (Djinn) added");
        System.out.println(saveResponse);
    }

    @Test
    void itShouldDeleteAnExistingMonster() {
        // Arrange
        String monsterName = "bears";
        Optional<Monster> existingMonster = testMonsters
                .stream()
                .filter(m -> m.getName().equals(monsterName))
                .findFirst();

        Long monsterId = existingMonster.get().getId();

        // Act
        when(monsterRepository.existsById(monsterId)).thenReturn(true);
        String deleteResponse = monsterService.deleteMonster(monsterId, apiAdminKey);

        // Assert
        verify(monsterRepository, times(1)).deleteById(monsterId);
        System.out.println(deleteResponse);
    }

    //endregion
}
