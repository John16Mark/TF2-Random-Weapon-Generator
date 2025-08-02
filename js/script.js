document.addEventListener('DOMContentLoaded', () => {

let btnGenerar = document.getElementById('generar');
let titulo = document.getElementById('title');
let imagen = document.getElementById('WeaponImage');
let sello = document.getElementById('sello');

let labelNeutral1 = document.getElementById('neutral1');
let labelPositive1 = document.getElementById('positive1');
let labelNegative1 = document.getElementById('negative1');

btnGenerar.addEventListener('click', () => {
  let clase;
  let slot;
  let tipo;

  let positive_min;
  let positive_max;
  let negative_min;
  let negative_max;
  let power_min;
  let power_max;

  let positive_score_min;
  let positive_score_max;
  let negative_score_min;
  let negative_score_max;
  let banner_score_min
  let banner_score_max;

  let primaryAmmo;
  let secondaryAmmo;

  let stats_all = [];
  let available_stats_positive = 0;
  let available_stats_negative = 0;
  let stats_blacklist = [];
  
  let stats_positive = [];
  let stats_negative = [];
  let stats_banner = [];
  
  let score_positive = 0;
  let score_negative = 0;
  

  obtener_datos_iniciales();
  set_stats_generic(stats_all, slot, primaryAmmo, secondaryAmmo);
  if(tipo.tipo == 'Weapon' || tipo.tipo == 'Medigun' || tipo.tipo == 'Sapper')
    set_stats_weapon(stats_all, tipo.tipo, tipo.clip_size, slot);
  for(var i=0; i<tipo.properties.length; i++) {
    let propiedad = tipo.properties[i];
    if(propiedad == 'Bullet')
      set_stats_bullets(stats_all);
    else if(propiedad == 'Shotgun')
      set_stats_shotgun(stats_all);
    else if(propiedad == 'Projectile')
      set_stats_projectile(stats_all);
    else if(propiedad == 'Explosive')
      set_stats_explosive(stats_all);
    else if(propiedad == 'Melee')
      set_stats_melee(stats_all);
    else
      console.error('')
  }
  ordenar_stats();
  anadir_stats();
  mostrar_arma();

  console.table(stats_all);
  console.table(stats_positive);
  console.table(stats_negative);
  console.log('Score positive', score_positive);
  console.log('Score negative', score_negative);
  
  function obtener_datos_iniciales() {
    clase = document.querySelector('.clase.selected').getAttribute('data-valor');
    if(clase == 'randomClass') {
      let keys = Array.from(class_map.keys());
      clase = keys[random_int(class_map.size)];
    }

    slot = document.querySelector('.slot.selected').getAttribute('data-valor');
    if(slot == 'randomSlot') {
      let slotsArray = ['Primary', 'Secondary', 'Melee', 'Special'];
      if(clase == 'Spy')
        slot = slotsArray[random_int(4)];
      else
        slot = slotsArray[random_int(3)];
    }

    tipo = document.querySelector('.tipo.selected');
    let tiposArray = class_slot_map.get(clase + " " + slot)
    if(tipo) {
      tipo = tipo.getAttribute('data-valor');
      if(tipo == 'randomType')
        tipo = tiposArray[random_int(tiposArray.length)];
      else 
        tipo = tiposArray[tipo];
    } else {
      tipo = tiposArray[random_int(tiposArray.length)];
    }

    positive_min = parseInt(document.getElementById('positive-min').value);
    positive_max = parseInt(document.getElementById('positive-max').value);
    negative_min = parseInt(document.getElementById('negative-min').value);
    negative_max = parseInt(document.getElementById('negative-max').value);

    power_min_object = power_levels_map.get(parseInt(document.getElementById('power-min').value));
    power_max_object = power_levels_map.get(parseInt(document.getElementById('power-max').value));
    power_min = power_min_object.text;
    power_max = power_max_object.text;
    
    primaryAmmo = class_map.get(clase).ammoPrimary;
    secondaryAmmo = class_map.get(clase).ammoSecondary;

    console.log("\x1b[94m --------------------- \x1b[0m");
    console.log("\x1b[92mclase\x1b[0m", clase);
    console.log("\x1b[92mslot\x1b[0m", slot);
    console.log("\x1b[92mtipo\x1b[0m", tipo);

    console.log("\x1b[93mPositve", positive_min + " - " + positive_max);
    console.log("\x1b[93mNegative", negative_min + " - " + negative_max);

    // Cambios en el front
    titulo.innerText = 'New '+tipo.nombre + ' for the ' + clase;
    imagen.src = tipo.image;
    sello.src = class_map.get(clase).icon;
    sello.classList.remove('hidden');
  }

  function ordenar_stats()
  {
    // Barajear el arreglo
    for (let i = stats_all.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [stats_all[i], stats_all[j]] = [stats_all[j], stats_all[i]];
    }

    // Ordenar por categorías
    stats_all.sort((a, b) => {
      function getPriority(stat) {
        if (stat.tipo.startsWith('UNIQUE')) {
          return stat.positivo ? 0 : 2;
        } else if (stat.tipo.startsWith('BOTH')) {
          return 1;
        }
        return 3;
      }
      return getPriority(a) - getPriority(b);
    });
    
    // Contar stats
    for(let i=0; i<stats_all.length; i++) {
      let stat = stats_all[i];
      count_stats(stat, true)
    }

  }

  function anadir_stats() {
    if(power_min == 'Trash' && power_max == 'Broken') {
      let n = random_int(negative_max - negative_min + 1) + negative_min;
      let p = random_int(positive_max - positive_min + 1) + positive_min;

      n = 2;
      p = 2;
      for(var i=0; i<p; i++) add_stat(stats_positive, true);
      for(var i=0; i<n; i++) add_stat(stats_negative, false);
      
    }
  }

  function add_stat(lista_stats, positive) {
    console.log("\x1b[95m --------------- \x1b[0m");
    console.log('\x1b[96m Positivos ', available_stats_positive);
    console.log('\x1b[96m Negativos ', available_stats_negative);
    var r = random_int(positive ? available_stats_positive : available_stats_negative);
    console.log('r', r);
    if(!positive)
      r = r+stats_all.length-available_stats_negative;
    console.log('r', r);
    let StatAux = JSON.parse(JSON.stringify(stats_all[r]));
    console.log('STAT', StatAux);

    stat_set_valores(StatAux, positive);
    lista_stats.push(StatAux);
    if(positive)
      score_positive += StatAux.score;
    else
      score_negative += StatAux.score;

    // Quitar los stats relacionados
    for(var i=0; i<StatAux.relacionadas.length; i++) {
      for(var j=0; j<stats_all.length; j++) {
        if(StatAux.relacionadas[i] === stats_all[j].nombre) {
          console.log('\x1b[91mEliminado: ', stats_all[j].nombre);
          count_stats(stats_all[j], false);
          stats_blacklist.push(stats_all[j].nombre);
          stats_all.splice(j, 1);
          break;
        }
      }
    }

    // Quitar stat seleccionado
    for(var j=0; j<stats_all.length; j++) {
      if(StatAux.nombre == stats_all[j].nombre) {
        console.log('\x1b[91mEliminado: ', StatAux.nombre);
        count_stats(StatAux, false);
        stats_blacklist.push(StatAux.nombre);
        stats_all.splice(j, 1);
      }
    }
    
    console.table(stats_all);
    console.log(stats_blacklist);
  }

  function count_stats(stat, suma) {
    if(suma) {
      if(stat.tipo.startsWith('BOTH')) {
        available_stats_positive++;
        available_stats_negative++;
      } else {
        if(stat.positivo)
          available_stats_positive++;
        else
          available_stats_negative++;
      }
    } else {
      if(stat.tipo.startsWith('BOTH')) {
        available_stats_positive--;
        available_stats_negative--;
      } else {
        if(stat.positivo) 
          available_stats_positive--;
        else 
          available_stats_negative--;
      }
    }
  }

  function mostrar_arma() {
    var texto = '';
    labelNeutral1.innerHTML = texto;

    texto = '';
    stats_positive.forEach(stat => {
      if(stat.tp1 != undefined && stat.tp1 != null)
        texto += stat.tp1;
      if(stat.valor != undefined && stat.valor != null)
        texto += stat.valor;
      if(stat.tp2 != undefined && stat.tp2 != null)
        texto += stat.tp2;
      texto += '<br>';
    });
    labelPositive1.innerHTML = texto;

    texto = '';
    stats_negative.forEach(stat => {
      if(stat.tn1 != undefined && stat.tn1 != null)
        texto += stat.tn1;
      if(stat.valor != undefined && stat.valor != null)
        texto += stat.valor;
      if(stat.tn2 != undefined && stat.tn2 != null)
        texto += stat.tn2;
      texto += '<br>';
    });
    labelNegative1.innerHTML = texto;
  }


});

/*******************************************************************
                          CONTROLAR SLIDERS
*******************************************************************/
  
});