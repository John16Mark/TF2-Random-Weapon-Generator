var class_slot_map = new Map();
class_slot_map.set("Scout Primary", ["Scattergun"]);
class_slot_map.set("Scout Secondary", ["Pistol", "Drink", "Throwable AOE"]);
class_slot_map.set("Scout Melee", ["Bat", "Bat and Ball"]);

class_slot_map.set("Soldier Primary", ["Rocket Launcher"]);
class_slot_map.set("Soldier Secondary", ["Shotgun", "Banner", "Boots"]);
class_slot_map.set("Soldier Melee", ["Shovel"]);

class_slot_map.set("Pyro Primary", ["Flame Thrower"]);
class_slot_map.set("Pyro Secondary", ["Shotgun", "Flare Gun", "Throwable AOE"]);
class_slot_map.set("Pyro Melee", ["Fireaxe"]);

class_slot_map.set("Demoman Primary", ["Grenade Launcher", "Boots"]);
class_slot_map.set("Demoman Secondary", ["Stickybomb Launcher", "Shield"]);
class_slot_map.set("Demoman Melee", ["Bottle", "Sword"]);

class_slot_map.set("Heavy Primary", ["Minigun"]);
class_slot_map.set("Heavy Secondary", ["Shotgun", "Lunchbox"]);
class_slot_map.set("Heavy Melee", ["Fists"]);

class_slot_map.set("Engineer Primary", ["Shotgun"]);
class_slot_map.set("Engineer Secondary", ["Pistol"]);
class_slot_map.set("Engineer Melee", ["Wrench"]);

class_slot_map.set("Medic Primary", ["Syringe Gun"]);
class_slot_map.set("Medic Secondary", ["Medigun"]);
class_slot_map.set("Medic Melee", ["Bonesaw"]);

class_slot_map.set("Sniper Primary", ["Sniper Rifle"]);
class_slot_map.set("Sniper Secondary", ["SMG", "Throwable AOE", "Backpack"]);
class_slot_map.set("Sniper Melee", ["Kukri"]);

class_slot_map.set("Spy Primary", ["Revolver"]);
class_slot_map.set("Spy Secondary", ["Sapper"]);
class_slot_map.set("Spy Melee", ["Knife"]);
class_slot_map.set("Spy Special", ["Invis Watch"]);

var class_type_map = new Map();
class_type_map.set("Scout Scattergun", {image: 'https://wiki.teamfortress.com/w/images/7/74/Backpack_Scattergun.png'});
class_type_map.set("Scout Pistol", {image: 'https://wiki.teamfortress.com/w/images/f/f0/Backpack_Pistol.png'});
class_type_map.set("Scout Drink", {image: 'https://wiki.teamfortress.com/w/images/5/55/Backpack_Bonk%21_Atomic_Punch.png'});
class_type_map.set("Scout Throwable AOE", {image: 'https://wiki.teamfortress.com/w/images/0/0e/Backpack_Mad_Milk.png'});
class_type_map.set("Scout Bat", {image: 'https://wiki.teamfortress.com/w/images/d/d1/Backpack_Bat.png'});
class_type_map.set("Scout Bat and Ball", {image: 'https://wiki.teamfortress.com/w/images/f/f5/Backpack_Sandman.png'});

class_type_map.set("Soldier Rocket Launcher", {image: 'https://wiki.teamfortress.com/w/images/1/1d/Backpack_Rocket_Launcher.png'});
class_type_map.set("Soldier Shotgun", {image: 'https://wiki.teamfortress.com/w/images/c/c9/Backpack_Shotgun.png'});
class_type_map.set("Soldier Banner", {image: 'https://wiki.teamfortress.com/w/images/7/73/Backpack_Buff_Banner.png'});
class_type_map.set("Soldier Boots", {image: 'https://wiki.teamfortress.com/w/images/8/88/Backpack_Gunboats.png'});
class_type_map.set("Soldier Shovel", {image: 'https://wiki.teamfortress.com/w/images/c/c6/Backpack_Shovel.png'});

