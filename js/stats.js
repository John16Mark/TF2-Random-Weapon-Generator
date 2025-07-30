const positiveMin = document.getElementById('positive-min');
const positiveMax = document.getElementById('positive-max');
const positiveOutput = document.getElementById('positive-output');
const positiveSlider = document.getElementById('positive-slider');

const negativeMin = document.getElementById('negative-min');
const negativeMax = document.getElementById('negative-max');
const negativeOutput = document.getElementById('negative-output');
const negativeSlider = document.getElementById('negative-slider');

const powerMin = document.getElementById('power-min');
const powerMax = document.getElementById('power-max');
const powerOutput = document.getElementById('power-output');
const powerSlider = document.getElementById('power-slider');

function adjustZIndex(inputMin, minValue, inputMax, maxValue) {
  if((minValue == 0) && (maxValue == 0)) {
    inputMin.style.zIndex = 4;
    inputMax.style.zIndex = 5;
  } else {
    inputMin.style.zIndex = 5;
    inputMax.style.zIndex = 4;
  }
}

function updateSlider(isMax, slider, sliderMin, sliderMax, output) {
  let minValue = parseInt(sliderMin.value);
  let maxValue = parseInt(sliderMax.value);

  // Evitar rangos inválidos
  if(minValue > maxValue) {
    if(isMax) {
      maxValue = minValue;
      sliderMax.value = maxValue;
    } else {
      minValue = maxValue;
      sliderMin.value = minValue;
    }
  }
  
  // Ajustar Z-Index de los sliders
  adjustZIndex(sliderMin, minValue, sliderMax, maxValue);

  // Ajustar máscara del track
  const total = sliderMin.max - sliderMin.min;
  const leftPercent = (minValue / total) * 100;
  const rightPercent = 100 - (maxValue / total) * 100;

  slider.style.setProperty('--left-mask', leftPercent + '%');
  slider.style.setProperty('--right-mask', rightPercent + '%');

  if(slider == powerSlider) {
    minValue = power_levels_map.get(minValue).text;
    maxValue = power_levels_map.get(maxValue).text;
  }
  if(minValue == maxValue)
    output.textContent = `${maxValue}`;
  else
    output.textContent = `${minValue} - ${maxValue}`;
}



positiveMin.addEventListener('input', () => {
  updateSlider(false, positiveSlider, positiveMin, positiveMax, positiveOutput);
});
positiveMax.addEventListener('input', () => {
  updateSlider(true, positiveSlider, positiveMin, positiveMax, positiveOutput);
});
updateSlider(false, positiveSlider, positiveMin, positiveMax, positiveOutput);

negativeMin.addEventListener('input', () => {
  updateSlider(false, negativeSlider, negativeMin, negativeMax, negativeOutput);
});
negativeMax.addEventListener('input', () => {
  updateSlider(true, negativeSlider, negativeMin, negativeMax, negativeOutput);
});
updateSlider(false, negativeSlider, negativeMin, negativeMax, negativeOutput);

powerMin.addEventListener('input', () => {
  updateSlider(false, powerSlider, powerMin, powerMax, powerOutput);
});
powerMax.addEventListener('input', () => {
  updateSlider(true, powerSlider, powerMin, powerMax, powerOutput);
});
updateSlider(false, powerSlider, powerMin, powerMax, powerOutput);