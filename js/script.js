document.addEventListener('DOMContentLoaded', () => {

  let btnGenerar = document.getElementById('generar');
  let titulo = document.getElementById('title');
  let imagen = document.getElementById('WeaponImage');
  let sello = document.getElementById('sello');

  btnGenerar.addEventListener('click', () => {
    Generar();
  });

  function Generar() {
    let clase = document.querySelector('.clase.selected').getAttribute('data-valor');
    if(clase == 'randomClass') {
      let keys = Array.from(class_map.keys());
      clase = keys[random_int(class_map.size)];
    }

    let slot = document.querySelector('.slot.selected').getAttribute('data-valor');
    if(slot == 'randomSlot') {
      let slotsArray = ['Primary', 'Secondary', 'Melee', 'Special'];
      if(clase == 'Spy')
        slot = slotsArray[random_int(4)];
      else
        slot = slotsArray[random_int(3)];
    }

    let tipo = document.querySelector('.tipo.selected');
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

    let positive_min = parseInt(document.getElementById('positive-min').value);
    let positive_max = parseInt(document.getElementById('positive-max').value);
    let negative_min = parseInt(document.getElementById('negative-min').value);
    let negative_max = parseInt(document.getElementById('negative-max').value);
    
    console.log("\x1b[94m ------------ \x1b[0m");
    console.log("\x1b[92mclase\x1b[0m", clase);
    console.log("\x1b[92mslot\x1b[0m", slot);
    console.log("\x1b[92mtipo\x1b[0m", tipo);

    console.log("\x1b[93mPositve", positive_min + " - " + positive_max);
    console.log("\x1b[93mNegative", negative_min + " - " + negative_max);

    console.log(class_map);
    titulo.innerText = 'New '+tipo.nombre + ' for the ' + clase;
    imagen.src = tipo.image;
    sello.src = class_map.get(clase).icon;
    sello.classList.remove('hidden');
  }
/*******************************************************************
                          CONTROLAR SLIDERS
*******************************************************************/

});