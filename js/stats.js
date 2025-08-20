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

  if(stat.extra == 'SecondsText') {
    if(positive)
      stat.tp2 = stat.valor == 1 ? ' second' : ' seconds';
    else
      stat.tn2 = stat.valor == 1 ? ' second' : ' seconds';
  }
}

function set_stats_generic(stat_list, slot, primaryAmmo, secondaryAmmo) {
  if(primaryAmmo != null) stat_list.push({nombre: 'MaxPrimaryAmmo', tipo: StatTypes.BOTH_MAX_AMMO, maxScore: 15, maxAmmo: primaryAmmo, relacionadas: slot == 'Primary' ? ['NoAmmoNeed'] : [],
    tp1: '+', tp2: '% max primary ammo on wearer', tn1: '-', tn2: '% max primary ammo on wearer'});
  if(secondaryAmmo != null) stat_list.push({nombre: 'MaxSecondaryAmmo', tipo: StatTypes.BOTH_MAX_AMMO, maxScore: 15, maxAmmo: secondaryAmmo, relacionadas: slot == 'Secondary' ? ['NoAmmoNeed'] : [],
    tp1: '+', tp2: '% max secondary ammo on wearer', tn1: '-', tn2: '% max secondary ammo on wearer'});
  
  stat_list.push({nombre: 'MaxHP', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: false, maxScore: 70, maxValueNeg: 40, salto: 5, relacionadas: [],
    tn1: '-', tn2: ' max health on wearer'});
  stat_list.push({nombre: 'DmgResPassive', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: false, maxScore: 40, maxValueNeg: 30, salto: 5, relacionadas: ['FireResPassive', 'ExpResPassive', 'BullResPassive', 'MeleeResPassive', 'DmgResActive', 'FireResActive', 'ExpResPassive', 'BullResActive', 'MeleeResActive'],
    tn1: '-', tn2: '% damage vulnerability on wearer'});
  stat_list.push({nombre: 'FireResPassive', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: false, maxScore: 25, maxValueNeg: 35, salto: 5, relacionadas: ['DmgResPassive', 'DmgResActive', 'FireResActive'],
    tn1: '-', tn2: '% fire damage vulnerability on wearer'});
  stat_list.push({nombre: 'ExpResPassive', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: false, maxScore: 30, maxValueNeg: 30, salto: 5, relacionadas: ['DmgResPassive', 'DmgResActive', 'ExpResActive'],
    tn1: '-', tn2: '% explosive damage vulnerability on wearer'});
  stat_list.push({nombre: 'BullResPassive', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: false, maxScore: 35, maxValueNeg: 25, salto: 5, relacionadas: ['DmgResPassive', 'DmgResActive', 'BullResActive'],
    tn1: '-', tn2: '% bullet damage vulnerability on wearer'});
  stat_list.push({nombre: 'MeleeResPassive', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: false, maxScore: 17, maxValueNeg: 25, salto: 5, relacionadas: ['DmgResPassive', 'DmgResActive', 'MeleeResActive'],
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
    tn1: '-', tn2: '% faster overheal decay on wearer'});
}

