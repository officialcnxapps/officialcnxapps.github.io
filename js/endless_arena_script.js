jQuery(document).ready(function ($) {
	MontarGaleria = (function () {
		let holder = document.getElementById("holder-display-boxes");
		holder.innerHTML = "";
		let imgs = ["../img/apps/endless-arena/galeria_1.jpg", "../img/apps/endless-arena/galeria_2.jpg", "../img/apps/endless-arena/galeria_3.jpg", "../img/apps/endless-arena/galeria_4.jpg", "../img/apps/endless-arena/galeria_5.jpg"];

		for (let i = 0; i < imgs.length; i++) {
			let source = imgs[i];

			if (window.CURRENT_LANGUAGE != "pt-br") {
				source = source.replace("galeria", "gallery");
			}

			let box = document.createElement("div");
			box.className = "padding-2x box-display-img";

			let aBox = document.createElement("a");
			aBox.href = source;

			let img = document.createElement("img");
			img.className = "app-galeria-imagem";
			img.src = source;
			aBox.appendChild(img);

			box.appendChild(aBox);
			holder.appendChild(box);
		}
	})();

	TraduzirPagina = (function () {
		let sobreTitulo = document.getElementById("about_section_title");
		let galeria = document.getElementById("galeria_title");
		let sobreJogo = document.getElementById("about_section_text");
		let downloadTitulo = document.getElementById("download_section_title");
		let contatoTitulo = document.getElementById("contact_us_title");

		sobreTitulo.innerHTML = Traduzir("Sobre_Jogo_Titulo");
		galeria.innerHTML = Traduzir("Galeria");
		sobreJogo.innerHTML = Traduzir("Sobre_Endless_Arena");
		downloadTitulo.innerHTML = Traduzir("Download_Jogo");
		contatoTitulo.innerHTML = Traduzir("Contato");

		// let novidadesTitulo = document.getElementById("novidades_section_title");
		// let lang = CURRENT_LANGUAGE;

		// novidadesTitulo.innerHTML = EndlessArena.DICT_NOVIDADES[lang].Novidades;

		// let versoes = EndlessArena.DICT_NOVIDADES[lang].Versoes;
		// let versoesElem = document.getElementById("endless_novidades_container");
		// for (let i = 0; i < versoes.length; i++) {
		// 	let versao = versoes[i];
		// 	let holder = document.createElement("div");
		// 	holder.className = "endless_version_box";

		// 	let versionTitle = document.createElement("h5");
		// 	versionTitle.className = "endless_version_title";
		// 	versionTitle.innerHTML = versao.Numero + " - " + versao.DataDisplay;

		// 	let versionDesc = document.createElement("p");
		// 	versionDesc.className = "endless_version_description";
		// 	versionDesc.innerHTML = versao.Descricao;

		// 	holder.appendChild(versionTitle);
		// 	holder.appendChild(versionDesc);
		// 	versoesElem.appendChild(holder);
		// }
	})();
});
