/**
 * parse-equipment.js
 * 
 * Parseia os arquivos .java de equipamentos e gera um JSON
 * que a wiki consome para renderizar tabelas automaticamente.
 * 
 * Uso: node tools/parse-equipment.js
 * Output: js/wiki_data_equipment.json
 */

const fs = require('fs');
const path = require('path');

const CONTENT_DIR = path.join(__dirname, '..', 'pages', 'wiki_et2', 'content', 'items');
const OUTPUT_FILE = path.join(__dirname, '..', 'js', 'wiki_data_equipment.json');

const FILES = [
  'EquippableWeaponsAndShields.java',
  'EquippableArmorsAndLegs.java',
  'EquippableHelmetsAndBoots.java',
  'EquippableJewelsAndBags.java'
];

const CONSUMABLE_FILES = [
  'Consumables.java',
  'Potions.java'
];

const OTHER_FILES = [
  'Other.java'
];

function parseJavaFile(filePath) {
  const content = fs.readFileSync(filePath, 'utf-8');
  const items = [];

  // Split into method blocks (each method returns an EquippableItem)
  const methodRegex = /(?:EquippableItem|Item)\s+\w+\(\)\s*\{([\s\S]*?)(?=\n\s{4}(?:EquippableItem|Item)\s+\w+\(\)|$)/g;
  let match;

  while ((match = methodRegex.exec(content)) !== null) {
    const block = match[1];
    const item = parseItemBlock(block);
    if (item) items.push(item);
  }

  // Fallback: split by method signatures more aggressively
  if (items.length === 0) {
    const blocks = content.split(/\n\s{4}(?:EquippableItem|Item)\s+\w+\(\)\s*\{/);
    for (let i = 1; i < blocks.length; i++) {
      const block = blocks[i].split(/\n\s{4}\}/)[0];
      const item = parseItemBlock(block);
      if (item) items.push(item);
    }
  }

  return items;
}

function parseItemBlock(block) {
  const item = {};

  // Name (English - constructor)
  const nameMatch = block.match(/new EquippableItem\("([^"]+)"\)/);
  if (!nameMatch) return null;
  item.name_en = nameMatch[1];

  // Name PT
  const ptMatch = block.match(/addNameTranslation\(.*?PORTUGUESE,\s*"([^"]+)"\)/);
  item.name_pt = ptMatch ? ptMatch[1] : item.name_en;

  // Image file
  const imgMatch = block.match(/imgFile\s*=\s*"([^"]+)"/);
  if (imgMatch) {
    item.img = imgMatch[1];
  } else {
    // Generate from EN name: "Iron Sword" -> "item_iron_sword"
    item.img = 'item_' + item.name_en.toLowerCase().replace(/['']/g, '').replace(/\s+/g, '_');
  }

  // Damage
  const minDmg = block.match(/minDamage\s*=\s*(\d+)/);
  const maxDmg = block.match(/maxDamage\s*=\s*(\d+)/);
  item.minDamage = minDmg ? parseInt(minDmg[1]) : 0;
  item.maxDamage = maxDmg ? parseInt(maxDmg[1]) : 0;

  // Critical
  const crit = block.match(/criticalChanceIncrease\s*=\s*(\d+)/);
  item.critical = crit ? parseInt(crit[1]) : 0;

  // Defense
  const def = block.match(/defense\s*=\s*(\d+)/);
  item.defense = def ? parseInt(def[1]) : 0;

  // Type
  const typeMatch = block.match(/type\s*=\s*Enums\.ItemType\.(\w+)/);
  item.type = typeMatch ? typeMatch[1] : 'UNKNOWN';

  // Slot
  const slotMatch = block.match(/slotPart\s*=\s*Enums\.SlotPart\.(\w+)/);
  item.slot = slotMatch ? slotMatch[1] : '';

  // Element
  const elemMatch = block.match(/element\s*=\s*Enums\.Elements\.(\w+)/);
  item.element = elemMatch ? elemMatch[1] : null;

  // Rarity
  const rarityMatch = block.match(/rarity\s*=\s*Enums\.Rarity\.(\w+)/);
  item.rarity = rarityMatch ? rarityMatch[1] : 'COMMON';

  // Resistances
  item.resistances = [];
  const resRegex = /resistancesModifiers\.put\(Enums\.Elements\.(\w+),\s*(\d+)\)/g;
  let resMatch;
  while ((resMatch = resRegex.exec(block)) !== null) {
    item.resistances.push({ element: resMatch[1], value: parseInt(resMatch[2]) });
  }

  // Weaknesses
  item.weaknesses = [];
  const weakRegex = /weaknessesModifiers\.put\(Enums\.Elements\.(\w+),\s*(\d+)\)/g;
  let weakMatch;
  while ((weakMatch = weakRegex.exec(block)) !== null) {
    item.weaknesses.push({ element: weakMatch[1], value: parseInt(weakMatch[2]) });
  }

  // Attribute modifiers
  item.modifiers = [];
  const modRegex = /new AttributeModifierValue\(Enums\.AttributeName\.(\w+),\s*(\d+)(?:,\s*Enums\.StatusModifier\.(\w+))?\)/g;
  let modMatch;
  while ((modMatch = modRegex.exec(block)) !== null) {
    item.modifiers.push({
      attr: modMatch[1],
      value: parseInt(modMatch[2]),
      decrease: modMatch[3] === 'DECREASE'
    });
  }

  // Description
  const descEn = block.match(/addDescriptionTranslation\(.*?ENGLISH,\s*"([^"]+)"\)/);
  const descPt = block.match(/addDescriptionTranslation\(.*?PORTUGUESE,\s*"([^"]+)"\)/);
  item.desc_en = descEn ? descEn[1] : '';
  item.desc_pt = descPt ? descPt[1] : '';

  // Classes
  item.classes = [];
  const classRegex = /classes\.add\(ClassesIds\.(\w+)\)/g;
  let classMatch;
  while ((classMatch = classRegex.exec(block)) !== null) {
    item.classes.push(classMatch[1]);
  }

  // Weight
  const weightMatch = block.match(/weight\s*=\s*([\d.]+)f?/);
  item.weight = weightMatch ? parseFloat(weightMatch[1]) : 0;

  // Level requirement
  const lvlMatch = block.match(/chara\.level\s*>=\s*(\d+)/);
  item.levelReq = lvlMatch ? parseInt(lvlMatch[1]) : 0;

  return item;
}

