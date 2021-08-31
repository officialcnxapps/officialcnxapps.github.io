jQuery(document).ready(function ($) {

  MontarGaleria = function () {
      let holder = document.getElementById("holder-display-boxes");
      holder.innerHTML = "";
      let imgs = [
          "../img/apps/dejavi/galeria (1).jpeg",
          "../img/apps/dejavi/galeria (2).jpeg",
          "../img/apps/dejavi/galeria (3).jpeg",
          "../img/apps/dejavi/galeria (4).jpeg",
      ]

      for (let i = 0; i < imgs.length; i++) {
          let source = imgs[i];
          let box = document.createElement("div")
          box.className = "padding-2x box-display-img";

          let aBox = document.createElement("a")
          aBox.href = source;

          let img = document.createElement("img");
          img.className = "app-galeria-imagem"
          img.src = source;
          aBox.appendChild(img)

          box.appendChild(aBox)
          holder.appendChild(box)
      }
  }();

  TraduzirPagina = function () {
      let sobreTitulo = document.getElementById("about_section_title");
      let galeria = document.getElementById("galeria_title");
      let sobreJogo = document.getElementById("about_section_text");
      let downloadTitulo = document.getElementById("download_section_title");
      let contatoTitulo = document.getElementById("contact_us_title");

      sobreTitulo.innerHTML = Traduzir("Sobre_App_Titulo");
      galeria.innerHTML = Traduzir("Galeria");
      sobreJogo.innerHTML = Traduzir("Sobre_Dejavi");
      downloadTitulo.innerHTML = Traduzir("Download_App");
      contatoTitulo.innerHTML = Traduzir("Contato")
  }();

});