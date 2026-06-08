package com.cnx.endlesstalestwo.data.items;

import static com.cnx.endlesstalestwo.data.crafts.Crafts.getCraftsToDisplay;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.BookItem;
import com.cnx.endlesstalestwo.entities.Item;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Books extends DataHelper {

    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.ITEM, letterFromErino());
        App.DataManager.add(Enums.DataTypes.ITEM, loveLetter());
        App.DataManager.add(Enums.DataTypes.ITEM, letterFromQueen());
        App.DataManager.add(Enums.DataTypes.ITEM, aQueensMessage());
        App.DataManager.add(Enums.DataTypes.ITEM, woodcuttersLetter());
        App.DataManager.add(Enums.DataTypes.ITEM, alchemyAnnotations());
        App.DataManager.add(Enums.DataTypes.ITEM, alchemyForDummies());
        App.DataManager.add(Enums.DataTypes.ITEM, theMasterBookOfCrafter());//
        App.DataManager.add(Enums.DataTypes.ITEM, theCookBook());//
        App.DataManager.add(Enums.DataTypes.ITEM, queensRequisitionLetter());
        App.DataManager.add(Enums.DataTypes.ITEM, ancientElvenProphecies());//
        App.DataManager.add(Enums.DataTypes.ITEM, goldenAgeChronicle());//
        App.DataManager.add(Enums.DataTypes.ITEM, ancientScrollUntranslated());//
        App.DataManager.add(Enums.DataTypes.ITEM, ancientScrollTranslated());//
        App.DataManager.add(Enums.DataTypes.ITEM, theRareMetalCaltranium());//
        App.DataManager.add(Enums.DataTypes.ITEM, chroniclesOfTheDwarvenFolk());//
        App.DataManager.add(Enums.DataTypes.ITEM, studentLetter());
        App.DataManager.add(Enums.DataTypes.ITEM, spiritTreasureDocument());
        App.DataManager.add(Enums.DataTypes.ITEM, ancientLiberationTome());
        App.DataManager.add(Enums.DataTypes.ITEM, treasureMap());
        App.DataManager.add(Enums.DataTypes.ITEM, oldBrantContract());
        App.DataManager.add(Enums.DataTypes.ITEM, falkerApologyLetter());
        App.DataManager.add(Enums.DataTypes.ITEM, jardLoveLetter());
    }

    BookItem letterFromErino() {
        BookItem book = new BookItem("Letter from Erino");
        book.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Carta de Erino");
        book.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Carta de Erino");

        book.weight = .1f;
        book.vanishAfterRead = false;
        book.sellable = false;
        book.buyable = false;
        book.discardable = false;
        book.canBeIngredient = false;
        return book;
    }

    BookItem loveLetter() {
        BookItem book = new BookItem("Rawer Love letter");
        book.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Carta de amor de Rawer");
        book.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Carta de amor de Rawer");

        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A letter wrote by a passionated doctor.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma carta escrita por um médico apaixonado.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una carta escrita por un médico apasionado.");

        book.weight = .1f;
        book.vanishAfterRead = false;
        book.sellable = false;
        book.buyable = false;
        book.discardable = false;
        book.canBeIngredient = false;

        return book;
    }

    Item letterFromQueen() {
        BookItem item = new BookItem("Letter from Queen");
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Carta da Rainha");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Carta de la reina");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A royal letter from the queen Enola to you.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma carta real da rainha Enola para você.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una carta real de la reina Enola para ti.");

        item.addTextTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Dear, [GENDER_FORMAL_CALL] [PLAYERNAME],\nBe aware that the majestic queen of Havarus wants to meet with you as soon as possible to talk about a job opportunity.\nYour work at Lisport by fighting orcs is recognized as a efficient and deserved the attention of the havarus forces.\n\nSigned by Queen Enola of Havarus");
        item.addTextTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caro, [GENDER_FORMAL_CALL] [PLAYERNAME],\nEsteja ciente de que a majestosa rainha de Havarus quer se encontrar com você o mais breve possível para falar sobre uma oportunidade de emprego.\nSeu trabalho em Lisport lutando contra orcs é reconhecido como eficiente e merece a atenção das forças de Havarus.\nAssinado pela Rainha Enola de Havarus");
        item.addTextTranslation(CoreEnums.AvailableLanguages.SPANISH, "Estimado, [GENDER_FORMAL_CALL] [PLAYERNAME],\nTen en cuenta que la majestuosa reina de Havarus quiere reunirse contigo lo antes posible para hablar sobre una oportunidad laboral.\nTu trabalho en Lisport luchando contra los orcos es reconocido como eficiente y merece la atención de las forças de Havarus.\n\nFirmado por la Reina Enola de Havarus");

        item.listener = ctx -> {
            Quest newQuest = App.DataManager.getQuest(QuestsIds.OVERSEAS_RECOGNITION);
            LibQuest.includeQuestToQuestbook(newQuest, App.getPlayerChar(), ctx);
        };

        item.weight = 0.1f;
        item.marketValue = 1;
        item.vanishAfterRead = true;
        item.sellable = false;
        item.discardable = false;
        item.imgFile = "item_generic_letter";
        item.illustrationFile = "items/item_generic_letter";
        item.canBeIngredient = false;

        return item;
    }

    Item aQueensMessage() {
        BookItem item = new BookItem("A Queen's Message");
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mensagem da Rainha");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mensaje de la Reina");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "An urgent letter from Queen Enola requesting an emergency meeting at the castle.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma carta urgente da Rainha Enola solicitando uma reunião de emergência no castelo.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una carta urgente de la Reina Enola solicitando uma reunião de emergência en el castillo.");

        item.addTextTranslation(CoreEnums.AvailableLanguages.ENGLISH, "[PLAYERNAME],\n\nThe situation has escalated far beyond what we anticipated. Dark creatures are attacking multiple locations simultaneously. I need your expertise now more than ever.\n\nCome to the castle immediately. We must discuss the defense of our kingdom and make critical decisions about where to deploy our forces.\n\nTime is of the essence.\n\nQueen Enola");
        item.addTextTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "[PLAYERNAME],\n\nA situação se agravou muito além do que antecipamos. Criaturas das trevas estão atacando múltiplos locais simultaneamente. Preciso de sua experiência agora mais do que nunca.\n\nVenha ao castelo imediatamente. Devemos discutir a defesa do nosso reino e tomar decisões críticas sobre onde deslocar nossas forças.\n\nO tempo é essencial.\n\nRainha Enola");
        item.addTextTranslation(CoreEnums.AvailableLanguages.SPANISH, "[PLAYERNAME],\n\nLa situación se ha agravado mucho más allá de lo anticipado. Las criaturas oscuras están atacando múltiples ubicaciones simultáneamente. Necesito tu experiencia ahora más que nunca.\n\nVen al castillo inmediatamente. Debemos discutir la defensa de nuestro reino y tomar decisiones críticas sobre dónde desplegar nuestras fuerzas.\n\nEl tiempo es esencial.\n\nReina Enola");

        item.listener = ctx -> {
            Quest newQuest = App.DataManager.getQuest(QuestsIds.A_QUEEN_MESSAGE);
            LibQuest.includeQuestToQuestbook(newQuest, App.getPlayerChar(), ctx);
        };

        item.weight = 0.1f;
        item.marketValue = 1;
        item.vanishAfterRead = true;
        item.sellable = false;
        item.discardable = false;
        item.imgFile = "item_generic_letter";
        item.illustrationFile = "items/item_generic_letter";
        item.canBeIngredient = false;

        return item;
    }

    Item woodcuttersLetter() {
        BookItem item = new BookItem("Woodcutters Letter");
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Carta dos Lenhadores");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Carta de los Leñadores");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A letter from the woodcutters of Apenna addressed to the kingdom leaders.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma carta dos lenhadores de Apenna endereçada aos líderes do reino.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una carta de los leñadores de Apenna dirigida a los líderes del reino.");

        item.addTextTranslation(CoreEnums.AvailableLanguages.ENGLISH, "To our Majesty, the Queen, and the Esteemed Leaders of the Kingdom,\n\n" +
                "We, the woodcutters of Apenna, humbly address you with a matter of grave concern. For years, we have labored tirelessly to provide timber for the kingdom, enduring harsh conditions and risking our lives to ensure the prosperity of our land. However, our efforts have gone unrecognized, and our struggles have been met with indifference.\n" +
                "Yesterday, one of our own, a dedicated and hardworking man, lost his life in the line of duty. His death was preventable, yet no aid or support was extended to him or his family. This tragedy is a stark reminder of the neglect we face daily.\n" +
                "We demand the following:\n" +
                "Fair wages that reflect the dangers and hardships of our work.\n" +
                "Support for the families of those injured or killed in service to the kingdom.\n\n" +
                "Until these demands are met, we will halt all production of planks and logs. We do not take this decision lightly, but we must stand together to ensure our voices are heard.\n" +
                "We trust that you will act with the wisdom and compassion befitting your station.\n" +
                "Respectfully,\nThe Woodcutters of Apenna");
        item.addTextTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Para vossa Majestade, a Rainha, e os Estimados Líderes do Reino,\n\n" +
                "Nós, os lenhadores de Apenna, humildemente nos dirigimos a vocês com um assunto de extrema importância. Por anos, trabalhamos incansavelmente para fornecer madeira para o reino, suportando condições difíceis e arriscando nossas vidas para garantir a prosperidade de nossa terra. No entanto, nossos esforços foram ignorados, e nossas lutas foram tratadas com indiferença.\n" +
                "Ontem, um dos nossos, um homem dedicado e trabalhador, perdeu a vida em serviço. Sua morte era evitável, mas nenhum auxílio ou apoio foi oferecido a ele ou à sua família. Esta tragédia é um lembrete cruel do descaso que enfrentamos diariamente.\n" +
                "Exigimos o seguinte:\n" +
                "Salários justos que reflitam os perigos e dificuldades do nosso trabalho.\n" +
                "Apoio para as famílias daqueles que foram feridos ou mortos em serviço ao reino.\n\n" +
                "Até que essas demandas sejam atendidas, interromperemos toda a produção de tábuas e toras. Não tomamos essa decisão levianamente, mas precisamos nos unir para garantir que nossas vozes sejam ouvidas.\n" +
                "Respeitosamente,\n" +
                "Os Lenhadores de Apenna");
        item.addTextTranslation(CoreEnums.AvailableLanguages.SPANISH, "Para Su Majestad, la Reina, y los Estimados Líderes del Reino,\n\n" +
                "Nosotros, los leñadores de Apenna, nos dirigimos humildemente a ustedes con un asunto de gran importancia. Durante años, hemos trabajado incansablemente para proveer madera al reino, soportando condiciones difíciles y arriesgando nuestras vidas para garantizar la prosperidad de nuestra tierra. Sin embargo, nuestros esfuerzos han sido ignorados, y nuestras luchas han sido tratadas con indiferencia.\n" +
                "Ayer, uno de los nuestros, un hombre dedicado y trabajador, perdió la vida en el cumplimiento de su deber. Su muerte era evitable, pero no se le brindó ayuda ni apoyo a él ni a su familia. Esta tragedia es un recordatorio cruel del abandono que enfrentamos a diario.\n" +
                "Exigimos lo siguiente:\n" +
                "Salarios justos que reflejen los peligros y dificultades de nuestro trabajo.\n" +
                "Apoyo para las familias de aquellos que resulten heridos o mueran en servicio al reino.\n\n" +
                "Hasta que se cumplan estas demandas, detendremos toda producción de tablones y troncos. No tomamos esta decisión a la ligera, pero debemos unirnos para asegurarnos de que nuestras voces sean escuchadas.\n" +
                "Atentamente,\n" +
                "Los Leñadores de Apenna");

        item.weight = 0.1f;
        item.marketValue = 1;
        item.vanishAfterRead = false;
        item.sellable = false;
        item.discardable = false;
        item.imgFile = "item_generic_letter";
        item.canBeIngredient = false;
        return item;
    }

    BookItem alchemyForDummies() {
        BookItem book = new BookItem("Alchemy For Dummies");
        book.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Alquimia Para Leigos");
        book.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Alquimia Para Dummies");

        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A book with the basics about alchemy and potion crafting.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um livro com o básico sobre alquimia e criação de poções.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un libro con lo básico sobre alquimia y fabricación de pociones.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.ENGLISH, "[A lot of texts and specifications about herbs, ingredients, potions and how to mix them]");
        book.addTextTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "[Muitos textos e especificações sobre ervas, ingredientes, poções e como misturá-los]");
        book.addTextTranslation(CoreEnums.AvailableLanguages.SPANISH, "[Muchos textos y especificaciones sobre hierbas, ingredientes, pociones y cómo mezclarlos]");

        book.weight = .3f;
        book.vanishAfterRead = true;
        book.sellable = false;
        book.buyable = false;
        book.discardable = false;
        book.canBeIngredient = false;

        book.listener = ctx -> {
            Quest quest = App.DataManager.getQuest(QuestsIds.LEARNING_ALCHEMY);
            LibQuest.updateQuest(quest, 2, App.getPlayerChar(), ctx);
            LibInventory.removeFromInventory(ItemsIds.ALCHEMY_FOR_DUMMIES, 1, App.getPlayerChar());
        };

        return book;
    }

    BookItem alchemyAnnotations() {
        BookItem book = new BookItem("Alchemy Annotations");
        book.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Anotações de Alquimia");
        book.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Anotaciones de Alquimia");

        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Some pages of notes with tips for creating potions.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Algumas páginas de anotações com dicas de criação de pocões.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Algunas páginas de notas con consejos para crear pociones.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Those recipes are my scratches about my discoveries when learning alchemy from the great Professor Kalwyn, I tested all potions and they did not killed me." + "\nCurrent known recipes: " + getCraftsToDisplay(CoreEnums.AvailableLanguages.ENGLISH, Enums.CraftTypes.ALCHEMY));
        book.addTextTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Essas receitas são meus rascunhos sobre minhas descobertas ao aprender alquimia com o grande Professor Kalwyn, testei todas as poções e elas não me mataram." + "\nReceitas conhecidas: " + getCraftsToDisplay(CoreEnums.AvailableLanguages.PORTUGUESE, Enums.CraftTypes.ALCHEMY));
        book.addTextTranslation(CoreEnums.AvailableLanguages.SPANISH, "Esas recetas son mis apuntes sobre mis descubrimientos al aprender alquimia del gran Profesor Kalwyn, probé todas las pociones y no me mataron." + "\nRecetas conocidas: " + getCraftsToDisplay(CoreEnums.AvailableLanguages.SPANISH, Enums.CraftTypes.ALCHEMY));

        book.weight = .1f;
        book.marketValue = 11;
        book.illustrationFile = "items/item_alchemy_annotations";
        book.canBeIngredient = false;

        return book;
    }

    BookItem theMasterBookOfCrafter() {
        BookItem book = new BookItem("The Master Book of Crafter");
        book.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Livro Mestre do Artesão");
        book.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "El Libro Maestro del Artesano");

        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A thick book with many tips on general production.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um livro grosso com muitas dicas sobre produção geral.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un libro grueso con muchos consejos sobre producción general.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Here is a list of things that you can learn how to produce by using a forge and mixing or melting the ingredients:" + "\nCraft recipes known: " + getCraftsToDisplay(CoreEnums.AvailableLanguages.ENGLISH, Enums.CraftTypes.GENERAL));
        book.addTextTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Aqui está uma lista de coisas que você pode aprender a produzir usando uma forja e misturando ou derretendo os ingredientes:" + "\nCriações conhecidas: " + getCraftsToDisplay(CoreEnums.AvailableLanguages.PORTUGUESE, Enums.CraftTypes.GENERAL));
        book.addTextTranslation(CoreEnums.AvailableLanguages.SPANISH, "Aquí hay una lista de cosas que puedes aprender a producir usando una forja y mezclando o derritiendo los ingredientes:" + "\nCreaciones conocidas: " + getCraftsToDisplay(CoreEnums.AvailableLanguages.SPANISH, Enums.CraftTypes.GENERAL));

        book.weight = 1.1f;
        book.marketValue = 20;
        book.illustrationFile = "items/item_the_master_book_of_crafter";
        book.canBeIngredient = false;

        return book;
    }

    BookItem theCookBook() {
        BookItem book = new BookItem("The Cook Book");
        book.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O Livro de Receitas");
        book.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "El Libro de Cocina");

        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A book with practical and tasty recipes for all kinds of food.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um livro com receitas práticas e saborosas de todo tipo de comida.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un libro con recetas prácticas y sabrosas de todo tipo de comida.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A book by Madelaine\nHere is my best recipes. To anyone reading this, all you need is an oven and some kitchen tools. Then mix the ingredients and make the best dishes!" + "\nCurrent known recipes: " + getCraftsToDisplay(CoreEnums.AvailableLanguages.ENGLISH, Enums.CraftTypes.COOKING));
        book.addTextTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um livro de Madelaine\nAqui estão minhas melhores receitas. Para quem estiver lendo isso, tudo que você precisa é um forno e algumas ferramentas de cozinha. Depois, misture os ingredientes e faça os melhores pratos!" + "\nReceitas conhecidas: " + getCraftsToDisplay(CoreEnums.AvailableLanguages.PORTUGUESE, Enums.CraftTypes.COOKING));
        book.addTextTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un libro de Madelaine\nAquí están mis mejores recetas. Para cualquiera que lea esto, todo lo que necesita es un horno y algunos utensilios de cocina. ¡Luego mezcle los ingredientes y haga los mejores platos!" + "\nRecetas conocidas: " + getCraftsToDisplay(CoreEnums.AvailableLanguages.SPANISH, Enums.CraftTypes.COOKING));

        book.weight = .5f;
        book.marketValue = 7;
        book.illustrationFile = "items/item_the_cook_book";
        book.canBeIngredient = false;

        return book;
    }

    BookItem queensRequisitionLetter() {
        BookItem item = new BookItem("Queens Requisition Letter");
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Carta de Requisição da Rainha");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Carta de Requisición de la Reina");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A formal diplomatic letter from Queen Enola requesting aid from the elves.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma carta diplomática formal da Rainha Enola solicitando ajuda dos elfos.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una carta diplomática formal de la Reina Enola solicitando ayuda de los elfos.");

        item.addTextTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "By Royal Decree of Queen Enola of Havarus\n\n" +
                        "To the Honored Lords and Ladies of Ayalon, the Elven Realm,\n\n" +
                        "Greetings and salutations in the name of peace and mutual prosperity.\n\n" +
                        "It is with great respect and urgency that I, Queen Enola of the Kingdom of Havarus, reach out across the years of silence that have grown between our peoples. I write not from pride, but from necessity - a darkness rises that threatens not merely humans, but all living beings who call this world home.\n\n" +
                        "Strange creatures born of shadow and malice have begun to assault our lands. Our conventional forces, though brave and skilled, find themselves inadequate against enemies that should not exist. We face an evil that transcends the boundaries of realm and race.\n\n" +
                        "I humbly request an audience with your leaders. The bearer of this letter, [PLAYERNAME], is my trusted champion who has proven their valor and wisdom in defending our people. I ask that you hear their plea and consider what was once unthinkable - an alliance between our kingdoms against this common enemy.\n\n" +
                        "The ancient magic of the elves may be our only hope. I do not ask this lightly, nor do I expect aid without understanding. But I believe that if our peoples once stood together as friends, perhaps we can do so again.\n\n" +
                        "May wisdom guide your decision.\n\n" +
                        "With deepest respect,\n" +
                        "Queen Enola of Havarus\n" +
                        "[Royal Seal of Havarus]");

        item.addTextTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "Por Decreto Real da Rainha Enola de Havarus\n\n" +
                        "Aos Honrados Senhores e Senhoras de Ayalon, o Reino Élfico,\n\n" +
                        "Saudações em nome da paz e prosperidade mútua.\n\n" +
                        "É com grande respeito e urgência que eu, Rainha Enola do Reino de Havarus, me comunico através dos anos de silêncio que cresceram entre nossos povos. Não escrevo por orgulho, mas por necessidade - uma escuridão surge que ameaça não apenas humanos, mas todos os seres vivos que chamam este mundo de lar.\n\n" +
                        "Criaturas estranhas nascidas das sombras e da malícia começaram a assaltar nossas terras. Nossas forças convencionais, embora corajosas e habilidosas, se mostram inadequadas contra inimigos que não deveriam existir. Enfrentamos um mal que transcende as fronteiras de reino e raça.\n\n" +
                        "Solicito humildemente uma audiência com seus líderes. O portador desta carta, [PLAYERNAME], é meu campeão de confiança que provou seu valor e sabedoria defendendo nosso povo. Peço que ouçam seu apelo e considerem o que antes era impensável - uma aliança entre nossos reinos contra esse inimigo comum.\n\n" +
                        "A magia ancestral dos elfos pode ser nossa única esperança. Não peço isso levianamente, nem espero ajuda sem compreensão. Mas acredito que se nossos povos já foram amigos, talvez possamos sê-lo novamente.\n\n" +
                        "Que a sabedoria guie sua decisão.\n\n" +
                        "Com o mais profundo respeito,\n" +
                        "Rainha Enola de Havarus\n" +
                        "[Selo Real de Havarus]");

        item.addTextTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "Por Decreto Real de la Reina Enola de Havarus\n\n" +
                        "A los Honorables Señores y Señoras de Ayalon, el Reino Élfico,\n\n" +
                        "Saludos en nombre de la paz y la prosperidad mutua.\n\n" +
                        "Es con gran respeto y urgencia que yo, la Reina Enola del Reino de Havarus, me comunico a través de los años de silencio que han crecido entre nuestros pueblos. No escribo por orgullo, sino por necesidad: una oscuridad surge que amenaza no solo a los humanos, sino a todos los seres vivos que llaman hogar a este mundo.\n\n" +
                        "Criaturas extrañas nacidas de la sombra y la malicia han comenzado a asaltar nuestras tierras. Nuestras fuerzas convencionales, aunque valientes y hábiles, se encuentran inadecuadas contra enemigos que no deberían existir. Enfrentamos un mal que trasciende las fronteras de reino y raza.\n\n" +
                        "Solicito humildemente una audiencia con sus líderes. El portador de esta carta, [PLAYERNAME], es mi campeón de confianza que ha demostrado su valor y sabiduría defendiendo a nuestro pueblo. Pido que escuchen su súplica y consideren lo que antes era impensable: una alianza entre nuestros reinos contra este enemigo común.\n\n" +
                        "La magia ancestral de los elfos puede ser nuestra única esperanza. No pido esto a la ligera, ni espero ayuda sin comprensión. Pero creo que si nuestros pueblos alguna vez fueron amigos, quizás podamos serlo nuevamente.\n\n" +
                        "Que la sabiduría guíe su decisión.\n\n" +
                        "Con el más profundo respeto,\n" +
                        "Reina Enola de Havarus\n" +
                        "[Selo Real de Havarus]");

        item.weight = 0.1f;
        item.marketValue = 0;
        item.vanishAfterRead = false;
        item.sellable = false;
        item.discardable = false;
        item.imgFile = "item_generic_letter";
        item.canBeIngredient = false;
        return item;
    }

    BookItem ancientElvenProphecies() {
        BookItem book = new BookItem("Ancient Elven Prophecies");
        book.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Profecias Élficas Ancestrais");
        book.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Profecías Élficas Ancestrales");

        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "An ancient tome containing elven prophecies and knowledge about the Death King. Given by Nelera after discovering Casiel's treachery.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um antigo tomo contendo profecias élficas e conhecimento sobre o Rei da Morte. Dado por Nelera após descobrir a traição de Casiel.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un tomo antiguo que contiene profecías élficas y conocimiento sobre el Rey de la Muerte. Dado por Nelera tras descubrir la traición de Casiel.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "ANCIENT ELVEN PROPHECIES\n" +
                        "Chapter VII: The Death King\n\n" +
                        "From the deepest archives of Ayalon, translated by Scholar Nelera:\n\n" +
                        "\"When the balance of life and death is shattered, and dark creatures walk the mortal plane, the throne of the Death King shall stand vacant, waiting for one with sufficient will and power to claim it.\n\n" +
                        "The Death King is no birthright, no divine appointment - it is a position that any mage of great power may seize through ritual and sacrifice. Yet the cost is terrible: to command the dead, one must surrender their living heart to darkness.\n\n" +
                        "The power of the Death King is absolute over the realms of the deceased. They may:\n" +
                        "- Command legions of the dead across multiple worlds\n" +
                        "- Resurrect the fallen with their memories intact\n" +
                        "- Grant immortality or enforce death upon any being\n" +
                        "- Open portals between the realm of the living and the dead\n" +
                        "- Merge the planes of existence into one hybrid reality\n\n" +
                        "But beware - such power corrupts even the most noble heart. Those who seek the throne often believe they act from love or justice, but in the end, they become the very evil they sought to defeat.\n\n" +
                        "The last known Death King was the demon Targon, slain through great sacrifice. Should another claim this mantle, only united mortal and elven magic may have the power to stop them.\n\n" +
                        "Remember well: the road to darkness is paved with good intentions.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "PROFECIAS ÉLFICAS ANCESTRAIS\n" +
                        "Capítulo VII: O Rei da Morte\n\n" +
                        "Dos arquivos mais profundos de Ayalon, traduzido pela Estudiosa Nelera:\n\n" +
                        "\"Quando o equilíbrio entre vida e morte for quebrado, e criaturas das trevas caminharem pelo plano mortal, o trono do Rei da Morte permanecerá vago, esperando por alguém com vontade e poder suficientes para reivindicá-lo.\n\n" +
                        "O Rei da Morte não é um direito de nascença, nem uma nomeação divina - é uma posição que qualquer mago de grande poder pode tomar através de ritual e sacrifício. Mas o custo é terrível: para comandar os mortos, deve-se entregar o coração vivo às trevas.\n\n" +
                        "O poder do Rei da Morte é absoluto sobre os reinos dos mortos. Eles podem:\n" +
                        "- Comandar legiões de mortos através de múltiplos mundos\n" +
                        "- Ressuscitar os caídos com suas memórias intactas\n" +
                        "- Conceder imortalidade ou forçar a morte sobre qualquer ser\n" +
                        "- Abrir portais entre o reino dos vivos e dos mortos\n" +
                        "- Fundir os planos de existência em uma realidade híbrida\n\n" +
                        "Mas cuidado - tal poder corrompe até o coração mais nobre. Aqueles que buscam o trono frequentemente acreditam agir por amor ou justiça, mas no final, tornam-se o próprio mal que buscavam derrotar.\n\n" +
                        "O último Rei da Morte conhecido foi o demônio Targon, morto através de grande sacrifício. Se outro reivindicar este manto, apenas magia mortal e élfica unida pode ter poder para detê-los.\n\n" +
                        "Lembre-se bem: o caminho para as trevas é pavimentado com boas intenções.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "PROFECÍAS ÉLFICAS ANCESTRALES\n" +
                        "Capítulo VII: El Rey de la Muerte\n\n" +
                        "De los archivos más profundos de Ayalon, traducido por la Erudita Nelera:\n\n" +
                        "\"Cuando el equilibrio entre vida y muerte se rompa, y criaturas oscuras caminen por el plano mortal, el trono del Rey de la Muerte permanecerá vacante, esperando a alguien con suficiente voluntad y poder para reclamarlo.\n\n" +
                        "El Rey de la Muerte no es un derecho de nacimiento, ni una designación divina - es una posición que cualquier mago de gran poder puede tomar a través de ritual y sacrificio. Pero el costo es terrible: para comandar a los muertos, uno debe entregar su corazón vivo a la oscuridad.\n\n" +
                        "El poder del Rey de la Muerte es absoluto sobre los reinos de los muertos. Pueden:\n" +
                        "- Comandar legiones de muertos a través de múltiples mundos\n" +
                        "- Resucitar a los caídos con sus memorias intactas\n" +
                        "- Otorgar inmortalidad o forzar la muerte sobre cualquier ser\n" +
                        "- Abrir portales entre el reino de los vivos y los muertos\n" +
                        "- Fusionar los planos de existencia en una realidad híbrida\n\n" +
                        "Pero cuidado - tal poder corrompe hasta el corazón más noble. Aquellos que buscan el trono a menudo creen actuar por amor o justicia, pero al final, se convierten en el mismo mal que buscaban derrotar.\n\n" +
                        "El último Rey de la Muerte conocido fue el demonio Targon, asesinado a través de gran sacrificio. Si otro reclama este manto, solo la magia mortal y élfica unida puede tener el poder para detenerlos.\n\n" +
                        "Recuerden bien: el camino hacia la oscuridad está pavimentado con buenas intenciones.");

        book.weight = 0.5f;
        book.marketValue = 0;
        book.vanishAfterRead = false;
        book.sellable = false;
        book.discardable = false;
        book.canBeIngredient = false;
        return book;
    }

    BookItem goldenAgeChronicle() {
        BookItem book = new BookItem("Chronicle of the Golden Age");
        book.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Crônica da Era Dourada");
        book.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Crónica de la Edad de Oro");

        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "An ancient book about the era when elves and humans lived in harmony.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um livro ancestral sobre a era em que elfos e humanos viviam em harmonia.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un libro ancestral sobre la era en que elfos y humanos vivían en armonía.");

        book.imgFile = "item_ancient_elven_prophecies";

        book.addTextTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "CHRONICLE OF THE GOLDEN AGE\n" +
                        "Volume III: When Elves Walked Among Us\n\n" +
                        "Written by Historian Marcus Thorne of Havarus\n" +
                        "Year 847 of the Second Age\n\n" +
                        "\"As a human scholar documenting our shared history, I write this account based on records, letters, and testimonies from those who lived through the Golden Age - that wondrous period three centuries past when our peoples truly knew unity.\n\n" +
                        "I have interviewed the eldest among us and studied countless documents. All speak of a time when elves and humans did not merely coexist - we thrived together as one people.\n\n" +
                        "In the great city of Arathor, we witnessed the impossible made real. Elven architects, with their innate understanding of natural harmony, worked alongside our finest human engineers. Together they created marvels that transcended what either people could achieve alone. Towers reached toward the sky through spells of levitation, while human masonry of unparalleled precision secured their foundations.\n\n" +
                        "The exchange of knowledge was extraordinary:\n" +
                        "- Elven masters taught us the subtle arts of nature magic and healing\n" +
                        "- Our craftsmen shared innovations in metallurgy and mechanical engineering\n" +
                        "- Together, we developed hybrid techniques never seen before or since\n\n" +
                        "Love between our peoples was common and celebrated. Half-elf children walked our streets with pride, not as outcasts but as honored bridges between cultures. One of my own ancestors married an elven herbalist - their union was blessed by both communities.\n\n" +
                        "Our festivals were legendary. The Midsummer Festival of Unity drew visitors from across all lands. Elven song merged with human instruments, magical lights danced above tables laden with foods from both traditions. These were not just celebrations - they were affirmations of what cooperation could achieve.\n\n" +
                        "Trade routes between our kingdoms and elven forests were well-traveled and safe. Guards of both races protected caravans together. Border town markets were vibrant meeting places where goods, stories, and friendships were exchanged with equal enthusiasm.\n\n" +
                        "But what impressed me most in my research was the mutual respect. Elves did not see us as lesser for our shorter lives - they admired our passion and innovation. We did not see them as aloof for their long perspective - we valued their wisdom and patience.\n\n" +
                        "This was the Golden Age - not perfect, but peaceful. Not without challenges, but facing them together. A time when 'elf' and 'human' were descriptors, not divisions.\n\n" +
                        "I write this as much for hope as for history. What once was can be again. The distance between our peoples is not fate - it is circumstance. And circumstances can change.\"\n\n" +
                        "---\n" +
                        "Preservation Note: This chronicle was copied and preserved by Scholar Nelera, who found it in the human archives of Bastian. It now resides in both human and elven libraries as a testament to shared history.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "CRÔNICA DA ERA DOURADA\n" +
                        "Volume III: Quando Elfos Caminhavam Entre Nós\n\n" +
                        "Escrito pelo Historiador Marcus Thorne de Havarus\n" +
                        "Ano 847 da Segunda Era\n\n" +
                        "\"Como um estudioso humano documentando nossa história compartilhada, escrevo este relato baseado em registros, cartas e testemunhos daqueles que viveram a Era Dourada - aquele período maravilhoso há três séculos quando nossos povos verdadeiramente conheceram a unidade.\n\n" +
                        "Entrevistei os mais velhos entre nós e estudei inúmeros documentos. Todos falam de um tempo em que elfos e humanos não apenas coexistiam - prosperávamos juntos como um só povo.\n\n" +
                        "Na grande cidade de Arathor, testemunhamos o impossível se tornar real. Arquitetos élficos, com sua compreensão inata da harmonia natural, trabalhavam ao lado de nossos melhores engenheiros humanos. Juntos criaram maravilhas que transcendiam o que qualquer povo poderia alcançar sozinho. Torres alcançavam o céu através de feitiços de levitação, enquanto a alvenaria humana de precisão sem igual garantia suas fundações.\n\n" +
                        "A troca de conhecimento era extraordinária:\n" +
                        "- Mestres élficos nos ensinavam as artes sutis da magia da natureza e cura\n" +
                        "- Nossos artesãos compartilhavam inovações em metalurgia e engenharia mecânica\n" +
                        "- Juntos, desenvolvemos técnicas híbridas nunca vistas antes ou depois\n\n" +
                        "O amor entre nossos povos era comum e celebrado. Crianças meio-elfas caminhavam por nossas ruas com orgulho, não como párias mas como honradas pontes entre culturas. Um de meus próprios ancestrais casou-se com uma herborista élfica - sua união foi abençoada por ambas as comunidades.\n\n" +
                        "Nossos festivais eram lendários. O Festival de Unidade do Meio do Verão atraía visitantes de todas as terras. Canções élficas se fundiam com instrumentos humanos, luzes mágicas dançavam sobre mesas repletas de comidas de ambas as tradições. Estas não eram apenas celebrações - eram afirmações do que a cooperação poderia alcançar.\n\n" +
                        "Rotas comerciais entre nossos reinos e florestas élficas eram bem viajadas e seguras. Guardas de ambas as raças protegiam caravanas juntos. Mercados de cidades fronteiriças eram vibrantes locais de encontro onde mercadorias, histórias e amizades eram trocadas com igual entusiasmo.\n\n" +
                        "Mas o que mais me impressionou em minha pesquisa foi o respeito mútuo. Elfos não nos viam como inferiores por nossas vidas mais curtas - eles admiravam nossa paixão e inovação. Nós não os víamos como distantes por sua perspectiva longa - valorizávamos sua sabedoria e paciência.\n\n" +
                        "Esta foi a Era Dourada - não perfeita, mas pacífica. Não sem desafios, mas enfrentando-os juntos. Um tempo em que 'elfo' e 'humano' eram descritores, não divisões.\n\n" +
                        "Escrevo isto tanto por esperança quanto por história. O que uma vez foi pode ser novamente. A distância entre nossos povos não é destino - é circunstância. E circunstâncias podem mudar.\"\n\n" +
                        "---\n" +
                        "Nota de Preservação: Esta crônica foi copiada e preservada pela Estudiosa Nelera, que a encontrou nos arquivos humanos de Bastian. Agora reside tanto em bibliotecas humanas quanto élficas como testemunho de história compartilhada.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "CRÓNICA DE LA EDAD DE ORO\n" +
                        "Volumen III: Cuando Elfos Caminaban Entre Nosotros\n\n" +
                        "Escrito por el Historiador Marcus Thorne de Havarus\n" +
                        "Año 847 de la Segunda Era\n\n" +
                        "\"Como un erudito humano documentando nuestra historia compartida, escribo este relato basado en registros, cartas y testimonios de aquellos que vivieron la Edad de Oro - ese maravilloso período hace tres siglos cuando nuestros pueblos verdaderamente conocieron la unidad.\n\n" +
                        "He entrevistado a los más ancianos entre nosotros y estudiado innumerables documentos. Todos hablan de un tiempo en que elfos y humanos no solo coexistían - prosperábamos juntos como un solo pueblo.\n\n" +
                        "En la gran ciudad de Arathor, presenciamos lo imposible hacerse real. Arquitectos élficos, con su comprensión innata de la armonía natural, trabajaban junto a nuestros mejores ingenieros humanos. Juntos crearon maravillas que trascendían lo que cualquier pueblo podría lograr solo. Torres alcanzaban el cielo a través de hechizos de levitación, mientras que la mampostería humana de precisión sin igual aseguraba sus cimientos.\n\n" +
                        "El intercambio de conocimiento era extraordinario:\n" +
                        "- Maestros élficos nos enseñaban las artes sutiles de la magia de la naturaleza y curación\n" +
                        "- Nuestros artesanos compartían innovaciones en metalurgia e ingeniería mecánica\n" +
                        "- Juntos, desarrollamos técnicas híbridas nunca vistas antes o después\n\n" +
                        "El amor entre nuestros pueblos era común y celebrado. Niños mitad elfos caminaban por nuestras calles con orgullo, no como parias sino como honrados puentes entre culturas. Uno de mis propios ancestros se casó con una herbolaria élfica - su unión fue bendecida por ambas comunidades.\n\n" +
                        "Nuestros festivales eran legendarios. El Festival de Unidad de Mediados de Verano atraía visitantes de todas las tierras. Canciones élficas se fusionaban con instrumentos humanos, luces mágicas bailaban sobre mesas repletas de comidas de ambas tradiciones. Estas no eran solo celebraciones - eran afirmaciones de lo que la cooperación podía lograr.\n\n" +
                        "Las rutas comerciales entre nuestros reinos y bosques élficos eran muy transitadas y seguras. Guardias de ambas razas protegían caravanas juntos. Los mercados de ciudades fronterizas eran vibrantes lugares de encuentro donde mercancías, historias y amistades se intercambiaban con igual entusiasmo.\n\n" +
                        "Pero lo que más me impresionó en mi investigación fue el respeto mutuo. Los elfos no nos veían como inferiores por nuestras vidas más cortas - admiraban nuestra pasión e innovación. Nosotros no los veíamos como distantes por su larga perspectiva - valorábamos su sabiduría y paciencia.\n\n" +
                        "Esta fue la Edad de Oro - no perfecta, pero pacífica. No sin desafíos, pero enfrentándolos juntos. Un tiempo en que 'elfo' y 'humano' eran descriptores, no divisiones.\n\n" +
                        "Escribo esto tanto por esperanza como por historia. Lo que una vez fue puede ser nuevamente. La distancia entre nuestros pueblos no es destino - es circunstancia. Y las circunstancias pueden cambiar.\"\n\n" +
                        "---\n" +
                        "Nota de Preservación: Esta crónica fue copiada y preservada por la Erudita Nelera, quien la encontró en los archivos humanos de Bastian. Ahora reside tanto en bibliotecas humanas como élficas como testimonio de historia compartida.");

        book.weight = 0.8f;
        book.marketValue = 0;
        book.vanishAfterRead = false;
        book.sellable = false;
        book.discardable = false;
        book.canBeIngredient = false;
        return book;
    }

    BookItem ancientScrollUntranslated() {
        BookItem book = new BookItem("Ancient Elven Scroll");
        book.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pergaminho Élfico Ancestral");
        book.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Pergamino Élfico Ancestral");

        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "An ancient scroll written in elven language. Unreadable without translation.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um pergaminho ancestral escrito em língua élfica. Ilegível sem tradução.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un pergamino ancestral escrito en idioma élfico. Ilegible sin traducción.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "The scroll is covered in elegant elven script. Without knowledge of the ancient elven language, the words remain a beautiful but incomprehensible mystery.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "O pergaminho está coberto com elegante escrita élfica. Sem conhecimento da antiga língua élfica, as palavras permanecem um mistério belo mas incompreensível.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "El pergamino está cubierto con elegante escritura élfica. Sin conocimiento del antiguo idioma élfico, las palabras permanecen como un misterio hermoso pero incomprensible.");

        book.weight = 0.2f;
        book.marketValue = 0;
        book.vanishAfterRead = false;
        book.sellable = false;
        book.discardable = false;
        book.canBeIngredient = false;
        book.imgFile = "item_generic_letter";
        return book;
    }

    BookItem ancientScrollTranslated() {
        BookItem book = new BookItem("Ancient Scroll Translated");
        book.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pergaminho Ancestral Traduzido");
        book.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Pergamino Ancestral Traducido");

        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "An ancient elven scroll about humans, translated by Scholar Nelera.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um pergaminho élfico ancestral sobre humanos, traduzido pela Estudiosa Nelera.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un pergamino élfico ancestral sobre humanos, traducido por la Erudita Nelera.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "OBSERVATIONS ON HUMANITY\n" +
                        "By Elder Aelrindel of the Temple\n" +
                        "Written in the 347th year of the Golden Age\n\n" +
                        "Translated by Scholar Nelera:\n\n" +
                        "\"I have walked among humans for fifty of their years - barely a season in elven reckoning, yet long enough to marvel at their nature.\n\n" +
                        "Where we elves measure our lives in centuries and our decisions in decades, humans burn with an intensity born of brevity. They love fiercely because they have so little time. They build urgently because death waits at their shoulder. They innovate constantly because they cannot afford to wait for perfection.\n\n" +
                        "Some of my kindred view this as weakness - this rushing, this urgency, this desperate clinging to fleeting moments. But I have come to see it as their greatest strength.\n\n" +
                        "A human blacksmith I know works his forge with passionate dedication, knowing his hands have perhaps forty good years left. An elven craftsman might spend a century perfecting a single technique. The human innovates, experiments, fails, and tries again - creating twenty new things in the time the elf creates one perfect thing.\n\n" +
                        "Human parents pour everything into their children, knowing they will see only two or three generations before passing into memory. Elven parents love too, but with the patience of knowing they will guide dozens of generations. Different approaches, both beautiful in their own way.\n\n" +
                        "In human cities, I see change happen in years that would take us centuries to consider. New ideas spread like wildfire. Traditions adapt and evolve. It is chaotic, yes, but also vital and alive in ways our ancient forests sometimes forget to be.\n\n" +
                        "What humans lack in long perspective, they make up for in passionate intensity. What we provide in wisdom and patience, they complement with innovation and drive.\n\n" +
                        "This is why our alliance flourishes. Not because we are the same, but precisely because we are different. The patient elf and the urgent human, together, create something neither could achieve alone.\n\n" +
                        "Perhaps the tragedy is not that humans live briefly, but that we elves sometimes forget to truly live at all, measuring our existence in centuries while they squeeze eternity into decades.\n\n" +
                        "I hope this alliance endures. Both peoples need what the other offers - they need our wisdom and perspective, we need their passion and innovation.\n\n" +
                        "May future generations, both elven and human, remember this truth.\"\n\n" +
                        "---\n" +
                        "Translator's note: This scroll was preserved in the Sacred Temple of Ayalon. Elder Aelrindel was known for her love of human philosophy and her tireless work building bridges between our peoples. She would weep to see how far we have drifted apart.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "OBSERVAÇÕES SOBRE A HUMANIDADE\n" +
                        "Por Anciã Aelrindel do Templo\n" +
                        "Escrito no 347º ano da Era Dourada\n\n" +
                        "Traduzido pela Estudiosa Nelera:\n\n" +
                        "\"Caminhei entre humanos por cinquenta de seus anos - mal uma estação na contagem élfica, mas tempo suficiente para maravilhar-me com sua natureza.\n\n" +
                        "Onde nós elfos medimos nossas vidas em séculos e nossas decisões em décadas, humanos queimam com uma intensidade nascida da brevidade. Eles amam ferozmente porque têm tão pouco tempo. Constroem urgentemente porque a morte espera em seus ombros. Inovam constantemente porque não podem se dar ao luxo de esperar pela perfeição.\n\n" +
                        "Alguns de meu povo veem isso como fraqueza - essa pressa, essa urgência, esse apego desesperado a momentos fugazes. Mas passei a ver isso como sua maior força.\n\n" +
                        "Um ferreiro humano que conheço trabalha em sua forja com dedicação apaixonada, sabendo que suas mãos têm talvez quarenta anos bons restantes. Um artesão élfico pode passar um século aperfeiçoando uma única técnica. O humano inova, experimenta, falha e tenta novamente - criando vinte coisas novas no tempo em que o elfo cria uma coisa perfeita.\n\n" +
                        "Pais humanos derramam tudo em seus filhos, sabendo que verão apenas duas ou três gerações antes de passar à memória. Pais élficos também amam, mas com a paciência de saber que guiarão dezenas de gerações. Abordagens diferentes, ambas lindas à sua maneira.\n\n" +
                        "Em cidades humanas, vejo mudanças acontecer em anos que nos levariam séculos para considerar. Novas ideias se espalham como fogo selvagem. Tradições se adaptam e evoluem. É caótico, sim, mas também vital e vivo de maneiras que nossas florestas ancestrais às vezes esquecem de ser.\n\n" +
                        "O que humanos carecem em perspectiva longa, compensam com intensidade apaixonada. O que fornecemos em sabedoria e paciência, eles complementam com inovação e ímpeto.\n\n" +
                        "É por isso que nossa aliança floresce. Não porque somos iguais, mas precisamente porque somos diferentes. O elfo paciente e o humano urgente, juntos, criam algo que nenhum poderia alcançar sozinho.\n\n" +
                        "Talvez a tragédia não seja que humanos vivam brevemente, mas que nós elfos às vezes esquecemos de verdadeiramente viver, medindo nossa existência em séculos enquanto eles espremem a eternidade em décadas.\n\n" +
                        "Espero que esta aliança perdure. Ambos os povos precisam do que o outro oferece - eles precisam de nossa sabedoria e perspectiva, nós precisamos de sua paixão e inovação.\n\n" +
                        "Que gerações futuras, tanto élficas quanto humanas, lembrem desta verdade.\"\n\n" +
                        "---\n" +
                        "Nota da tradutora: Este pergaminho foi preservado no Templo Sagrado de Ayalon. A Anciã Aelrindel era conhecida por seu amor à filosofia humana e seu trabalho incansável construindo pontes entre nossos povos. Ela choraria ao ver o quão distantes nos tornamos.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "OBSERVACIONES SOBRE LA HUMANIDAD\n" +
                        "Por Anciana Aelrindel del Templo\n" +
                        "Escrito en el año 347 de la Edad de Oro\n\n" +
                        "Traducido por la Erudita Nelera:\n\n" +
                        "\"He caminado entre humanos durante cincuenta de sus años - apenas una estación en el recuento élfico, pero tiempo suficiente para maravillarme con su naturaleza.\n\n" +
                        "Donde nosotros los elfos medimos nuestras vidas en siglos y nuestras decisiones en décadas, los humanos arden con una intensidad nacida de la brevedad. Aman ferozmente porque tienen tan poco tiempo. Construyen urgentemente porque la muerte espera en su hombro. Innovan constantemente porque no pueden darse el lujo de esperar la perfección.\n\n" +
                        "Algunos de mi pueblo ven esto como debilidad - esta prisa, esta urgencia, este aferrarse desesperado a momentos fugaces. Pero he llegado a verlo como su mayor fortaleza.\n\n" +
                        "Un herrero humano que conozco trabaja su forja con dedicación apasionada, sabiendo que sus manos tienen quizás cuarenta años buenos restantes. Un artesano élfico podría pasar un siglo perfeccionando una sola técnica. El humano innova, experimenta, falla e intenta de nuevo - creando veinte cosas nuevas en el tiempo en que el elfo crea una cosa perfecta.\n\n" +
                        "Los padres humanos vierten todo en sus hijos, sabiendo que verán solo dos o tres generaciones antes de pasar a la memoria. Los padres élficos también aman, pero con la paciencia de saber que guiarán docenas de generaciones. Enfoques diferentes, ambos hermosos a su manera.\n\n" +
                        "En las ciudades humanas, veo cambios suceder en años que nos tomarían siglos considerar. Las nuevas ideas se propagan como fuego salvaje. Las tradiciones se adaptan y evolucionan. Es caótico, sí, pero también vital y vivo de maneras que nuestros bosques ancestrales a veces olvidan ser.\n\n" +
                        "Lo que los humanos carecen en perspectiva larga, lo compensan con intensidad apasionada. Lo que proporcionamos en sabiduría y paciencia, ellos lo complementan con innovación e impulso.\n\n" +
                        "Por eso nuestra alianza florece. No porque somos iguales, sino precisamente porque somos diferentes. El elfo paciente y el humano urgente, juntos, crean algo que ninguno podría lograr solo.\n\n" +
                        "Quizás la tragedia no es que los humanos vivan brevemente, sino que nosotros los elfos a veces olvidamos vivir verdaderamente, midiendo nuestra existencia en siglos mientras ellos exprimen la eternidad en décadas.\n\n" +
                        "Espero que esta alianza perdure. Ambos pueblos necesitan lo que el otro ofrece - ellos necesitan nuestra sabiduría y perspectiva, nosotros necesitamos su pasión e innovación.\n\n" +
                        "Que las generaciones futuras, tanto élficas como humanas, recuerden esta verdad.\"\n\n" +
                        "---\n" +
                        "Nota de la traductora: Este pergamino fue preservado en el Templo Sagrado de Ayalon. La Anciana Aelrindel era conocida por su amor a la filosofía humana y su trabajo incansable construyendo puentes entre nuestros pueblos. Lloraría al ver cuán distantes nos hemos vuelto.");

        book.weight = 0.2f;
        book.marketValue = 0;
        book.vanishAfterRead = false;
        book.sellable = false;
        book.discardable = false;
        book.canBeIngredient = false;
        book.imgFile = "item_generic_letter";
        return book;
    }

    BookItem theRareMetalCaltranium() {
        BookItem book = new BookItem("The Rare Metal: Caltranium");
        book.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O Metal Raro: Caltrânio");
        book.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "El Metal Raro: Caltranio");

        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A scholarly treatise on Caltranium, the legendary metal of the deep.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um tratado acadêmico sobre Caltrânio, o metal lendário das profundezas.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un tratado académico sobre el Caltranio, el metal legendario de las profundidades.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "THE RARE METAL: CALTRANIUM\n\n" +
                        "Among all metals known to smiths, none surpasses the legendary Caltranium in rarity and excellence. This remarkable material was discovered by the dwarven folk in their deep delving beneath the mountains.\n\n" +
                        "ORIGIN\n\n" +
                        "Caltranium exists only in the deepest reaches of the world, in veins located miles below the surface. The dwarves, master miners without equal, are the only ones who know how to reach these depths and extract this precious metal.\n\n" +
                        "PROPERTIES\n\n" +
                        "DURABILITY: Blades of Caltranium hold their edge through countless battles, never dulling or chipping. The metal resists wear and corrosion to an almost magical degree.\n\n" +
                        "RESILIENCE: Armor made from Caltranium absorbs tremendous impact without breaking, combining remarkable flexibility with incredible strength.\n\n" +
                        "WEIGHT: Despite its strength, Caltranium is lighter than steel, ideal for weapons and armor.\n\n" +
                        "LUSTER: When polished, it displays a distinctive deep blue-gray sheen that never tarnishes.\n\n" +
                        "CRAFTING\n\n" +
                        "Only the most skilled dwarven smiths can work this metal. It requires extraordinarily high temperatures and specialized techniques that the dwarves guard jealously. They share only finished products, never raw ore or forging knowledge.\n\n" +
                        "RARITY\n\n" +
                        "Caltranium is extraordinarily rare. The difficulty of extraction, the extreme depths where it's found, and the skill required to work it make Caltranium items among the most valuable treasures in existence - approximately ten thousand times more valuable than gold, weight for weight.\n\n" +
                        "Most warriors will never wield a Caltranium blade or wear Caltranium armor. For those fortunate enough to possess even a small piece, treasure it well - you hold material from the very bones of the earth, shaped by the finest artisans who ever lived.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "O METAL RARO: CALTRÂNIO\n\n" +
                        "Entre todos os metais conhecidos por ferreiros, nenhum supera o lendário Caltrânio em raridade e excelência. Este material notável foi descoberto pelo povo anão em suas escavações sob as montanhas.\n\n" +
                        "ORIGEM\n\n" +
                        "O Caltrânio existe apenas nas profundezas mais extremas do mundo, em veios localizados a quilômetros abaixo da superfície. Os anões, mestres mineradores sem igual, são os únicos que sabem como alcançar essas profundidades e extrair este metal precioso.\n\n" +
                        "PROPRIEDADES\n\n" +
                        "DURABILIDADE: Lâminas de Caltrânio mantêm seu fio através de incontáveis batalhas, nunca ficando cegas ou lascando. O metal resiste ao desgaste e corrosão de forma quase mágica.\n\n" +
                        "RESILIÊNCIA: Armaduras feitas de Caltrânio absorvem impacto tremendo sem quebrar, combinando flexibilidade notável com força incrível.\n\n" +
                        "PESO: Apesar de sua força, o Caltrânio é mais leve que o aço, ideal para armas e armaduras.\n\n" +
                        "BRILHO: Quando polido, exibe um distinto brilho azul-acinzentado profundo que nunca perde o lustro.\n\n" +
                        "ARTESANATO\n\n" +
                        "Apenas os ferreiros anões mais habilidosos podem trabalhar este metal. Requer temperaturas extraordinariamente altas e técnicas especializadas que os anões guardam zelosamente. Eles compartilham apenas produtos acabados, nunca minério bruto ou conhecimento de forja.\n\n" +
                        "RARIDADE\n\n" +
                        "O Caltrânio é extraordinariamente raro. A dificuldade de extração, as profundidades extremas onde é encontrado, e a habilidade necessária para trabalhá-lo tornam itens de Caltrânio entre os tesouros mais valiosos existentes - aproximadamente dez mil vezes mais valioso que ouro, peso por peso.\n\n" +
                        "A maioria dos guerreiros nunca empunhará uma lâmina de Caltrânio ou usará armadura de Caltrânio. Para os afortunados o suficiente para possuir mesmo um pequeno pedaço, guardem-no bem - vocês seguram material dos próprios ossos da terra, moldado pelos melhores artesãos que já viveram.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "EL METAL RARO: CALTRANIO\n\n" +
                        "Entre todos los metales conocidos por herreros, ninguno supera al legendario Caltranio en rareza y excelencia. Este material notable fue descubierto por el pueblo enano en sus excavaciones bajo las montañas.\n\n" +
                        "ORIGEN\n\n" +
                        "El Caltranio existe solo en los alcances más profundos del mundo, en vetas localizadas a kilómetros bajo la superficie. Los enanos, maestros mineros sin igual, son los únicos que saben cómo alcanzar estas profundidades y extraer este metal precioso.\n\n" +
                        "PROPIEDADES\n\n" +
                        "DURABILIDAD: Hojas de Caltranio mantienen su filo a través de incontables batallas, nunca embotándose o astillándose. El metal resiste el desgaste y corrosión de forma casi mágica.\n\n" +
                        "RESILIENCIA: Armaduras hechas de Caltranio absorben tremendo impacto sin romperse, combinando flexibilidad notable con fuerza increíble.\n\n" +
                        "PESO: A pesar de su fuerza, el Caltranio es más ligero que el acero, ideal para armas y armaduras.\n\n" +
                        "LUSTRE: Cuando está pulido, muestra un distintivo brillo azul-grisáceo profundo que nunca se empaña.\n\n" +
                        "ARTESANÍA\n\n" +
                        "Solo los herreros enanos más hábiles pueden trabajar este metal. Requiere temperaturas extraordinariamente altas y técnicas especializadas que los enanos guardan celosamente. Comparten solo productos terminados, nunca mineral crudo o conocimiento de forja.\n\n" +
                        "RAREZA\n\n" +
                        "El Caltranio es extraordinariamente raro. La dificultad de extracción, las profundidades extremas donde se encuentra, y la habilidad requerida para trabajarlo hacen que los objetos de Caltranio estén entre los tesoros más valiosos existentes - aproximadamente diez mil veces más valioso que el oro, peso por peso.\n\n" +
                        "La mayoría de los guerreros nunca empuñarán una hoja de Caltranio o usarán armadura de Caltranio. Para los afortunados de poseer incluso un pequeño pedazo, atesórenlo bien - sostienen material de los propios huesos de la tierra, moldeado por los mejores artesanos que jamás vivieron.");

        book.weight = 0.4f;
        book.marketValue = 12;
        book.vanishAfterRead = false;
        book.sellable = true;
        book.discardable = true;
        book.canBeIngredient = false;
        book.illustrationFile = "items/item_generic_book";
        book.resetId("THE_RARE_METAL_CALTRANIUM");
        return book;
    }

    BookItem chroniclesOfTheDwarvenFolk() {
        BookItem book = new BookItem("Chronicles of the Dwarven Folk");
        book.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Crônicas do Povo Anão");
        book.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Crónicas del Pueblo Enano");

        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A human historian's account of the mysterious dwarven civilization.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um relato de historiador humano sobre a misteriosa civilização anã.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un relato de historiador humano sobre la misteriosa civilización enana.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "CHRONICLES OF THE DWARVEN FOLK\n\n" +
                        "The dwarven people remain among the most enigmatic civilizations in our world. Despite occasional encounters with their traders, much about them remains shrouded in mystery.\n\n" +
                        "NATURE AND TEMPERAMENT\n\n" +
                        "The dwarves are a proud and industrious people, shorter in stature than humans but broader and more robust. Their strength is legendary - a single dwarf can carry loads requiring three strong men.\n\n" +
                        "Though they maintain limited contact with human settlements, preferring isolation in remote places, dwarves are not hostile. Those who have met them describe them as honorable, straightforward, and possessed of a dry wit. They speak rarely but value substance over superficiality. Once you earn a dwarf's respect, you will find no more loyal friend.\n\n" +
                        "MASTERS OF MINING AND METALLURGY\n\n" +
                        "The dwarves are renowned for their unparalleled mastery of mining and metalworking. While human miners work shallow veins near the surface, dwarven operations delve miles into the earth's depths, extracting ores and materials previously unknown.\n\n" +
                        "Their knowledge of stone, metal, and gems surpasses human understanding by centuries. A dwarven smith can forge items of such quality that our finest craftsmen can only admire in despair. Their secret techniques, passed down through families, are guarded more jealously than any treasury.\n\n" +
                        "Dwarven-made weapons never need sharpening, armor seems impossibly light yet stops any blade, and jewelry is so exquisitely crafted it brings tears to the eyes.\n\n" +
                        "THE GREAT ISOLATION\n\n" +
                        "For unclear reasons, the dwarven people have chosen isolation over integration with surface dwellers. While trade caravans occasionally emerge from their distant settlements, bringing finished goods to exchange for foodstuffs, actual dwarven cities remain closed to outsiders.\n\n" +
                        "No human has been permitted to enter a dwarven city in living memory. Traders meet them at designated border posts, conducting business quickly before the dwarves retreat into their stone halls.\n\n" +
                        "THE UNDERGROUND KINGDOM\n\n" +
                        "According to reliable sources among their traders, the dwarven clans have begun construction of an immense underground city in the depths of a desert crater - not merely expanded halls, but a true kingdom carved into the earth itself.\n\n" +
                        "This project has occupied their people for decades and will likely continue for decades more. The scale is difficult to comprehend - the crater's depths being excavated further, vast cavern systems connected and expanded, underground rivers redirected.\n\n" +
                        "Some dwarven traders hint at dangers from below - creatures of the deep dark necessitating fortified settlements. Others speak of creating something that will endure through ages, a monument to dwarven skill and determination.\n\n" +
                        "This underground kingdom in the desert depths represents an engineering feat beyond anything humans have attempted. When completed, it will surely stand as one of the wonders of the world, even if few eyes besides dwarven ones ever behold it.\n\n" +
                        "RELATIONS WITH HUMANS\n\n" +
                        "Despite their isolation, the dwarves harbor no animosity toward humanity. Their trade is fair and honest - a dwarven merchant's word is absolutely binding. They expect the same honesty in return and permanently cut ties with any settlement where they were cheated.\n\n" +
                        "The dwarves have proven that a people can maintain their independence and culture while still engaging with the wider world on their own terms.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "CRÔNICAS DO POVO ANÃO\n\n" +
                        "O povo anão permanece entre as civilizações mais enigmáticas do nosso mundo. Apesar de encontros ocasionais com seus comerciantes, muito sobre eles permanece envolto em mistério.\n\n" +
                        "NATUREZA E TEMPERAMENTO\n\n" +
                        "Os anões são um povo orgulhoso e industrioso, mais baixos em estatura que humanos mas mais largos e robustos. Sua força é lendária - um único anão pode carregar cargas que exigiriam três homens fortes.\n\n" +
                        "Embora mantenham contato limitado com assentamentos humanos, preferindo o isolamento em lugares remotos, os anões não são hostis. Aqueles que os conheceram os descrevem como honrados, diretos e possuidores de um humor seco. Falam raramente mas valorizam substância sobre superficialidade. Uma vez que você ganha o respeito de um anão, não encontrará amigo mais leal.\n\n" +
                        "MESTRES DE MINERAÇÃO E METALURGIA\n\n" +
                        "Os anões são renomados por seu domínio incomparável de mineração e trabalho em metal. Enquanto mineradores humanos trabalham veios rasos perto da superfície, operações anãs penetram quilômetros nas profundezas da terra, extraindo minérios e materiais antes desconhecidos.\n\n" +
                        "Seu conhecimento de pedra, metal e gemas supera o entendimento humano em séculos. Um ferreiro anão pode forjar itens de tal qualidade que nossos melhores artesãos só podem admirar em desespero. Suas técnicas secretas, passadas através de famílias, são guardadas mais zelosamente que qualquer tesouro.\n\n" +
                        "Armas feitas por anões nunca precisam ser afiadas, armaduras parecem impossivelmente leves mas param qualquer lâmina, e joias são tão requintadamente trabalhadas que trazem lágrimas aos olhos.\n\n" +
                        "O GRANDE ISOLAMENTO\n\n" +
                        "Por razões obscuras, o povo anão escolheu isolamento sobre integração com habitantes da superfície. Enquanto caravanas de comércio ocasionalmente emergem de seus assentamentos distantes, trazendo produtos acabados para trocar por alimentos, cidades anãs reais permanecem fechadas a forasteiros.\n\n" +
                        "Nenhum humano teve permissão para entrar numa cidade anã em memória viva. Comerciantes se encontram com eles em postos de fronteira designados, conduzindo negócios rapidamente antes que os anões recuem para seus salões de pedra.\n\n" +
                        "O REINO SUBTERRÂNEO\n\n" +
                        "Segundo fontes confiáveis entre seus comerciantes, os clãs anões começaram a construção de uma imensa cidade subterrânea nas profundezas de uma cratera desértica - não meramente salões expandidos, mas um verdadeiro reino escavado na própria terra.\n\n" +
                        "Este projeto tem ocupado seu povo por décadas e provavelmente continuará por décadas mais. A escala é difícil de compreender - as profundezas da cratera sendo escavadas ainda mais, vastos sistemas de cavernas conectados e expandidos, rios subterrâneos redirecionados.\n\n" +
                        "Alguns comerciantes anões insinuam perigos vindos de baixo - criaturas da escuridão profunda que necessitam assentamentos fortificados. Outros falam de um desejo de criar algo que perdurará através das eras, um monumento à habilidade e determinação anã.\n\n" +
                        "Este reino subterrâneo nas profundezas do deserto representa um feito de engenharia além de qualquer coisa que humanos já tentaram. Quando completado, certamente ficará como uma das maravilhas do mundo, mesmo que poucos olhos além dos anões alguma vez o contemplem.\n\n" +
                        "RELAÇÕES COM HUMANOS\n\n" +
                        "Apesar de seu isolamento, os anões não nutrem animosidade contra a humanidade. Seu comércio é justo e honesto - a palavra de um mercador anão é absolutamente vinculativa. Esperam a mesma honestidade em retorno e cortam permanentemente laços com qualquer assentamento onde foram enganados.\n\n" +
                        "Os anões provaram que um povo pode manter sua independência e cultura enquanto ainda se engaja com o mundo mais amplo em seus próprios termos.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "CRÓNICAS DEL PUEBLO ENANO\n\n" +
                        "El pueblo enano permanece entre las civilizaciones más enigmáticas de nuestro mundo. A pesar de encuentros ocasionales con sus comerciantes, mucho sobre ellos permanece envuelto en misterio.\n\n" +
                        "NATURALEZA Y TEMPERAMENTO\n\n" +
                        "Los enanos son un pueblo orgulloso e industrioso, más bajos en estatura que los humanos pero más anchos y robustos. Su fuerza es legendaria - un solo enano puede cargar pesos que requerirían tres hombres fuertes.\n\n" +
                        "Aunque mantienen contacto limitado con asentamientos humanos, prefiriendo el aislamiento en lugares remotos, los enanos no son hostiles. Quienes los han conocido los describen como honorables, directos y poseedores de un ingenio seco. Hablan raramente pero valoran sustancia sobre superficialidad. Una vez que ganas el respeto de un enano, no encontrarás amigo más leal.\n\n" +
                        "MAESTROS DE MINERÍA Y METALURGIA\n\n" +
                        "Los enanos son renombrados por su dominio incomparable de la minería y el trabajo en metal. Mientras los mineros humanos trabajan vetas superficiales cerca de la superficie, las operaciones enanas penetran kilómetros en las profundidades de la tierra, extrayendo minerales y materiales antes desconocidos.\n\n" +
                        "Su conocimiento de piedra, metal y gemas supera el entendimiento humano en siglos. Un herrero enano puede forjar objetos de tal calidad que nuestros mejores artesanos solo pueden admirar en desesperación. Sus técnicas secretas, transmitidas a través de familias, son guardadas más celosamente que cualquier tesoro.\n\n" +
                        "Armas hechas por enanos nunca necesitan afilarse, armaduras parecen imposiblemente ligeras pero detienen cualquier hoja, y joyas son tan exquisitamente trabajadas que traen lágrimas a los ojos.\n\n" +
                        "EL GRAN AISLAMIENTO\n\n" +
                        "Por razones oscuras, el pueblo enano ha elegido aislamiento sobre integración con habitantes de la superficie. Mientras caravanas comerciales ocasionalmente emergen de sus asentamientos distantes, trayendo productos terminados para intercambiar por alimentos, las ciudades enanas reales permanecen cerradas a forasteros.\n\n" +
                        "Ningún humano ha tenido permiso para entrar en una ciudad enana en memoria viva. Los comerciantes se encuentran con ellos en puestos fronterizos designados, conduciendo negocios rápidamente antes de que los enanos se retiren a sus salones de piedra.\n\n" +
                        "EL REINO SUBTERRÁNEO\n\n" +
                        "Según fuentes confiables entre sus comerciantes, los clanes enanos han comenzado la construcción de una inmensa ciudad subterránea en las profundidades de un cráter desértico - no meramente salones expandidos, sino un verdadero reino excavado en la tierra misma.\n\n" +
                        "Este proyecto ha ocupado a su pueblo por décadas y probablemente continuará por décadas más. La escala es difícil de comprender - las profundidades del cráter siendo excavadas aún más, vastos sistemas de cavernas conectados y expandidos, ríos subterráneos redirigidos.\n\n" +
                        "Algunos comerciantes enanos insinúan peligros desde abajo - criaturas de la oscuridad profunda que necesitan asentamientos fortificados. Otros hablan de un deseo de crear algo que perdurará a través de las eras, un monumento a la habilidad y determinación enana.\n\n" +
                        "Este reino subterráneo en las profundidades del desierto representa una hazaña de ingeniería más allá de cualquier cosa que los humanos hayan intentado. Cuando sea completado, seguramente quedará como una de las maravillas del mundo, incluso si pocos ojos además de los enanos alguna vez lo contemplen.\n\n" +
                        "RELACIONES CON HUMANOS\n\n" +
                        "A pesar de su aislamiento, los enanos no albergan animosidad hacia la humanidad. Su comercio es justo y honesto - la palabra de un mercader enano es absolutamente vinculante. Esperan la misma honestidad a cambio y cortan permanentemente lazos con cualquier asentamiento donde fueron engañados.\n\n" +
                        "Los enanos han demostrado que un pueblo puede mantener su independencia y cultura mientras aún se involucra con el mundo más amplio en sus propios términos.");

        book.weight = 0.5f;
        book.marketValue = 10;
        book.vanishAfterRead = false;
        book.sellable = true;
        book.discardable = true;
        book.canBeIngredient = false;
        book.illustrationFile = "items/item_generic_book";
        return book;
    }

    BookItem studentLetter() {
        BookItem book = new BookItem("Student Letter");
        book.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Carta da Estudante");
        book.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Carta de la Estudiante");

        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A letter from a student to her father.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma carta de uma estudante para seu pai.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una carta de una estudiante a su padre.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "Dear Father,\n\n" +
                        "I hope this letter finds you well. I write with news that may surprise you, but I hope you will understand and support my decision.\n\n" +
                        "An opportunity has presented itself - a chance to purchase a house in Havarus, the great kingdom. I know this is sudden, but this is the opportunity I've been waiting for all my life. In Havarus, I can study at their grand libraries, learn from the greatest scholars, and truly develop my knowledge.\n\n" +
                        "I will use all the gold coins I have saved for this. I know it seems risky, but I'm confident this is the right choice for my future. The knowledge and skills I'll gain there will be invaluable. After my studies are complete, I promise I will return and help you even more with your alchemy. Everything I learn will benefit both of us.\n\n" +
                        "Please don't worry about me. I know this is the path I must take. I hope to see you visit me in Havarus once I'm settled.\n\n" +
                        "With all my love and respect,\nElena");

        book.addTextTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "Querido Pai,\n\n" +
                        "Espero que esta carta o encontre bem. Escrevo com notícias que podem surpreendê-lo, mas espero que compreenda e apoie minha decisão.\n\n" +
                        "Uma oportunidade surgiu - uma chance de comprar uma casa em Havarus, o grande reino. Sei que é repentino, mas esta é a oportunidade que esperava toda a minha vida. Em Havarus, posso estudar em suas grandes bibliotecas, aprender com os maiores estudiosos e realmente desenvolver meu conhecimento.\n\n" +
                        "Usarei todas as moedas de ouro que economizei para isso. Sei que parece arriscado, mas estou confiante de que esta é a escolha certa para meu futuro. O conhecimento e as habilidades que ganharei lá serão inestimáveis. Depois que meus estudos estiverem completos, prometo que voltarei e o ajudarei ainda mais com sua alquimia. Tudo o que aprender beneficiará a nós dois.\n\n" +
                        "Por favor, não se preocupe comigo. Sei que este é o caminho que devo seguir. Espero vê-lo me visitar em Havarus assim que eu me estabelecer.\n\n" +
                        "Com todo meu amor e respeito,\nElena");

        book.addTextTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "Querido Padre,\n\n" +
                        "Espero que esta carta te encuentre bien. Escribo con noticias que pueden sorprenderte, pero espero que comprendas y apoyes mi decisión.\n\n" +
                        "Se ha presentado una oportunidad: una posibilidad de comprar una casa en Havarus, el gran reino. Sé que es repentino, pero esta es la oportunidad que he estado esperando toda mi vida. En Havarus, puedo estudiar en sus grandes bibliotecas, aprender de los mejores eruditos y realmente desarrollar mi conocimiento.\n\n" +
                        "Usaré todas las monedas de oro que he ahorrado para esto. Sé que parece arriesgado, pero estoy segura de que esta es la elección correcta para mi futuro. El conocimiento y las habilidades que ganaré allí serán invaluables. Después de completar mis estudios, prometo que volveré y te ayudaré aún más con tu alquimia. Todo lo que aprenda nos beneficiará a ambos.\n\n" +
                        "Por favor, no te preocupes por mí. Sé que este es el camino que debo seguir. Espero verte visitarme en Havarus una vez que me establezca.\n\n" +
                        "Con todo mi amor y respeto,\nElena");

        book.weight = .1f;
        book.vanishAfterRead = false;
        book.sellable = false;
        book.buyable = false;
        book.discardable = false;
        book.canBeIngredient = false;
        book.imgFile = "item_generic_letter";

        return book;
    }

    BookItem spiritTreasureDocument() {
        BookItem book = new BookItem("Spirit's Treasure Document");
        book.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Documento do Tesouro do Espírito");
        book.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Documento del Tesoro del Espíritu");

        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "An ancient document revealing the location of a hidden treasure in Esperand Grove.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um documento antigo revelando a localização de um tesouro escondido no Bosque de Esperand.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un documento antiguo que revela la ubicación de un tesoro escondido en el Bosque de Esperand.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "To the kind soul who freed me from my earthly prison,\n\n" +
                        "In life, I guarded a treasure - precious gems I gathered over many years. When death claimed me, I could not bear to leave them behind. They remain buried where I once walked, in the heart of Esperand Forest, beneath the ancient oak that stands alone near the western edge.\n\n" +
                        "Dig three paces north of the oak's base, and you shall find what I have left. May these treasures serve you better than they served me. Consider them payment for your mercy and compassion.\n\n" +
                        "Walk in peace, kind traveler.\n\n" +
                        "- A grateful spirit, finally free");

        book.addTextTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "À alma gentil que me libertou da minha prisão terrena,\n\n" +
                        "Em vida, guardei um tesouro - gemas preciosas que reuni ao longo de muitos anos. Quando a morte me reivindicou, não pude suportar deixá-las para trás. Elas permanecem enterradas onde eu caminhava, no coração do Bosque de Esperand, sob o carvalho antigo que se ergue sozinho perto da borda oeste.\n\n" +
                        "Cave três passos ao norte da base do carvalho, e encontrarás o que deixei. Que esses tesouros te sirvam melhor do que me serviram. Considere-os pagamento pela tua misericórdia e compaixão.\n\n" +
                        "Caminhe em paz, gentil viajante.\n\n" +
                        "- Um espírito grato, finalmente livre");

        book.addTextTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "Al alma gentil que me liberó de mi prisión terrenal,\n\n" +
                        "En vida, guardé un tesoro - gemas preciosas que reuní durante muchos años. Cuando la muerte me reclamó, no pude soportar dejarlas atrás. Permanecen enterradas donde solía caminar, en el corazón del Bosque de Esperand, bajo el roble antiguo que se alza solo cerca del borde oeste.\n\n" +
                        "Cava tres pasos al norte de la base del roble, y encontrarás lo que dejé. Que estos tesoros te sirvan mejor de lo que me sirvieron a mí. Considéralos pago por tu misericordia y compasión.\n\n" +
                        "Camina en paz, gentil viajero.\n\n" +
                        "- Un espíritu agradecido, finalmente libre");

        book.weight = .1f;
        book.vanishAfterRead = false;
        book.sellable = false;
        book.buyable = false;
        book.discardable = false;
        book.canBeIngredient = false;
        book.imgFile = "item_generic_letter";

        return book;
    }

    BookItem ancientLiberationTome() {
        BookItem book = new BookItem("Ancient Liberation Tome");
        book.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Tomo Antigo de Libertação");
        book.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Tomo Antiguo de Liberación");

        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A rare book about rituals to free trapped spirits, kept in the restricted section of Monelix Library.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um livro raro sobre rituais para libertar espíritos presos, guardado na seção restrita da Biblioteca de Monelix.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un libro raro sobre rituales para liberar espíritus atrapados, guardado en la sección restringida de la Biblioteca de Monelix.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "On the Liberation of Earthbound Spirits\n" +
                        "By Father Gregorius Sariseus\n\n" +
                        "Through decades of study and communion with the divine, I have learned truths about souls that linger between worlds. Spirits bound to our realm are prisoners of unfinished business, violent ends, or powerful emotions that anchor them to mortal soil.\n\n" +
                        "The ritual of liberation requires not sacred items, but sacred intent. The trapped soul must return to the place of their passing and, with a heart open to peace, surrender to the purifying light of the divine gods. Through meditation and acceptance, the spirit can release its earthly bonds and ascend to eternal rest.\n\n" +
                        "[Note: The remaining pages describe various spiritual theories, but this passage seems to be the core ritual]");

        book.addTextTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "Sobre a Libertação de Espíritos Terrenos\n" +
                        "Por Padre Gregorius Sariseus\n\n" +
                        "Através de décadas de estudo e comunhão com o divino, aprendi verdades sobre almas que permanecem entre mundos. Espíritos presos ao nosso reino são prisioneiros de assuntos inacabados, fins violentos ou emoções poderosas que os ancoram ao solo mortal.\n\n" +
                        "O ritual de libertação não requer itens sagrados, mas intenção sagrada. A alma presa deve retornar ao lugar de sua passagem e, com o coração aberto à paz, render-se à luz purificadora dos deuses divinos. Através da meditação e aceitação, o espírito pode liberar seus laços terrestres e ascender ao descanso eterno.\n\n" +
                        "[Nota: As páginas restantes descrevem várias teorias espirituais, mas esta passagem parece ser o ritual central]");

        book.addTextTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "Sobre la Liberación de Espíritus Terrenales\n" +
                        "Por Padre Gregorius Sariseus\n\n" +
                        "A través de décadas de estudio y comunión con lo divino, he aprendido verdades sobre almas que permanecen entre mundos. Los espíritus atados a nuestro reino son prisioneros de asuntos pendientes, finales violentos o emociones poderosas que los anclan al suelo mortal.\n\n" +
                        "El ritual de liberación no requiere objetos sagrados, sino intención sagrada. El alma atrapada debe regresar al lugar de su paso y, con el corazón abierto a la paz, rendirse a la luz purificadora de los dioses divinos. A través de la meditación y aceptación, el espíritu puede liberar sus lazos terrenales y ascender al descanso eterno.\n\n" +
                        "[Nota: Las páginas restantes describen varias teorías espirituales, pero este pasaje parece ser el ritual central]");

        book.weight = .5f;
        book.vanishAfterRead = false;
        book.sellable = false;
        book.buyable = false;
        book.discardable = false;
        book.canBeIngredient = false;
        book.imgFile = "item_ancient_book";

        return book;
    }

    BookItem treasureMap() {
        BookItem book = new BookItem("Treasure Map");
        book.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mapa do Tesouro");
        book.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mapa del Tesoro");

        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "An ancient map taken from a ghost pirate. It shows the location of a cursed treasure.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um mapa antigo tirado de um pirata fantasma. Mostra a localização de um tesouro amaldiçoado.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un mapa antiguo tomado de un pirata fantasma. Muestra la ubicación de un tesoro maldito.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "[Map of the Wazel coastline with an X marked in the orc lands]\n\n" +
                        "Buried beneath ancient earth where the orcs dwell. The amulet holds our curse - whoever finds it shall decide our fate. Break it and free us, or keep it and damn us forever.\n\n" +
                        "[Strange glowing runes border the map]");

        book.addTextTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "[Mapa da costa de Wazel com um X marcado nas terras dos orcs]\n\n" +
                        "Enterrado sob terra antiga onde os orcs habitam. O amuleto guarda nossa maldição - quem o encontrar decidirá nosso destino. Quebre-o e nos liberte, ou mantenha-o e nos condene para sempre.\n\n" +
                        "[Runas estranhas e brilhantes fazem a borda do mapa]");

        book.addTextTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "[Mapa de la costa de Wazel con una X marcada en las tierras orcas]\n\n" +
                        "Enterrado bajo tierra antigua donde habitan los orcos. El amuleto guarda nuestra maldición - quien lo encuentre decidirá nuestro destino. Rómpelo y libéranos, o consérvalo y condénanos para siempre.\n\n" +
                        "[Runas extrañas y brillantes bordean el mapa]");

        book.listener = ctx -> LibQuest.updateQuest(QuestsIds.THE_TALE_OF_A_GHOST_SHIP, 4, App.getPlayerChar(), ctx);

        book.weight = .1f;
        book.vanishAfterRead = true;
        book.sellable = false;
        book.buyable = false;
        book.discardable = false;
        book.canBeIngredient = false;
        book.imgFile = "item_map";
        book.illustrationFile = "items/item_map";

        return book;
    }

    BookItem oldBrantContract() {
        BookItem book = new BookItem("Old Brant Contract");
        book.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Antigo Contrato Brant");
        book.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Antiguo Contrato Brant");

        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "An old contract found in the prison archives, sealed with the Brant family crest.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um antigo contrato encontrado nos arquivos da prisão, selado com o brasão da família Brant.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un antiguo contrato encontrado en los archivos de la prisión, sellado con el escudo de armas de los Brant.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "LAND AGREEMENT — By Royal Mandate of King Oriun\n\n" +
                        "This document certifies that the lands formerly belonging to the Falker family, located near the northern road, are hereby transferred to the Crown for the construction of a penal institution.\n\n" +
                        "In compensation, Lord Den Falker shall receive the northern territories of Letow, as agreed upon by both parties.\n\n" +
                        "[Clauses 1 through 6 establish standard terms of land transfer, duly witnessed and sealed by the Crown's authority.]\n\n" +
                        "— — —\n" +
                        "[Clause 7]\n" +
                        "Furthermore, this agreement is contingent upon the marriage of Lady Lara Falker to Sir Jard Brant, son of Sir Martyn Brant, to be celebrated no later than one year from this date. Failure to fulfill this condition nullifies the compensation clause and allows for legal recourse over the transferred lands.\n\n" +
                        "— — —\n\n" +
                        "[Signed: Sir Martyn Brant, Advisor to the Crown]\n" +
                        "[Witnessed: Lord Den Falker]");

        book.addTextTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "ACORDO DE TERRAS — Por Mandato Real do Rei Oriun\n\n" +
                        "Este documento certifica que as terras anteriormente pertencentes à família Falker, localizadas próximas à estrada do norte, são transferidas à Coroa para a construção de uma instituição penal.\n\n" +
                        "Como compensação, Lorde Den Falker receberá os territórios do norte de Letow, conforme acordado por ambas as partes.\n\n" +
                        "[As cláusulas 1 a 6 estabelecem os termos padrão de transferência de terras, devidamente testemunhadas e seladas pela autoridade da Coroa.]\n\n" +
                        "— — —\n" +
                        "[Cláusula 7]\n" +
                        "Ademais, este acordo está condicionado ao casamento de Lady Lara Falker com Sir Jard Brant, filho de Sir Martyn Brant, a ser celebrado em no máximo um ano a partir desta data. O descumprimento desta condição invalida a cláusula de compensação e permite recurso legal sobre as terras transferidas.\n\n" +
                        "— — —\n" +
                        "[Assinado: Sir Martyn Brant, Conselheiro da Coroa]\n" +
                        "[Testemunha: Lorde Den Falker]");

        book.addTextTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "ACUERDO DE TIERRAS — Por Mandato Real del Rey Oriun\n\n" +
                        "Este documento certifica que las tierras que anteriormente pertenecían a la familia Falker, ubicadas cerca del camino del norte, son transferidas a la Corona para la construcción de una institución penal.\n\n" +
                        "A modo de compensación, Lord Den Falker recibirá los territorios del norte de Letow, según lo acordado por ambas partes.\n\n" +
                        "[Las cláusulas 1 a 6 establecen los términos estándar de transferencia de tierras, debidamente atestiguadas y selladas por la autoridad de la Corona.]\n\n" +
                        "— — —\n" +
                        "[Cláusula 7]\n" +
                        "Además, este acuerdo está condicionado al matrimonio de Lady Lara Falker con Sir Jard Brant, hijo de Sir Martyn Brant, a celebrarse a más tardar un año a partir de esta fecha. El incumplimiento de esta condición invalida la cláusula de compensación y permite recursos legales sobre las tierras transferidas.\n\n" +
                        "— — —\n" +
                        "[Firmado: Sir Martyn Brant, Asesor de la Corona]\n" +
                        "[Testigo: Lord Den Falker]");

        book.weight = .2f;
        book.vanishAfterRead = false;
        book.sellable = false;
        book.buyable = false;
        book.discardable = false;
        book.canBeIngredient = false;
        book.imgFile = "item_generic_letter";
        book.illustrationFile = "item_generic_letter";

        return book;
    }

    BookItem falkerApologyLetter() {
        BookItem book = new BookItem("Falker Apology Letter");
        book.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Carta de Desculpas dos Falker");
        book.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Carta de Disculpa de los Falker");

        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A letter written by Lord Den Falker, admitting to illegal dealings and promising to cease all unlawful operations.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma carta escrita por Lorde Den Falker, admitindo negócios ilegais e prometendo cessar todas as operações ilícitas.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una carta escrita por Lord Den Falker, admitiendo negocios ilegales y prometiendo cesar todas las operaciones ilícitas.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "To Lady Jade Wintar, Counselor of the Crown,\n\n" +
                        "I, Lord Den Falker, ruler of Letow, confess to having maintained unlawful dealings with certain individuals from the Swamp Island territories. My desperation to provide for my people on these barren lands drove me to poor judgment.\n\n" +
                        "I hereby pledge, on my family's honor, to immediately and permanently cease all such activities. I accept whatever judgment the Crown sees fit to impose.\n\n" +
                        "I ask only that the injustice done to my family regarding our original lands be remembered when my conduct is weighed.\n\n" +
                        "[Signed: Lord Den Falker, Letow]");

        book.addTextTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "À Lady Jade Wintar, Conselheira da Coroa,\n\n" +
                        "Eu, Lorde Den Falker, governante de Letow, confesso ter mantido negócios ilícitos com certos indivíduos dos territórios da Ilha do Pântano. Meu desespero em prover meu povo nestas terras áridas me levou a julgamentos equivocados.\n\n" +
                        "Comprometo-me, pela honra da minha família, a cessar imediata e permanentemente todas essas atividades. Aceito qualquer julgamento que a Coroa considerar adequado impor.\n\n" +
                        "Peço apenas que a injustiça cometida contra minha família em relação às nossas terras originais seja lembrada quando minha conduta for avaliada.\n\n" +
                        "[Assinado: Lorde Den Falker, Letow]");

        book.addTextTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "A Lady Jade Wintar, Consejera de la Corona,\n\n" +
                        "Yo, Lord Den Falker, gobernante de Letow, confieso haber mantenido tratos ilegales con ciertos individuos de los territorios de la Isla del Pantano. Mi desesperación por proveer a mi gente en estas tierras áridas me llevó a un juicio equivocado.\n\n" +
                        "Me comprometo, por el honor de mi familia, a cesar inmediata y permanentemente todas esas actividades. Acepto cualquier sentencia que la Corona considere apropiado imponer.\n\n" +
                        "Solo pido que la injusticia cometida contra mi familia con respecto a nuestras tierras originales sea recordada cuando se evalúe mi conducta.\n\n" +
                        "[Firmado: Lord Den Falker, Letow]");

        book.weight = .1f;
        book.vanishAfterRead = false;
        book.sellable = false;
        book.buyable = false;
        book.discardable = false;
        book.canBeIngredient = false;
        book.imgFile = "item_generic_letter";
        book.illustrationFile = "item_generic_letter";

        return book;
    }

    BookItem jardLoveLetter() {
        BookItem book = new BookItem("Jard's Love Letter");
        book.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Carta de Amor de Jard");
        book.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Carta de Amor de Jard");

        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A love letter written by Sir Jard Brant, addressed to Lady Lara Falker.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma carta de amor escrita por Sir Jard Brant, endereçada a Lady Lara Falker.");
        book.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una carta de amor escrita por Sir Jard Brant, dirigida a Lady Lara Falker.");

        book.addTextTranslation(CoreEnums.AvailableLanguages.ENGLISH,
                "My dearest Lara,\n\n" +
                        "I know the years have not been kind to us. The war, our fathers' choices, the distance between Monelix and Helera — all of it has kept us apart. But I want you to know that not a day passes that I do not think of what could have been.\n\n" +
                        "Our fathers arranged a union, yes. But what I feel is not arrangement. It is real. I have always admired your strength, your defiance, your spirit. These are the qualities I fell for — not the alliance.\n\n" +
                        "I ask not for you to forget the past. Only that you give me a chance to build something new.\n\n" +
                        "Yours, if you will allow it,\n" +
                        "Sir Jard Brant");

        book.addTextTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
                "Minha querida Lara,\n\n" +
                        "Sei que os anos não foram gentis conosco. A guerra, as escolhas de nossos pais, a distância entre Monelix e Helera — tudo isso nos manteve separados. Mas quero que saiba que não passa um dia sequer sem que eu pense no que poderia ter sido.\n\n" +
                        "Nossos pais arranjaram uma união, sim. Mas o que sinto não é arranjo. É real. Sempre admirei sua força, sua determinação, seu espírito. Foram essas qualidades que me conquistaram — não a aliança.\n\n" +
                        "Não te peço que esqueças o passado. Apenas que me dês uma chance de construir algo novo.\n\n" +
                        "Seu, se me permitires,\n" +
                        "Sir Jard Brant");

        book.addTextTranslation(CoreEnums.AvailableLanguages.SPANISH,
                "Mi querida Lara,\n\n" +
                        "Sé que los años no han sido amables con nosotros. La guerra, las decisiones de nuestros padres, la distancia entre Monelix y Helera — todo ello nos ha mantenido separados. Pero quiero que sepas que no pasa un día sin que piense en lo que podría haber sido.\n\n" +
                        "Nuestros padres arreglaron una unión, sí. Pero lo que siento no es un arreglo. Es real. Siempre admiré tu fuerza, tu determinación, tu espíritu. Esas son las cualidades que me conquistaron, no la alianza.\n\n" +
                        "No te pido que olvides el pasado. Solo que me des una oportunidad para construir algo nuevo.\n\n" +
                        "Tuyo, si me lo permites,\n" +
                        "Sir Jard Brant");

        book.weight = .1f;
        book.vanishAfterRead = false;
        book.sellable = false;
        book.buyable = false;
        book.discardable = false;
        book.canBeIngredient = false;
        book.imgFile = "item_rawer_love_letter";
        book.illustrationFile = "item_rawer_love_letter";

        return book;
    }
}













