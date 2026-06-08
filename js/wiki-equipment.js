/**
 * wiki-equipment.js
 * Renderiza tabelas de equipamentos com ordenação clicável, classes e tradução.
 */
(function () {
  var IMG_BASE = '../../img/apps/endlesstales2/assets/items/';

  var ATTR_LABELS = {
    STRENGTH: { pt: 'Força', en: 'Strength', icon: '💪' },
    AGILITY: { pt: 'Agilidade', en: 'Agility', icon: '⚡' },
    MAGIC: { pt: 'Magia', en: 'Magic', icon: '✨' },
    CHARISMA: { pt: 'Carisma', en: 'Charisma', icon: '👑' },
    LUCK: { pt: 'Sorte', en: 'Luck', icon: '🍀' },
    HP_MODIFIER: { pt: 'HP', en: 'HP', icon: '❤️' },
    MP_MODIFIER: { pt: 'MP', en: 'MP', icon: '💙' },
    ALIGNMENT: { pt: 'Alinhamento', en: 'Alignment', icon: '⚖️' },
    CRAFT: { pt: 'Artesanato', en: 'Craft', icon: '🔨' },
    ALCHEMY: { pt: 'Alquimia', en: 'Alchemy', icon: '⚗️' },
    CRITICAL_CHANCE: { pt: 'Chance Crítica %', en: 'Critical Chance %', icon: '🎯' }
  };

  var ELEM_LABELS = {
    FIRE: { pt: 'Fogo', en: 'Fire', icon: '🔥' },
    WATER: { pt: 'Água', en: 'Water', icon: '💧' },
    EARTH: { pt: 'Terra', en: 'Earth', icon: '🌱' },
    WIND: { pt: 'Vento', en: 'Wind', icon: '🌀' },
    DARK: { pt: 'Sombrio', en: 'Dark', icon: '🌑' },
    LIGHT: { pt: 'Luz', en: 'Light', icon: '💫' }
  };

  var CLASS_LABELS = {
    WARRIOR: { pt: 'Guerreiro', en: 'Warrior' },
    THIEF: { pt: 'Ladrão', en: 'Thief' },
    ARCHER: { pt: 'Arqueiro', en: 'Archer' },
    DRUID: { pt: 'Druida', en: 'Druid' },
    SORCERER: { pt: 'Feiticeiro', en: 'Sorcerer' }
  };

  function getLang() {
    return (window.CURRENT_LANGUAGE || 'pt-br') === 'pt-br' ? 'pt' : 'en';
  }

  function formatModifiers(mods, lang) {
    if (!mods || !mods.length) return '—';
    return mods.map(function (m) {
      var label = ATTR_LABELS[m.attr];
      var name = label ? label[lang] : m.attr;
      var icon = label ? label.icon : '';
      var sign = m.decrease ? '-' : '+';
      return icon + sign + m.value + ' ' + name;
    }).join('<br>');
  }

  function formatResWeak(resistances, weaknesses, lang) {
    var parts = [];
    if (resistances && resistances.length) {
      resistances.forEach(function (r) {
        var el = ELEM_LABELS[r.element];
        var name = el ? el[lang] : r.element;
        parts.push('<span class="res-badge res">' + (el ? el.icon : '') + '+' + r.value + '% ' + name + '</span>');
      });
    }
    if (weaknesses && weaknesses.length) {
      weaknesses.forEach(function (w) {
        var el = ELEM_LABELS[w.element];
        var name = el ? el[lang] : w.element;
        parts.push('<span class="res-badge weak">' + (el ? el.icon : '') + '-' + w.value + '% ' + name + '</span>');
      });
    }
    return parts.length ? parts.join(' ') : '—';
  }

  function formatClasses(classes, lang) {
    if (!classes || !classes.length) return '<span class="class-badge all">' + (lang === 'pt' ? 'Todas' : 'All') + '</span>';
    return classes.map(function (c) {
      var label = CLASS_LABELS[c];
      return '<span class="class-badge">' + (label ? label[lang] : c) + '</span>';
    }).join(' ');
  }

  function getItemName(item, lang) {
    return lang === 'pt' ? item.name_pt : item.name_en;
  }

  function sortItems(items, col, direction, lang) {
    var sorted = items.slice();
    sorted.sort(function (a, b) {
      var va, vb;
      switch (col) {
        case 'name':
          va = getItemName(a, lang).toLowerCase();
          vb = getItemName(b, lang).toLowerCase();
          return direction === 'asc' ? va.localeCompare(vb) : vb.localeCompare(va);
        case 'damage':
          va = a.maxDamage || 0;
          vb = b.maxDamage || 0;
          return direction === 'asc' ? va - vb : vb - va;
        case 'critical':
          va = a.critical || 0;
          vb = b.critical || 0;
          return direction === 'asc' ? va - vb : vb - va;
        case 'defense':
          va = a.defense || 0;
          vb = b.defense || 0;
          return direction === 'asc' ? va - vb : vb - va;
        case 'weight':
          va = a.weight || 0;
          vb = b.weight || 0;
          return direction === 'asc' ? va - vb : vb - va;
        case 'level':
          va = a.levelReq || 0;
          vb = b.levelReq || 0;
          return direction === 'asc' ? va - vb : vb - va;
        default:
          return 0;
      }
    });
    return sorted;
  }

  // Registry of tables for event delegation
  var tableRegistry = {};

  function buildTableHTML(items, options, state, lang) {
    var showDamage = options.showDamage;
    var showDefense = options.showDefense;
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
    if (showDamage) html += '<th class="sortable" data-sort="damage">' + (lang === 'pt' ? 'Dano' : 'Damage') + sortIcon('damage') + '</th>';
    if (showDamage) html += '<th class="sortable" data-sort="critical">' + (lang === 'pt' ? 'Crítico' : 'Critical') + sortIcon('critical') + '</th>';
    if (showDefense) html += '<th class="sortable" data-sort="defense">' + (lang === 'pt' ? 'Defesa' : 'Defense') + sortIcon('defense') + '</th>';
    html += '<th>Classes</th>';
    html += '<th>' + (lang === 'pt' ? 'Res. / Fraq.' : 'Res. / Weak.') + '</th>';
    html += '<th>' + (lang === 'pt' ? 'Atributos' : 'Attributes') + '</th>';
    html += '<th class="sortable" data-sort="weight">' + (lang === 'pt' ? 'Peso' : 'Weight') + sortIcon('weight') + '</th>';
    html += '<th class="sortable" data-sort="level">' + (lang === 'pt' ? 'Nível' : 'Level') + sortIcon('level') + '</th>';
    html += '</tr></thead><tbody>';

    sortedItems.forEach(function (item) {
      var name = getItemName(item, lang);
      var imgSrc = IMG_BASE + item.img + '.webp';
      var rarityClass = item.rarity ? 'rarity-' + item.rarity.toLowerCase() : '';

      html += '<tr class="' + rarityClass + '">';
      html += '<td class="td-img"><img src="' + imgSrc + '" alt="' + name + '" loading="lazy" onerror="if(!this.dataset.retry){this.dataset.retry=1;this.src=this.src.replace(\'.webp\',\'.png\')}else{this.style.display=\'none\'}"></td>';
      html += '<td class="td-name"><strong>' + name + '</strong></td>';
      if (showDamage) html += '<td>' + (item.minDamage || item.maxDamage ? item.minDamage + '–' + item.maxDamage : '—') + '</td>';
      if (showDamage) html += '<td>' + (item.critical ? '+' + item.critical + '%' : '—') + '</td>';
      if (showDefense) html += '<td>' + (item.defense ? '+' + item.defense : '—') + '</td>';
      html += '<td>' + formatClasses(item.classes, lang) + '</td>';
      html += '<td>' + formatResWeak(item.resistances, item.weaknesses, lang) + '</td>';
      html += '<td>' + formatModifiers(item.modifiers, lang) + '</td>';
      html += '<td>' + (item.weight ? item.weight.toFixed(1) + 'kg' : '—') + '</td>';
      html += '<td>' + (item.levelReq ? item.levelReq : '—') + '</td>';
      html += '</tr>';
    });

    html += '</tbody></table></div>';
    return html;
  }

  function renderTable(containerId, items, options) {
    var container = document.getElementById(containerId);
    if (!container || !items || !items.length) return;

    var lang = getLang();
    var state = tableRegistry[containerId]
      ? tableRegistry[containerId].state
      : { col: options.defaultSort || 'name', dir: options.defaultDir || 'desc' };

    container.innerHTML = buildTableHTML(items, options, state, lang);

    // Store in registry for event delegation
    tableRegistry[containerId] = { items: items, options: options, state: state };
  }

  // Single global click handler using event delegation
  document.addEventListener('click', function (e) {
    var th = e.target.closest('th.sortable[data-sort]');
    if (!th) return;

    // Find which container this th belongs to
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
    container.innerHTML = buildTableHTML(reg.items, reg.options, reg.state, lang);
  });

  // Public API
  window.WikiEquipment = {
    render: function (jsonPath) {
      var xhr = new XMLHttpRequest();
      xhr.open('GET', jsonPath, true);
      xhr.onload = function () {
        if (xhr.status !== 200) return;
        var data = JSON.parse(xhr.responseText);

        renderTable('wiki-table-weapons', data.weapons, { showDamage: true, defaultSort: 'damage', defaultDir: 'asc' });
        renderTable('wiki-table-shields', data.shields, { showDefense: true, defaultSort: 'defense', defaultDir: 'asc' });
        renderTable('wiki-table-armors', data.armors, { showDefense: true, defaultSort: 'defense', defaultDir: 'asc' });
        renderTable('wiki-table-helmets', data.helmets, { showDefense: true, defaultSort: 'defense', defaultDir: 'asc' });
        renderTable('wiki-table-boots', data.boots, { showDefense: true, defaultSort: 'defense', defaultDir: 'asc' });
        renderTable('wiki-table-legs', data.legs, { showDefense: true, defaultSort: 'defense', defaultDir: 'asc' });
        renderTable('wiki-table-jewels', data.jewels, { defaultSort: 'name', defaultDir: 'asc' });
      };
      xhr.send();
    }
  };
})();
