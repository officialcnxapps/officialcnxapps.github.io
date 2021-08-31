jQuery(document).ready(function ($) {

  // Sticky Nav Bar
  $(window).scroll(function () {
    if ($(this).scrollTop() > 20) {
      $('.sticky').addClass("fixed");
    }
    else {
      $('.sticky').removeClass("fixed");
    }
  });

  $(".menu-lateral-lista li").on("click", function () {
    var hamburgerIcon = $("#top-menu-holder .nav-text");
    hamburgerIcon.click();
  })

  MontarToolbar = function () {
    let toolbar_inicio = document.getElementById("toolbar_inicio");
    let toolbar_apps = document.getElementById("toolbar_apps");
    let toolbar_sobre = document.getElementById("toolbar_sobre");
    let toolbar_contato = document.getElementById("toolbar_contato");
    let toolbar_galeria = document.getElementById("toolbar_galeria");
    let toolbar_download = document.getElementById("toolbar_download");
    let toolbar_privacidade = document.getElementById("toolbar_privacidade");

    toolbar_inicio.textContent = Traduzir("Home");
    toolbar_sobre.textContent = Traduzir("Sobre");
    toolbar_contato.textContent = Traduzir("Contato");
    toolbar_privacidade.textContent = Traduzir("Privacidade");

    if (toolbar_apps != null) {
      toolbar_apps.textContent = Traduzir("Apps");
    }
    if (toolbar_galeria != null) {
      toolbar_galeria.textContent = Traduzir("Galeria");
    }
    if (toolbar_download != null) {
      toolbar_download.textContent = "Download";
    }

    document.querySelector(".nav-text").innerHTML = '<i class="icon-sli-menu cnx-color-clear icon2x"></i>';
  }();


});