class_type_map.set("Pyro Flame Thrower", {image: 'https://wiki.teamfortress.com/w/images/3/33/Backpack_Flame_Thrower.png'});
class_type_map.set("Pyro Shotgun", {image: 'https://wiki.teamfortress.com/w/images/c/c9/Backpack_Shotgun.png'});
class_type_map.set("Pyro Flare Gun", {image: 'https://wiki.teamfortress.com/w/images/1/1d/Backpack_Flare_Gun.png'});
class_type_map.set("Pyro Throwable AOE", {image: 'https://wiki.teamfortress.com/w/images/5/53/Backpack_Gas_Passer.png'});
class_type_map.set("Pyro Fireaxe", {image: 'https://wiki.teamfortress.com/w/images/e/ea/Backpack_Fire_Axe.png'});

class_type_map.set("Demoman Grenade Launcher", {image: 'https://wiki.teamfortress.com/w/images/7/74/Backpack_Grenade_Launcher.png'});
class_type_map.set("Demoman Boots", {image: 'https://wiki.teamfortress.com/w/images/6/64/Backpack_Ali_Baba%27s_Wee_Booties.png'});
class_type_map.set("Demoman Stickybomb Launcher", {image: 'https://wiki.teamfortress.com/w/images/4/49/Backpack_Stickybomb_Launcher.png'});
class_type_map.set("Demoman Shield", {image: 'https://wiki.teamfortress.com/w/images/2/2f/Backpack_Chargin%27_Targe.png'});
class_type_map.set("Demoman Bottle", {image: 'https://wiki.teamfortress.com/w/images/7/72/Backpack_Bottle.png'});
class_type_map.set("Demoman Sword", {image: 'https://wiki.teamfortress.com/w/images/7/7e/Backpack_Eyelander.png'});

class_type_map.set("Heavy Minigun", {image: 'https://wiki.teamfortress.com/w/images/1/1f/Backpack_Minigun.png'});
class_type_map.set("Heavy Shotgun", {image: 'https://wiki.teamfortress.com/w/images/c/c9/Backpack_Shotgun.png'});
class_type_map.set("Heavy Lunchbox", {image: 'https://wiki.teamfortress.com/w/images/f/f4/Backpack_Sandvich.png'});
class_type_map.set("Heavy Fists", {image: 'https://wiki.teamfortress.com/w/images/c/c4/Backpack_Fists.png'});

class_type_map.set("Engineer Shotgun", {image: 'https://wiki.teamfortress.com/w/images/c/c9/Backpack_Shotgun.png'});
class_type_map.set("Engineer Pistol", {image: 'https://wiki.teamfortress.com/w/images/f/f0/Backpack_Pistol.png'});
class_type_map.set("Engineer Wrench", {image: 'https://wiki.teamfortress.com/w/images/5/52/Backpack_Wrench.png'});

class_type_map.set("Medic Syringe Gun", {image: 'https://wiki.teamfortress.com/w/images/b/bf/Backpack_Syringe_Gun.png'});
class_type_map.set("Medic Medigun", {image: 'https://wiki.teamfortress.com/w/images/c/c7/Backpack_Medi_Gun.png'});
class_type_map.set("Medic Bonesaw", {image: 'https://wiki.teamfortress.com/w/images/9/95/Backpack_Bonesaw.png'});

class_type_map.set("Sniper Sniper Rifle", {image: 'https://wiki.teamfortress.com/w/images/3/30/Backpack_Sniper_Rifle.png'});
class_type_map.set("Sniper SMG", {image: 'https://wiki.teamfortress.com/w/images/e/ee/Backpack_SMG.png'});
class_type_map.set("Sniper Throwable AOE", {image: 'https://wiki.teamfortress.com/w/images/f/f8/Backpack_Jarate.png'});
class_type_map.set("Sniper Backpack", {image: 'https://wiki.teamfortress.com/w/images/6/6d/Backpack_Cozy_Camper.png'});
class_type_map.set("Sniper Kukri", {image: 'https://wiki.teamfortress.com/w/images/b/b8/Backpack_Kukri.png'});

class_type_map.set("Spy Revolver", {image: 'https://wiki.teamfortress.com/w/images/4/48/Backpack_Revolver.png'});
class_type_map.set("Spy Sapper", {image: 'https://wiki.teamfortress.com/w/images/d/de/Backpack_Electro_Sapper.png'});
class_type_map.set("Spy Knife", {image: 'https://wiki.teamfortress.com/w/images/1/12/Backpack_Knife.png'});
class_type_map.set("Spy Invis Watch", {image: 'https://wiki.teamfortress.com/w/images/d/d9/Backpack_Invisibility_Watch.png'});