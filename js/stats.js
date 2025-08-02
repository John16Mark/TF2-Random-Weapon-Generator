function stat_set_valores(stat, positive) {
  stat_definir_puntaje(stat, positive);
}

function stat_definir_puntaje(stat, positive) {
  if(stat.tipo == StatTypes.BOTH_ZERO_TO_MAX || stat.tipo == StatTypes.UNIQUE_ZERO_TO_MAX) {
    let r = random_int((positive ? stat.maxValuePos : stat.maxValueNeg)/stat.salto) + 1;
    stat.valor = r * stat.salto;
    stat.score = stat.maxScore*(stat.valor/(positive ? stat.maxValuePos : stat.maxValueNeg));
  }
  else if(stat.tipo == StatTypes.BOTH_MAX_AMMO) {
    let lista_divisores = ammo_divisors.get(stat.maxAmmo);
    let divisor = lista_divisores[random_int(lista_divisores.length)];
    let R = (stat.maxAmmo/divisor) - (positive ? 0 : 1);
    let r = random_int(R) + 1;
    stat.valor = Math.trunc((r*divisor*100)/(stat.maxAmmo));
    stat.score = (r/R)*stat.maxScore;
    /*
    console.log('maxAmmo', stat.maxAmmo);
    console.log('divisor', divisor);
    console.log('r', r);
    console.log('R', R);
    console.log('valor', stat.valor);
    */
  }
  else if(stat.tipo == StatTypes.BOTH_CLIP_SIZE) {
    let divisor = stat.clipSize;
    let R = divisor - (positive ? 0 : 1);
    let r = random_int(R) + 1;
    stat.valor = Math.trunc((r*100)/(divisor));
    stat.score = (r/R)*stat.maxScore;
    /*
    console.log('clipSize', stat.clipSize);
    console.log('divisor', divisor);
    console.log('r', r);
    console.log('R', R);
    console.log('valor', stat.valor);
    console.log('score', stat.score);
    */
  }
  else if(stat.tipo == StatTypes.BOTH_TEXT || stat.tipo == StatTypes.UNIQUE_TEXT) {
    stat.score = stat.maxScore;
  }
}

