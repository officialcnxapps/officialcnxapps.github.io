/**
 * parse-enemies.js
 * Parseia arquivos de enemies e cruza com skills/items para resolver nomes.
 * Uso: node tools/parse-enemies.js
 */
const fs = require('fs');
const path = require('path');

const ENEMIES_DIR = path.join(__dirname, '..', 'pages', 'wiki_et2', 'content', 'enemies');
const SKILLS_DIR = path.join(__dirname, '..', 'pages', 'wiki_et2', 'content', 'skills');
const OUTPUT_FILE = path.join(__dirname, '..', 'js', 'wiki_data_enemies.json');

// Load item data for loot name resolution
const equipData = JSON.parse(fs.readFileSync(path.join(__dirname, '..', 'js', 'wiki_data_equipment.json'), 'utf-8'));
const consumData = JSON.parse(fs.readFileSync(path.join(__dirname, '..', 'js', 'wiki_data_consumables.json'), 'utf-8'));
const otherData = JSON.parse(fs.readFileSync(path.join(__dirname, '..', 'js', 'wiki_data_other.json'), 'utf-8'));

const allItems = [
  ...equipData.weapons, ...equipData.shields, ...equipData.armors,
  ...equipData.helmets, ...equipData.boots, ...equipData.legs, ...equipData.jewels,
  ...consumData.foods, ...consumData.potions,
  ...otherData.valuables, ...otherData.ores, ...otherData.tools, ...otherData.misc
];

function nameToKey(name) {
  return name.toLowerCase().replace(/['']/g, '').replace(/\s+/g, '_');
}

const itemLookup = {};
allItems.forEach(item => { itemLookup[nameToKey(item.name_en)] = item; });

function resolveItemEnum(enumName) {
  const key = enumName.toLowerCase();
  const item = itemLookup[key];
  if (item) return { name_en: item.name_en, name_pt: item.name_pt };
  // Fallback Title Case
  const humanized = enumName.toLowerCase().replace(/_/g, ' ').replace(/\b\w/g, c => c.toUpperCase());
  return { name_en: humanized, name_pt: humanized };
}

// Parse skills to build name lookup: SKILL_ENUM -> { name_en, name_pt }
function buildSkillLookup() {
  const lookup = {};
  const files = ['AttackSkills.java', 'HealingSkills.java', 'SupportSkills.java'];
  for (const file of files) {
    const filePath = path.join(SKILLS_DIR, file);
    if (!fs.existsSync(filePath)) continue;
    const content = fs.readFileSync(filePath, 'utf-8');
    // Match: new Skill("Name", ...)
    const blocks = content.split(/\n\s{4}Skill\s+\w+\(\)\s*\{/);
    for (let i = 1; i < blocks.length; i++) {
      const block = blocks[i].split(/\n\s{4}\}/)[0];
      const nameMatch = block.match(/new Skill\("([^"]+)"/);
      if (!nameMatch) continue;
      const name_en = nameMatch[1];
      const ptMatch = block.match(/addNameTranslation\(.*?PORTUGUESE,\s*"([^"]+)"\)/);
      const name_pt = ptMatch ? ptMatch[1] : name_en;
      // Derive enum from DataManager.add line or from method context
      // Actually easier: match the SkillsIds enum by converting name
      const enumKey = name_en.toUpperCase().replace(/['']/g, '').replace(/\s+/g, '_');
      lookup[enumKey] = { name_en, name_pt };
    }
  }
  return lookup;
}

const skillLookup = buildSkillLookup();

function resolveSkillEnum(enumName) {
  const skill = skillLookup[enumName];
  if (skill) return skill;
  const humanized = enumName.toLowerCase().replace(/_/g, ' ').replace(/\b\w/g, c => c.toUpperCase());
  return { name_en: humanized, name_pt: humanized };
}