// Categorize items
function parseOtherFile(filePath) {
  const content = fs.readFileSync(filePath, 'utf-8');
  const items = [];
  // Split by method: Item methodName() { or ConsumableItem methodName() {
  const blocks = content.split(/\n\s{4}(?:Item|ConsumableItem)\s+\w+\(\)\s*\{/);
  for (let i = 1; i < blocks.length; i++) {
    const block = blocks[i].split(/\n\s{4}\}/)[0];
    const item = parseOtherBlock(block);
    if (item) items.push(item);
  }
  return items;
}

function parseOtherBlock(block) {
  const item = {};
  const nameMatch = block.match(/new (?:Item|ConsumableItem)\("([^"]+)"(?:,\s*Enums\.ItemType\.(\w+))?\)/);
  if (!nameMatch) return null;
  item.name_en = nameMatch[1];
  item.type = nameMatch[2] || 'MISC';
  // Override type if set later
  const typeOverride = block.match(/\.type\s*=\s*Enums\.ItemType\.(\w+)/);
  if (typeOverride) item.type = typeOverride[1];
  const ptMatch = block.match(/addNameTranslation\(.*?PORTUGUESE,\s*"([^"]+)"\)/);
  item.name_pt = ptMatch ? ptMatch[1] : item.name_en;
  const imgMatch = block.match(/imgFile\s*=\s*"([^"]+)"/);
  item.img = imgMatch ? imgMatch[1] : 'item_' + item.name_en.toLowerCase().replace(/['']/g, '').replace(/\s+/g, '_');
  const weightMatch = block.match(/weight\s*=\s*([\d.]+)f?/);
  item.weight = weightMatch ? parseFloat(weightMatch[1]) : 0;
  const valueMatch = block.match(/marketValue\s*=\s*(\d+)/);
  item.value = valueMatch ? parseInt(valueMatch[1]) : 0;
  // canBeIngredient defaults to true unless explicitly set to false
  const ingredientMatch = block.match(/canBeIngredient\s*=\s*(true|false)/);
  item.ingredient = ingredientMatch ? ingredientMatch[1] === 'true' : true;
  const rarityMatch = block.match(/rarity\s*=\s*Enums\.Rarity\.(\w+)/);
  item.rarity = rarityMatch ? rarityMatch[1] : 'COMMON';
  const descEn = block.match(/addDescriptionTranslation\(.*?ENGLISH,\s*"([^"]+)"\)/);
  const descPt = block.match(/addDescriptionTranslation\(.*?PORTUGUESE,\s*"([^"]+)"\)/);
  item.desc_en = descEn ? descEn[1] : '';
  item.desc_pt = descPt ? descPt[1] : '';
  return item;
}