// NOTE Si es algo pasivo (mochila, botas, etc...)
function set_stats_passive(stat_list) {
  eliminarStatPorNombre(stat_list, 'MaxHP');
  eliminarStatPorNombre(stat_list, 'DmgResPassive');
  eliminarStatPorNombre(stat_list, 'FireResPassive');
  eliminarStatPorNombre(stat_list, 'ExpResPassive');
  eliminarStatPorNombre(stat_list, 'BullResPassive');
  eliminarStatPorNombre(stat_list, 'MeleeResPassive');

  stat_list.push({nombre: 'MaxHP', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 80, maxValuePos: 50, maxValueNeg: 50, salto: 5, relacionadas: [],
    tp1: '+', tp2: ' max health on wearer', tn1: '-', tn2: ' max health on wearer'});
  stat_list.push({nombre: 'DmgResPassive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 40, maxValuePos: 30, maxValueNeg: 30, salto: 5, relacionadas: ['FireResPassive', 'ExpResPassive', 'BullResPassive', 'MeleeResPassive', 'DmgResActive', 'FireResActive', 'ExpResPassive', 'BullResActive', 'MeleeResActive'],
    tp1: '+', tp2: '% damage resistance on wearer', tn1: '-', tn2: '% damage vulnerability on wearer'});
  stat_list.push({nombre: 'FireResPassive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 25, maxValuePos: 35, maxValueNeg: 35, salto: 5, relacionadas: ['DmgResPassive', 'DmgResActive', 'FireResActive'],
    tp1: '+', tp2: '% fire damage resistance on wearer', tn1: '-', tn2: '% fire damage vulnerability on wearer'});
  stat_list.push({nombre: 'ExpResPassive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 30, maxValuePos: 30, maxValueNeg: 30, salto: 5, relacionadas: ['DmgResPassive', 'DmgResActive', 'ExpResActive'],
    tp1: '+', tp2: '% explosive damage resistance on wearer', tn1: '-', tn2: '% explosive damage vulnerability on wearer'});
  stat_list.push({nombre: 'BullResPassive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 35, maxValuePos: 25, maxValueNeg: 25, salto: 5, relacionadas: ['DmgResPassive', 'DmgResActive', 'BullResActive'],
    tp1: '+', tp2: '% bullet damage resistance on wearer', tn1: '-', tn2: '% bullet damage vulnerability on wearer'});
  stat_list.push({nombre: 'MeleeResPassive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 17, maxValuePos: 25, maxValueNeg: 25, salto: 5, relacionadas: ['DmgResPassive', 'DmgResActive', 'MeleeResActive'],
    tp1: '+', tp2: '% melee damage resistance on wearer', tn1: '-', tn2: '% melee damage vulnerability on wearer'});

  stat_list.push({nombre: 'SpeedPassive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 40, maxValuePos: 20, maxValueNeg: 20, salto: 5, relacionadas: ['SpeedDemoBoots'],
    tp1: '+', tp2: '% faster move speed on wearer', tn1: '-', tn2: '% slower move speed on wearer'});
  stat_list.push({nombre: 'JumpPassive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 20, maxValuePos: 15, maxValueNeg: 10, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% greater jump height on wearer', tn1: '-', tn2: '% jump height on wearer'});
  stat_list.push({nombre: 'HpRegenPassive', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: true, maxScore: 30, maxValuePos: 5, salto: 1, relacionadas: ['HpRegenActive'],
    tp1: '+', tp2: ' health regenerated per second on wearer'});
  stat_list.push({nombre: 'FallResPassive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 20, maxValuePos: 75, maxValueNeg: 40, salto: 5, relacionadas: ['NoFallPassive'],
    tp1: '-', tp2: '% fall damage taken', tn1: '+', tn2: '% fall damage taken'});
  stat_list.push({nombre: 'NoFallPassive', tipo: StatTypes.UNIQUE_TEXT, positivo: true, maxScore: 25, relacionadas: ['FallResPassive'],
    tp1: 'Wearer takes no fall damage'});

  stat_list.push({nombre: 'KnbkResPassive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 45, maxValuePos: 75, maxValueNeg: 40, salto: 5, relacionadas: ['KnbkDmgResPassive', 'KnbkAirResPassive', 'KnbkResActive', 'KnbkDmgResActive', 'KnbkAirResActive'],
    tp1: '-', tp2: '% reduction in push force taken from damage and airblast', tn1: '+', tn2: '% increase in push force taken from damage and airblast'});
  stat_list.push({nombre: 'KnbkDmgResPassive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 30, maxValuePos: 75, maxValueNeg: 40, salto: 5, relacionadas: ['KnbkResPassive', 'KnbkResActive'],
    tp1: '-', tp2: '% reduction in push force taken from damage', tn1: '+', tn2: '% increase in push force taken from damage'});
  stat_list.push({nombre: 'KnbkAirResPassive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 15, maxValuePos: 75, maxValueNeg: 40, salto: 5, relacionadas: ['KnbkResPassive', 'KnbkResActive'],
    tp1: '-', tp2: '% reduction in push force taken from airblast', tn1: '+', tn2: '% increase in push force taken from airblast'});
  
}

