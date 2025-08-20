const imagenes = [
    'https://wiki.teamfortress.com/w/images/a/a1/Ctf_2fort_bridge_ss.png',
    'https://wiki.teamfortress.com/w/images/5/56/Cp_process_middle_point.png',
    'https://wiki.teamfortress.com/w/images/8/84/Snakewater_mid.png',
    'https://wiki.teamfortress.com/w/images/3/31/TF2_Dustbowl_Map.jpg',
];
const imagenAleatoria = imagenes[Math.floor(Math.random() * imagenes.length)];
document.body.style.backgroundImage = `url(${imagenAleatoria})`;
