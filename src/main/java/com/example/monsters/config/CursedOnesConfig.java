package com.example.monsters.config;

import com.example.monsters.model.Category;
import com.example.monsters.model.Monster;
import com.example.monsters.repository.MonsterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.List;

@Profile("!test")
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
                            "– Blasco Tennerbe, last words\n\n" +
                            "Archespores look like gigantic, aesthetically unpleasing flowers with some of the traits of exceptionally cruel and bloodthirsty sundews. They are, however, far more dangerous that even the most colossal sundew. Their peculiar appearance makes them practically impossible to discern amidsts other plants. By the time one draws close enough to realize what they are, it is often too late to flee.\n" +
                            "According to popular belief, archespores are cursed plants grown in soil fertilized by the blood of the dying. They are most often found in places which in the past saw pogroms, bloody rituals or cruel murders Four types of archespore have been catalogued to date, differing from one another in terms of coloring: brown (the least dangerous), green and purple (the most dangerous). The final variant, said to have been cultivated by mages from Ban Ard, is the yellow archespore, whose strength is similar to that of its green-colored-cousins.\n\n" +
                            "Regardless of color, all archespores fight using similar methods: attacking with powerful, jaw-like leaves. If their victim is out of reach, they can also spray caustic acid which if it makes any contact whatsoever with the skin, can provoke a reaction similar to that caused by severe poisoning.\n\n" +
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
                    "Now finish your soup, or a berserker'll come and swallow ye whole.\n" +
                            "– Skellige mother scolding a child.\n\n" +
                            "Skellige legends speak of men known as berserkers who transform into bears when overwhelmed by battle rage. In doing so, they lose all self-awareness and are driven by a bloodlust which they must satiate in order to return to human form." +
                            "Few believe these blood-curdling tales, however, not even in Skellige, where the inhabitants usually treat even the least probable legends with the utmost gravity. This indicates either that berserkers are in fact mere figments of mead-sodden imaginations, or else that they have learned to hide their abilities from the rest of the islanders.\n\n" +
                            "The skalds' ballads indicate a berserker transformed in the heat of battle cannot be distinguised from a true-born bear. Only minute anatomical details - such as the shape of their tongues and teeth - reveal their secret. Descriptions of their fighting prowess paint them as invulnerable to pain and able to heal any wound received almost at once.\n\n" +
                            "If these men-turned-bears truly do exist, one can suppose that, like werewolves and lycanthropes, they are particularly vulnerable to oils that harm cursed creatured. But if we are to give credence to ancient songs about these creatures' deeds, about the mass murders and massacres they have committed, we can only hope that no witcher will have to test this hypothesis.",
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
                            "– Lambert, witcher of the Wolf School\n\n" +
                            "Botchlings are perhaps the most repulsive creatures a witcher will ever have the displeasure of meeting. Born of dead, unwanted babies discarded without a proper burial, their appearance is that of a partially-decayed fetus, their unformed flesh twisted with hate, fear and malice. These hideous creatures feed on the blood of pregnant women, driven by a mad hunger that most often leads to their victim's death.\n\n" +
                            "A botchling will emerge from its lair at night to lurk by the bedside of an expectant mother, draining her strength and that of her unborn progeny as she sleeps. A woman thus beleaguered first suffers from troubling dreams, then fever, delirium and a general weakening of the flesh. After a few such nights she is enfeebled and unable to defend herself - it is then the botchling attacks directly, sinking its long, sharp fangs into her body and drinking her blood until mother and fetus perish together.\n\n" +
                            "A botchling stands around a foot and a half in height, but, when threatened and if gorged with blood, it can change form. At such times it grows into a deformed man, hunched over and striding, ape-like, on its forearms. Stronger and fiercer after this alteration, it hurls itself into direct, physical combat, gnashing at its opponent or attacking him with sharp claws.\n\n" +
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
                            "– folk tale, author unknown\n\n" +
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
                    "Ulfhedinn? What's that, some kind of fish?\n" +
                            "– Professor Artibus Joannes Rack, geographer, disappeared during a surveying expedition in Skellige\n\n" +
                            "Ulfhedinn are a breed of werewolf found mainly in Skellige. The harsh and barren conditions of the isles might explain why they primarily hunt men and are stronger than their continental brethren. Older and particularly dangerous ulfhedinn are called vorefs. Only a few daring warriors in Skellige history have managed to defeat an ulfhedinn, and each of them is commemorated in ballads as a hero to this day.\n\n" +
                            "Like werewolves, ulfhedinn and vorefs are active at night, particularly when the moon is at its fullest. Fast, strong, and amazingly resilient, these creatures kill with disturbing ease. Silver blades should be brought against them, as should Devil's Puffball. Take note that when near death the ulfhedinn becomes particularly dangerous and will attack with doubled fury, while calling on wolves to come to its rescue.",
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
                            "– Elsa Vilge, archer\n\n" +
                            "Werewolves are creatures with both men and wolves inside them. When in beastly form, they take the worst traits of each: the wolf's drive to kill and hunger for raw flesh and the man's cruel and calculating intelligence. A werewolf's condition comes about through a curse, and the transformations happen outside his conscious control. When he reverts to human form, he has no memory of his deeds – otherwise he would surely go mad and take his own life.\n\n" +
                            "Werewolves are active at night, particularly when the moon is full. Though they hunt alone, when threatened they will summon wolves to aid them. Werewolves rarely feel the need to flee, for few adversaries put up much of a fight against them. They strike as swiftly as lightning with claws sharp as razors and regenerate any damage received in mere moments. When fighting werewolves a witcher should wield a blade covered in oil harmful to the cursed and have a large supply of Devil's Puffballs handy.\n\n" +
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
