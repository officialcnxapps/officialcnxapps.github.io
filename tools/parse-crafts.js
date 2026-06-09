/**
 * parse-crafts.js
 * Parseia Crafts.java e cruza com os JSONs de itens para resolver nomes.
 * Uso: node tools/parse-crafts.js
 */
const fs = require('fs');
const path = require('path');

const CRAFTS_FILE = path.join(__dirname, '..', 'pages', 'wiki_et2', 'content', 'crafts', 'Crafts.java');
const OUTPUT_FILE = path.join(__dirname, '..', 'js', 'wiki_data_crafts.json');

// Load all item data to build name lookup
const equipData = JSON.parse(fs.readFileSync(path.join(__dirname, '..', 'js', 'wiki_data_equipment.json'), 'utf-8'));
const consumData = JSON.parse(fs.readFileSync(path.join(__dirname, '..', 'js', 'wiki_data_consumables.json'), 'utf-8'));
const otherData = JSON.parse(fs.readFileSync(path.join(__dirname, '..', 'js', 'wiki_data_other.json'), 'utf-8'));

// Build lookup by normalized name key (lowercase, no apostrophes, spaces->underscores)
const allItems = [
  ...equipData.weapons, ...equipData.shields, ...equipData.armors,
  ...equipData.helmets, ...equipData.boots, ...equipData.legs, ...equipData.jewels,
  ...consumData.foods, ...consumData.potions,
  ...otherData.valuables, ...otherData.ores, ...otherData.tools, ...otherData.misc
];

function nameToKey(name) {
  return name.toLowerCase().replace(/['']/g, '').replace(/\s+/g, '_');
}

function enumToKey(enumName) {
  return enumName.toLowerCase();
}

const itemLookup = {};
allItems.forEach(function (item) {
  // Index by normalized English name
  itemLookup[nameToKey(item.name_en)] = item;
});

function resolveItemId(enumName) {
  var key = enumToKey(enumName);
  var item = itemLookup[key];
  if (item) return { name_en: item.name_en, name_pt: item.name_pt, img: item.img };
  // Fallback: humanize enum name to Title Case
  var humanized = enumName.toLowerCase().replace(/_/g, ' ').replace(/\b\w/g, function (c) { return c.toUpperCase(); });
  return { name_en: humanized, name_pt: humanized, img: 'item_' + key };
}

// Parse crafts
const content = fs.readFileSync(CRAFTS_FILE, 'utf-8');
const crafts = [];

// Match: new CraftRecipe(time, ItemsIds.RESULT, ItemsIds.ING1, ItemsIds.ING2?, ItemsIds.ING3?)
const recipeRegex = /new CraftRecipe\((\d+),\s*ItemsIds\.(\w+)((?:,\s*ItemsIds\.\w+)+)\)/g;
const typeRegex = /recipe\.type\s*=\s*Enums\.CraftTypes\.(\w+)/;
const successRegex = /recipe\.successRate\s*=\s*(\d+)/;

// Split into method blocks
const methods = content.split(/\n\s{4}(?:public\s+)?CraftRecipe\s+\w+\(\)\s*\{/);

for (let i = 1; i < methods.length; i++) {
  const block = methods[i].split(/\n\s{4}\}/)[0];

  const recipeMatch = block.match(/new CraftRecipe\((\d+),\s*ItemsIds\.(\w+)((?:,\s*ItemsIds\.\w+)+)\)/);
  if (!recipeMatch) continue;

  const time = parseInt(recipeMatch[1]);
  const resultId = recipeMatch[2];
  const ingredientsRaw = recipeMatch[3];

  // Parse ingredients
  const ingMatches = ingredientsRaw.match(/ItemsIds\.(\w+)/g);
  const ingredients = ingMatches ? ingMatches.map(function (m) {
    return m.replace('ItemsIds.', '');
  }) : [];

  // Type
  const typeMatch = block.match(typeRegex);
  const type = typeMatch ? typeMatch[1] : 'GENERAL';

  // Success rate
  const successMatch = block.match(successRegex);
  const successRate = successMatch ? parseInt(successMatch[1]) : 0;

  // Resolve names
  const result = resolveItemId(resultId);
  const resolvedIngredients = ingredients.map(resolveItemId);

  crafts.push({
    result: result,
    ingredients: resolvedIngredients,
    time: time,
    successRate: successRate,
    type: type
  });
}

// Categorize
const cooking = crafts.filter(c => c.type === 'COOKING');
const general = crafts.filter(c => c.type === 'GENERAL');
const alchemy = crafts.filter(c => c.type === 'ALCHEMY');

console.log(`Parsed ${crafts.length} crafts:`);
console.log(`  Cooking: ${cooking.length}`);
console.log(`  General: ${general.length}`);
console.log(`  Alchemy: ${alchemy.length}`);

fs.writeFileSync(OUTPUT_FILE, JSON.stringify({ cooking, general, alchemy }, null, 2), 'utf-8');
console.log(`Output: ${OUTPUT_FILE}`);
