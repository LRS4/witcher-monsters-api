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

            Monster djinn = new Monster(
                    "djinn",
                    "Djinn",
                    "The pitcher emitted a puff of glowing red smoke. The smoke pulsated, then gathered up into an irregular sphere floating in front of the poet's head...\n" +
                            "–The First Longing, a Tale Fantastic in All Ways.\n" +
                            "A djinn is a powerful air spirit, a condensation of the power of that element endowed with consciousness and character - the latter usually nasty. According to legend, djinn can grant even the most far-fetched wishes, though they do so very begrudgingly.\n" +
                            "Unusually powerful mages can capture and tame these beings. The mage can then draw on its energy, using it to cast spells without having to call on Power from traditional sources. Only a sparse handful have managed this feat, however, for djinn fight to avoid such a fate with stubborn determination. To imprison a djinn and bend it to one's will, one must first weaken it - and that is no easy feat.\n" +
                            "Fighting a djinn is extraordinarily difficult. They can fling off spells in an instant that the most accomplished human mages could never cast with years of preparation. What's more, by manipulating the element of air they can summon powerful storms, hurricanes, and gales. Luckily, as magic beings, they are vulnerable to silver - yet steel will do them no harm.\n",
                    "https://static.wikia.nocookie.net/witcher/images/e/e2/Tw3_journal_djinn.png/revision/latest?cb=20160409111026",
                    "N/A",
                    "Dimeritium bomb,Elementa oil",
                    "None",
                    LocalDate.now(),
                    elementa
            );

            Monster earthElemental = new Monster(
                    "earth-elemental",
                    "Earth Elemental",
                    "How to survive an encounter with an earth element? Simple. Run. Fast as you can.\n" +
                            "– Nino Murk, bounty hunter\n" +
                            "Earth elementals are made of mud, clay, sand and rock dust clumped together with water and brought alive with magic. While seemingly slow and ponderous, there creatures are nevertheless dangerous and should be avoided at all costs.\n" +
                            "Earth elementals can withstand a tremendous amount of punishment. Due to their enormous mass they are virtually impossible to knock off balance. They do not bleed nor feel any pain from poison or even fire.\n" +
                            "They kill men with astonishing ease – whether by smashing them with their fists or hurling enormous stones at them. Their only weakness is their vulnerability to dimeritium dust – thus before combat one should prepare a full arsenal of bombs containing this ingredient.",
                    "https://static.wikia.nocookie.net/witcher/images/9/94/Tw3_journal_earthelemental.png/revision/latest?cb=20160409114804",
                    "Elven ruins,Ermion's laboratory in Kaer Trolde citadel",
                    "Dimeritium bomb,Elementa oil",
                    "Elemental essence,Earth elemental mutagen",
                    LocalDate.now(),
                    elementa
            );

            Monster fireElemental = new Monster(
                    "fire-elemental",
                    "Fire Elemental",
                    "The first fire elemental was created by Ransant Alvaro. Sadly, flames engulfed his entire laboratory, burning it - along with every other building on his block - to ash.\n" +
                            "– Tarvix Sandoval, \"Origins of Magic Arcana\"\n" +
                            "Fire is the most destructive of the elements, thus the aggressive lethality of the creature that embodies its essence should come as no surprise. Fire elementals are forged in complicated magic rituals for one purpose: destruction. And they pursue this with murderous determination.\n" +
                            "This elemental attacks using fireballs and streams of flame which reduce anything in their path to ashes in the blink of an eye. Like golems and other elementals, poison does not touch it nor does it bleed. Fire-based spells not only do no harm but in fact strengthen it - thus one should by no means think of striking it with Igni. " +
                            "Though vulnerable to silver blades, getting within sword's reach of one is dangerous due to the furnace-like heart they emanate. When fighting a fire elemental one should thus strike from a distance, using frost-spewing and dimeritium bombs, for they will do it the most damage.",
                    "https://static.wikia.nocookie.net/witcher/images/d/d0/Tw3_journal_fireelemental.png/revision/latest?cb=20160409120404",
                    "Found in magical ruins",
                    "Dimeritium bomb,Northern wind,Elementa oil,Aard",
                    "Greater Dazhbog runestone",
                    LocalDate.now(),
                    elementa
            );

            Monster gargoyle = new Monster(
                    "gargoyle",
                    "Gargoyle",
                    "It just me, or is that gargoyle ogling us?\n" +
                            "– Lara Estevann, burglar from Loc Muinne\n" +
                            "Gargoyles are stone statues brought to life by magic in order to guard mages' laboratories and lairs from intruders. Their appearance alone has scared off more than one prospective burglar. Those who do not take fright at the sight of these horned and winged monstrosities usually die shortly thereafter, torn to shreds by stony claws.",
                    "https://static.wikia.nocookie.net/witcher/images/b/be/Tw3_journal_gargoyle.png/revision/latest?cb=20160409175319",
                    "Abandoned Ruins and Castles",
                    "Dimeritium bomb,Elementa oil,Quen",
                    "Gargoyle dust,Gargoyle heart,Elemental essence,Iron ore,Monster heart",
                    LocalDate.now(),
                    elementa
            );

            Monster golem = new Monster(
                    "golem",
                    "Golem",
                    "If want[sic] us to break through this wall, we're gonna need twenty sappers, seven mules and a hundredweight of saltpeter. Or one golem.\n" +
                            "– Vilmir Brass, foreman at Mount Carbon\n" +
                            "Golems are mindless matter brought to life by a spell. They obey their creator's orders without question. Their boundless strength, ability to withstand pain, endless patience and the fact that they neet not one jot of food or drink makes them the best servants or guards anyone could ask for. Once provoked, they will not tire of battle until they have either crushed their opponent or themselves crumbled to dust.\n" +
                            "Defeating a golem is extraordinarily difficult: for obvious reasons it does not bleed, it feels no fear or mercy and it is invulnerable to fire and poison. What's more, a golem's body is as hard as the rock it is sometimes heft out of, so even a silver blade will barely wound it. The monster's only weakness is acid – a blade covered in acrid oil can thus increase one's chances for victory.\n" +
                            "Golems use no weapons, for they have no need – their fists, weighing over a hundred pounds each, can crush solid granite with one hit. A blow from a golem should thus be avoided at all costs – there is no shield that can stop it, nor sword that can parry it. That is no easy task, for these creatures are able to move with surprising speed. Luckily, their enormous mass means they are not very agile – once a golem begins a charge, it cannot stop quickly, a fact experienced witchers use to their advantage.",
                    "https://static.wikia.nocookie.net/witcher/images/d/d6/Tw3_journal_golem.png/revision/latest?cb=20160409131122",
                    "Elven ruins and caves (throughout the world)",
                    "Dimeritium bomb,Elementa oil",
                    "Golem's heart,Infused dust,Monster essence,Monster saliva,Runestones",
                    LocalDate.now(),
                    elementa
            );

            Monster houndOfTheWildHunt = new Monster(
                    "hound-of-the-wild-hunt",
                    "Hound of the Wild Hunt",
                    "Baying at the heels of the Wild hunt are its Hounds, fierce beasts which follow it like dust clouds trailing after a comet. Hushed legends speak of them losing their way at times and descending from the night sky to earth, cold and death following in their wake.\n" +
                            "– Essi \"Blackjack\" Daven, trobairitz\n" +
                            "Born or so some experts believe, of magic ice crystal, the Hounds of the Wild Hunt race alongside their spectral masters. Like ravenous, feral dogs they are capable only of mindlessly attacking whatever crosses their path.\n" +
                            "The Hounds' chief weapons are their claws and teeth. Their battle tactics rely on knocking their opponents to the ground before tearing them to shreds. Badly wounded Hounds fall into a kind of frenzy that adds to their deadly might. These beasts also use their powers over the cold to freeze the ground around them and create sharp spikes of ice. Creatures born of frost,they feel pain from the Igni Sign, and there is also reason to believe Axii can momentarily weaken their drive to kill and somewhat weaken these fierce foes.\n" +
                            "The Hounds' icy nature also means they can draw strength from extreme cold. Thus one should be particularly on guard when fighting them during blizzards or in glacial regions. Elven legends likewise claim they gain strength when a red moon - a known herald of the Hunt's arrival - hangs in the sky.",
                    "https://static.wikia.nocookie.net/witcher/images/c/c0/Tw3_journal_houndofthewildhunt.png/revision/latest?cb=20160409135922",
                    "Always together with Wild Hunt",
                    "Dimeritium bomb,Elementa oil,Igni,Axii",
                    "Monster bone,Monster brain,Monster saliva,Rotting flesh,Sulfur",
                    LocalDate.now(),
                    elementa
            );

            Monster iceElemental = new Monster(
                    "ice-elemental",
                    "Ice Elemental",
                    "I thought to myself - what's a hunk of ice doing in the middle of some lab? And then that hunk of ice got up and broke my legs.\n" +
                            "– Yannick Lovt, burglar\n" +
                            "An ice elemental is a mass of frozen water animated by magic. Deprived of consciousness or independent will, this elemental is boundlessly obedient to the orders of the mage who created it. Those orders usually contain but one syllable: kill.\n" +
                            "Ice elementals have no qualms about carrying out this order nor any particular difficulty in doing so. Gifted with incredible strength, they are completely invulnerable to poison and fire, deprived of sensitive organs, hard as permafrost and all in all incredibly difficult opponents. A witcher's only chance at tipping the scales towards victory is to toss a dimeritium bomb – shrapnel made of this metal interferes with the workings of the spell that gives this creature life. Beyond that remains only prayer.",
                    "https://static.wikia.nocookie.net/witcher/images/c/c6/Tw3_journal_iceelemental.png/revision/latest?cb=20160409141539",
                    "Skellige",
                    "Dimeritium bomb,Elementa oil",
                    "Elemental essence",
                    LocalDate.now(),
                    elementa
            );

            Monster moreausGolem = new Monster(
                    "moreaus-golem",
                    "Moreau's Golem",
                    "Long years of solitary study tend to make mages somewhat eccentric. As the years pass, laypeople being to irritate them more and more: they are dense, unreliable, disobedient and determined not to understand the gravity of mages' work. They display emotion when they should show discipline and self-mastery. No wonder mages have long considered the best companions to be artificial constructs they themselves bring to life and design to follow their orders and meet their needs." +
                            "  Professor Moreau was no exception in this regard. His golem was his dutiful servant and companion, in good times and bad. Moreau's golem was also an excellent guardian: massive, unyielding and devilishly strong. All in all, he was a tough nut for a witcher to crack!",
                    "https://static.wikia.nocookie.net/witcher/images/0/05/Tw3_journal_moreaus_golem.png/revision/latest?cb=20170301181026",
                    "Mont Crane Castle",
                    "Dimeritium bomb,Elementa oil",
                    "None",
                    LocalDate.now(),
                    elementa
            );

            Monster pixies = new Monster(
                    "pixies",
                    "Pixies",
                    "\"Look! Pixies!\"\n" +
                            "\"We should go. Now.\"\n" +
                            "\"Come on, what harm can cute little pixies do us?\"\n" +
                            "– last words of two criminals who broke into the Land of a Thousand Fables, identities unknown\n" +
                            "Pixies might look like gentle, harmless creatures, yet in their case, the saying about appearances being deceiving fits all too perfectly. The pixies from the Land of a Thousand Fables were created to protect that magic place from intruders and ensure the ducal daughters, Sylvia Anna and Anna Henrietta, " +
                            "did not come to even the slightest harm. Thus whenever anyone else crossed the pixies' path, it ended badly for them, for pixies are aggressive, war-like creatures, created to kill, defend and fight till they can fight no more.",
                    "https://static.wikia.nocookie.net/witcher/images/7/7a/Tw3_journal_pixie.png/revision/latest?cb=20170301181026",
                    "Land of a Thousand Fables",
                    "Elementa oil",
                    "None",
                    LocalDate.now(),
                    elementa
            );

            Monster apiarianPhantom = new Monster(
                    "the-apiarian-phantom",
                    "The Apiarian Phantom",
                    "Something's destroyed our fields and hives. We think it's... the apiarian phantom.\n" +
                            "Holofernes Meiersdorf\n" +
                            "The \"Apiarian Phantom\" destroying the Meiersdorf family's hives turned out to be a lost Hound of the Wild Hunt. When fighting such a beast, one must bear in mind three things. First of all, that the thick armor of ice covering it can only be pierced by strong blows. Second, that, like any other frost-born creature, it is vulnerable to fire, the Igni Sign included. Third and last: that it shall show no mercy.\n" +
                            "Though the Hound fought fiercely, it nevertheless fell to the witcher's blade. By killing this dangerous monster, Geralt saved the humans, halflings and, last but not least, bees of the area from further torment.",
                    "https://static.wikia.nocookie.net/witcher/images/f/f6/Tw3_journal_theapiarianphantom.png/revision/latest?cb=20160409162145",
                    "In hut near Honeyfill Meadworks",
                    "Dimeritium bomb,Elementa oil,Igni,Axii",
                    "Wild Hunt hound trophy,Sulfur",
                    LocalDate.now(),
                    elementa
            );

            Monster therazane = new Monster(
                    "therazane",
                    "Therazane",
                    "I do not believe in ghosts - it is that simple. But my men say the house shakes at night, walls crumble, why, even the floors move about...\n" +
                            "– Kurt Dysart, Count of Anchor\n" +
                            "There's no such thing as a risk-free real estate investment. It might turn out your new home has a leaky roof, structural rot in the attic, a scratched floor in the living room... or elven ruins beneath its foundations, and within them an enormous earth elemental just waiting for a chance to break free of its chains.\n" +
                            "Fighting such a monster is no easy task. Its tough outer husk deflects all but the strongest blows. It can liquefy a man's bones with one crushing blow from its fists  - thus, one should never near it without first casting the Quen Sign. One should have the Yrden Sign at the ready as well, whereas the other signs - Igni, Aard and Axii - are completely ineffective against it.\n" +
                            "In the end the witcher triumphed over the powerful earth elemental, and in doing so won gratitude of, and a reward from, Count Dysart.",
                    "https://static.wikia.nocookie.net/witcher/images/9/97/Tw3_journal_therazane.png/revision/latest?cb=20160409171526",
                    "Moldavie Residence",
                    "Dimeritium bomb,Elementa oil",
                    "Earth elemental trophy,Earth elemental mutagen,Cleaver hood,Monster claw,Powdered monster tissue,Monster eye,Fifth essence",
                    LocalDate.now(),
                    elementa
            );

            //endregion

            repository.saveAll(
                    List.of(djinn,
                            earthElemental,
                            fireElemental,
                            gargoyle,
                            golem,
                            houndOfTheWildHunt,
                            iceElemental,
                            moreausGolem,
                            pixies,
                            apiarianPhantom,
                            therazane)
            );
        };
    }
}
