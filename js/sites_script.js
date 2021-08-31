jQuery(document).ready(function ($) {
	MontarGaleria = (function () {
		let holder = document.getElementById("holder-display-boxes");
		holder.innerHTML = "";
		let imgs = ["../img/apps/sites/galeria1.png", "../img/apps/sites/galeria2.png", "../img/apps/sites/galeria3.png", "../img/apps/sites/galeria4.png", "../img/apps/sites/galeria5.png", "../img/apps/sites/galeria6.png"];

		for (let i = 0; i < imgs.length; i++) {
			let source = imgs[i];
			let box = document.createElement("div");
			box.className = "padding-2x box-display-img col-lg-4 col-sm-6 col-xs-12";

			let aBox = document.createElement("a");
			aBox.href = source;

			let img = document.createElement("img");
			img.className = "site-galeria-imagem";
			img.src = source;
			aBox.appendChild(img);

			box.appendChild(aBox);
			holder.appendChild(box);
		}
		$(holder).magnificPopup({ delegate: "a", type: "image", gallery: { enabled: true } });
	})();

	TraduzirPagina = (function () {
		let sobreTitulo = document.getElementById("about_section_title");
		let galeria = document.getElementById("galeria_title");
		let sobreJogo = document.getElementById("about_section_text");
		let contatoTitulo = document.getElementById("contact_us_title");

		sobreTitulo.innerHTML = Traduzir("Sobre_Sites_Titulo");
		galeria.innerHTML = Traduzir("Portfolio");
		sobreJogo.innerHTML = Traduzir("Sobre_Sites");
		contatoTitulo.innerHTML = Traduzir("Contato");
	})();

	inputPaginas = document.getElementById("input-pages");
	selectTipo = document.getElementById("input-tipo");
	infoTipo = document.getElementById("tipo-info");
	infoHasForm = document.getElementById("input-hasForm");
	infoValor = document.getElementById("valor-aprox-orcamento");

	const descricaoTipo = {
		institucional: "Um site prático, que divulga seu negócio e seus serviços em uma única página detalhada.<br>Muito usado para turbinar a marca da empresa e expor seus produtos a seus clientes.",
		portfolio: "Um website completo que foca em exibir os resultados de um serviço, como fotogragias, obras e livros.<br>Costuma atrair o cliente com belas imagens de divulgação.<br>Perfeito para quem quer divulgar um serviço de arte.",
		personalizado: "Se você quer escolher suas páginas, expor sua marca totalmente do seu jeito e se comunicar da sua forma com seu cliente, essa é sua escolha.<br>Usado por quem quer seu negócio e sua marca de forma exclusiva na web.",
	};

	selectTipo.onchange = function (ev) {
		if (this.value == "institucional" || this.value == "pagina_unica") {
			inputPaginas.value = 1;
			inputPaginas.setAttribute("disabled", "true");
		} else {
			inputPaginas.removeAttribute("disabled");
		}
		infoTipo.innerHTML = descricaoTipo[this.value];
	};

	CalcularOrcamento = function () {
		let valorHora = 45;
		let horasPage = {
			institucional: { HorasBase: 0, PorPagina: 16 },
			portfolio: { HorasBase: 15, PorPagina: 3 },
			personalizado: { HorasBase: 16, PorPagina: 4 },
		};
		let valorFormEmail = 100;
		let qtdPages = Number(inputPaginas.value);

		let tipo = selectTipo.value;
		if (tipo == "institucional") {
			qtdPages = 1;
		}

		let objHoras = horasPage[tipo];
		let horas = objHoras.HorasBase;
		horas += qtdPages * objHoras.PorPagina;
		let total = horas * valorHora;

		if (infoHasForm.checked) {
			total += valorFormEmail;
		}

		infoValor.innerHTML = "Valor:  R$ " + total.toFixed(2);
		console.log("Horas de Desenvolvimento: " + horas);
	};
	document.getElementById("btn-orcar").onclick = CalcularOrcamento;
});