function parseConsumableFile(filePath) {
  const content = fs.readFileSync(filePath, 'utf-8');
  const items = [];
  const blocks = content.split(/\n\s{4}ConsumableItem\s+\w+\(\)\s*\{/);
  for (let i = 1; i < blocks.length; i++) {
    const block = blocks[i].split(/\n\s{4}\}/)[0];
    const item = parseConsumableBlock(block);
    if (item) items.push(item);
  }
  return items;
}

function parseConsumableBlock(block) {
  const item = {};
  const nameMatch = block.match(/new ConsumableItem\("([^"]+)"\)/);
  if (!nameMatch) return null;
  item.name_en = nameMatch[1];
  const ptMatch = block.match(/addNameTranslation\(.*?PORTUGUESE,\s*"([^"]+)"\)/);
  item.name_pt = ptMatch ? ptMatch[1] : item.name_en;
  item.img = 'item_' + item.name_en.toLowerCase().replace(/['']/g, '').replace(/\s+/g, '_');
  const typeMatch = block.match(/type\s*=\s*Enums\.ItemType\.(\w+)/);
  item.type = typeMatch ? typeMatch[1] : 'FOOD';
  const hungryMatch = block.match(/hungryTimeRecover\s*=\s*(\d+)/);
  item.satiety = hungryMatch ? parseInt(hungryMatch[1]) : 0;
  const weightMatch = block.match(/weight\s*=\s*([\d.]+)f?/);
  item.weight = weightMatch ? parseFloat(weightMatch[1]) : 0;
  const valueMatch = block.match(/marketValue\s*=\s*(\d+)/);
  item.value = valueMatch ? parseInt(valueMatch[1]) : 0;
  const battleMatch = block.match(/inBattleUsage\s*=\s*(true|false)/);
  item.inBattle = battleMatch ? battleMatch[1] === 'true' : false;
  item.effects = [];
  const modRegex = /new AttributeModifierValue\(Enums\.AttributeName\.(\w+),\s*(\d+)(?:,\s*(\d+))?(?:,\s*\d+)?(?:,\s*Enums\.StatusModifier\.(\w+))?\)/g;
  let modMatch;
  while ((modMatch = modRegex.exec(block)) !== null) {
    item.effects.push({
      attr: modMatch[1],
      min: parseInt(modMatch[2]),
      max: modMatch[3] ? parseInt(modMatch[3]) : parseInt(modMatch[2]),
      decrease: modMatch[4] === 'DECREASE'
    });
  }
  const descEn = block.match(/addDescriptionTranslation\(.*?ENGLISH,\s*"([^"]+)"\)/);
  const descPt = block.match(/addDescriptionTranslation\(.*?PORTUGUESE,\s*"([^"]+)"\)/);
  item.desc_en = descEn ? descEn[1] : '';
  item.desc_pt = descPt ? descPt[1] : '';
  return item;
}

