/**
 * wiki-cities.js
 * Renderiza tabela de cidades.
 */
(function () {
  var IMG_BASE = '../../img/apps/endlesstales2/assets/locations/';

  function getLang() {
    return (window.CURRENT_LANGUAGE || 'pt-br') === 'pt-br' ? 'pt' : 'en';
  }

  function getName(obj, lang) {
    return lang === 'pt' ? (obj.name_pt || obj.name_en) : obj.name_en;
  }

  function getRegion(city, lang) {
    return lang === 'pt' ? city.region_pt : city.region_en;
  }

  function getDesc(city, lang) {
    return lang === 'pt' ? (city.desc_pt || city.desc_en) : city.desc_en;
  }

  var sortState = { col: 'name', dir: 'asc' };

  function sortCities(items, col, dir, lang) {
    var sorted = items.slice();
    sorted.sort(function (a, b) {
      var va, vb;
      switch (col) {
        case 'name': va = getName(a, lang).toLowerCase(); vb = getName(b, lang).toLowerCase(); break;
        case 'region': va = getRegion(a, lang).toLowerCase(); vb = getRegion(b, lang).toLowerCase(); break;
        case 'shops': va = a.shops.length; vb = b.shops.length; return dir === 'asc' ? va - vb : vb - va;
        default: return 0;
      }
      return dir === 'asc' ? va.localeCompare(vb) : vb.localeCompare(va);
    });
    return sorted;
  }

  function buildHTML(items, state, lang) {
    var sorted = sortCities(items, state.col, state.dir, lang);

    function si(col) {
      if (state.col !== col) return ' <i class="fa-solid fa-sort sort-icon"></i>';
      return state.dir === 'asc' ? ' <i class="fa-solid fa-sort-up sort-icon active"></i>' : ' <i class="fa-solid fa-sort-down sort-icon active"></i>';
    }

    var html = '<div class="wiki-table-wrap"><table class="wiki-table wiki-table-cities">';
    html += '<thead><tr>';
    html += '<th></th>';
    html += '<th class="sortable" data-sort="name">' + (lang === 'pt' ? 'Nome' : 'Name') + si('name') + '</th>';
    html += '<th class="sortable" data-sort="region">' + (lang === 'pt' ? 'Região' : 'Region') + si('region') + '</th>';
    html += '<th class="sortable" data-sort="shops">' + (lang === 'pt' ? 'Lojas' : 'Shops') + si('shops') + '</th>';
    html += '<th>' + (lang === 'pt' ? 'Descrição' : 'Description') + '</th>';
    html += '</tr></thead><tbody>';

    sorted.forEach(function (city) {
      var cName = getName(city, lang);
      var imgSrc = IMG_BASE + city.img + '.webp';

      html += '<tr>';
      html += '<td class="td-img"><img src="' + imgSrc + '" alt="' + cName + '" loading="lazy" onerror="if(!this.dataset.retry){this.dataset.retry=1;this.src=this.src.replace(\'.webp\',\'.png\')}else{this.style.display=\'none\'}"></td>';
      html += '<td class="td-name"><strong>' + cName + '</strong></td>';
      html += '<td>' + getRegion(city, lang) + '</td>';

      // Shops
      html += '<td>';
      if (city.shops.length) {
        html += city.shops.map(function (s) { return getName(s, lang); }).join('; ');
      } else { html += '—'; }
      html += '</td>';

      // Description
      html += '<td class="td-desc">' + getDesc(city, lang) + '</td>';

      html += '</tr>';
    });

    html += '</tbody></table></div>';
    return html;
  }

  var data = null;

  function render() {
    var container = document.getElementById('wiki-table-cities');
    if (!container || !data || !data.length) return;
    var lang = getLang();
    var countHTML = '<p class="wiki-table-count">' + data.length + (lang === 'pt' ? ' cidades' : ' cities') + '</p>';
    container.innerHTML = countHTML + buildHTML(data, sortState, lang);
  }

  document.addEventListener('click', function (e) {
    var th = e.target.closest('#wiki-table-cities th.sortable[data-sort]');
    if (!th) return;
    var col = th.getAttribute('data-sort');
    if (sortState.col === col) {
      sortState.dir = sortState.dir === 'asc' ? 'desc' : 'asc';
    } else {
      sortState.col = col;
      sortState.dir = 'asc';
    }
    render();
  });

  window.WikiCities = {
    render: function (jsonPath) {
      var xhr = new XMLHttpRequest();
      xhr.open('GET', jsonPath, true);
      xhr.onload = function () {
        if (xhr.status !== 200) return;
        data = JSON.parse(xhr.responseText);
        render();
        var lang = getLang();
        var el = document.getElementById('wiki-total-count');
        if (el) el.textContent = data.length + (lang === 'pt' ? ' cidades no total' : ' cities total');
      };
      xhr.send();
    }
  };
})();
