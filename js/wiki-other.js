/**
 * wiki-other.js
 * Renderiza tabelas de itens valiosos e outros itens misc.
 */
(function () {
  var IMG_BASE = '../../img/apps/endlesstales2/assets/items/';

  function getLang() {
    return (window.CURRENT_LANGUAGE || 'pt-br') === 'pt-br' ? 'pt' : 'en';
  }

  function getItemName(item, lang) {
    return lang === 'pt' ? item.name_pt : item.name_en;
  }

  var sortStates = {};

  function sortItems(items, col, direction, lang) {
    var sorted = items.slice();
    sorted.sort(function (a, b) {
      var va, vb;
      switch (col) {
        case 'name':
          va = getItemName(a, lang).toLowerCase();
          vb = getItemName(b, lang).toLowerCase();
          return direction === 'asc' ? va.localeCompare(vb) : vb.localeCompare(va);
        case 'value':
          va = a.value || 0; vb = b.value || 0;
          return direction === 'asc' ? va - vb : vb - va;
        case 'weight':
          va = a.weight || 0; vb = b.weight || 0;
          return direction === 'asc' ? va - vb : vb - va;
        default: return 0;
      }
    });
    return sorted;
  }

  function buildTableHTML(items, state, lang) {
    var sortedItems = sortItems(items, state.col, state.dir, lang);

    function sortIcon(col) {
      if (state.col !== col) return ' <i class="fa-solid fa-sort sort-icon"></i>';
      return state.dir === 'asc'
        ? ' <i class="fa-solid fa-sort-up sort-icon active"></i>'
        : ' <i class="fa-solid fa-sort-down sort-icon active"></i>';
    }

    var html = '<div class="wiki-table-wrap"><table class="wiki-table">';
    html += '<thead><tr>';
    html += '<th></th>';
    html += '<th class="sortable" data-sort="name">' + (lang === 'pt' ? 'Nome' : 'Name') + sortIcon('name') + '</th>';
    html += '<th class="sortable" data-sort="value">' + (lang === 'pt' ? 'Valor Base' : 'Base Value') + sortIcon('value') + '</th>';
    html += '<th class="sortable" data-sort="weight">' + (lang === 'pt' ? 'Peso' : 'Weight') + sortIcon('weight') + '</th>';
    html += '<th>' + (lang === 'pt' ? 'Ingrediente' : 'Ingredient') + '</th>';
    html += '</tr></thead><tbody>';

    sortedItems.forEach(function (item) {
      var name = getItemName(item, lang);
      var imgSrc = IMG_BASE + item.img + '.webp';
      var rarityClass = item.rarity ? 'rarity-' + item.rarity.toLowerCase() : '';

      html += '<tr class="' + rarityClass + '">';
      html += '<td class="td-img"><img src="' + imgSrc + '" alt="' + name + '" loading="lazy" onerror="if(!this.dataset.retry){this.dataset.retry=1;this.src=this.src.replace(\'.webp\',\'.png\')}else{this.style.display=\'none\'}"></td>';
      html += '<td class="td-name"><strong>' + name + '</strong></td>';
      html += '<td>' + (item.value ? item.value + ' 🪙' : '—') + '</td>';
      html += '<td>' + (item.weight ? item.weight.toFixed(1) + 'kg' : '—') + '</td>';
      html += '<td>' + (item.ingredient ? '✅' : '❌') + '</td>';
      html += '</tr>';
    });

    html += '</tbody></table></div>';
    return html;
  }

  var tableRegistry = {};

  function renderTable(containerId, items, options) {
    var container = document.getElementById(containerId);
    if (!container || !items || !items.length) return;
    var lang = getLang();
    var state = tableRegistry[containerId]
      ? tableRegistry[containerId].state
      : { col: options.defaultSort || 'value', dir: options.defaultDir || 'desc' };
    container.innerHTML = buildTableHTML(items, state, lang);
    tableRegistry[containerId] = { items: items, options: options, state: state };
  }

  document.addEventListener('click', function (e) {
    var th = e.target.closest('th.sortable[data-sort]');
    if (!th) return;
    var container = th.closest('[id^="wiki-table-"]');
    if (!container) return;
    var id = container.id;
    var reg = tableRegistry[id];
    if (!reg) return;
    var col = th.getAttribute('data-sort');
    if (reg.state.col === col) {
      reg.state.dir = reg.state.dir === 'asc' ? 'desc' : 'asc';
    } else {
      reg.state.col = col;
      reg.state.dir = col === 'name' ? 'asc' : 'desc';
    }
    var lang = getLang();
    container.innerHTML = buildTableHTML(reg.items, reg.state, lang);
  });

  window.WikiOther = {
    render: function (jsonPath) {
      var xhr = new XMLHttpRequest();
      xhr.open('GET', jsonPath, true);
      xhr.onload = function () {
        if (xhr.status !== 200) return;
        var data = JSON.parse(xhr.responseText);
        renderTable('wiki-table-valuables', data.valuables, { defaultSort: 'value', defaultDir: 'desc' });
        renderTable('wiki-table-misc', data.misc, { defaultSort: 'name', defaultDir: 'asc' });
      };
      xhr.send();
    }
  };
})();