function categorize(items) {  const weapons = items.filter(i => ['WEAPON', 'MAGICAL_WEAPON'].includes(i.type));
  const shields = items.filter(i => i.type === 'SHIELD');
  const armors = items.filter(i => ['ARMOR', 'LIGHT_ARMOR', 'MAGICAL_ARMOR'].includes(i.type));
  const helmets = items.filter(i => ['HELMET', 'HAT'].includes(i.type));
  const boots = items.filter(i => ['BOOTS'].includes(i.type));
  const legs = items.filter(i => ['LEGS', 'LEGS_ARMOR'].includes(i.type));
  const jewels = items.filter(i => ['JEWEL', 'BAG', 'RING', 'NECKLACE', 'AMULET', 'CAPE'].includes(i.type));
  const other = items.filter(i => !weapons.includes(i) && !shields.includes(i) && !armors.includes(i) && !helmets.includes(i) && !boots.includes(i) && !legs.includes(i) && !jewels.includes(i));

  return { weapons, shields, armors, helmets, boots, legs, jewels, other };
}

// Main
console.log('Parsing equipment files...');
let allItems = [];

for (const file of FILES) {
  const filePath = path.join(CONTENT_DIR, file);
  if (fs.existsSync(filePath)) {
    const items = parseJavaFile(filePath);
    console.log(`  ${file}: ${items.length} items`);
    allItems = allItems.concat(items);
  } else {
    console.log(`  ${file}: NOT FOUND, skipping`);
  }
}

const categorized = categorize(allItems);
console.log(`\nTotal Equipment: ${allItems.length} items`);
console.log(`  Weapons: ${categorized.weapons.length}`);
console.log(`  Shields: ${categorized.shields.length}`);
console.log(`  Armors: ${categorized.armors.length}`);
console.log(`  Helmets: ${categorized.helmets.length}`);
console.log(`  Boots: ${categorized.boots.length}`);
console.log(`  Legs: ${categorized.legs.length}`);
console.log(`  Jewels: ${categorized.jewels.length}`);
console.log(`  Other: ${categorized.other.length}`);

fs.writeFileSync(OUTPUT_FILE, JSON.stringify(categorized, null, 2), 'utf-8');
console.log(`Output: ${OUTPUT_FILE}`);

// --- CONSUMABLES ---
console.log('\nParsing consumable files...');
let allConsumables = [];

for (const file of CONSUMABLE_FILES) {
  const filePath = path.join(CONTENT_DIR, file);
  if (fs.existsSync(filePath)) {
    const items = parseConsumableFile(filePath);
    console.log(`  ${file}: ${items.length} items`);
    allConsumables = allConsumables.concat(items);
  } else {
    console.log(`  ${file}: NOT FOUND, skipping`);
  }
}

const foods = allConsumables.filter(i => i.type === 'FOOD');
const potions = allConsumables.filter(i => i.type === 'POTION');
console.log(`\nTotal Consumables: ${allConsumables.length}`);
console.log(`  Foods: ${foods.length}`);
console.log(`  Potions: ${potions.length}`);

const CONSUMABLE_OUTPUT = path.join(__dirname, '..', 'js', 'wiki_data_consumables.json');
fs.writeFileSync(CONSUMABLE_OUTPUT, JSON.stringify({ foods, potions }, null, 2), 'utf-8');
console.log(`Output: ${CONSUMABLE_OUTPUT}`);

// --- OTHER / VALUABLES ---
console.log('\nParsing other items...');
let allOther = [];
for (const file of OTHER_FILES) {
  const filePath = path.join(CONTENT_DIR, file);
  if (fs.existsSync(filePath)) {
    const items = parseOtherFile(filePath);
    console.log(`  ${file}: ${items.length} items`);
    allOther = allOther.concat(items);
  }
}
const valuables = allOther.filter(i => i.type === 'VALUABLE');
const misc = allOther.filter(i => i.type !== 'VALUABLE');
console.log(`  Valuables: ${valuables.length}`);
console.log(`  Misc/Tools: ${misc.length}`);
const OTHER_OUTPUT = path.join(__dirname, '..', 'js', 'wiki_data_other.json');
fs.writeFileSync(OTHER_OUTPUT, JSON.stringify({ valuables, misc }, null, 2), 'utf-8');
console.log(`Output: ${OTHER_OUTPUT}`);
