let selected_class = 'randomClass';
let selected_slot = 'randomSlot';
let selected_type = null;

const slotsContainer = document.getElementById('imgButtonsSlots');
const tiposContainer = document.getElementById('imgButtonsTypes');

function addExtraSlot(image, value) {
  if (!document.querySelector('.slot.extra')) {
    const img = document.createElement('img');
    img.src = `img/${image}`;
    img.className = 'boton-opcion slot extra';
    img.dataset.valor = value;
    slotsContainer.appendChild(img);

    slotsContainer.classList.add('imgButtons5');
    slotsContainer.classList.remove('imgButtons4');

    img.addEventListener('click', () => selectSlot(img));
  }
}

function removeExtraSlot() {
  const extra = document.querySelector('.slot.extra');
  if (extra) {
    if (extra.classList.contains('selected')) {
      document.querySelector('.slot.selected')?.classList.remove('selected');
      const defaultSlot = document.querySelector('.slot[data-valor="Melee"]');
      defaultSlot.classList.add('selected');
      selected_slot = 'Melee';
    }

    extra.remove();
    slotsContainer.classList.add('imgButtons4');
    slotsContainer.classList.remove('imgButtons5');
  }
}

document.querySelectorAll('.clase').forEach(img => {
  img.addEventListener('click', () => {
    AudioBoton();
    if (!img.classList.contains('selected')) {
      document.querySelector('.clase.selected')?.classList.remove('selected');
      img.classList.add('selected');
      selected_class = img.dataset.valor;
      console.log('selected class:', selected_class);

      if (selected_class == 'Spy') {
        addExtraSlot("special.png", 'Special');
      } else {
        removeExtraSlot();
      }

      toggleTipos(selected_slot != 'randomSlot' && selected_class != 'randomClass');
    }
  });
});

function selectSlot(img) {
  if (!img.classList.contains('selected')) {
    document.querySelector('.slot.selected')?.classList.remove('selected');
    img.classList.add('selected');
    selected_slot = img.dataset.valor;

    console.log('selected slot', selected_slot);
    toggleTipos(selected_slot != 'randomSlot' && selected_class != 'randomClass');
  }
}

document.querySelectorAll('.slot').forEach(img => {
  img.addEventListener('click', () => {
    AudioBoton();
    selectSlot(img)
  });
});

function toggleTipos(show) {
  tiposContainer.innerHTML = '';
  
  let resultado = class_slot_map.get(selected_class + " " + selected_slot)
  console.log(resultado)

  if(resultado && resultado.length != 0) {

    if(resultado.length > 1) {
      const elementoRandom = document.createElement('img');
      elementoRandom.classList.add('boton-opcion');
      elementoRandom.classList.add('tipo');
      elementoRandom.classList.add('selected');
      elementoRandom.src = 'img/random.png';
      elementoRandom.setAttribute("data-valor", "randomType");

      elementoRandom.addEventListener('click', () => {
        AudioBoton();
        if(!elementoRandom.classList.contains('selected')) {
          document.querySelector('.tipo.selected')?.classList.remove('selected');
          elementoRandom.classList.add('selected');
          selected_type = elementoRandom.dataset.valor;
          console.log('selected type:', selected_type);
        }
      });

      tiposContainer.appendChild(elementoRandom);
    }

    for(var i=1; i<=6; i++) {
      tiposContainer.classList.remove('imgButtons' + i);
    }
    if(resultado.length == 1)
      tiposContainer.classList.add('imgButtons1');
    else
      tiposContainer.classList.add('imgButtons'+(resultado.length+1))

    // Para cada tipo de arma
    for(var i=0; i<resultado.length; i++) {
      let tipo = resultado[i];
      const elementoImagen = document.createElement('img');
      elementoImagen.classList.add('boton-opcion');
      elementoImagen.classList.add('tipo');
      if(resultado.length == 1)
        elementoImagen.classList.add('selected');
      elementoImagen.setAttribute('data-valor', i)
      
      let imagen = tipo.image;
      if(imagen)
        elementoImagen.src = imagen;

      // Si hacemos clic
      elementoImagen.addEventListener('click', () => {
        AudioBoton();
        if(!elementoImagen.classList.contains('selected')) {
          document.querySelector('.tipo.selected')?.classList.remove('selected');
          elementoImagen.classList.add('selected');
          selected_type = elementoImagen.dataset.valor;
          console.log('selected type:', selected_type);
        }
      });

      tiposContainer.appendChild(elementoImagen);
    }
  }

  document.querySelectorAll('.tipos').forEach(el => {
    if (show) {
      selected_type = 'randomType';
      el.classList.remove('hidden');
    } else {
      selected_type = null;
      el.classList.add('hidden');
    }
  });
}

function AudioBoton() {
  const audio = new Audio('./audio/tf2-button-click.mp3');
  audio.volume = 0.5;
  audio.play();
}