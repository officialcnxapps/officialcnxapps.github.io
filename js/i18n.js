/**
 * i18n — Sistema centralizado de tradução.
 *
 * Uso: data-i18n="secao.chave" em qualquer elemento HTML.
 *   - textContent por padrão
 *   - innerHTML se o elemento tiver o atributo data-i18n-html
 *   - Arrays são renderizados como <li> dentro do elemento
 *
 * O idioma é detectado via window.CURRENT_LANGUAGE (definido por translator.js).
 */
(function () {
  function resolvePath(obj, path) {
    return path.split('.').reduce(function (o, k) { return o && o[k]; }, obj);
  }

  function applyTranslations(dict, lang) {
    var key = lang === 'pt-br' ? 'pt' : 'en';
    document.querySelectorAll('[data-i18n]').forEach(function (el) {
      var path = el.getAttribute('data-i18n');
      var entry = resolvePath(dict, path);
      if (!entry) return;
      var value = entry[key];
      if (value === undefined) return;

      if (Array.isArray(value)) {
        el.innerHTML = value.map(function (v) { return '<li>' + v + '</li>'; }).join('');
      } else if (el.hasAttribute('data-i18n-html')) {
        el.innerHTML = value;
      } else {
        el.textContent = value;
      }
    });
  }

  // Resolve JSON path relative to the i18n.js script location
  var scripts = document.querySelectorAll('script[src*="i18n.js"]');
  var scriptSrc = scripts.length ? scripts[0].getAttribute('src') : '';
  var jsonPath = scriptSrc.replace('i18n.js', 'i18n_et2.json');

  // Wait for translator.js to set CURRENT_LANGUAGE
  function init() {
    var lang = window.CURRENT_LANGUAGE || 'pt-br';
    var xhr = new XMLHttpRequest();
    xhr.open('GET', jsonPath, true);
    xhr.onload = function () {
      if (xhr.status === 200) {
        try {
          var dict = JSON.parse(xhr.responseText);
          applyTranslations(dict, lang);
        } catch (e) { /* silent */ }
      }
    };
    xhr.send();
  }

  // Ensure translator.js has run first
  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', init);
  } else {
    init();
  }
})();
