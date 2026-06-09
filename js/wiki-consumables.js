/**
 * wiki-consumables.js
 * Renderiza tabelas de consumíveis (comidas e poções) com ordenação.
 */
(function () {
  var IMG_BASE = '../../img/apps/endlesstales2/assets/items/';

  var ATTR_LABELS = {
    HP: { pt: 'PV', en: 'HP', icon: '❤️' },
    MP: { pt: 'PM', en: 'MP', icon: '💙' }
  };

  function getLang() {
    return (window.CURRENT_LANGUAGE || 'pt-br') === 'pt-br' ? 'pt' : 'en';
  }

  function formatEffects(effects, lang) {
    if (!effects || !effects.length) return '—';
    return effects.map(function (e) {
      var label = ATTR_LABELS[e.attr];
      var name = label ? label[lang] : e.attr;
      var icon = label ? label.icon : '';
      var sign = e.decrease ? '-' : '+';
      var val = e.min === e.max ? e.min : e.min + '–' + e.max;
      return icon + sign + val + ' ' + name;
    }).join('<br>');
  }

  function getEffectMax(item, attr) {
    if (!item.effects) return 0;
    var eff = item.effects.find(function (e) { return e.attr === attr; });
    return eff ? eff.max : 0;
  }

  function formatSingleEffect(item, attr) {
    if (!item.effects) return '—';
    var eff = item.effects.find(function (e) { return e.attr === attr; });
    if (!eff) return '—';
    var sign = eff.decrease ? '-' : '+';
    var val = eff.min === eff.max ? eff.min : eff.min + '–' + eff.max;
    return sign + val;
  }

  function formatSatiety(minutes) {
    if (!minutes) return '—';
    if (minutes >= 60) {
      var h = Math.floor(minutes / 60);
      var m = minutes % 60;
      return m > 0 ? h + 'h ' + m + 'min' : h + 'h';
    }
    return minutes + 'min';
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
        case 'satiety':
          va = a.satiety || 0; vb = b.satiety || 0;
          return direction === 'asc' ? va - vb : vb - va;
        case 'weight':
          va = a.weight || 0; vb = b.weight || 0;
          return direction === 'asc' ? va - vb : vb - va;
        case 'hp':
          va = getEffectMax(a, 'HP'); vb = getEffectMax(b, 'HP');
          return direction === 'asc' ? va - vb : vb - va;
        case 'mp':
          va = getEffectMax(a, 'MP'); vb = getEffectMax(b, 'MP');
          return direction === 'asc' ? va - vb : vb - va;
        default: return 0;
      }
    });
    return sorted;
  }

  function buildFoodHTML(items, state, lang) {
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
    html += '<th class="sortable" data-sort="hp">❤️ HP' + sortIcon('hp') + '</th>';
    html += '<th class="sortable" data-sort="mp">💙 MP' + sortIcon('mp') + '</th>';
    html += '<th class="sortable" data-sort="satiety">' + (lang === 'pt' ? 'Saciedade' : 'Satiety') + sortIcon('satiety') + '</th>';
    html += '<th class="sortable" data-sort="weight">' + (lang === 'pt' ? 'Peso' : 'Weight') + sortIcon('weight') + '</th>';
    html += '</tr></thead><tbody>';

    sortedItems.forEach(function (item) {
      var name = getItemName(item, lang);
      var imgSrc = IMG_BASE + item.img + '.webp';
      html += '<tr>';
      html += '<td class="td-img"><img src="' + imgSrc + '" alt="' + name + '" loading="lazy" onerror="if(!this.dataset.retry){this.dataset.retry=1;this.src=this.src.replace(\'.webp\',\'.png\')}else{this.style.display=\'none\'}"></td>';
      html += '<td class="td-name"><strong>' + name + '</strong></td>';
      html += '<td>' + formatSingleEffect(item, 'HP') + '</td>';
      html += '<td>' + formatSingleEffect(item, 'MP') + '</td>';
      html += '<td>' + formatSatiety(item.satiety) + '</td>';
      html += '<td>' + (item.weight ? item.weight.toFixed(1) + 'kg' : '—') + '</td>';
      html += '</tr>';
    });

    html += '</tbody></table></div>';
    return html;
  }

  function buildPotionHTML(items, state, lang) {
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
    html += '<th class="sortable" data-sort="hp">❤️ HP' + sortIcon('hp') + '</th>';
    html += '<th class="sortable" data-sort="mp">💙 MP' + sortIcon('mp') + '</th>';
    html += '<th>' + (lang === 'pt' ? 'Descrição' : 'Description') + '</th>';
    html += '<th class="sortable" data-sort="weight">' + (lang === 'pt' ? 'Peso' : 'Weight') + sortIcon('weight') + '</th>';
    html += '</tr></thead><tbody>';

    sortedItems.forEach(function (item) {
      var name = getItemName(item, lang);
      var imgSrc = IMG_BASE + item.img + '.webp';
      var desc = lang === 'pt' ? (item.desc_pt || item.desc_en) : item.desc_en;
      html += '<tr>';
      html += '<td class="td-img"><img src="' + imgSrc + '" alt="' + name + '" loading="lazy" onerror="if(!this.dataset.retry){this.dataset.retry=1;this.src=this.src.replace(\'.webp\',\'.png\')}else{this.style.display=\'none\'}"></td>';
      html += '<td class="td-name"><strong>' + name + '</strong></td>';
      html += '<td>' + formatSingleEffect(item, 'HP') + '</td>';
      html += '<td>' + formatSingleEffect(item, 'MP') + '</td>';
      html += '<td style="font-size:0.8rem;color:var(--text-secondary);max-width:220px;">' + desc + '</td>';
      html += '<td>' + (item.weight ? item.weight.toFixed(1) + 'kg' : '—') + '</td>';
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
    var builder = options.tableType === 'potion' ? buildPotionHTML : buildFoodHTML;
    var label = options.tableType === 'potion' ? (lang === 'pt' ? ' poções' : ' potions') : (lang === 'pt' ? ' comidas' : ' foods');
    container.innerHTML = '<p class="wiki-table-count">' + items.length + label + '</p>' + builder(items, state, lang);
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
    var builder = reg.options.tableType === 'potion' ? buildPotionHTML : buildFoodHTML;
    var label = reg.options.tableType === 'potion' ? (lang === 'pt' ? ' poções' : ' potions') : (lang === 'pt' ? ' comidas' : ' foods');
    container.innerHTML = '<p class="wiki-table-count">' + reg.items.length + label + '</p>' + builder(reg.items, reg.state, lang);
  });

  window.WikiConsumables = {
    render: function (jsonPath) {
      var xhr = new XMLHttpRequest();
      xhr.open('GET', jsonPath, true);
      xhr.onload = function () {
        if (xhr.status !== 200) return;
        var data = JSON.parse(xhr.responseText);
        renderTable('wiki-table-foods', data.foods, { tableType: 'food', defaultSort: 'satiety', defaultDir: 'asc' });
        renderTable('wiki-table-potions', data.potions, { tableType: 'potion', defaultSort: 'name', defaultDir: 'asc' });
        var total = (data.foods||[]).length + (data.potions||[]).length;
        window._wikiItemTotal = (window._wikiItemTotal || 0) + total;
        var lang = getLang();
        var el = document.getElementById('wiki-total-count');
        if (el) el.textContent = window._wikiItemTotal + (lang === 'pt' ? ' itens no total' : ' items total');
      };
      xhr.send();
    }
  };
})();
