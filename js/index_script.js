jQuery(document).ready(function ($) {
	TraduzirPagina = (function () {
		let nossosApps = document.getElementById("nossos_apps_title");
		let endlessDesc = document.getElementById("endless_tales_descricao");
		let endlessArenaDesc = document.getElementById("endless_arena_descricao");
		let dejaviDesc = document.getElementById("dejavi_descricao");
		let sitesDesc = document.getElementById("sites_descricao");
		let sobreTitulo = document.getElementById("about_section_title");
		let sobre = document.getElementById("about_section_text");
		let contatoTitulo = document.getElementById("contact_us_title");

		nossosApps.innerHTML = Traduzir("Nossos_Apps");
		endlessDesc.innerHTML = Traduzir("Descricao_Endless");
		endlessArenaDesc.innerHTML = Traduzir("Descricao_Endless_Arena");
		dejaviDesc.innerHTML = Traduzir("Descricao_Dejavi");
		sitesDesc.innerHTML = Traduzir("Descricao_Sites");
		sobreTitulo.innerHTML = Traduzir("Sobre_Nos");
		sobre.innerHTML = Traduzir("Texto_Sobre");
		contatoTitulo.innerHTML = Traduzir("Contato");
	})();
});
