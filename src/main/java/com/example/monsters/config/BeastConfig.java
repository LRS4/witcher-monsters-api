package com.example.monsters.config;

import com.example.monsters.model.Monster;
import com.example.monsters.model.Category;
import com.example.monsters.repository.MonsterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class BeastConfig {

    @Bean
    CommandLineRunner beastCommandLineRunner(MonsterRepository repository) {
        return args -> {
            Category beasts = new Category("beasts", "Beasts");

            //region Populate monsters

            Monster bear = new Monster(
                    "bears",
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
                    beasts
            );

            Monster panther = new Monster(
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
                    "https://static.wikia.nocookie.net/witcher/images/d/da/Tw3_journal_panther.png/revision/latest?cb=20160531173331",
                    "Toussaint",
                    "Beast oil",
                    "Fur scrap,Cured leather,Raw meat",
                    LocalDate.now(),
                    beasts
            );

            Monster wildBoars = new Monster(
                    "wild-boars",
                    "Wild Boars",
                    "How doth the little wild boar\n" +
                            "Improve his shining tusks,\n" +
                            "And rut them 'gainst the forest floor,\n" +
                            "And on the trees' rough husks!\n" +
                            "How cheerfully he seems to grin\n" +
                            "How neatly spreads his claws,\n" +
                            "And welcomes little lasses in,\n" +
                            "With gently smiling jaws!\n" +
                            "Louis of Charolle, mathematician, author and poet\n" +
                            "These woodland beasts are as \"wild\" – untamed, nasty and aggressive – as their name indicates. To this day, many peasants in outlying Kaedweni villages believe wild boars persist on a diet of young maids, though in truth they most often slate their hunger with roots and acorns. Do not think this vegetarian diet makes them harmless, however. In fact, these animals' stout build and sharp teeth render them veritable fur-covered combat machines. Mother Nature has additionally equipped them with dual pairs of tusks - upper \"pipes\" and lower \"sabres\" - and this weaponry's sum effect is to make the beasts the terrors of the woods, a threat to all who venture or dwell there, human, humanoid and otherwise. Boars also have hard, club-like snouts, which some peasants call their \"whistles,\" though no boar has ever been heard to make such a noise. Instead, they emit a characteristic grunt, which sounds to some like the snoring of an extremely overweight man. Another peasant belief claims boars have extremely prickly natures, and, if offended, will vent their anger by knocking down fences and gobbling up potatoes. Though they sometimes live alone, boars usually appear in small groups of 3 to 5 specimens.",
                    "https://static.wikia.nocookie.net/witcher/images/9/93/Tw3_journal_wild_boar.png/revision/latest?cb=20170501180811",
                    "Gustfields,Toussaint",
                    "Northern Wind,Beast oil,Igni,Yrden",
                    "Boar tusk,Boar pelt,Raw meat",
                    LocalDate.now(),
                    beasts
            );

            Monster bigBadWolf = new Monster(
                    "big-bad-wolf",
                    "Big Bad Wolf",
                    "You ask why I have these big hands, my friend? Well, I'll tell you my secret: exercise.\n" +
                            "— Big Bad Wolf\n" +
                            "The Big Bad Wolf who lived in the Land of a Thousand Fables was, like the other denizens of that strange sphere, created by Artorius Vigo based on a figure from folk tales. Once he served as a playmate to the duke's daughters, acting out scenes with a certain red-hooded girl and her grandmother, but as the fable land slowly degenerated, so did he.\n" +
                            "Geralt and Syanna met the Big Bad Wolf while he was nursing a nasty hangover and was not eager to cooperate. Yet since our heroes needed a bean which the wolf had, they forced him to act out his tale.\n" +
                            "That tale ended as it always had: the Big Bad Wolf attacked the Hunter (played by Geralt), biting and clawing him fiercely while his own wounds healed almost instantaneously. Inevitably, however, the Big Bad Wolf was killed and his stomach cut open.\n" +
                            "This time, out came not a grandma and her granddaughter, but a magic bean.",
                    "https://static.wikia.nocookie.net/witcher/images/d/db/Tw3_journal_bigbadwolf.png/revision/latest?cb=20160605085157",
                    "Land of a Thousand Fables",
                    "Devil's Puffball,Beast oil",
                    "Magic dust,Red mutagen,Fake tooth,Corkscrew,Bottle caps",
                    LocalDate.now(),
                    beasts
            );

            Monster beastOfBeauclair = new Monster(
                    "the-beast-of-beauclair",
                    "The Beast of Beauclair",
                    "Eyewitnesses to gruesome monster attacks always have a hard time describing the creature in question. The beasts move quickly and often attack at night, while the witnesses are terrified and primarily concerned with fleeing for their lives. As a result, witchers quite often have no inkling what creature they face until they find tracks or otherwise establish something for themselves. Such was the case with the Beast tormenting Beauclair. Geralt knew it was deadly, elusive and fiendishly clever. Everything else he heard was clearly the product of imaginations fed by fear of a dangerous predator.\n" +
                            "When Geralt identified the Beast, he discovered it was a higher vampire, meaning one of the most difficult foes a witcher can come to face.\n" +
                            "Higher vampires are superhumanly strong and fast. They can turn completely invisible, and each comes with its own personalized set of talents and abilities perfected through centuries of existence.\n" +
                            "When Geralt realized he was dealing with such a creature, he swore foully and realized the rumors about the Beast had not been exaggerated in the slightest.",
                    "https://static.wikia.nocookie.net/witcher/images/b/b5/Tw3_journal_dettlaff_vampire.png/revision/latest?cb=20160601042441",
                    "Toussaint",
                    "Vampire oil,Black Blood,Quen",
                    "None",
                    LocalDate.now(),
                    beasts
            );

            Monster wolves = new Monster(
                    "wolves",
                    "Wolves",
                    "Friend of mine used to say that with all these griffins and basilisks and whatnot, good old fashioned wolves weren't nothing to worry about... Then the damned beasts devoured half his flock.\n" +
                            "– Yngvar, shepherd\n" +
                            "Once upon a time wolves were the absolute rulers of the forest. Men used them to frighten children, while adults, too, trembled at the sound of their howling. Post-Conjunction monsters not only pushed wolves into the deepest wilds but also took over their place in human nightmares. Yet this does not mean the old predators ceased to be a danger. Wolves do not have a drop of magic within them, breathe no fire and spit no acid, but that in no way stops them from killing unwary travelers and hunters.\n" +
                            "Particularly dangerous are wargs, a nasty and ferocious subspecies of wolf, and the snow-white wolves which today can only be found in the wild highlands of the Skellige archipelago.\n" +
                            "Wolves usually feed in packs counting from a handful to over a dozen members, though some particularly strong males hunt alone. Though wolves are weaker than many post-Conjunction monsters, they make up for any lack of strength with their intelligence. When fighting them one must be especially careful not to become surrounded. The presence of wolves can also signal more serious trouble – these predators often share their hunting grounds with werewolves and leshens.",
                    "https://static.wikia.nocookie.net/witcher/images/6/62/Tw3_journal_wolf.png/revision/latest?cb=20160409074701",
                    "Velen,White Orchard,Skellige,Toussaint",
                    "Beast oil",
                    "Raw meat,Wolf hide,Wolf's liver,Dog tallow",
                    LocalDate.now(),
                    beasts
            );

            Monster dogs = new Monster(
                    "dogs",
                    "Dogs",
                    "They say a dog's a man's best friend... But in these foul times one best be wary, even of his friends.\n" +
                            "– Alfred Pankratz, beggar from Novigrad\n" +
                            "Some claim dogs are reflections of their masters. A well-treated pet repays his owner with loyalty and trust, whereas an ill-treated one repays this treatment in kind as well, meeting yells with barks and kicks with bites. Since there is an abundance of bad men, so, too, is there an abundance of bad dogs. Most dangerous of all are the vagrant mutts who have lost all respect for men and developed a taste for blood and carrion.\n" +
                            "Dogs usually attack in packs, choosing isolated victims, especially ones in whom they sense some kind of weakness. Packs of rabid dogs usually only dare attack children, drunkards, the elderly and cripples. Yet when backed into a corner, they will defend themselves with frothing bites and sharp claws against all and sundry.",
                    "https://static.wikia.nocookie.net/witcher/images/e/e4/Tw3_journal_dog.png/revision/latest?cb=20160304193515",
                    "Velen,Novigrad,Skellige",
                    "Beast oil",
                    "Dog tallow,Raw meat",
                    LocalDate.now(),
                    beasts
            );

            Monster threeLittlePigs = new Monster(
                    "three-little-pigs",
                    "Three Little Pigs",
                    "Why bother with brick? In this climate, even a straw house's nice and cozy.\n" +
                            "– a little pig\n" +
                            "\n" +
                            "The three little pigs are perfect examples of a rather unfortunate phenomenon. Leave even a kind-hearted, warm, naively benign creature to fend for itself, and it won't remain so benign for long.\n" +
                            "The three little pigs from the Land of a Thousand Fables were left for years without Artorius Vigo's supervision. During this time they went completely feral, transforming into three wild boars which attacked anyone who dared approach their ruined home.",
                    "https://static.wikia.nocookie.net/witcher/images/b/b3/Tw3_journal_three_little_pigs.png/revision/latest?cb=20161031083059",
                    "Land of a Thousand Fables",
                    "Beast oil",
                    "Magic dust",
                    LocalDate.now(),
                    beasts
            );

            //endregion

            repository.saveAll(
                    List.of(bear,
                            panther,
                            wildBoars,
                            bigBadWolf,
                            beastOfBeauclair,
                            wolves,
                            dogs,
                            threeLittlePigs)
            );
        };
    }
}
