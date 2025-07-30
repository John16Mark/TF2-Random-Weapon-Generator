/*******************************************************************
                             PUNTUACIONES
*******************************************************************/

var power_levels_map = new Map();
power_levels_map.set(0, {text: 'Trash',     positive_score: [0, 20],    negative_score: [35, 80]});
power_levels_map.set(1, {text: 'Weak',      positive_score: [8, 25],    negative_score: [28, 55]});
power_levels_map.set(2, {text: 'Balanced',  positive_score: [25, 40],   negative_score: [18, 32]});
power_levels_map.set(3, {text: 'Strong',    positive_score: [37, 52],   negative_score: [10, 27]});
power_levels_map.set(4, {text: 'Broken',    positive_score: [46, 140],  negative_score: [0, 20]});

/*******************************************************************
                        DEFINICIONES DE CLASE
*******************************************************************/

var class_map = new Map();
class_map.set('Scout', {ammoPrimary: 32, ammoSecondary: 36, icon: 'https://wiki.teamfortress.com/w/images/a/ad/Leaderboard_class_scout.png'});
class_map.set('Soldier', {ammoPrimary: 20, ammoSecondary: 32, icon: "https://wiki.teamfortress.com/w/images/9/96/Leaderboard_class_soldier.png"});
class_map.set('Pyro', {ammoPrimary: 200, ammoSecondary: 32, icon: "https://wiki.teamfortress.com/w/images/8/80/Leaderboard_class_pyro.png"});
class_map.set('Demoman', {ammoPrimary: 16, ammoSecondary: 24, icon: "https://wiki.teamfortress.com/w/images/4/47/Leaderboard_class_demoman.png"});
class_map.set('Heavy', {ammoPrimary: 200, ammoSecondary: 32, icon: "https://wiki.teamfortress.com/w/images/5/5a/Leaderboard_class_heavy.png"});
class_map.set('Engineer', {ammoPrimary: 32, ammoSecondary: 200, icon: "https://wiki.teamfortress.com/w/images/1/12/Leaderboard_class_engineer.png"});
class_map.set('Medic', {ammoPrimary: 150, ammoSecondary: null, icon: "https://wiki.teamfortress.com/w/images/e/e5/Leaderboard_class_medic.png"});
class_map.set('Sniper', {ammoPrimary: 25, ammoSecondary: 75, icon: "https://wiki.teamfortress.com/w/images/f/fe/Leaderboard_class_sniper.png"});
class_map.set('Spy', {ammoPrimary: 24, ammoSecondary: null, icon: "https://wiki.teamfortress.com/w/images/3/33/Leaderboard_class_spy.png"});

var class_slot_map = new Map();
class_slot_map.set('Scout Primary', [
  {nombre: 'Scattergun', clip_size: 6,
    properties: ['Weapon', 'Bullet', 'Shotgun'], image: 'https://wiki.teamfortress.com/w/images/7/74/Backpack_Scattergun.png'}]);
class_slot_map.set('Scout Secondary', [
  {nombre: 'Pistol', clip_size: 12,
    properties: ['Weapon', 'Bullet', 'RapidFire'], image: 'https://wiki.teamfortress.com/w/images/f/f0/Backpack_Pistol.png'},
  {nombre: 'Drink', clip_size: null,
    properties: ['Consumable'], image: 'https://wiki.teamfortress.com/w/images/5/55/Backpack_Bonk%21_Atomic_Punch.png'},
  {nombre: 'Throwable AOE', clip_size: null,
    properties: ['Consumable'], image: 'https://wiki.teamfortress.com/w/images/0/0e/Backpack_Mad_Milk.png'}]);
class_slot_map.set('Scout Melee', [
  {nombre: 'Bat', clip_size: null,
    properties: ['Weapon', 'Melee'], image: 'https://wiki.teamfortress.com/w/images/d/d1/Backpack_Bat.png'},
  {nombre: 'Bat and Ball', clip_size: null,
    properties: ['Weapon', 'Melee'], image: 'https://wiki.teamfortress.com/w/images/f/f5/Backpack_Sandman.png'}]);

class_slot_map.set('Soldier Primary', [
  {nombre: 'Rocket Launcher', clip_size: 4,
    properties: ['Weapon', 'Projectile', 'Explosive'], image: 'https://wiki.teamfortress.com/w/images/1/1d/Backpack_Rocket_Launcher.png'}]);
class_slot_map.set('Soldier Secondary', [
  {nombre: 'Shotgun', clip_size: 6,
    properties: ['Weapon', 'Bullet', 'Shotgun'], image: 'https://wiki.teamfortress.com/w/images/c/c9/Backpack_Shotgun.png'},
  {nombre: 'Banner', clip_size: null,
    properties: ['Passive'], image: 'https://wiki.teamfortress.com/w/images/7/73/Backpack_Buff_Banner.png'},
  {nombre: 'Boots', clip_size: null, image: 'https://wiki.teamfortress.com/w/images/8/88/Backpack_Gunboats.png'}]);
class_slot_map.set('Soldier Melee', [
  {nombre: 'Shovel',clip_size: null,
    properties: ['Weapon', 'Melee'], image: 'https://wiki.teamfortress.com/w/images/c/c6/Backpack_Shovel.png'}]);

class_slot_map.set('Pyro Primary', [
  {nombre: 'Flame Thrower', clip_size: null,
    properties: ['Weapon', 'Airblast'], image: 'https://wiki.teamfortress.com/w/images/3/33/Backpack_Flame_Thrower.png'}]);