// Parse a single enemy Java file
function parseEnemyFile(filePath) {
  const content = fs.readFileSync(filePath, 'utf-8');

  const enemy = {};

  // Name EN
  const nameMatch = content.match(/new Enemy\("([^"]+)"\)/);
  if (!nameMatch) return null;
  enemy.name_en = nameMatch[1];

  // Name PT
  const ptMatch = content.match(/addNameTranslation\(.*?PORTUGUESE,\s*"([^"]+)"\)/);
  enemy.name_pt = ptMatch ? ptMatch[1] : enemy.name_en;

  // Image
  const imgMatch = content.match(/imgFile\s*=\s*"([^"]+)"/);
  enemy.img = imgMatch ? imgMatch[1] : 'enemy_' + enemy.name_en.toLowerCase().replace(/['']/g, '').replace(/\s+/g, '_');

  // Stats
  const hp = content.match(/setVitalities\((\d+),\s*(\d+)\)/);
  enemy.hp = hp ? parseInt(hp[1]) : 0;
  enemy.mp = hp ? parseInt(hp[2]) : 0;

  const def = content.match(/setDefense\((\d+)\)/);
  enemy.defense = def ? parseInt(def[1]) : 0;

  const agi = content.match(/setAgility\((\d+)\)/);
  enemy.agility = agi ? parseInt(agi[1]) : 0;

  const str = content.match(/setStrength\((\d+)\)/);
  enemy.strength = str ? parseInt(str[1]) : 0;

  const exp = content.match(/givenExperience\s*=\s*(\d+)/);
  enemy.exp = exp ? parseInt(exp[1]) : 0;

  const gold = content.match(/givenGold\s*=\s*(\d+)/);
  enemy.gold = gold ? parseInt(gold[1]) : 0;

  const minDmg = content.match(/minDamage\s*=\s*(\d+)/);
  const maxDmg = content.match(/maxDamage\s*=\s*(\d+)/);
  enemy.minDamage = minDmg ? parseInt(minDmg[1]) : 0;
  enemy.maxDamage = maxDmg ? parseInt(maxDmg[1]) : 0;

  // Weaknesses
  enemy.weaknesses = [];
  const weakRegex = /weaknesses\.put\(Enums\.Elements\.(\w+),\s*(\d+)\)/g;
  let m;
  while ((m = weakRegex.exec(content)) !== null) {
    enemy.weaknesses.push({ element: m[1], value: parseInt(m[2]) });
  }

  // Resistances
  enemy.resistances = [];
  const resRegex = /resistances\.put\(Enums\.Elements\.(\w+),\s*(\d+)\)/g;
  while ((m = resRegex.exec(content)) !== null) {
    enemy.resistances.push({ element: m[1], value: parseInt(m[2]) });
  }

  // Skills
  enemy.skills = [];
  const skillRegex = /skills\.put\(SkillsIds\.(\w+),\s*(\d+)\)/g;
  while ((m = skillRegex.exec(content)) !== null) {
    const resolved = resolveSkillEnum(m[1]);
    enemy.skills.push({ ...resolved, chance: parseInt(m[2]) });
  }

  // Loot
  enemy.loot = [];
  const lootRegex = /new ItemReference\(ItemsIds\.(\w+),\s*(\d+),\s*(\d+)\)/g;
  while ((m = lootRegex.exec(content)) !== null) {
    const resolved = resolveItemEnum(m[1]);
    enemy.loot.push({ ...resolved, qty: parseInt(m[2]), chance: parseInt(m[3]) });
  }

  return enemy;
}

// Scan categories (subfolders)
const CATEGORIES = [
  { folder: 'common', key: 'common' },
  { folder: 'orcs', key: 'orcs' },
  { folder: 'humanoids', key: 'humanoids' },
  { folder: 'dark', key: 'dark' },
  { folder: 'earth', key: 'earth' },
  { folder: 'fire', key: 'fire' },
  { folder: 'waterIce', key: 'waterIce' },
  { folder: 'air', key: 'air' },
  { folder: 'light', key: 'light' },
  { folder: 'golems', key: 'golems' },
  { folder: 'bosses', key: 'bosses' }
];

const result = {};
let total = 0;

for (const cat of CATEGORIES) {
  const dir = path.join(ENEMIES_DIR, cat.folder);
  if (!fs.existsSync(dir)) { result[cat.key] = []; continue; }
  const files = fs.readdirSync(dir).filter(f => f.endsWith('.java'));
  const enemies = [];
  for (const file of files) {
    const enemy = parseEnemyFile(path.join(dir, file));
    if (enemy) enemies.push(enemy);
  }
  // Also check root-level files that belong to this category (MutantInsectSwarm.java)
  result[cat.key] = enemies;
  total += enemies.length;
}

// Parse root-level enemy files (e.g. MutantInsectSwarm.java)
const rootFiles = fs.readdirSync(ENEMIES_DIR).filter(f => f.endsWith('.java') && !['EnemiesDataManager.java', 'EnemiesIds.java'].includes(f));
for (const file of rootFiles) {
  const enemy = parseEnemyFile(path.join(ENEMIES_DIR, file));
  if (enemy) {
    result.bosses.push(enemy);
    total++;
  }
}

console.log(`Parsed ${total} enemies:`);
for (const cat of CATEGORIES) {
  console.log(`  ${cat.key}: ${result[cat.key].length}`);
}

fs.writeFileSync(OUTPUT_FILE, JSON.stringify(result, null, 2), 'utf-8');
console.log(`Output: ${OUTPUT_FILE}`);
