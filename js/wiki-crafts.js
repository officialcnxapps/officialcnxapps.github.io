/**
 * wiki-crafts.js
 * Renderiza tabelas de receitas de crafting.
 */
(function () {
  var IMG_BASE = '../../img/apps/endlesstales2/assets/items/';

  function getLang() {
    return (window.CURRENT_LANGUAGE || 'pt-br') === 'pt-br' ? 'pt' : 'en';
  }

  function getName(item, lang) {
    return lang === 'pt' ? item.name_pt : item.name_en;
  }

  var sortStates = {};

  function sortItems(items, col, direction, lang) {
    var sorted = items.slice();
    sorted.sort(function (a, b) {
      var va, vb;
      switch (col) {
        case 'name':
          va = getName(a.result, lang).toLowerCase();
          vb = getName(b.result, lang).toLowerCase();
          return direction === 'asc' ? va.localeCompare(vb) : vb.localeCompare(va);
        case 'success':
          va = a.successRate || 0; vb = b.successRate || 0;
          return direction === 'asc' ? va - vb : vb - va;
        case 'time':
          va = a.time || 0; vb = b.time || 0;
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
    html += '<th class="sortable" data-sort="name">' + (lang === 'pt' ? 'Resultado' : 'Result') + sortIcon('name') + '</th>';
    html += '<th>' + (lang === 'pt' ? 'Ingrediente 1' : 'Ingredient 1') + '</th>';
    html += '<th>' + (lang === 'pt' ? 'Ingrediente 2' : 'Ingredient 2') + '</th>';
    html += '<th>' + (lang === 'pt' ? 'Ingrediente 3' : 'Ingredient 3') + '</th>';
    html += '<th class="sortable" data-sort="success">' + (lang === 'pt' ? '% Sucesso' : '% Success') + sortIcon('success') + '</th>';
    html += '<th class="sortable" data-sort="time">' + (lang === 'pt' ? 'Tempo' : 'Time') + sortIcon('time') + '</th>';
    html += '</tr></thead><tbody>';

    sortedItems.forEach(function (craft) {
      var resultName = getName(craft.result, lang);
      var imgSrc = IMG_BASE + craft.result.img + '.webp';

      html += '<tr>';
      html += '<td class="td-img"><img src="' + imgSrc + '" alt="' + resultName + '" loading="lazy" onerror="if(!this.dataset.retry){this.dataset.retry=1;this.src=this.src.replace(\'.webp\',\'.png\')}else{this.style.display=\'none\'}"></td>';
      html += '<td class="td-name"><strong>' + resultName + '</strong></td>';

      for (var i = 0; i < 3; i++) {
        if (craft.ingredients[i]) {
          var ingName = getName(craft.ingredients[i], lang);
          html += '<td>' + ingName + '</td>';
        } else {
          html += '<td>—</td>';
        }
      }

      html += '<td>' + craft.successRate + '%</td>';
      html += '<td>' + craft.time + 'min</td>';
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
      : { col: options.defaultSort || 'name', dir: options.defaultDir || 'asc' };
    var countHTML = '<p class="wiki-table-count">' + items.length + (lang === 'pt' ? ' receitas' : ' recipes') + '</p>';
    container.innerHTML = countHTML + buildTableHTML(items, state, lang);
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
    var countHTML = '<p class="wiki-table-count">' + reg.items.length + (lang === 'pt' ? ' receitas' : ' recipes') + '</p>';
    container.innerHTML = countHTML + buildTableHTML(reg.items, reg.state, lang);
  });

  window.WikiCrafts = {
    render: function (jsonPath) {
      var xhr = new XMLHttpRequest();
      xhr.open('GET', jsonPath, true);
      xhr.onload = function () {
        if (xhr.status !== 200) return;
        var data = JSON.parse(xhr.responseText);
        renderTable('wiki-table-cooking', data.cooking, { defaultSort: 'name', defaultDir: 'asc' });
        renderTable('wiki-table-general', data.general, { defaultSort: 'name', defaultDir: 'asc' });
        renderTable('wiki-table-alchemy', data.alchemy, { defaultSort: 'name', defaultDir: 'asc' });
        var total = (data.cooking ? data.cooking.length : 0) + (data.general ? data.general.length : 0) + (data.alchemy ? data.alchemy.length : 0);
        var lang = getLang();
        var el = document.getElementById('wiki-total-count');
        if (el) el.textContent = total + (lang === 'pt' ? ' receitas no total' : ' recipes total');
      };
      xhr.send();
    }
  };
})();