class_slot_map.set('Pyro Secondary', [
  {nombre: 'Shotgun', clip_size: 6,
    properties: ['Weapon', 'Bullet', 'Shotgun'], image: 'https://wiki.teamfortress.com/w/images/c/c9/Backpack_Shotgun.png'},
  {nombre: 'Flare Gun', clip_size: null,
    properties: ['Weapon', 'Projectile'], image: 'https://wiki.teamfortress.com/w/images/1/1d/Backpack_Flare_Gun.png'},
  {nombre: 'Throwable AOE', clip_size: null, image: 'https://wiki.teamfortress.com/w/images/5/53/Backpack_Gas_Passer.png'}]);
class_slot_map.set('Pyro Melee', [
  {nombre: 'Fireaxe', clip_size: null, image: 'https://wiki.teamfortress.com/w/images/e/ea/Backpack_Fire_Axe.png'}]);

class_slot_map.set('Demoman Primary', [
  {nombre: 'Grenade Launcher', clip_size: 4, image: 'https://wiki.teamfortress.com/w/images/7/74/Backpack_Grenade_Launcher.png'},
  {nombre: 'Boots', clip_size: null, image: 'https://wiki.teamfortress.com/w/images/6/64/Backpack_Ali_Baba%27s_Wee_Booties.png'}]);
class_slot_map.set('Demoman Secondary', [
  {nombre: 'Stickybomb Launcher', clip_size: 8, image: 'https://wiki.teamfortress.com/w/images/4/49/Backpack_Stickybomb_Launcher.png'},
  {nombre: 'Shield', clip_size: null, image: 'https://wiki.teamfortress.com/w/images/2/2f/Backpack_Chargin%27_Targe.png'}]);
class_slot_map.set('Demoman Melee', [
  {nombre: 'Bottle', clip_size: null, image: 'https://wiki.teamfortress.com/w/images/7/72/Backpack_Bottle.png'},
  {nombre: 'Sword', clip_size: null, image: 'https://wiki.teamfortress.com/w/images/7/7e/Backpack_Eyelander.png'}]);

class_slot_map.set('Heavy Primary', [
  {nombre: 'Minigun', clip_size: null, image: 'https://wiki.teamfortress.com/w/images/1/1f/Backpack_Minigun.png'}]);
class_slot_map.set('Heavy Secondary', [
  {nombre: 'Shotgun', clip_size: 6, image: 'https://wiki.teamfortress.com/w/images/c/c9/Backpack_Shotgun.png'},
  {nombre: 'Lunchbox', clip_size: null, image: 'https://wiki.teamfortress.com/w/images/f/f4/Backpack_Sandvich.png'}]);
class_slot_map.set('Heavy Melee', [
  {nombre: 'Fists', clip_size: null, image: 'https://wiki.teamfortress.com/w/images/c/c4/Backpack_Fists.png'}]);

class_slot_map.set('Engineer Primary', [
  {nombre: 'Shotgun', clip_size: 6, image: 'https://wiki.teamfortress.com/w/images/c/c9/Backpack_Shotgun.png'}]);
class_slot_map.set('Engineer Secondary', [
  {nombre: 'Pistol', clip_size: 12, image: 'https://wiki.teamfortress.com/w/images/f/f0/Backpack_Pistol.png'}]);
class_slot_map.set('Engineer Melee', [
  {nombre: 'Wrench', clip_size: null, image: 'https://wiki.teamfortress.com/w/images/5/52/Backpack_Wrench.png'}]);

class_slot_map.set('Medic Primary', [
  {nombre: 'Syringe Gun', clip_size: 50, image: 'https://wiki.teamfortress.com/w/images/b/bf/Backpack_Syringe_Gun.png'}]);
class_slot_map.set('Medic Secondary', [
  {nombre: 'Medigun', clip_size: null, image: 'https://wiki.teamfortress.com/w/images/c/c7/Backpack_Medi_Gun.png'}]);
class_slot_map.set('Medic Melee', [
  {nombre: 'Bonesaw', clip_size: null, image: 'https://wiki.teamfortress.com/w/images/9/95/Backpack_Bonesaw.png'}]);

class_slot_map.set('Sniper Primary', [
  {nombre: 'Sniper Rifle', clip_size: null, image: 'https://wiki.teamfortress.com/w/images/3/30/Backpack_Sniper_Rifle.png'}]);
class_slot_map.set('Sniper Secondary', [
  {nombre: 'SMG', clip_size: 25, image: 'https://wiki.teamfortress.com/w/images/e/ee/Backpack_SMG.png'},
  {nombre: 'Throwable AOE', clip_size: null, image: 'https://wiki.teamfortress.com/w/images/f/f8/Backpack_Jarate.png'},
  {nombre: 'Backpack', clip_size: null, image: 'https://wiki.teamfortress.com/w/images/6/6d/Backpack_Cozy_Camper.png'}]);
class_slot_map.set('Sniper Melee', [
  {nombre: 'Kukri', clip_size: null, image: 'https://wiki.teamfortress.com/w/images/b/b8/Backpack_Kukri.png'}]);

class_slot_map.set('Spy Primary', [
  {nombre: 'Revolver', clip_size: 6, image: 'https://wiki.teamfortress.com/w/images/4/48/Backpack_Revolver.png'}]);
class_slot_map.set('Spy Secondary', [
  {nombre: 'Sapper', clip_size: null, image: 'https://wiki.teamfortress.com/w/images/d/de/Backpack_Electro_Sapper.png'}]);
class_slot_map.set('Spy Melee', [
  {nombre: 'Knife', clip_size: null, image: 'https://wiki.teamfortress.com/w/images/1/12/Backpack_Knife.png'}]);
class_slot_map.set('Spy Special', [
  {nombre: 'Invis Watch', clip_size: null, image: 'https://wiki.teamfortress.com/w/images/d/d9/Backpack_Invisibility_Watch.png'}]);

function random_int(number) {
  return Math.floor(Math.random() * number);
}