function set_stats_generic(stat_list, slot, primaryAmmo, secondaryAmmo) {
  if(primaryAmmo != null) stat_list.push({nombre: 'MaxPrimaryAmmo', tipo: StatTypes.BOTH_MAX_AMMO, maxScore: 15, maxAmmo: primaryAmmo, relacionadas: slot == 'Primary' ? ['NoAmmoNeed'] : [],
    tp1: '+', tp2: '% max primary ammo on wearer', tn1: '-', tn2: '% max primary ammo on wearer'});
  if(secondaryAmmo != null) stat_list.push({nombre: 'MaxSecondaryAmmo', tipo: StatTypes.BOTH_MAX_AMMO, maxScore: 15, maxAmmo: secondaryAmmo, relacionadas: slot == 'Secondary' ? ['NoAmmoNeed'] : [],
    tp1: '+', tp2: '% max secondary ammo on wearer', tn1: '-', tn2: '% max secondary ammo on wearer'});
  
  stat_list.push({nombre: 'MaxHP', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: false, maxScore: 80, maxValueNeg: 40, salto: 5, relacionadas: [],
    tn1: '-', tn2: ' max health on wearer'});
  stat_list.push({nombre: 'DmgResPassive', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: false, maxScore: 45, maxValueNeg: 30, salto: 5, relacionadas: ['FireResPassive', 'ExpResPassive', 'BullResPassive', 'MeleeResPassive', 'DmgResActive', 'FireResActive', 'ExpResPassive', 'BullResActive', 'MeleeResActive'],
    tn1: '-', tn2: '% damage vulnerability on wearer'});
  stat_list.push({nombre: 'FireResPassive', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: false, maxScore: 27, maxValueNeg: 35, salto: 5, relacionadas: ['DmgResPassive', 'DmgResActive', 'FireResActive'],
    tn1: '-', tn2: '% fire damage vulnerability on wearer'});
  stat_list.push({nombre: 'ExpResPassive', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: false, maxScore: 32, maxValueNeg: 30, salto: 5, relacionadas: ['DmgResPassive', 'DmgResActive', 'ExpResActive'],
    tn1: '-', tn2: '% explosive damage vulnerability on wearer'});
  stat_list.push({nombre: 'BullResPassive', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: false, maxScore: 38, maxValueNeg: 25, salto: 5, relacionadas: ['DmgResPassive', 'DmgResActive', 'BullResActive'],
    tn1: '-', tn2: '% bullet damage vulnerability on wearer'});
  stat_list.push({nombre: 'MeleeResPassive', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: false, maxScore: 20, maxValueNeg: 20, salto: 5, relacionadas: ['DmgResPassive', 'DmgResActive', 'MeleeResActive'],
    tn1: '-', tn2: '% melee damage vulnerability on wearer'});
  
  stat_list.push({nombre: 'HealFromKits', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 50, maxValuePos: 100, maxValueNeg: 80, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% health from packs on wearer', tn1: '-', tn2: '% health from packs on wearer'});
  stat_list.push({nombre: 'HealFromHealers', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 65, maxValuePos: 100, maxValueNeg: 95, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% health from healers on wearer', tn1: '-', tn2: '% health from healers on wearer'});
  stat_list.push({nombre: 'OverHealPenalty', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: false, maxScore: 55, maxValueNeg: 90, salto: 10, relacionadas: ['NoOverHeal'],
    tn1: '-', tn2: '% maxium overheal on wearer'});
  stat_list.push({nombre: 'NoOverHeal', tipo: StatTypes.UNIQUE_TEXT, positivo: false, maxScore: 60, relacionadas: ['OverHealPenalty', 'OverHealDecay'],
    tn1: '-100% maxium overheal on wearer'});
  stat_list.push({nombre: 'OverHealDecay', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: false, maxScore: 40, maxValueNeg: 30, salto: 5, relacionadas: ['NoOverHeal'],
    tn1: '-', tn2: '% faster overheal decay'});
}

// NOTE Si es un arma
function set_stats_weapon(stat_list, tipo, clip_size, slot) {
  if(tipo == 'Weapon') stat_list.push({nombre: 'Damage', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 60, maxValuePos: 30, maxValueNeg: 30, salto: 5, relacionadas: ['DamagePlayers', 'DamageBuildings'],
    tp1: '+', tp2: '% damage bonus', tn1: '-', tn2: '% damage penalty'});
  if(tipo == 'Weapon') stat_list.push({nombre: 'DamagePlayers', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 45, maxValuePos: 25, maxValueNeg: 40, salto: 5, relacionadas: ['Damage'],
    tp1: '+', tp2: '% damage vs players', tn1: '-', tn2: '% damage penalty vs players'});
  if(tipo == 'Weapon') stat_list.push({nombre: 'DamageBuildings', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 20, maxValuePos: 35, maxValueNeg: 80, salto: 5, relacionadas: ['Damage'],
    tp1: '+', tp2: '% damage vs buildings', tn1: '-', tn2: '% damage penalty vs buildings'});
  if(clip_size) stat_list.push({nombre: 'ClipSize', tipo: StatTypes.BOTH_CLIP_SIZE, maxScore: 75, clipSize: clip_size, relacionadas: [],
    tp1: '+', tp2: '% clip size', tn1: '-', tn2: '% clip size'});
  if(clip_size) stat_list.push({nombre: 'FiringSpeed', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 80, maxValuePos: 60, maxValueNeg: 60, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% faster firing speed', tn1: '-', tn2: '% slower firing speed'});
  if(tipo == 'Weapon') stat_list.push({nombre: 'HpOnHit', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: true, maxScore: 40, maxValuePos: 25, salto: 5, relacionadas: [],
    tp1: 'On Hit: Gain up to +', tp2: ' health per attack'});

  stat_list.push({nombre: 'DeploySpeed', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 30, maxValuePos: 75, maxValueNeg: 75, salto: 5, relacionadas: [],
    tp1: 'This weapon deploys ', tp2: '% faster', tn1: 'This weapon deploys ', tn2: '% slower'});
  stat_list.push({nombre: 'HolsterSpeed', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 20, maxValuePos: 30, maxValueNeg: 75, salto: 5, relacionadas: [],
    tp1: 'This weapon holsters ', tp2: '% faster', tn1: 'This weapon holsters ', tn2: '% slower'});
  stat_list.push({nombre: 'ReloadSpeed', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 30, maxValuePos: 25, maxValueNeg: 25, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% faster reload speed', tn1: '-', tn2: '% slower reload speed'});

  stat_list.push({nombre: 'SpeedActive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 45, maxValuePos: 15, maxValueNeg: 15, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% faster moving speed when active', tn1: '-', tn2: '% slower moving speed when active'});
  stat_list.push({nombre: 'JumpActive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 15, maxValuePos: 25, maxValueNeg: 25, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% greater jump height when active', tn1: '-', tn2: '% jump height when active'});

  if(slot == 'Primary' || slot == 'Secondary') stat_list.push({nombre: 'NoAmmoNeed', tipo: StatTypes.UNIQUE_TEXT, positivo: true, maxScore: 12, relacionadas: slot == 'Primary' ? ['MaxPrimaryAmmo', 'NoAmmoDispensers', 'AirblastCost'] : ['MaxSecondaryAmmo', 'NoAmmoDispensers', 'AirblastCost'],
    tp1: 'Does not require ammo'});
  if(tipo == 'Weapon' && (slot == 'Primary' || slot == 'Secondary')) stat_list.push({nombre: 'NoAmmoDispensers', tipo: StatTypes.UNIQUE_TEXT, positivo: false, maxScore: 8, relacionadas: ['NoAmmoNeed'],
    tn1: 'No ammo from dispensers when active'});

  if(tipo == 'Weapon') stat_list.push({nombre: 'MinicritsExplosion', tipo: StatTypes.UNIQUE_TEXT, positivo: true, maxScore: 12, relacionadas: [],
    tp1: 'Mini-crits targets launched airborne by explosions, grapple hooks or rocket packs'});
  if(tipo == 'Weapon') stat_list.push({nombre: 'MinicritsWhenCrit', tipo: StatTypes.UNIQUE_TEXT, positivo: false, maxScore: 20, relacionadas: ['CritsWhenMinicrit'],
    tn1: 'Minicrits whenever it would normally crit'});
  if(tipo == 'Weapon') stat_list.push({nombre: 'NoRandomCrits', tipo: StatTypes.UNIQUE_TEXT, positivo: false, maxScore: 20, relacionadas: [],
    tn1: 'No random critical hits'});
  
  stat_list.push({nombre: 'DmgResActive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 50, maxValuePos: 35, maxValueNeg: 35, salto: 5, relacionadas: ['DmgResPassive', 'FireResPassive', 'ExpResPassive', 'BullResPassive', 'MeleeResPassive', 'FireResActive', 'ExpResPassive', 'BullResActive', 'MeleeResActive'],
    tp1: '+', tp2: '% damage resistance when active', tn1: '-', tn2: '% damage vulnerability when active'});
  stat_list.push({nombre: 'FireResActive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 25, maxValuePos: 35, maxValueNeg: 35, salto: 5, relacionadas: ['DmgResPassive', 'DmgResActive', 'FireResPassive'],
    tp1: '+', tp2: '% fire damage resistance when active', tn1: '-', tn2: '% fire damage vulnerability when active'});
  stat_list.push({nombre: 'ExpResActive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 30, maxValuePos: 35, maxValueNeg: 35, salto: 5, relacionadas: ['DmgResPassive', 'DmgResActive', 'ExpResPassive'],
    tp1: '+', tp2: '% explosive damage resistance when active', tn1: '-', tn2: '% explosive damage vulnerability when active'});
  stat_list.push({nombre: 'BullResActive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 35, maxValuePos: 35, maxValueNeg: 35, salto: 5, relacionadas: ['DmgResPassive', 'DmgResActive', 'BullResPassive'],
    tp1: '+', tp2: '% bullet damage resistance when active', tn1: '-', tn2: '% bullet damage vulnerability when active'});
  stat_list.push({nombre: 'MeleeResActive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 15, maxValuePos: 35, maxValueNeg: 35, salto: 5, relacionadas: ['DmgResPassive', 'DmgResActive', 'MeleeResPassive'],
    tp1: '+', tp2: '% melee damage resistance when active', tn1: '-', tn2: '% melee damage vulnerability when active'});
  stat_list.push({nombre: 'HealFromHealersWA', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 60, maxValuePos: 50, maxValueNeg: 90, salto: 5, relacionadas: ['DmgResPassive'],
    tp1: '+', tp2: '% health from healers when active', tn1: '-', tn2: '% health from healers when active'});
}

// NOTE Si es arma que dispara balas
function set_stats_bullets(stat_list) {
  stat_list.push({nombre: 'Accuracy', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 35, maxValuePos: 25, maxValueNeg: 20, salto: 5, relacionadas: ['FixedPattern'],
    tp1: '+', tp2: '% more accurate', tn1: '-', tn2: '% less accurate'});
}

function set_stats_shotgun(stat_list) {

}

function set_stats_projectile(stat_list) {

}

function set_stats_explosive(stat_list) {

}

function set_stats_melee(stat_list) {

}