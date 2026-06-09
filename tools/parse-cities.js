/**
 * parse-cities.js
 * Parseia Cities.java + Places.java + Others.java para extrair dados completos de cidades.
 * Uso: node tools/parse-cities.js
 */
const fs = require('fs');
const path = require('path');

const LOCATIONS_DIR = path.join(__dirname, '..', 'pages', 'wiki_et2', 'content', 'locations');
const SHOPS_DIR = path.join(__dirname, '..', 'pages', 'wiki_et2', 'content', 'shops');

const OUTPUT_FILE = path.join(__dirname, '..', 'js', 'wiki_data_cities.json');

const REGIONS = {
  LISPORT: { en: 'Lisport', pt: 'Lisport' },
  HAVARUS_NORTH: { en: 'Havarus North', pt: 'Havarus Norte' },
  HAVARUS_SOUTH: { en: 'Havarus South', pt: 'Havarus Sul' },
  GYBRALAR_FOREST: { en: 'Gybralar Forest', pt: 'Floresta Gybralar' },
  ESPERAND: { en: 'Esperand', pt: 'Esperand' },
  WAZEL: { en: 'Wazel', pt: 'Wazel' },
  GROWROCKS: { en: 'Growrocks', pt: 'Growrocks' },
  AYALON: { en: 'Ayalon', pt: 'Ayalon' }
};

// Build shop name lookup
function buildShopLookup() {
  const lookup = {};
  const folders = fs.readdirSync(SHOPS_DIR).filter(f => fs.statSync(path.join(SHOPS_DIR, f)).isDirectory());
  for (const folder of folders) {
    const dir = path.join(SHOPS_DIR, folder);
    const files = fs.readdirSync(dir).filter(f => f.endsWith('.java'));
    for (const file of files) {
      const content = fs.readFileSync(path.join(dir, file), 'utf-8');
      const nameMatch = content.match(/new (?:Shop|Stable)\("([^"]+)"/);
      const ptMatch = content.match(/addNameTranslation\(.*?PORTUGUESE,\s*"([^"]+)"\)/);
      if (nameMatch) {
        const enumKey = nameMatch[1].toUpperCase().replace(/['']/g, '').replace(/\s+/g, '_');
        lookup[enumKey] = { name_en: nameMatch[1], name_pt: ptMatch ? ptMatch[1] : nameMatch[1] };
      }
    }
  }
  return lookup;
}



const shopLookup = buildShopLookup();


function humanize(enumName) {
  return enumName.toLowerCase().replace(/_/g, ' ').replace(/\b\w/g, c => c.toUpperCase());
}
function resolveShop(enumName) { return shopLookup[enumName] || { name_en: humanize(enumName), name_pt: humanize(enumName) }; }

function resolveRegion(enumName) { return REGIONS[enumName] || { en: humanize(enumName), pt: humanize(enumName) }; }

// === STEP 1: Parse Cities.java to get base city data ===
function parseCitiesFile(filePath) {
  const content = fs.readFileSync(filePath, 'utf-8');
  const cities = [];
  const blocks = content.split(/\n\s{4}Locale\s+\w+\(\)\s*\{/);
  for (let i = 1; i < blocks.length; i++) {
    const block = blocks[i].split(/\n\s{4}\}/)[0];
    const constructorMatch = block.match(/new Locale\("([^"]+)",\s*RegionsIds\.(\w+)\)/);
    if (!constructorMatch) continue;

    const city = {};
    city.name_en = constructorMatch[1];
    city.regionEnum = constructorMatch[2];
    const region = resolveRegion(city.regionEnum);
    city.region_en = region.en;
    city.region_pt = region.pt;
    const ptMatch = block.match(/addNameTranslation\(.*?PORTUGUESE,\s*"([^"]+)"\)/);
    city.name_pt = ptMatch ? ptMatch[1] : city.name_en;
    city.img = 'locale_' + city.name_en.toLowerCase().replace(/['']/g, '').replace(/\s+/g, '_');

    // Description
    const descEn = block.match(/addDescriptionTranslation\(.*?ENGLISH,\s*"([^"]+)"\)/);
    const descPt = block.match(/addDescriptionTranslation\(.*?PORTUGUESE,\s*"([^"]+)"\)/);
    city.desc_en = descEn ? descEn[1] : '';
    city.desc_pt = descPt ? descPt[1] : '';

    // Shops
    city.shops = [];
    const shopRegex = /shops\.add\(ShopsIds\.(\w+)\)/g;
    let m;
    while ((m = shopRegex.exec(block)) !== null) city.shops.push(resolveShop(m[1]));
    const stableRegex = /stables\.add\(ShopsIds\.(\w+)\)/g;
    while ((m = stableRegex.exec(block)) !== null) city.shops.push(resolveShop(m[1]));

  



    // Type
    const typeMatch = block.match(/type\s*=\s*Enums\.LocationTypes\.(\w+)/);
    city.type = typeMatch ? typeMatch[1] : 'CITY';

    cities.push(city);
  }
  return cities;
}



// === MAIN ===
const regionFolders = fs.readdirSync(LOCATIONS_DIR).filter(f => fs.statSync(path.join(LOCATIONS_DIR, f)).isDirectory());

let allCities = [];

for (const folder of regionFolders) {
  const citiesFile = path.join(LOCATIONS_DIR, folder, 'Cities.java');
  if (fs.existsSync(citiesFile)) {
    const cities = parseCitiesFile(citiesFile);
    allCities = allCities.concat(cities);
  }
}

// Exclude Wazel Ruins
allCities = allCities.filter(c => c.name_en !== 'Wazel Ruins');

// Clean up internal fields
allCities.forEach(city => {
  delete city.regionEnum;
});

console.log(`Parsed ${allCities.length} cities:`);
allCities.forEach(c => console.log(`  ${c.name_en} (${c.region_en}) - ${c.shops.length} shops`));

fs.writeFileSync(OUTPUT_FILE, JSON.stringify(allCities, null, 2), 'utf-8');
console.log(`Output: ${OUTPUT_FILE}`);
