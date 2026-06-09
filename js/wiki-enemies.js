/**
 * wiki-enemies.js
 * Renderiza tabelas de criaturas/enemies por categoria.
 */
(function () {
  var IMG_BASE = '../../img/apps/endlesstales2/assets/enemies/';

  var ELEM_LABELS = {
    FIRE: { pt: 'Fogo', en: 'Fire', icon: '🔥' },
    WATER: { pt: 'Água', en: 'Water', icon: '💧' },
    EARTH: { pt: 'Terra', en: 'Earth', icon: '🌱' },
    WIND: { pt: 'Vento', en: 'Wind', icon: '🌀' },
    DARK: { pt: 'Sombrio', en: 'Dark', icon: '🌑' },
    LIGHT: { pt: 'Luz', en: 'Light', icon: '💫' },
    PHYSICAL: { pt: 'Físico', en: 'Physical', icon: '⚔️' }
  };

  function getLang() {
    return (window.CURRENT_LANGUAGE || 'pt-br') === 'pt-br' ? 'pt' : 'en';
  }

  function getName(obj, lang) {
    return lang === 'pt' ? (obj.name_pt || obj.name_en) : obj.name_en;
  }

  function elemBadge(elem, value, type) {
    var el = ELEM_LABELS[elem];
    var icon = el ? el.icon : elem;
    var name = el ? el[getLang()] : elem;
    var cls = type === 'res' ? 'res-badge res' : 'res-badge weak';
    return '<span class="' + cls + '">' + icon + ' ' + name + ' ' + value + '%</span>';
  }

  function sortEnemies(items, col, dir, lang) {
    var sorted = items.slice();
    sorted.sort(function (a, b) {
      var va, vb;
      switch (col) {
        case 'name': va = getName(a, lang).toLowerCase(); vb = getName(b, lang).toLowerCase(); return dir === 'asc' ? va.localeCompare(vb) : vb.localeCompare(va);
        case 'hp': va = a.hp; vb = b.hp; break;
        case 'mp': va = a.mp; vb = b.mp; break;
        case 'exp': va = a.exp; vb = b.exp; break;
        case 'gold': va = a.gold; vb = b.gold; break;
        case 'strength': va = a.strength; vb = b.strength; break;
        case 'agility': va = a.agility; vb = b.agility; break;
        case 'defense': va = a.defense; vb = b.defense; break;
        default: return 0;
      }
      if (col !== 'name') return dir === 'asc' ? va - vb : vb - va;
      return 0;
    });
    return sorted;
  }

  function buildTableHTML(items, state, lang) {
    var sorted = sortEnemies(items, state.col, state.dir, lang);

    function si(col) {
      if (state.col !== col) return ' <i class="fa-solid fa-sort sort-icon"></i>';
      return state.dir === 'asc' ? ' <i class="fa-solid fa-sort-up sort-icon active"></i>' : ' <i class="fa-solid fa-sort-down sort-icon active"></i>';
    }

    var html = '<div class="wiki-table-wrap wiki-table-sticky"><table class="wiki-table wiki-table-enemies">';
    html += '<thead><tr>';
    html += '<th></th>';
    html += '<th class="sortable" data-sort="name">' + (lang === 'pt' ? 'Nome' : 'Name') + si('name') + '</th>';
    html += '<th class="sortable" data-sort="hp">❤️ HP' + si('hp') + '</th>';
    html += '<th class="sortable" data-sort="mp">💙 MP' + si('mp') + '</th>';
    html += '<th class="sortable" data-sort="defense">🛡️ Def' + si('defense') + '</th>';
    html += '<th class="sortable" data-sort="strength">💪 ' + (lang === 'pt' ? 'Força' : 'Str') + si('strength') + '</th>';
    html += '<th class="sortable" data-sort="agility">⚡ Agi' + si('agility') + '</th>';
    html += '<th>' + (lang === 'pt' ? 'Resistências' : 'Resistance') + '</th>';
    html += '<th>' + (lang === 'pt' ? 'Fraquezas' : 'Weakness') + '</th>';
    html += '<th>' + (lang === 'pt' ? 'Habilidades' : 'Skills') + '</th>';
    html += '<th class="sortable" data-sort="gold">🪙 Gold' + si('gold') + '</th>';
    html += '<th class="sortable" data-sort="exp">⭐ Exp' + si('exp') + '</th>';
    html += '<th>' + (lang === 'pt' ? 'Loot' : 'Loot') + '</th>';
    html += '</tr></thead><tbody>';

    sorted.forEach(function (e) {
      var eName = getName(e, lang);
      var imgSrc = IMG_BASE + e.img + '.webp';

      html += '<tr>';
      html += '<td class="td-img enemy-img"><img src="' + imgSrc + '" alt="' + eName + '" loading="lazy" onerror="if(!this.dataset.retry){this.dataset.retry=1;this.src=this.src.replace(\'.webp\',\'.png\')}else{this.style.display=\'none\'}"></td>';
      html += '<td class="td-name"><strong>' + eName + '</strong></td>';
      html += '<td>' + e.hp + '</td>';
      html += '<td>' + e.mp + '</td>';
      html += '<td>' + e.defense + '</td>';
      html += '<td>' + e.strength + '</td>';
      html += '<td>' + e.agility + '</td>';

      // Resistances
      html += '<td>';
      if (e.resistances.length) {
        e.resistances.forEach(function (r) { html += elemBadge(r.element, r.value, 'res'); });
      } else { html += '—'; }
      html += '</td>';

      // Weaknesses
      html += '<td>';
      if (e.weaknesses.length) {
        e.weaknesses.forEach(function (w) { html += elemBadge(w.element, w.value, 'weak'); });
      } else { html += '—'; }
      html += '</td>';

      // Skills
      html += '<td class="td-skills">';
      if (e.skills.length) {
        html += e.skills.map(function (s) { return '<span class="skill-tag">' + getName(s, lang) + '</span>'; }).join(' ');
      } else { html += '—'; }
      html += '</td>';

      html += '<td>' + e.gold + '</td>';
      html += '<td>' + e.exp + '</td>';

      // Loot (simple text: "Item (chance%); Item (chance%)")
      html += '<td class="td-loot">';
      if (e.loot.length) {
        html += e.loot.map(function (l) {
          var qty = l.qty > 1 ? l.qty + 'x ' : '';
          return qty + getName(l, lang) + ' (' + l.chance + '%)';
        }).join('; ');
      } else { html += '—'; }
      html += '</td>';

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
    var countHTML = '<p class="wiki-table-count">' + items.length + (lang === 'pt' ? ' criaturas' : ' creatures') + '</p>';
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
    var countHTML = '<p class="wiki-table-count">' + reg.items.length + (lang === 'pt' ? ' criaturas' : ' creatures') + '</p>';
    container.innerHTML = countHTML + buildTableHTML(reg.items, reg.state, lang);
  });

  window.WikiEnemies = {
    render: function (jsonPath) {
      var xhr = new XMLHttpRequest();
      xhr.open('GET', jsonPath, true);
      xhr.onload = function () {
        if (xhr.status !== 200) return;
        var data = JSON.parse(xhr.responseText);
        var categories = ['common', 'orcs', 'humanoids', 'dark', 'earth', 'fire', 'waterIce', 'air', 'light', 'golems', 'bosses'];
        var total = 0;
        categories.forEach(function (cat) {
          if (data[cat] && data[cat].length) {
            total += data[cat].length;
            renderTable('wiki-table-' + cat, data[cat], { defaultSort: 'name', defaultDir: 'asc' });
          }
        });
        var lang = getLang();
        var el = document.getElementById('wiki-total-count');
        if (el) el.textContent = total + (lang === 'pt' ? ' criaturas no total' : ' creatures total');
      };
      xhr.send();
    }
  };
})();
