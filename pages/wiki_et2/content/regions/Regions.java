package com.cnx.endlesstalestwo.data.regions;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Region;
import com.cnx.endlesstalestwo.enums.Enums;

public class Regions extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.REGION, lisport());
        App.DataManager.add(Enums.DataTypes.REGION, havarusNorth());
        App.DataManager.add(Enums.DataTypes.REGION, havarusSouth());
        App.DataManager.add(Enums.DataTypes.REGION, gybralarForest());
        App.DataManager.add(Enums.DataTypes.REGION, esperand());
        App.DataManager.add(Enums.DataTypes.REGION, wazel());
        App.DataManager.add(Enums.DataTypes.REGION, growrocks());
        App.DataManager.add(Enums.DataTypes.REGION, ayalon());
        App.DataManager.add(Enums.DataTypes.REGION, underworld());
        App.DataManager.add(Enums.DataTypes.REGION, dragonland());
    }

    Region lisport() {
        Region region = new Region("Lisport");
        region.mapItemUid = ItemsIds.LISPORT_MAP;

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "Lisport is an independent island kingdom far from the main continent, governed by its own king " +
                        "with no direct ties to the kingdom of Havarus, though it maintains good diplomatic relations with " +
                        "the crown of Monelix. Characterized by architecture that blends wood and stone constructions, an " +
                        "imposing castle dominates the landscape in the background, while the tree-lined central square " +
                        "serves as the heart of local commerce. The city is well-structured with organized streets and a " +
                        "diverse population of merchants, alchemists, farmers, and fishermen. Its natural harbor offers a " +
                        "strategic position on maritime routes, making it both a commercial point and a defense position.");

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "Lisport é um reino-ilha independente afastado do continente principal, governado por seu próprio rei " +
                        "sem ligação direta com o reino de Havarus, embora mantenha boas relações diplomáticas com a coroa de " +
                        "Monelix. Caracterizado por sua arquitetura que mescla construções de madeira e pedra, um imponente " +
                        "castelo domina a paisagem ao fundo, enquanto a praça central arborizada serve como coração do comércio " +
                        "local. A cidade é bem estruturada com ruas organizadas e uma população diversificada de mercadores, " +
                        "alquimistas, fazendeiros e pescadores. Seu porto natural oferece posição estratégica nas rotas " +
                        "marítimas, tornando-a tanto um ponto comercial quanto de defesa.");

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "Lisport es un reino-isla independiente alejado del continente principal, gobernado por su propio rey " +
                        "sin vínculos directos con el reino de Havarus, aunque mantiene buenas relaciones diplomáticas con la " +
                        "corona de Monelix. Caracterizado por su arquitectura que mezcla construcciones de madera y piedra, un " +
                        "imponente castillo domina el paisaje al fondo, mientras que la plaza central arbolada sirve como corazón " +
                        "del comercio local. La ciudad está bien estructurada con calles organizadas y una población diversificada " +
                        "de comerciantes, alquimistas, granjeros y pescadores. Su puerto natural ofrece una posición estratégica " +
                        "en las rutas marítimas, convirtiéndola tanto en un punto comercial como de defensa.");

        return region;
    }

    Region havarusNorth() {
        Region region = new Region("Havarus North");
        region.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Havarus Norte");
        region.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Havarus Norte");
        region.mapItemUid = ItemsIds.HAVARUS_NORTH_MAP;

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "The northern region of the great continental kingdom of Havarus concentrates political and military " +
                        "power, governed by Queen Enola Lysnes from the capital Monelix. Monelix rises as the largest city " +
                        "in the kingdom - its high stone walls protect the royal castle, the clock tower that dominates the " +
                        "horizon, vast libraries and markets full of varieties. Farmland, with its fertile lands, feeds the " +
                        "entire kingdom, while Letow is a small village granted to the Falker family in ancient times. This " +
                        "is the most developed and populous region, being the center of decisions that shape the destiny of " +
                        "the entire kingdom.");

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "A região norte do grande reino continental de Havarus concentra o poder político e militar, governada " +
                        "pela Rainha Enola Lysnes desde a capital Monelix. Monelix ergue-se como a maior cidade do reino - suas " +
                        "altas muralhas de pedra protegem o castelo real, a torre do relógio que domina o horizonte, vastas " +
                        "bibliotecas e mercados repletos de variedades. Farmland, com suas terras férteis, alimenta todo o reino, " +
                        "enquanto Letow é um pequeno vilarejo concedido à família Falker em tempos antigos. Esta é a região mais " +
                        "desenvolvida e populosa, sendo o centro das decisões que moldam o destino de todo o reino.");

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "La región norte del gran reino continental de Havarus concentra el poder político y militar, gobernada " +
                        "por la Reina Enola Lysnes desde la capital Monelix. Monelix se eleva como la ciudad más grande del reino " +
                        "- sus altas murallas de piedra protegen el castillo real, la torre del reloj que domina el horizonte, " +
                        "vastas bibliotecas y mercados llenos de variedades. Farmland, con sus tierras fértiles, alimenta todo " +
                        "el reino, mientras que Letow es un pequeño pueblo concedido a la familia Falker en tiempos antiguos. " +
                        "Esta es la región más desarrollada y poblada, siendo el centro de las decisiones que moldean el destino " +
                        "de todo el reino.");

        return region;
    }

    Region havarusSouth() {
        Region region = new Region("Havarus South");
        region.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Havarus Sul");
        region.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Havarus Sur");
        region.mapItemUid = ItemsIds.HAVARUS_SOUTH_MAP;

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "The southern region of the continental kingdom of Havarus has a history marked by ancient political " +
                        "tensions that led to greater autonomy agreements. Helera, the second largest city in the kingdom " +
                        "governed by Lord Mathew Wintar, stands out with brown stone walls and extensive commercial areas full " +
                        "of colorful tents. Bastian, under Lord Markus Wintar, is known for its hardworking people and narrow " +
                        "streets. Fisherman Ville lives from coastal fishing, Apenna is home to the loggers, and Umera serves " +
                        "the miners who work in the nearby mountains. This diverse region balances trade, natural resources, " +
                        "and pride in its unique identity within the kingdom.");

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "A região sul do reino continental de Havarus possui história marcada por antigas tensões políticas que " +
                        "levaram a acordos de autonomia maior. Helera, segunda maior cidade do reino governada por Lord Mathew " +
                        "Wintar, destaca-se com muros de pedra marrom e extensas áreas de comércio repletas de tendas coloridas. " +
                        "Bastian, sob Lord Markus Wintar, é conhecida pelo seu povo trabalhador e ruas estreitas. Fisherman Ville " +
                        "vive da pesca costeira, Apenna é o lar dos lenhadores e Umera serve aos mineradores que trabalham nas " +
                        "montanhas próximas. Esta região diversificada equilibra comércio, recursos naturais e orgulho por sua " +
                        "identidade única no reino.");

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "La región sur del reino continental de Havarus tiene una historia marcada por antiguas tensiones políticas " +
                        "que llevaron a acuerdos de mayor autonomía. Helera, la segunda ciudad más grande del reino gobernada por " +
                        "Lord Mathew Wintar, se destaca con murallas de piedra marrón y extensas áreas comerciales llenas de tiendas " +
                        "coloridas. Bastian, bajo Lord Markus Wintar, es conocida por su gente trabajadora y calles estrechas. " +
                        "Fisherman Ville vive de la pesca costera, Apenna es el hogar de los leñadores y Umera sirve a los mineros " +
                        "que trabajan en las montañas cercanas. Esta región diversa equilibra comercio, recursos naturales y orgullo " +
                        "por su identidad única en el reino.");

        return region;
    }

    Region gybralarForest() {
        Region region = new Region("Gybralar Forest");
        region.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Floresta Gybralar");
        region.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bosque Gybralar");
        region.mapItemUid = ItemsIds.GYBRALAR_FOREST_MAP;

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "Gybralar Forest is a vast and dense expanse of ancient trees located within the southern territory " +
                        "of Havarus, functioning as a natural barrier between different civilized areas. Divided into five " +
                        "large sections - north, south, east, west, and inner - the forest offers an abundance of vital " +
                        "natural resources: quality wood, rare medicinal herbs, abundant hunting, and gathering points. The " +
                        "air is fresh, birds sing constantly, and the vegetation creates an environment of natural beauty " +
                        "that contrasts with its dangerous reputation. Magical creatures such as wooden golems inhabit its " +
                        "depths, and ancient elven paths forgotten by time can still be found by those brave enough to " +
                        "explore its secrets.");

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "A Floresta Gybralar é uma vasta e densa extensão de árvores antigas localizada dentro do território " +
                        "sul de Havarus, funcionando como barreira natural entre diferentes áreas civilizadas. Dividida em " +
                        "cinco grandes seções - norte, sul, leste, oeste e interior - a floresta oferece abundância de recursos " +
                        "naturais vitais: madeira de qualidade, ervas medicinais raras, caça abundante e pontos de coleta. O ar " +
                        "é fresco, pássaros cantam constantemente e a vegetação cria um ambiente de beleza natural que contrasta " +
                        "com sua reputação perigosa. Criaturas mágicas como golems de madeira habitam suas profundezas, e antigos " +
                        "caminhos élficos esquecidos pelo tempo ainda podem ser encontrados por aqueles corajosos o suficiente " +
                        "para explorar seus segredos.");

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "El Bosque Gybralar es una vasta y densa extensión de árboles antiguos ubicada dentro del territorio sur " +
                        "de Havarus, funcionando como barrera natural entre diferentes áreas civilizadas. Dividido en cinco grandes " +
                        "secciones - norte, sur, este, oeste e interior - el bosque ofrece abundancia de recursos naturales vitales: " +
                        "madera de calidad, hierbas medicinales raras, caza abundante y puntos de recolección. El aire es fresco, " +
                        "los pájaros cantan constantemente y la vegetación crea un ambiente de belleza natural que contrasta con " +
                        "su reputación peligrosa. Criaturas mágicas como golems de madera habitan sus profundidades, y antiguos " +
                        "caminos élficos olvidados por el tiempo aún pueden ser encontrados por aquellos lo suficientemente " +
                        "valientes para explorar sus secretos.");

        return region;
    }

    Region esperand() {
        Region region = new Region("Esperand");
        region.mapItemUid = ItemsIds.ESPERAND_MAP;

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "Esperand is a horseshoe-shaped island covered in eternal snow and ice, maintaining semi-independent " +
                        "kingdom status under Havarus sovereignty, locally governed by Lord Mukas Wintar. Despite extremely " +
                        "low temperatures, its resilient people built a remarkable city at the island's northern top, with " +
                        "stone and wood houses, blue-painted roofs frequently covered in snow, and fixed lit torches on every " +
                        "street to provide light and warmth. A central well marks the city's main square. To the south on the " +
                        "right side of the island, isolated from urban bustle, stands a majestic Gothic-style monastery " +
                        "surrounded by low walls, ample gardens with a frozen lake, and accommodations in columned corridors, " +
                        "where monks dedicate themselves to prayer and knowledge preservation.");

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "Esperand é uma ilha em formato de ferradura coberta por neve e gelo eternos, mantendo status de reino " +
                        "semi-independente sob soberania de Havarus, governada localmente por Lord Mukas Wintar. Apesar das " +
                        "temperaturas extremamente baixas, seu povo resiliente construiu uma cidade notável no topo norte da ilha, " +
                        "com casas de pedra e madeira, telhados pintados de azul frequentemente cobertos pela neve, e tochas acesas " +
                        "fixas em cada rua para prover luz e calor. Um poço central marca a praça principal da cidade. Ao sul no " +
                        "lado direito da ilha, isolado do burburinho urbano, ergue-se um majestoso monastério em estilo gótico " +
                        "cercado por muros baixos, jardins amplos com lago congelado e acomodações em corredores com pilares, onde " +
                        "monges dedicam-se à oração e preservação do conhecimento.");

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "Esperand es una isla en forma de herradura cubierta de nieve y hielo eternos, manteniendo el estatus de " +
                        "reino semi-independiente bajo la soberanía de Havarus, gobernada localmente por Lord Mukas Wintar. A pesar " +
                        "de las temperaturas extremadamente bajas, su pueblo resistente construyó una ciudad notable en la parte " +
                        "superior norte de la isla, con casas de piedra y madera, techos pintados de azul frecuentemente cubiertos " +
                        "de nieve, y antorchas encendidas fijas en cada calle para proporcionar luz y calor. Un pozo central marca " +
                        "la plaza principal de la ciudad. Al sur en el lado derecho de la isla, aislado del bullicio urbano, se " +
                        "erige un majestuoso monasterio de estilo gótico rodeado de muros bajos, amplios jardines con lago congelado " +
                        "y alojamientos en corredores con pilares, donde los monjes se dedican a la oración y preservación del " +
                        "conocimiento.");

        return region;
    }

    Region wazel() {
        Region region = new Region("Wazel");
        region.mapItemUid = ItemsIds.WAZEL_MAP;

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "Wazel is an independent desert kingdom situated on an arid island, famous for its unique architecture " +
                        "of light stone and clay with rounded roofs and colorful tapestries that decorate both exteriors and " +
                        "interiors. Surrounded by high defensive walls, the city has streets paved with small stones amid " +
                        "omnipresent sand, creating a vibrant and exotic environment. The military forces are led by Danjor, " +
                        "commander of the local troops. The region includes vital oases for survival, desert trails, a busy " +
                        "port, the mysterious Tower of Warriors, deep desert caverns, and the dangerous Deep Crater - an " +
                        "enormous crater where the entrance to the dwarven underground kingdom can be found.");

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "Wazel é um reino-deserto independente situado em uma ilha árida, famoso por sua arquitetura única de " +
                        "pedra clara e argila com telhados arredondados e tapeçarias coloridas que decoram tanto exteriores quanto " +
                        "interiores. Cercada por altos muros defensivos, a cidade possui ruas pavimentadas com pequenas pedras em " +
                        "meio à areia onipresente, criando um ambiente vibrante e exótico. As forças militares são lideradas por " +
                        "Danjor, comandante das tropas locais. A região inclui oásis vitais para sobrevivência, trilhas desérticas, " +
                        "um porto movimentado, a misteriosa Torre dos Guerreiros, cavernas profundas no deserto e a perigosa Deep " +
                        "Crater - uma enorme cratera onde a entrada para o reino subterrâneo dos anões pode ser encontrada.");

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "Wazel es un reino-desierto independiente situado en una isla árida, famoso por su arquitectura única de " +
                        "piedra clara y arcilla con techos redondeados y tapices coloridos que decoran tanto exteriores como " +
                        "interiores. Rodeada por altas murallas defensivas, la ciudad tiene calles pavimentadas con pequeñas piedras " +
                        "en medio de arena omnipresente, creando un ambiente vibrante y exótico. Las fuerzas militares son lideradas " +
                        "por Danjor, comandante de las tropas locales. La región incluye oasis vitales para la supervivencia, senderos " +
                        "desérticos, un puerto concurrido, la misteriosa Torre de los Guerreros, cavernas profundas en el desierto y " +
                        "la peligrosa Deep Crater - un enorme cráter donde se puede encontrar la entrada al reino subterráneo de " +
                        "los enanos.");

        return region;
    }

    Region growrocks() {
        Region region = new Region("Growrocks");
        region.mapItemUid = ItemsIds.GROWROCKS_MAP;

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "Growrocks is the underground kingdom of the dwarves, built in the depths of the Deep Crater in the " +
                        "Wazel desert, where this reclusive people developed an advanced civilization focused on mining and " +
                        "forging. The Dwarven City impresses with its constructions entirely of worked stone, reddish roofs " +
                        "with chimneys exhaling smoke from the forges, light cobblestone streets illuminated by torch posts, " +
                        "and dwarves constantly circulating with wheelbarrows full of ores, food, and various materials. The " +
                        "dwarves are unparalleled masters in the extraction and working of rare caltranium, an exceptional " +
                        "metal discovered by their people in deep mines, known for incomparable resistance and durability.");

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "Growrocks é o reino subterrâneo dos anões, construído nas profundezas da Deep Crater no deserto de Wazel, " +
                        "onde este povo recluso desenvolveu uma civilização avançada focada em mineração e forjaria. A Dwarven City " +
                        "impressiona com suas construções inteiramente de pedra trabalhada, telhados avermelhados com chaminés que " +
                        "exalam fumaça das forjas, ruas de paralelepípedos claros iluminadas por postes de tochas e anões circulando " +
                        "constantemente com carrinhos de mão repletos de minérios, alimentos e materiais diversos. Os anões são mestres " +
                        "inigualáveis na extração e trabalho do raro caltranium, metal excepcional descoberto por seu povo em minas " +
                        "profundas, conhecido por resistência e durabilidade incomparáveis.");

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "Growrocks es el reino subterráneo de los enanos, construido en las profundidades del Deep Crater en el " +
                        "desierto de Wazel, donde este pueblo recluso desarrolló una civilización avanzada centrada en la minería " +
                        "y la forja. La Dwarven City impresiona con sus construcciones enteramente de piedra trabajada, techos " +
                        "rojizos con chimeneas que exhalan humo de las forjas, calles de adoquines claros iluminadas por postes " +
                        "de antorchas y enanos circulando constantemente con carretillas llenas de minerales, alimentos y diversos " +
                        "materiales. Los enanos son maestros incomparables en la extracción y trabajo del raro caltranium, un metal " +
                        "excepcional descubierto por su pueblo en minas profundas, conocido por su resistencia y durabilidad " +
                        "incomparables.");

        return region;
    }

    Region ayalon() {
        Region region = new Region("Ayalon");
        region.mapItemUid = ItemsIds.AYALON_MAP;

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "Ayalon is the ancestral land of the elves, an isolated and magically protected region where the " +
                        "Elven Citadel rises, a masterpiece of elven architecture with slender towers reaching the skies and " +
                        "enchanted gardens full of magical flora. The houses built with immaculate white stones and green roofs " +
                        "create visual harmony with the flowering trees that adorn every street, while birds fly gracefully over " +
                        "the city and conversations in elven language echo everywhere. For generations, the elves have cultivated " +
                        "their civilization in deliberate isolation, distrusting the expansionist and conflictive nature of humans. " +
                        "The Citadel houses the sacred temple of the elves, medicinal herb gardens of herbalists, the library of " +
                        "the wise full of millenary arcane knowledge, and the castle where Emperor Arilas governs with ancestral " +
                        "wisdom over his people.");

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "Ayalon é a terra ancestral dos elfos, uma região isolada e magicamente protegida onde se ergue a Elven " +
                        "Citadel (Cidadela dos Elfos), obra-prima de arquitetura élfica com torres esguias que alcançam os céus e " +
                        "jardins encantados repletos de flora mágica. As casas construídas com pedras brancas imaculadas e telhados " +
                        "verdes criam harmonia visual com as árvores floridas que adornam cada rua, enquanto pássaros voam " +
                        "graciosamente sobre a cidade e conversas em idioma élfico ecoam por toda parte. Por gerações, os elfos " +
                        "cultivaram sua civilização em isolamento deliberado, desconfiando da natureza expansionista e conflituosa " +
                        "dos humanos. A Cidadela abriga o templo sagrado dos elfos, jardins de ervas medicinais dos herbalistas, a " +
                        "biblioteca dos sábios repleta de conhecimentos arcanos milenares, e o castelo onde o Imperador Arilas governa " +
                        "com sabedoria ancestral sobre seu povo.");

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "Ayalon es la tierra ancestral de los elfos, una región aislada y mágicamente protegida donde se erige la " +
                        "Elven Citadel (Ciudadela Élfica), obra maestra de arquitectura élfica con torres esbeltas que alcanzan los " +
                        "cielos y jardines encantados llenos de flora mágica. Las casas construidas con piedras blancas inmaculadas " +
                        "y techos verdes crean armonía visual con los árboles florecidos que adornan cada calle, mientras los pájaros " +
                        "vuelan graciosamente sobre la ciudad y conversaciones en idioma élfico resuenan por todas partes. Por " +
                        "generaciones, los elfos han cultivado su civilización en aislamiento deliberado, desconfiando de la naturaleza " +
                        "expansionista y conflictiva de los humanos. La Ciudadela alberga el templo sagrado de los elfos, jardines de " +
                        "hierbas medicinales de los herbalistas, la biblioteca de los sabios repleta de conocimientos arcanos milenarios, " +
                        "y el castillo donde el Emperador Arilas gobierna con sabiduría ancestral sobre su pueblo.");

        return region;
    }

    public Region underworld() {
        Region region = new Region("Underworld");
        region.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Submundo");
        region.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Inframundo");

        return region;
    }

    Region dragonland() {
        Region region = new Region("Dragonland");
        region.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Terra dos Dragões");
        region.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Tierra de Dragones");
        region.mapItemUid = ItemsIds.DRAGONLAND_MAP;

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "Dragonland is a remote, arid island with dark soil, dominated by a massive mountain that occupies almost the entire island. It is the legendary home of dragons.");

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "Dragonland é uma ilha remota, árida e com terra escura, onde uma montanha ocupa quase toda a ilha. É o lar lendário dos dragões.");

        region.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "Dragonland es una isla remota y árida con tierra oscura, donde una montaña ocupa casi toda la isla. Es el hogar legendario de los dragones.");

        return region;
    }
}
