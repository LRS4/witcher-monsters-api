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

            //region Populate monsters

            Monster archespores = new Monster(
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
                    "https://res.cloudinary.com/dayqxxsip/image/upload/v1613822469/App%20Images/Witcher%203%20Bestiary/Cursed%20Ones/654_xg97ff.png",
                    "Skellige,Vildkaarls' village",
                    "Devil's Puffball,Cursed oil,Quen,Igni",
                    "Bear fat,Berserker hide,Raw meat",
                    LocalDate.now(),
                    cursedOnes
            );

            Monster botchlings = new Monster(
                    "botchlings",
                    "Botchlings",
                    "Saying a botchling's ugly is like saying shit's not particularly tasty: can't say it's a lie, but it doesn't exactly convey the whole truth, either.\n" +
                            "– Lambert, witcher of the Wolf School\n" +
                            "Botchlings are perhaps the most repulsive creatures a witcher will ever have the displeasure of meeting. Born of dead, unwanted babies discarded without a proper burial, their appearance is that of a partially-decayed fetus, their unformed flesh twisted with hate, fear and malice. These hideous creatures feed on the blood of pregnant women, driven by a mad hunger that most often leads to their victim's death.\n" +
                            "A botchling will emerge from its lair at night to lurk by the bedside of an expectant mother, draining her strength and that of her unborn progeny as she sleeps. A woman thus beleaguered first suffers from troubling dreams, then fever, delirium and a general weakening of the flesh. After a few such nights she is enfeebled and unable to defend herself - it is then the botchling attacks directly, sinking its long, sharp fangs into her body and drinking her blood until mother and fetus perish together.\n" +
                            "A botchling stands around a foot and a half in height, but, when threatened and if gorged with blood, it can change form. At such times it grows into a deformed man, hunched over and striding, ape-like, on its forearms. Stronger and fiercer after this alteration, it hurls itself into direct, physical combat, gnashing at its opponent or attacking him with sharp claws.\n" +
                            "A botchling's curse can be lifted by transforming it into a lubberkin - a guardian spirit of the hearth that watches over the family it never knew in the house it never could call home.",
                    "https://res.cloudinary.com/dayqxxsip/image/upload/v1613822501/App%20Images/Witcher%203%20Bestiary/Cursed%20Ones/654_pbig1z.png",
                    "Crow's Perch",
                    "Cursed oil,Axii",
                    "Lesser red mutagen,Monster ear,Monster blood,Monster bone,Necrophage hide,Rotting flesh,Monster brain",
                    LocalDate.now(),
                    cursedOnes
            );

            Monster toadPrince = new Monster(
                    "the-toad-prince",
                    "The Toad Prince",
                    "The girl walked up to the edge of the pond. There, squatting amidst the fragrant lilies and broad lily-pads, she saw a most unusual sight: a small green frog with a golden crown perched on its warty head. Charmed by this curious little creature, the girl picked it up and gave it a kiss. Immediately the little frog transformed into a handsome prince. Overcome with gratitude, he asked the girl to be his wife.\n" +
                            "– folk tale, author unknown\n" +
                            "Timeless tales always carry within them a grain of truth. The legend of the frog prince is no exception, or at least that's what the folk of Oxenfurt wished to believe when they found out a monstrous toad lurked in their city sewers. The women who hunted it in search of romance and a better life, however, found their tales had a most unhappy ending. The creature they encountered was no small, sweet frog but a bloodthirsty beast, who not only did not let them in for a kiss, but instead greedily devoured them and anything else that strayed into its slime-covered lair.",
                    "https://res.cloudinary.com/dayqxxsip/image/upload/v1613822489/App%20Images/Witcher%203%20Bestiary/Cursed%20Ones/latest_hjwb4r.png",
                    "Oxenfurt sewers",
                    "Northern Wind,Golden Oriole,Cursed oil,Yrden sign",
                    "None",
                    LocalDate.now(),
                    cursedOnes
            );

            Monster ulfhedinn = new Monster(
                    "ulfhedinn",
                    "Ulfhedinn",
                    "",
                    "https://res.cloudinary.com/dayqxxsip/image/upload/v1613822530/App%20Images/Witcher%203%20Bestiary/Cursed%20Ones/654_xhxmsp.png",
                    "Skellige",
                    "Moon Dust,Devil's Puffball,Cursed oil,Igni",
                    "Werewolf hide,Werewolf mutagen,Werewolf saliva,Monster essence",
                    LocalDate.now(),
                    cursedOnes
            );

            Monster werewolves = new Monster(
                    "werewolves",
                    "Werewolves",
                    "Wolves aren't as bad as they're made out to be. Werewolves, though – they're every bit as bad and worse.\n" +
                            "– Elsa Vilge, archer\n" +
                            "Werewolves are creatures with both men and wolves inside them. When in beastly form, they take the worst traits of each: the wolf's drive to kill and hunger for raw flesh and the man's cruel and calculating intelligence. A werewolf's condition comes about through a curse, and the transformations happen outside his conscious control. When he reverts to human form, he has no memory of his deeds – otherwise he would surely go mad and take his own life.\n" +
                            "Werewolves are active at night, particularly when the moon is full. Though they hunt alone, when threatened they will summon wolves to aid them. Werewolves rarely feel the need to flee, for few adversaries put up much of a fight against them. They strike as swiftly as lightning with claws sharp as razors and regenerate any damage received in mere moments. When fighting werewolves a witcher should wield a blade covered in oil harmful to the cursed and have a large supply of Devil's Puffballs handy.\n" +
                            "A werewolf's curse can at times be lifted, yet there is no universal, surefire method for doing this. A witcher seeking to undertake such a task must there equip himself with a great deal of patience – and sturdy armor.",
                    "https://res.cloudinary.com/dayqxxsip/image/upload/v1613822515/App%20Images/Witcher%203%20Bestiary/Cursed%20Ones/654_d6d5ke.png",
                    "Velen,Skellige",
                    "Moon Dust,Devil's Puffball,Cursed oil,Igni",
                    "Werewolf hide,Werewolf mutagen,Werewolf saliva",
                    LocalDate.now(),
                    cursedOnes
            );

            //endregion

            repository.saveAll(
                    List.of(archespores,
                            berserkers,
                            botchlings,
                            toadPrince,
                            ulfhedinn,
                            werewolves)
            );
        };
    }
}
