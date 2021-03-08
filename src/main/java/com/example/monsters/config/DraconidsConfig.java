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
                            "– Gravestone inscription, Vizima cemetery.\n\n" +
                            "Contrary to popular belief, basilisks cannot turn anything to stone with their gaze. That is small comfort, however, given that their acid, venom, claws and teeth provide them many other ways to kill.\n\nBasilisks love dark, damp places such as cellars, caves and city sewers. They hunt by day, waiting patiently in hiding for their prey to come, then jump out in a flash to unleash a deadly attack.\n\n" +
                            "When preparing to fight such a creature one should drink Golden Oriole, which will provide resistance to its venom, and also prepare Dancing Star or shrapnel bombs, which work particularly well against basilisks.\n\nBasilisk leather is a highly-valued material used to make fashionable shoes and women's handbags. For this reason many men, their courage girded by goldlust, take to hunting them. Most of these hunts end in disaster, " +
                            "but some do manage to bag their prey, which has led to a drastic decline in this creature's numbers in recent years. " +
                            "Some mages and druids are of the opinion that basilisks should be included in programs meant to safeguard dying species. Everyone else thinks those mages and druids have gone completely mad.",
                    "https://res.cloudinary.com/dayqxxsip/image/upload/v1613822647/App%20Images/Witcher%203%20Bestiary/Draconids/654_avsrxf.png",
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
                            "– Jethro, peasant from Pindal\n\n" +
                            "Foolish superstitions claim cockatrices, like basilisks, can kill with their gaze alone. That is utter nonsense, however, a cockatrice's gaze being no more dangerous than that of an angry goose. One should instead watch out for it's sharp beak and long tail, which it can whip to murderous effect.\n\n" +
                            "Cockatrices thrive in dark caves, abandoned ruins, cobwebbed dungeons and old basements. Though small compared to griffins and manticores, they are more than capable of killing anyone who stumbles across them in a dark corridor.\n\n" +
                            "Cockatrices do not shun direct fights, in which they strike furiously with wing and tail in an attempt to exhaust their foes. Blows from their beaks are especially dangerous, as they aim with deadly precision at exposed flesh and vital organs and leave bleeding, life-threatening wounds. When fighting them one " +
                            "should make liberal use of draconid oil as well as Grapeshot, whose shrapnel will pierce their delicate wings with ease.",
                    "https://res.cloudinary.com/dayqxxsip/image/upload/v1613822664/App%20Images/Witcher%203%20Bestiary/Draconids/654_wstvhy.png",
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
                            "– Yavinn Buck, veteran of the Mahakaman Volunteer Regiment\n\n" +
                            "Forktails owe their quaint name to the long sharp growths at the tip of their tails. A blow from this weapon can slice an oaken shield in two – along with the arm that was carrying it. Thus, though its name conjures images of cutlery, fighting a forktail is nothing like a dinner party and ends in death rather than dessert.",
                    "https://res.cloudinary.com/dayqxxsip/image/upload/v1613822714/App%20Images/Witcher%203%20Bestiary/Draconids/latest_tcxozy.png",
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
                            "– Conversation overheard in Velen\n\n" +
                            "A hunter who knows his prey's habits and behavior will rarely return from his hunt empty-handed. To know what forest paths deer are like to trod, to know in what muck boars will wallow, to guess when a hare will emerge from its burrow - that is half the battle.\n\n" +
                            "What most men do not know is that some monsters also possess such knowledge. For example, a royal wyvern from Velen had learned the danger of exposing itself to human eyes and arrows by flying high to pick out its prey from afar. Instead, it would lurk by the roadside and wait for military transports. In this way it grew fat on salted pork and beer, expanding until it resembled a dragon more than other, lesser members of its own kind.\n\n" +
                            "The witcher thus knew this beast would be much stronger and more resilient than a normal wyvern. Even one blow from it could kill - which is why he would need to avoid its charge at all costs. He would also be wise to force it to the ground with his crossbow or a bomb whenever it tried to fly into the air and hurtle down in a deadly dive.\n\n" +
                            "In the end the witcher slew the hideous creature, though not without some difficulty. Thanks to this feat, the soldiers could once again send shipments of food and equipment needed to conduct the war. Whether that was a good or a bad thing - that is an entirely different matter.",
                    "https://res.cloudinary.com/dayqxxsip/image/upload/v1613822695/App%20Images/Witcher%203%20Bestiary/Draconids/latest_e9uupo.png",
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
                            "– Conversation overheard at Crow's Perch\n\n" +
                            "The monster tormenting the residents of Crow's Perch turned out to be a particularly nasty cockatrice. Geralt was not surprised the baron's men had been unable to stop it. They could not possibly withstand the surgical precision of its strikes, which slice open arteries and provoke an outpouring of blood only the Swallow potion could hope to stop. Neither did they know to force it to the ground with a crossbow, a bomb or a Sign, and then evade its charge by rolling under the monster's outstretched wing.\n\n" +
                            "Just when it seemed the villagers would have to learn to live in the shadow of a bloodthirsty beast, to always look to the sky with fear, the witcher arrived - and put an end to the shrieker for good.",
                    "https://res.cloudinary.com/dayqxxsip/image/upload/v1613822767/App%20Images/Witcher%203%20Bestiary/Draconids/latest_qgepc4.png",
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
                            "- Anatole Vizholy, shoemaker from Beauclair\n\n" +
                            "Geralt always liked looking at things that don't exist. Be it a vampire with a human heart of the last basilisk of a species that no scholar has classified, discovering something thought not to be there to be discovered caused him great pleasure. That is why he took an interest in a contract which, at first glance, seemed banal, but proved to be very intriguing. It concerned the last basilisk of the nearly-extinct species Regulus Platinum.\n\n" +
                            "In the end, Geralt decided not to kill the basilisk, for who in his right mind would raise his sword against a living legend?",
                    "https://res.cloudinary.com/dayqxxsip/image/upload/v1613822791/App%20Images/Witcher%203%20Bestiary/Draconids/latest_jobdtg.png",
                    "Toussaint",
                    "Golden Oriole,Draconid oil,Aard,Igni",
                    "None",
                    LocalDate.now(),
                    draconids
            );

            Monster slyzard = new Monster(
                    "slyzard",
                    "Slyzard",
                    "Some peasants once offered me a king's ransom to slay a slyzard. A damned hefty purse, chock full o' gold... But I turned 'em down. Coin's no good if you're dead. And a slyzard, that's no fuckin' forktail.\n" +
                            "– Zator, one of the Crinfrid Reavers\n\n" +
                            "Slyzards are often mistaken for wyverns or forktails. Yet make no mistake: slyzards are nasty, terribly dangerous beasts, and confusing them for wyverns will end very badly for the confuser. While a wyvern can tear apart and devour an untrained man in seconds, only a slyzard can first bake him to a crisp with a waft of fiery breath.\n\n" +
                            "Slyzards are keenly aggressive and attack from both ground and air. Their goal during a fight is to get close enough to their foe to injure it with a breath of fire or knock it down with a sonic blast. Like wyverns, slyzards also attack with venom-spiked tails.\n\n" +
                            "Slyzards like to disengage mid-fight to fly into the air and plummet down at high speed while spewing out balls of fire.\n\n" +
                            "Right before these igneous missiles emerge, you can observe a fiery ball forming in the monster's maw. While airborne, a slyzard can also attack with its claws and teeth.\n\n" +
                            "It is worthwhile to employ the Aard and Igni Signs to force slyzards to the ground. They are not, however, vulnerable to burning. Before tackling one of them, be sure to coat your blade in draconid oil.",
                    "https://res.cloudinary.com/dayqxxsip/image/upload/v1613822815/App%20Images/Witcher%203%20Bestiary/Draconids/latest_xteslw.png",
                    "Dragon Mountains near Barefield,Toussaint",
                    "Grapeshot,Draconid oil,Aard,Quen",
                    "Slyzard scale plate",
                    LocalDate.now(),
                    draconids
            );

            Monster slyzardMatriarch = new Monster(
                    "slyzard-matriarch",
                    "Slyzard Matriarch",
                    "If you ever find yourself facing a monster that breathes fire, strikes with a tail tipped with venomous spines, bites with sharp teeth and swipes with even sharper claws and tends to knock its prey to the ground with a sonic blast, " +
                            "then you are fighting a slyzard. With an arsenal like that, it comes as no surprise folk often mistake these draconids for dragons. Yet the experts (meaning witchers) know " +
                            "slyzards constitute an entirely separate species, much smaller than dragons and far less dangerous. With one exception: slyzard females in mating season, or, even worse, just after laying their eggs. " +
                            "When fighting such individuals, my suggestion is to get as far as possible from the danger as quickly as possible, preferably by running, at full tilt, without looking back.",
                    "https://res.cloudinary.com/dayqxxsip/image/upload/v1613822842/App%20Images/Witcher%203%20Bestiary/Draconids/latest_h3bo9f.png",
                    "Toussaint",
                    "Grapeshot,Draconid oil,Aard,Quen",
                    "Slyzard trophy",
                    LocalDate.now(),
                    draconids
            );

            Monster dragonOfFyresdal = new Monster(
                    "the-dragon-of-fyresdal",
                    "The Dragon of Fyresdal",
                    "It's got scales, wings, claws... A dragon's a dragon! No point gabbin', just go kill it!\n" +
                            "– Vagn, village elder of Fyresdal\n\n" +
                            "Few truly know what a dragon looks like, for those who have seen one up-close rarely have a chance to share their impressions. That is why people are forever mistaking other monsters for dragons. This was the case in Fyresdal, where the so-called dragon wreaking havoc turned out to be a forktail.\n\n" +
                            "Yet this mistaken attribution did not mean there was no reason to worry. The forktail harassing Fyresdal was a particularly vile representative of its kind, one equipped with an endless store of deadly venom. Fighting it without first drinking a regenerative potion or a poison antidote would be tantamount to suicide.\n\n" +
                            "In his fight with the forktail, Geralt gave proof not only of his masterful swordsmanship, but also of a previously-undemonstrated flair for shepherdry. With a little help from a brave sheep lent by the village elder, he lured the monster into a trap - then ended its life.",
                    "https://res.cloudinary.com/dayqxxsip/image/upload/v1613822868/App%20Images/Witcher%203%20Bestiary/Draconids/latest_yckezl.png",
                    "Abandoned siege tower outside Fyresdal",
                    "Golden Oriole,Grapeshot,Draconid oil,Aard",
                    "Dragon scales,Forktail mutagen,Forktail hide,Forktail trophy,Monster bone,Monster heart,Monster tongue",
                    LocalDate.now(),
                    draconids
            );

            Monster wyverns = new Monster(
                    "wyverns",
                    "Wyverns",
                    "Most dangerous of all are the royal wyverns. Or, as they're called in some circles, the royal pains in the arse.\n" +
                            "– Albina Tottelkampf, lecturer in natural sciences at Aretuza\n\n" +
                            "Wyverns are often mistaken for dragons, and, though they are much smaller than their more famous kin and do not breathe fire, they are likewise extremely dangerous monsters. Especially feared are the so-called royal wyverns who, " +
                            "like their namesake monarchs, are exceptionally ornery and extremely deadly.",
                    "https://res.cloudinary.com/dayqxxsip/image/upload/v1613822741/App%20Images/Witcher%203%20Bestiary/Draconids/latest_dhs6hk.png",
                    "Velen,Skellige",
                    "Golden Oriole,Grapeshot,Draconid oil,Aard",
                    "Dragon scales,Monster blood,Monster bone,Monster brain,Monster claw,Monster eye,Wyvern egg,Wyvern hide,Wyvern mutagen,Wyvern trophy",
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
                            silverBasilisk,
                            slyzard,
                            slyzardMatriarch,
                            dragonOfFyresdal,
                            wyverns)
            );
        };
    }
}