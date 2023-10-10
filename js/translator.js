jQuery(document).ready(function ($) {
	const info = navigator;
	let language = info.language;
	let lang = "en-us";
	if (language != null) {
		language = language.toLowerCase();
		if (language == "pt" || language == "pt-br") {
			lang = "pt-br";
		} else if (language == "en" || language == "en-us") {
			lang = "en-us";
		}
	}
	window.CURRENT_LANGUAGE = lang;

	const dicionario = {
		"pt-br": {
			Home: "Home",
			Apps: "Apps",
			Nossos_Apps: "Nossos Produtos",
			Sobre_Nos: "Sobre Nós",
			Sobre: "Sobre",
			Contato: "Contato",
			Privacidade: "Privacidade",
			Descricao_Endless: "Um RPG imersivo e inacabável, onde você cria sua história e evolui sua personalidade.",
			Descricao_Endless_Arena: "",
			Descricao_Sites: "Fazemos um site rápido, simples e eficiente para você divulgar sua marca e seus produtos na web",
			Descricao_Dejavi: "DejaVi permite que você crie listas de séries e filmes que você ainda quer assistir e adicione lembretes como notificações no celular.",
			Texto_Sobre: "A CNX Apps cria e desenvolve websites e aplicativos mobiles para Android desde 2019, utilizando diferentes plataformas e tecnologias, sempre focando em programar o melhor resultado para nossos usuários e players.<br><br>" + "Desenvolvemos webApps e sites focados em informação rápida ao usuário final, com designs modernos e eficientes.<br><br>" + "Também temos atualmente temos 3 aplicativos em pleno funcionamento na Play Store, nosso jogo, Endless Tales, um ótimo RPG. Endless Arena e também o aplicativo DejaVi, para listar suas séries e filmes.<br>",
			Sobre_Jogo_Titulo: "O Jogo",
			Sobre_App_Titulo: "O App",
			Sobre_Sites_Titulo: "Nossos Sites",
			Galeria: "Galeria",
			Portfolio: "Portfólio",
			Download_Jogo: "Jogue Agora!",
			Download_App: "Baixe Agora!",
			Sobre_Endless: "Endless Tales é um jogo de Role-Playing (RPG) situado em uma era medieval fantasiosa. Desde o início já se pode personalizar suas características e evoluir seus atributos.<br>" + "Endless Tales é imersivo e infinito, permitindo que você explore todos os cantos do mundo enfrentando todas criaturas e vivendo diferentes e incríveis aventuras.<br>" + "Crie, evolua, faça suas escolhas (e sofra as consequências), enfrente criaturas e entre na fantasia deste RPG de escolhas.",
			Sobre_Endless_Arena: "",
			Sobre_Dejavi: "Nunca lembra daquela série que te indicaram? Aquele filme que ainda não lançou mas não quer esquecer de assitir?<br>" + "DejaVi permite que você crie listas de séries e filmes que você ainda quer assistir e adicione lembretes como notificações no celular.<br>" + "Também é possível listar os que já assistiu, dando uma nota para eles.<br>" + "Assim fica fácil manter suas séries sempre em dia!",
			Sobre_Sites: "Ter um site é primordial na era da informação; de forma rápida e simples, você pode ter o seu.<br>Desenvolvemos um site rápido, simples e eficiente para você divulgar sua marca e seus produtos na web.<br>Saiba mais e entre em contato, iremos criar para você um site personalizado e profissional para você turbinar o seu negócio através da internet!",
			Titulo_Politica: "Política de Privacidade",
			Texto_Privacidade: GetTextoPrivacidadePortugues(),
			Texto_Privacidade_Dejavi: "<h2>Privacidade - Dejavi</h2>" + "<p>Além de toda política citada nos termos acima, também informamos que o aplicativo DejaVi não coleta informações pessoais e é livre para todos os públicos.</p>",
			Texto_Privacidade_Endless: "<h2>Privacidade - Endless Tales</h2>" + "<p>Além de toda política citada nos termos acima, também informamos que o aplicativo Endless Tales não coleta informações pessoais, somente armazena dados do próprio aplicativo, que sejam necessários para seu funcionamento. É sugerido que os usuários tenham idade igual ou superior a 13 anos.</p>",
			Texto_Privacidade_Endless_Arena: "<h2>Privacidade - Endless Aerna</h2>" + "<p>Além de toda política citada nos termos acima, também informamos que o aplicativo Endless Arena não coleta informações pessoais, somente armazena dados do próprio aplicativo, que sejam necessários para seu funcionamento. É sugerido que os usuários tenham idade igual ou superior a 13 anos.</p>",
		},
		"en-us": {
			Home: "Home",
			Apps: "Apps",
			Nossos_Apps: "Our Products",
			Sobre: "About",
			Sobre_Nos: "About Us",
			Contato: "Contact",
			Privacidade: "Privacy",
			Descricao_Endless: "An endless and immersive RPG, where you create your own history and evolves your personality",
			Descricao_Endless_Arena: "",
			Descricao_Sites: "We have develop a fast, simple and efficient website for you to advertise your brand and your products on the web",
			Descricao_Dejavi: "DejaVi allows you to create lists of series and movies that you want to watch and lets you add reminders such as notifications on your device.",
			Texto_Sobre: "CNX Apps creates and develops websites and mobile applications for Android since 2019, using different platforms and technologies, always focusing on programming the best result for our users and players.<br><br>" + "We develop webApps and websites focused on quick information to the final user, with modern and efficient designs.<br><br>" + "We also currently have 2 fully functioning apps on the Play Store, our game, Endless Tales, a great RPG. Endless Arena and also the DejaVi app, to list your series and movies.<br>",
			Sobre_Jogo_Titulo: "The Game",
			Sobre_App_Titulo: "The App",
			Sobre_Sites_Titulo: "Our Websites",
			Galeria: "Gallery",
			Portfolio: "Portfolio",
			Download_Jogo: "Play Now!",
			Download_App: "Get it Now!",
			Sobre_Sites: "Having a website is essential in the information age; quickly and simply, you can have yours. <br> We develop a website quickly, simply and efficienttly for you to advertise your brand and products on the web.<br>Learn more and contact us, we will create a personalized and professional website for you, so you can boost your business over the internet!",
			Sobre_Endless: "Endless Tales is a Role-Playing Game (RPG) set in a fantasy medieval era. From the beginning, you can customize your characteristics and evolve your attributes.<br>" + "Endless Tales is immersive and infinite, allowing you to explore all corners of the world facing all creatures and living different and incredible adventures.<br>" + "Create, evolve, make your choices (and suffer the consequences), face creatures and dive into the fantasy of this RPG of choices.",
			Sobre_Endless_Arena: "",
			Sobre_Dejavi: "Do you always forget the series that friends told you about? A movie is not yet released but you want to remember to watch it?<br>" + "DejaVi lets you create lists of series and movies that you still want to watch and add reminders like notifications on your mobile.<br>" + "You can also list the ones you've already watched, giving them a score.<br>" + "That way it's easy to keep your series up-to-date!",
			Titulo_Politica: "Privacy Policy",
			Texto_Privacidade: GetTextoPrivacidadeIngles(),
			Texto_Privacidade_Dejavi: "<h2>Privacidade - Dejavi</h2>" + "<p>In addition to the policy mentioned in the above terms, we also inform that the 'DejaVi' application does not collect personal information and is free for all audiences.</p>",
			Texto_Privacidade_Endless: "<h2>Privacidade - Endless Tales</h2>" + "<p>In addition to the policy mentioned in the above terms, we also inform that the 'Endless Tales' application does not collect personal information, it only stores data from the application itself, which are necessary for its operation. It is suggested that users are 13 years old or older.</p>",
			Texto_Privacidade_Endless_Arena: "<h2>Privacidade - Endless Arena</h2>" + "<p>In addition to the policy mentioned in the above terms, we also inform that the 'Endless Arena' application does not collect personal information, it only stores data from the application itself, which are necessary for its operation. It is suggested that users are 13 years old or older.</p>",
		},
	};

	Traduzir = function (key) {
		return dicionario[lang][key] || " ";
	};
	window.Traduzir = Traduzir;

	function GetTextoPrivacidadePortugues() {
		return (
			"A sua privacidade é importante para nós. É política da CNX Apps respeitar a sua privacidade em relação a qualquer informação sua que possamos coletar em nosso site " +
			"<a href=https://cnxapps.com.br>CNX Apps</a>, e outros sites que possuímos e operamos." +
			"<p>Estas políticas listadas aqui se aplicam também para nossos aplicativos: <a href=https://cnxapps.com.br/endless_tales>Endless Tales</a>, <a href=https://cnxapps.com.br/endless_arena>Endless Arena</a> e <a href=https://cnxapps.com.br/dejavi>DejaVi</a></p><br>" +
			"<p>Solicitamos informações pessoais apenas quando realmente precisamos delas para lhe fornecer um serviço. Fazemo-lo por meios justos e legais, com o seu conhecimento e consentimento. Também informamos por que estamos coletando e como será usado. </p>" +
			"<p>Apenas retemos as informações coletadas pelo tempo necessário para fornecer o serviço solicitado. Quando armazenamos dados, protegemos dentro de meios comercialmente aceitáveis ​​para evitar perdas e roubos, bem como acesso, divulgação, cópia, uso ou modificação não autorizados.</p>" +
			"<p>Não compartilhamos informações de identificação pessoal publicamente ou com terceiros, exceto quando exigido por lei.</p>" +
			"<p>O nosso site pode ter links para sites externos que não são operados por nós. Esteja ciente de que não temos controle sobre o conteúdo e práticas desses sites e não podemos aceitar responsabilidade por suas respectivas <a href='https://politicaprivacidade.com' target='_BLANK'>políticas de privacidade</a>. </p>" +
			"<p>Você é livre para recusar a nossa solicitação de informações pessoais, entendendo que talvez não possamos fornecer alguns dos serviços desejados.</p>" +
			"<p>O uso continuado de nosso site será considerado como aceitação de nossas práticas em torno de privacidade e informações pessoais. Se você tiver alguma dúvida sobre como lidamos com dados do usuário e informações pessoais, entre em contacto connosco.</p>" +
			"<br><p>A política acima é válida também para nossos aplicativos, tais como: Endless Tales, Endless Arena e Dejavi, ambos podem ser adquiridos na loja de aplicativos Google, respeitando todas diretrizes.</p>" +
			"<h2 style='text-align:center'>Política de Cookies CNX Apps</h2>" +
			"<h3>O que são cookies?</h3>" +
			"<p>Como é prática comum em quase todos os sites profissionais, este site usa cookies, que são pequenos arquivos baixados no seu computador, para melhorar sua experiência. Esta página descreve quais informações eles coletam, como as usamos e por que às vezes precisamos armazenar esses cookies. Também compartilharemos como você pode impedir que esses cookies sejam armazenados, no entanto, isso pode fazer o downgrade ou 'quebrar' certos elementos da funcionalidade do site.</p>" +
			"<h3>Como usamos os cookies?</h3>" +
			"<p>Utilizamos cookies por vários motivos, detalhados abaixo. Infelizmente, na maioria dos casos, não existem opções padrão do setor para desativar os cookies sem desativar completamente a funcionalidade e os recursos que eles adicionam a este site. É recomendável que você deixe todos os cookies se não tiver certeza se precisa ou não deles, caso sejam usados ​​para fornecer um serviço que você usa.</p>" +
			"<h3>Desativar cookies</h3>" +
			"<p>Você pode impedir a configuração de cookies ajustando as configurações do seu navegador (consulte a Ajuda do navegador para saber como fazer isso). Esteja ciente de que a desativação de cookies afetará a funcionalidade deste e de muitos outros sites que você visita. A desativação de cookies geralmente resultará na desativação de determinadas funcionalidades e recursos deste site. Portanto, é recomendável que você não desative os cookies.</p>" +
			"<h3>Cookies que definimos</h3>" +
			"<ul>" +
			"<li> Cookies relacionados à conta<br><br> Se você criar uma conta connosco, usaremos cookies para o gerenciamento do processo de inscrição e administração geral. Esses cookies geralmente serão excluídos quando você sair do sistema, porém, em alguns casos, eles poderão permanecer posteriormente para lembrar as preferências do seu site ao sair.<br><br> </li>" +
			"<li> Cookies relacionados ao login<br><br> Utilizamos cookies quando você está logado, para que possamos lembrar dessa ação. Isso evita que você precise fazer login sempre que visitar uma nova página. Esses cookies são normalmente removidos ou limpos quando você efetua logout para garantir que você possa acessar apenas a recursos e áreas restritas ao efetuar login.<br><br> </li>" +
			"<li> Cookies relacionados a boletins por e-mail<br><br> Este site oferece serviços de assinatura de boletim informativo ou e-mail e os cookies podem ser usados ​​para lembrar se você já está registrado e se deve mostrar determinadas notificações válidas apenas para usuários inscritos / não inscritos.<br><br> </li>" +
			"<li> Pedidos processando cookies relacionados<br><br> Este site oferece facilidades de comércio eletrônico ou pagamento e alguns cookies são essenciais para garantir que seu pedido seja lembrado entre as páginas, para que possamos processá-lo adequadamente.<br><br> </li>" +
			"<li> Cookies relacionados a pesquisas<br><br> Periodicamente, oferecemos pesquisas e questionários para fornecer informações interessantes, ferramentas úteis ou para entender nossa base de usuários com mais precisão. Essas pesquisas podem usar cookies para lembrar quem já participou numa pesquisa ou para fornecer resultados precisos após a alteração das páginas.<br><br> </li>" +
			"<li> Cookies relacionados a formulários<br><br> Quando você envia dados por meio de um formulário como os encontrados nas páginas de contacto ou nos formulários de comentários, os cookies podem ser configurados para lembrar os detalhes do usuário para correspondência futura.<br><br> </li>" +
			"<li> Cookies de preferências do site<br><br> Para proporcionar uma ótima experiência neste site, fornecemos a funcionalidade para definir suas preferências de como esse site é executado quando você o usa. Para lembrar suas preferências, precisamos definir cookies para que essas informações possam ser chamadas sempre que você interagir com uma página for afetada por suas preferências.<br> </li>" +
			"</ul>" +
			"<h3>Cookies de Terceiros</h3>" +
			"<p>Em alguns casos especiais, também usamos cookies fornecidos por terceiros confiáveis.</p>" +
			"<p>Para mais informações sobre cookies do Google Analytics, consulte a página oficial do Google Analytics.</p>" +
			"<ul>" +
			"<li> As análises de terceiros são usadas para rastrear e medir o uso deste site, para que possamos continuar produzindo conteúdo atrativo. Esses cookies podem rastrear itens como o tempo que você passa no site ou as páginas visitadas, o que nos ajuda a entender como podemos melhorar o site para você.</li>" +
			"<li> Periodicamente, testamos novos recursos e fazemos alterações subtis na maneira como o site se apresenta. Quando ainda estamos testando novos recursos, esses cookies podem ser usados ​​para garantir que você receba uma experiência consistente enquanto estiver no site, enquanto entendemos quais otimizações os nossos usuários mais apreciam.</li>" +
			"<li> À medida que vendemos produtos, é importante entendermos as estatísticas sobre quantos visitantes de nosso site realmente compram e, portanto, esse é o tipo de dados que esses cookies rastrearão. Isso é importante para você, pois significa que podemos fazer previsões de negócios com precisão que nos permitem analizar nossos custos de publicidade e produtos para garantir o melhor preço possível.</li>" +
			"</ul>" +
			"<h3>Mais informações</h3>" +
			"<p>Esperemos que esteja esclarecido e, como mencionado anteriormente, se houver algo que você não tem certeza se precisa ou não, geralmente é mais seguro deixar os cookies ativados, caso interaja com um dos recursos que você usa em nosso site.</p>" +
			"<p>Esta política é efetiva a partir de <strong>Agosto</strong>/<strong>2020</strong>.</p>"
		);
	}

	function GetTextoPrivacidadeIngles() {
		return (
			"Your privacy is important to us. It is the policy of CNX Apps to respect your privacy in relation to any information about you that we may collect on the site" +
			"<a href=https://cnxapps.com.br>CNX Apps</a>, and other sites that we own and operate." +
			"<p>These policies listed here also apply to our applications: <a href=https://cnxapps.com.br/endless_tales>Endless Tales</a>, <a href=https://cnxapps.com.br/endless_arena>Endless Arena</a> and <a href=https://cnxapps.com.br/dejavi>DejaVi</a></p><br>" +
			"<p>We request personal information only when we really need it to provide you with a service. We do so by fair and legal means, with your knowledge and consent. We also inform you why we are collecting it and how it will be used. </p>" +
			"<p>We only retain the information collected for the time necessary to provide the requested service. When we store data, we protect it within commercially acceptable means to prevent loss and theft, as well as unauthorized access, disclosure, copying, use or modification. </p> " +
			"<p>We do not share personally identifiable information publicly or with third parties, except as required by law.</p>" +
			"<p>Our site may have links to external sites that are not operated by us. Please be aware that we have no control over the content and practices of those sites and cannot accept responsibility for their respective <a href = 'https: / /politicaprivácia.com 'target =' _ BLANK '> privacy policies </a>. </p> " +
			"<p>You are free to refuse our request for personal information, understanding that we may not be able to provide some of the desired services.</p>" +
			"<p>The continued use of our website will be considered acceptance of our practices around privacy and personal information. If you have any questions about how we handle user data and personal information, please contact us. </p> " +
			"<br><p> The above policy is also valid for our apps, such as: Endless Tales, Endless Arena and Dejavi, both can be purchased at the Google app store, respecting all guidelines. </p>" +
			"<h2 style='text-align: center'>CNX Apps Cookies Policy</h2>" +
			"<h3>What are cookies?</h3>" +
			"<p>As is common practice on almost all professional sites, this site uses cookies, which are small files downloaded to your computer, to improve your experience. This page describes what information they collect, how we use it and why sometimes we need to store these cookies. We will also share how you can prevent these cookies from being stored, however, this may downgrade or 'break' certain elements of the website's functionality. </p> " +
			"<h3>How do we use cookies?</h3>" +
			"<p>We use cookies for a variety of reasons, detailed below. Unfortunately, in most cases, there are no industry-standard options for disabling cookies without completely disabling the functionality and features they add to this site. It is recommended that you leave all cookies if you are not sure whether or not you need them, if they are used to provide a service you use.</p> " +
			"<h3>Disable cookies</h3>" +
			"<p>You can prevent cookies from being set by adjusting your browser settings (see your browser's Help to learn how to do this). Be aware that disabling cookies will affect the functionality of this and many other sites you visit Disabling cookies will generally result in disabling certain features and features on this site, so it is recommended that you do not disable cookies.</p> " +
			"<h3>Cookies we set</h3>" +
			"<ul>" +
			"<li>Account-related cookies <br> <br> If you create an account with us, we will use cookies to manage the sign-up and general administration process. These cookies will generally be deleted when you log out, however, in some cases , they can remain at a later date to remember your site’s preferences when they leave.<br><br></li> " +
			"<li>Login-related cookies <br> <br> We use cookies when you are logged in, so that we can remember this action. This prevents you from having to log in whenever you visit a new page. These cookies are usually removed or cleared when you log out to ensure that you can only access resources and restricted areas when you log in.<br><br></li> " +
			"<li>Cookies related to email newsletters <br> <br> This site offers newsletter or email subscription services and cookies can be used to remember if you are already registered and should show certain notifications valid only for registered / non-registered users. <br> <br> </li> " +
			"<li>Orders processing related cookies <br><br> This website offers e-commerce or payment facilities and some cookies are essential to ensure that your order is remembered between pages, so that we can process it properly.<br><br></li> " +
			"<li>Survey-related cookies <br> <br> We periodically offer surveys and questionnaires to provide interesting information, useful tools or to understand our user base more accurately. These surveys may use cookies to remember who has already participated in a survey or to provide accurate results after changing the pages.<br><br></li> " +
			"<li>Cookies related to forms <br> <br> When you send data using a form such as those found on contact pages or comment forms, cookies can be set to remember the user's details for future correspondence.<br><br></li> " +
			"<li>Site preferences cookies <br> <br> To provide a great experience on this site, we provide the functionality to set your preferences for how this site runs when you use it. To remember your preferences, we need to set cookies for that this information can be called up whenever you interact with a page is affected by your preferences.<br></li> " +
			"</ul>" +
			"<h3>Third Party Cookies </h3>" +
			"<p>In some special cases, we also use cookies provided by trusted third parties. </p>" +
			"<p>For more information on Google Analytics cookies, see the official Google Analytics page. </p>" +
			"<ul>" +
			"<li>Third party analytics are used to track and measure the use of this site, so that we can continue to produce compelling content. These cookies can track items such as the time you spend on the site or the pages you visit, which helps us to understand how we can improve the site for you. </li> " +
			"<li>We periodically test new features and make subtle changes to the way the site looks. When we're still testing new features, these cookies can be used to ensure that you receive a consistent experience while on the site, while we understand which optimizations our users appreciate most. </li> " +
			"<li>As we sell products, it is important to understand the statistics on how many visitors to our site actually buy, so this is the type of data these cookies will track. This is important to you, as it means that we can make predictions business deals that allow us to analyze our advertising and product costs to ensure the best possible price. </li> " +
			"</ul>" +
			"<h3>More information </h3>" +
			"<p>Hopefully it is clear and, as mentioned earlier, if there is something you are not sure whether you need or not, it is generally safer to leave cookies enabled if you interact with one of the features you use on our website. < / p> " +
			"<p>This policy is effective from <strong>August</strong>/<strong>2020</strong>.</p>"
		);
	}
});
