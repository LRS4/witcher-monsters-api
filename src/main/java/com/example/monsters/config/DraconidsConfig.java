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

            //region Populate monsters

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

            Monster cockatrice = new Monster(
                    "cockatrice",
                    "Cockatrice",
                    "Had meself eight heifers, five of 'em milchers. Then this cockatrice sprung up nearby, and now all's I got left's dried patties in an empty field.\n" +
                            "– Jethro, peasant from Pindal\n" +
                            "Foolish superstitions claim cockatrices, like basilisks, can kill with their gaze alone. That is utter nonsense, however, a cockatrice's gaze being no more dangerous than that of an angry goose. One should instead watch out for it's sharp beak and long tail, which it can whip to murderous effect.\n" +
                            "Cockatrices thrive in dark caves, abandoned ruins, cobwebbed dungeons and old basements. Though small compared to griffins and manticores, they are more than capable of killing anyone who stumbles across them in a dark corridor.\n" +
                            "Cockatrices do not shun direct fights, in which they strike furiously with wing and tail in an attempt to exhaust their foes. Blows from their beaks are especially dangerous, as they aim with deadly precision at exposed flesh and vital organs and leave bleeding, life-threatening wounds. When fighting them one " +
                            "should make liberal use of draconid oil as well as Grapeshot, whose shrapnel will pierce their delicate wings with ease.",
                    "https://static.wikia.nocookie.net/witcher/images/2/2a/Tw3_journal_cockatrice.png/revision/latest/scale-to-width-down/350?cb=20160408171230",
                    "Velen,Redania",
                    "Grapeshot,Draconid oil,Aard",
                    "Cockatrice egg,Cockatrice mutagen,Cockatrice stomach,Cockatrice trophy,Monster carapace",
                    LocalDate.now(),
                    draconids
            );

            Monster forktail = new Monster(
                    "forktail",
                    "Forktail",
                    "Forktails... Bah! Fuckers' tails're more like cleavers.\n" +
                            "– Yavinn Buck, veteran of the Mahakaman Volunteer Regiment\n" +
                            "Forktails owe their quaint name to the long sharp growths at the tip of their tails. A blow from this weapon can slice an oaken shield in two – along with the arm that was carrying it. Thus, though its name conjures images of cutlery, fighting a forktail is nothing like a dinner party and ends in death rather than dessert.",
                    "https://static.wikia.nocookie.net/witcher/images/2/2f/Tw3_journal_forktail.png/revision/latest/scale-to-width-down/350?cb=20160408181043",
                    "Velen,Skellige,White Orchard",
                    "Golden Oriole,Grapeshot,Draconid oil,Aard",
                    "Forktail mutagen,Forktail hide,Dragon scales,Monster liver,Monster eye,Raw meat",
                    LocalDate.now(),
                    draconids
            );

            Monster royalWyvern = new Monster(
                    "royal-wyvern",
                    "Royal Wyvern",
                    "It were huge. And those teeth, ugh! We barely escaped.\n" +
                            "Wonder if it killed the traders... Whoresons sure had it comin',\n" +
                            "– Conversation overheard in Velen\n" +
                            "A hunter who knows his prey's habits and behavior will rarely return from his hunt empty-handed. To know what forest paths deer are like to trod, to know in what muck boars will wallow, to guess when a hare will emerge from its burrow - that is half the battle.\n" +
                            "What most men do not know is that some monsters also possess such knowledge. For example, a royal wyvern from Velen had learned the danger of exposing itself to human eyes and arrows by flying high to pick out its prey from afar. Instead, it would lurk by the roadside and wait for military transports. In this way it grew fat on salted pork and beer, expanding until it resembled a dragon more than other, lesser members of its own kind.\n" +
                            "The witcher thus knew this beast would be much stronger and more resilient than a normal wyvern. Even one blow from it could kill - which is why he would need to avoid its charge at all costs. He would also be wise to force it to the ground with his crossbow or a bomb whenever it tried to fly into the air and hurtle down in a deadly dive.\n" +
                            "In the end the witcher slew the hideous creature, though not without some difficulty. Thanks to this feat, the soldiers could once again send shipments of food and equipment needed to conduct the war. Whether that was a good or a bad thing - that is an entirely different matter.",
                    "https://static.wikia.nocookie.net/witcher/images/8/8a/Tw3_journal_royalwyvern.png/revision/latest/scale-to-width-down/350?cb=20160408182854",
                    "Velen,Skellige,White Orchard",
                    "Golden Oriole,Grapeshot,Draconid oil,Aard",
                    "Wyvern trophy,Wyvern mutagen,Wyvern egg,Anathema",
                    LocalDate.now(),
                    draconids
            );

            Monster shrieker = new Monster(
                    "shrieker",
                    "Shrieker",
                    "Heard you have a problem - a monster you call a shrieker?\n" +
                            "Aye, prowls about, it does. Snatches cows and goats, mostly, but it won't scorn a man if it runs into one.\n" +
                            "– Conversation overheard at Crow's Perch\n" +
                            "The monster tormenting the residents of Crow's Perch turned out to be a particularly nasty cockatrice. Geralt was not surprised the baron's men had been unable to stop it. They could not possibly withstand the surgical precision of its strikes, which slice open arteries and provoke an outpouring of blood only the Swallow potion could hope to stop. Neither did they know to force it to the ground with a crossbow, a bomb or a Sign, and then evade its charge by rolling under the monster's outstretched wing.\n" +
                            "Just when it seemed the villagers would have to learn to live in the shadow of a bloodthirsty beast, to always look to the sky with fear, the witcher arrived - and put an end to the shrieker for good.",
                    "https://static.wikia.nocookie.net/witcher/images/7/73/Tw3_journal_shrieker.png/revision/latest/scale-to-width-down/350?cb=20160407141943",
                    "Cave near Crow's Perch",
                    "Grapeshot,Draconid oil,Aard",
                    "Cockatrice egg,Cockatrice mutagen,Cockatrice stomach,Cockatrice trophy,Dwarven axe,Monster carapace,Monster feather,Monster saliva",
                    LocalDate.now(),
                    draconids
            );

            Monster silverBasilisk = new Monster(
                    "silver-basilisk",
                    "Silver Basilisk",
                    "You want a fine pair of boots, you say? Bring me the hide of a silver basilisk, and I'll make you boots the whole world will envy.\n" +
                            "- Anatole Vizholy, shoemaker from Beauclair\n" +
                            "Geralt always liked looking at things that don't exist. Be it a vampire with a human heart of the last basilisk of a species that no scholar has classified, discovering something thought not to be there to be discovered caused him great pleasure. That is why he took an interest in a contract which, at first glance, seemed banal, but proved to be very intriguing. It concerned the last basilisk of the nearly-extinct species Regulus Platinum.\n" +
                            "In the end, Geralt decided not to kill the basilisk, for who in his right mind would raise his sword against a living legend?",
                    "https://static.wikia.nocookie.net/witcher/images/b/b2/Tw3_journal_silver_basilisk.png/revision/latest/scale-to-width-down/350?cb=20170302011053",
                    "Toussaint",
                    "Golden Oriole,Draconid oil,Aard,Igni",
                    "None",
                    LocalDate.now(),
                    draconids
            );

            //endregion

            repository.saveAll(
                    List.of(basilisks,
                            cockatrice,
                            forktail,
                            royalWyvern,
                            shrieker,
                            silverBasilisk)
            );
        };
    }
}