// NOTE Si es un arma
function set_stats_weapon(stat_list, tipo, clip_size, slot, nombre) {
  
  // -------- Attack ----------------------------------------
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
  if(tipo == 'Weapon') stat_list.push({nombre: 'HpOnHit', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: true, maxScore: 30, maxValuePos: 25, salto: 5, relacionadas: [],
    tp1: 'On Hit: Gain up to +', tp2: ' health per attack'});

  // -------- Speed ----------------------------------------
  stat_list.push({nombre: 'DeploySpeed', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 30, maxValuePos: 75, maxValueNeg: 75, salto: 5, relacionadas: [],
    tp1: 'This weapon deploys ', tp2: '% faster', tn1: 'This weapon deploys ', tn2: '% slower'});
  stat_list.push({nombre: 'HolsterSpeed', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 20, maxValuePos: 30, maxValueNeg: 75, salto: 5, relacionadas: [],
    tp1: 'This weapon holsters ', tp2: '% faster', tn1: 'This weapon holsters ', tn2: '% slower'});
  if(clip_size) stat_list.push({nombre: 'ReloadSpeed', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 30, maxValuePos: 25, maxValueNeg: 25, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% faster reload speed', tn1: '-', tn2: '% slower reload speed'});

  // -------- Utility ----------------------------------------
  stat_list.push({nombre: 'SpeedActive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 40, maxValuePos: 15, maxValueNeg: 15, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% faster moving speed when active', tn1: '-', tn2: '% slower moving speed when active'});
  stat_list.push({nombre: 'JumpActive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 15, maxValuePos: 25, maxValueNeg: 25, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% greater jump height when active', tn1: '-', tn2: '% jump height when active'});
  // NOTE hp regen active

  // -------- Extra ----------------------------------------
  if((slot == 'Primary' || slot == 'Secondary') && (nombre != 'Medi Gun' && nombre != 'Sapper')) stat_list.push({nombre: 'NoAmmoNeed', tipo: StatTypes.UNIQUE_TEXT, positivo: true, maxScore: 12, relacionadas: slot == 'Primary' ? ['MaxPrimaryAmmo', 'NoAmmoDispensers', 'AirblastCost'] : ['MaxSecondaryAmmo', 'NoAmmoDispensers', 'AirblastCost'],
    tp1: 'Does not require ammo'});
  if(tipo == 'Weapon' && (slot == 'Primary' || slot == 'Secondary')) stat_list.push({nombre: 'NoAmmoDispensers', tipo: StatTypes.UNIQUE_TEXT, positivo: false, maxScore: 8, relacionadas: ['NoAmmoNeed'],
    tn1: 'No ammo from dispensers when active'});

  // -------- Buffs ----------------------------------------
  if(tipo == 'Weapon') stat_list.push({nombre: 'MinicritsExplosion', tipo: StatTypes.UNIQUE_TEXT, positivo: true, maxScore: 12, relacionadas: [],
    tp1: 'Mini-crits targets launched airborne by explosions, grapple hooks or rocket packs'});
  if(tipo == 'Weapon') stat_list.push({nombre: 'MinicritsWhenCrit', tipo: StatTypes.UNIQUE_TEXT, positivo: false, maxScore: nombre=='Sniper' ? 50 : 20, relacionadas: ['CritsWhenMinicrit', 'HeadshotsMinicrit', 'CritStabSap', 'CritStab', 'CritSap'],
    tn1: 'Minicrits whenever it would normally crit'});
  if(tipo == 'Weapon') stat_list.push({nombre: 'NoRandomCrits', tipo: StatTypes.UNIQUE_TEXT, positivo: false, maxScore: 20, relacionadas: [],
    tn1: 'No random critical hits'});
  
  // -------- Defense ----------------------------------------
  stat_list.push({nombre: 'DmgResActive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 50, maxValuePos: 35, maxValueNeg: 35, salto: 5, relacionadas: ['DmgResPassive', 'FireResPassive', 'ExpResPassive', 'BullResPassive', 'MeleeResPassive', 'FireResActive', 'ExpResActive', 'BullResActive', 'MeleeResActive'],
    tp1: '+', tp2: '% damage resistance when active', tn1: '-', tn2: '% damage vulnerability when active'});
  stat_list.push({nombre: 'FireResActive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 25, maxValuePos: 35, maxValueNeg: 35, salto: 5, relacionadas: ['DmgResPassive', 'FireResPassive', 'DmgResActive'],
    tp1: '+', tp2: '% fire damage resistance when active', tn1: '-', tn2: '% fire damage vulnerability when active'});
  stat_list.push({nombre: 'ExpResActive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 30, maxValuePos: 35, maxValueNeg: 35, salto: 5, relacionadas: ['DmgResPassive', 'ExpResPassive', 'DmgResActive'],
    tp1: '+', tp2: '% explosive damage resistance when active', tn1: '-', tn2: '% explosive damage vulnerability when active'});
  stat_list.push({nombre: 'BullResActive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 35, maxValuePos: 35, maxValueNeg: 35, salto: 5, relacionadas: ['DmgResPassive', 'BullResPassive', 'DmgResActive'],
    tp1: '+', tp2: '% bullet damage resistance when active', tn1: '-', tn2: '% bullet damage vulnerability when active'});
  stat_list.push({nombre: 'MeleeResActive', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 15, maxValuePos: 35, maxValueNeg: 35, salto: 5, relacionadas: ['DmgResPassive', 'MeleeResPassive', 'DmgResActive'],
    tp1: '+', tp2: '% melee damage resistance when active', tn1: '-', tn2: '% melee damage vulnerability when active'});
  stat_list.push({nombre: 'HealFromHealersWA', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 60, maxValuePos: 50, maxValueNeg: 90, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% health from healers when active', tn1: '-', tn2: '% health from healers when active'});

  // TODO on kill set a buff
}

// NOTE Si es arma que dispara balas
function set_stats_bullets(stat_list) {
  stat_list.push({nombre: 'Accuracy', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 35, maxValuePos: 25, maxValueNeg: 20, salto: 5, relacionadas: ['FixedPattern'],
    tp1: '+', tp2: '% more accurate', tn1: '-', tn2: '% less accurate'});
  stat_list.push({nombre: 'MinicritsFromBack', tipo: StatTypes.UNIQUE_TEXT, positivo: true, maxScore: 20, relacionadas: [],
    tp1: 'Mini-crits targets when fired at their back from close range'});
  stat_list.push({nombre: 'MedRangeBulletPen', tipo: StatTypes.UNIQUE_TEXT, positivo: true, maxScore: 12, relacionadas: [],
    tp1: 'On medium and short range hits: Bullets penetrate through enemies'});
}

function set_stats_shotgun(stat_list) {
  stat_list.push({nombre: 'MorePellets', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 50, maxValuePos: 50, maxValueNeg: 60, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% bullets per shot', tn1: '-', tn2: '% bullets per shot'});
  stat_list.push({nombre: 'FixedPattern', tipo: StatTypes.UNIQUE_TEXT, positivo: true, maxScore: 15, relacionadas: ['Accuracy'],
    tp1: 'Fires a wide, fixed shot pattern'});
}

function set_stats_projectile(stat_list, nombre) {
  stat_list.push({nombre: 'ProjectileSpeed', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 50, maxValuePos: 80, maxValueNeg: 20, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% projectile speed', tn1: '-', tn2: '% projectile speed'});
  stat_list.push({nombre: 'ProjectileSpread', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: false, maxScore: 48, maxValueNeg: 3, salto: 1, relacionadas: [],
    tn1: '+', tn2: ' degrees random projectile deviation'});
  if(nombre != 'Syringe Gun' && nombre != 'Stickybomb Launcher') stat_list.push({nombre: 'ReflectedCrit', tipo: StatTypes.UNIQUE_TEXT, positivo: false, maxScore: 30, relacionadas: ['CannotReflect', 'ReflectedNoMini'],
    tn1: 'Reflected projectiles become crit boosted'});
  if(nombre != 'Syringe Gun' && nombre != 'Stickybomb Launcher') stat_list.push({nombre: 'ReflectedNoMini', tipo: StatTypes.UNIQUE_TEXT, positivo: true, maxScore: 15, relacionadas: ['ReflectedCrit', 'CannotReflect'],
    tp1: 'Reflected projectiles don\'t become mini-crit boosted'});
  if(nombre != 'Syringe Gun') stat_list.push({nombre: 'CannotReflect', tipo: StatTypes.UNIQUE_TEXT, positivo: true, maxScore: 30, relacionadas: ['ReflectedCrit', 'ReflectedNoMini'],
    tp1: 'Projectile cannot be deflected'});
}

function set_stats_explosive(stat_list) {
  stat_list.push({nombre: 'ExplosionRadius', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 50, maxValuePos: 25, maxValueNeg: 70, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% explosion radius', tn1: '-', tn2: '% explosion radius'});
  stat_list.push({nombre: 'DestroysStickies', tipo: StatTypes.UNIQUE_TEXT, positivo: true, maxScore: 25, relacionadas: [],
    tp1: 'Able to destroy enemy stickybombs'});
  stat_list.push({nombre: 'ExplosionFire', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, extra: 'SecondsText', positivo: true, maxScore: 45, maxValuePos: 5, salto: 1, relacionadas: [],
    tp1: 'Explosions ignite enemies for up to ', tp2: ''});
  stat_list.push({nombre: 'ExplosionKnockback', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 20, maxValuePos: 20, maxValueNeg: 20, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% explosion knockback', tn1: '-', tn2: '% explosion knockback'});
}

function set_stats_melee(stat_list) {
  eliminarStatPorNombre(stat_list, 'DamageBuildings');
  eliminarStatPorNombre(stat_list, 'HpOnHit');
  eliminarStatPorNombre(stat_list, 'HolsterSpeed');

  stat_list.push({nombre: 'DamageBuildings', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 35, maxValuePos: 100, maxValueNeg: 80, salto: 5, relacionadas: ['Damage'],
    tp1: '+', tp2: '% damage vs buildings', tn1: '-', tn2: '% damage penalty vs buildings'});
  stat_list.push({nombre: 'HpOnHit', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: true, maxScore: 45, maxValuePos: 30, salto: 5, relacionadas: [],
    tp1: 'On Hit: Gain +', tp2: ' health'});
  stat_list.push({nombre: 'HolsterSpeed', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 30, maxValuePos: 45, maxValueNeg: 100, salto: 5, relacionadas: [],
    tp1: 'This weapon holsters ', tp2: '% faster', tn1: 'This weapon holsters ', tn2: '% slower'});
  stat_list.push({nombre: 'MeleeRange', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: true, maxScore: 50, maxValuePos: 70, salto: 10, relacionadas: [],
    tp1: '+', tp2: '% longer range'});
  stat_list.push({nombre: 'ThreeHitCrit', tipo: StatTypes.UNIQUE_TEXT, positivo: true, maxScore: 25, relacionadas: [],
    tp1: 'Third successful hit in a row always crits.'});
  
  // NOTE mover para que no solo aplique a armas melee?
  stat_list.push({nombre: 'LTHalfHpDmg', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 35, maxValuePos: 25, maxValueNeg: 25, salto: 5, relacionadas: ['LTHalfHpDmgPlayers', 'LTHalfHpBuilds'],
    tp1: '+', tp2: '% increase in damage when health &lt;50% of max', tn1: '-', tn2: '% decrease in damage when health &lt;50% of max'});
  stat_list.push({nombre: 'GTHalfHpDmg', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 35, maxValuePos: 25, maxValueNeg: 25, salto: 5, relacionadas: ['GTHalfHpDmgPlayers', 'GTHalfHpBuilds'],
    tp1: '+', tp2: '% increase in damage when health &gt;50% of max', tn1: '-', tn2: '% decrease in damage when health &gt;50% of max'});
  stat_list.push({nombre: 'OnKillHp', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: true, maxScore: 60, maxValuePos: 50, salto: 5, relacionadas: [],
    tp1: 'On Kill: Gain +', tp2: ' health'});
}

/**************************************************************************************************
											                  ARMAS ESPECÍFICAS
**************************************************************************************************/

function set_stats_medi_gun(stat_list) {
  stat_list.push({nombre: 'HealRate', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 40, maxValuePos: 40, maxValueNeg: 15, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% heal rate', tn1: '-', tn2: '% heal rate'});
  stat_list.push({nombre: 'UberRate', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 60, maxValuePos: 65, maxValueNeg: 30, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% ÜberCharge rate', tn1: '-', tn2: '% ÜberCharge rate'});
  stat_list.push({nombre: 'OverhealRate', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 25, maxValuePos: 30, maxValueNeg: 65, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% Overheal build rate', tn1: '-', tn2: '% Overheal build rate'});
}

function set_stats_sniper_rifle(stat_list) {
  // TODO accuracy?
  eliminarStatPorNombre(stat_list, 'Accuracy');

  stat_list.push({nombre: 'RifleChargeRate', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 45, maxValuePos: 30, maxValueNeg: 30, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% charge rate', tn1: '-', tn2: '% charge rate'});
  stat_list.push({nombre: 'HeadshotsMinicrit', tipo: StatTypes.UNIQUE_TEXT, positivo: false, maxScore: 40, relacionadas: ['MinicritsWhenCrit'],
    tn1: 'Headshots Mini-crit instead of crit'});
  stat_list.push({nombre: 'HeadshotsNeedCharge', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: false, maxScore: 40, maxValueNeg: 90, salto: 10, relacionadas: ['HeadshotsNeedFullCharge'],
    tn1: 'Headshots only when charge is ', tn2: '% or more'});
  stat_list.push({nombre: 'HeadshotsNeedFullCharge', tipo: StatTypes.UNIQUE_TEXT, positivo: false, maxScore: 50, relacionadas: ['HeadshotsNeedCharge'],
    tn1: 'No headshots when not fully charged'});
  stat_list.push({nombre: 'CannotNoScope', tipo: StatTypes.UNIQUE_TEXT, positivo: false, maxScore: 25, relacionadas: [],
    tn1: 'Cannot fire unless zoomed'});
  stat_list.push({nombre: 'ChargeDmgMultiplier', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 30, maxValuePos: 25, maxValueNeg: 30, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% damage multiplier based on charge', tn1: '-', tn2: '% damage multiplier based on charge'});
  stat_list.push({nombre: 'DmgBodyshots', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: false, maxScore: 25, maxValueNeg: 25, salto: 5, relacionadas: [],
    tn1: '-', tn2: '% damage on body shot'});
  // todo debuff on charge
}

function set_stats_revolver(stat_list) {
  // TODO headshots?
  stat_list.push({nombre: 'RevolverCloakHit', tipo: StatTypes.UNIQUE_ZERO_TO_MAX, positivo: true, maxScore: 20, maxValuePos: 25, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% cloak on hit'});
  stat_list.push({nombre: 'RevolverCloakDuration', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 35, maxValuePos: 50, maxValueNeg: 20, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% cloak duration', tn1: '-', tn2: '% cloak duration'});
  stat_list.push({nombre: 'RevolverCloakRegen', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 35, maxValuePos: 50, maxValueNeg: 35, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% cloak regen rate', tn1: '-', tn2: '% cloak regen rate'});
    // todo piercing attacks
  stat_list.push({nombre: 'RevolverDmgDisguised', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 15, maxValuePos: 25, maxValueNeg: 25, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% damage bonus while disguised', tn1: '-', tn2: '% damage penalty while disguised'});
  stat_list.push({nombre: 'RevolverDmgUndisguised', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 20, maxValuePos: 25, maxValueNeg: 25, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% damage bonus while undisguised', tn1: '-', tn2: '% damage penalty while undisguised'});
  stat_list.push({nombre: 'CritStabSap', tipo: StatTypes.UNIQUE_TEXT, positivo: true, maxScore: 50, relacionadas: ['CritStab', 'CritSap', 'MinicritStabSap', 'MinicritStab', 'MinicritSap', 'MinicritsWhenCrit'],
    tp1: 'Gives one guaranteed critical hit for each building destroyed with your sapper attached or backstab kill'});
  stat_list.push({nombre: 'CritStab', tipo: StatTypes.UNIQUE_TEXT, positivo: true, maxScore: 50, relacionadas: ['CritStabSap', 'CritSap', 'MinicritStabSap', 'MinicritStab', 'MinicritsWhenCrit'],
    tp1: 'Gives one guaranteed critical hit for each backstab kill'});
  stat_list.push({nombre: 'CritSap', tipo: StatTypes.UNIQUE_TEXT, positivo: true, maxScore: 50, relacionadas: ['CritStabSap', 'CritStab', 'MinicritStabSap', 'MinicritSap', 'MinicritsWhenCrit'],
    tp1: 'Gives one guaranteed critical hit for each building destroyed with your sapper attached'});
  stat_list.push({nombre: 'MinicritStabSap', tipo: StatTypes.UNIQUE_TEXT, positivo: true, maxScore: 30, relacionadas: ['CritStabSap', 'CritStab', 'CritSap', 'MinicritStab', 'MinicritSap', 'CritsWhenMinicrit'],
    tp1: 'Gives one guaranteed Mini-crit for each building destroyed with your sapper attached or backstab kill'});
  stat_list.push({nombre: 'MinicritStab', tipo: StatTypes.UNIQUE_TEXT, positivo: true, maxScore: 15, relacionadas: ['CritStabSap', 'CritStab', 'MinicritStabSap', 'MinicritSap', 'CritsWhenMinicrit'],
    tp1: 'Gives one guaranteed Mini-crit for each backstab kill'});
  stat_list.push({nombre: 'MinicritSap', tipo: StatTypes.UNIQUE_TEXT, positivo: true, maxScore: 15, relacionadas: ['CritStabSap', 'CritSap', 'MinicritStabSap', 'MinicritStab', 'CritsWhenMinicrit'],
    tp1: 'Gives one guaranteed Mini-crit for each building destroyed with your sapper attached'});
  // TODO HEADSHOTS?
  stat_list.push({nombre: 'DmgSappedBuilds', tipo: StatTypes.BOTH_ZERO_TO_MAX, maxScore: 30, maxValuePos: 20, maxValueNeg: 20, salto: 5, relacionadas: [],
    tp1: '+', tp2: '% damage bonus on sapped buildings', tn1: '-', tn2: '% damage penalty on sapped buildings'});
}

function set_stats_sapper(stat_list) {
  stat_list
}

function eliminarStatPorNombre(stat_list, nombreBuscado) {
  const index = stat_list.findIndex(stat => stat.nombre === nombreBuscado);
  if (index !== -1) {
    stat_list.splice(index, 1);
    console.log(`Elemento con nombre "${nombreBuscado}" eliminado.`);
  }
}