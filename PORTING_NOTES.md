# Godzilla Mod - 1.6.2 -> 1.20.1 Forge (private port)

Original mod: **Godzilla Mod v1.1 by Tihyo (Cody Lee)**. Its Terms and Conditions allow personal use but
forbid redistribution without the author's written permission. **Keep this port private.**

## Building
Requires JDK 17.

**Option A - drop into an MDK (easiest):** download the Forge 1.20.1 MDK (47.3.0), then copy
`src/` and `gradle.properties` from here over the MDK's, and run `./gradlew build`
(or `./gradlew runClient` to test). The jar lands in `build/libs/`.

**Option B - use this folder as-is:** copy the `gradle/` folder + `gradlew`/`gradlew.bat` from any 1.20.1 MDK
into this folder, then `./gradlew build`.

## What was ported (all values read from the original bytecode)
| Thing | Original behaviour |
|---|---|
| Godzilla mob | 4x150 hitbox, fire immune, undead, 8x render scale, 5000 XP, never despawns, sound volume 5 |
| AI | swim, break doors, melee players/villagers, move through village, wander, watch player (100 blocks), hurt-by + nearest player/villager targeting |
| Drops | 64 G-Cell, 25 Godzilla Bone, 1 Godzilla Skull |
| Spawn | weight 1, group 1-1, creature category, beach / forest(hills) / ocean / plains |
| Items | G-Cell, Godzilla Bone, Godzilla Skull, Platinum Ingot, Bottle of Oxygen (glint), Micro-Oxygen Cell, Micro-Oxygen Ball |
| Oxygen Destroyer | single use; Wither II + Poison II for 10 s on hit; consumed on use |
| G-Sword | 100 uses, speed 15, damage 1000, enchantability 30 |
| G-Armor | durability x100, enchantability 50 |
| Platinum Ore | hardness 20, iron pickaxe, 5 veins/chunk, vein size 5, y 0-31 |
| Recipes | all 8 crafting recipes + 2 smelting recipes (ore -> ingot 5xp, Bottle of Oxygen -> Micro-Oxygen Cell 20xp) |
| Model | all 142 parts, UVs, pivots and rotations; head/mouth look and leg/claw walk animation |

## Deliberate differences
- **Godzilla max health 10000 -> 1024.** Vanilla caps the attribute at 1024.
- **Oxygen Destroyer damage bonus 10000 -> 2000** (player attack damage caps at 2048).
- **G-Armor protection.** Original values (450 / 5000 / 800 / 400) are meaningless under modern
  armor rules (cap of 30). Defense is set to saturate the cap and toughness 12 added.
- **Block/item IDs -> registry names** (e.g. `godzilla:g_cell`). Old worlds cannot be loaded.
- **Footstep sound** (`godzillafootstep.ogg` shipped but was unused in 1.6.2) is now Godzilla's step sound.
- **Sounds converted to mono** so they are positional in 1.20.1.
- Oxygen Destroyer is not consumed in creative mode.
- Mob category is `creature` as in the original; it spawns on solid ground via normal spawn rules.

## Not ported
- `OldModelGodzilla` + `oldgodzilla.png` - never used by the mod.
- `platinumplate.png` - texture shipped but no item used it.
- The old `.cfg` item/block ID config (IDs no longer exist).

## Things to double-check when you first run it
1. **Compile status:** I had no Java compiler or Forge in my sandbox, so this has not been built. If Gradle reports
   an error, send it to me and I will fix it.
2. **Spawn biomes:** the original used old biome constants; I mapped them to beach, forest, ocean and plains.
   Edit `data/godzilla/forge/biome_modifier/add_godzilla_spawn.json` to change.
   Because the hitbox is 150 blocks tall, natural spawns need a lot of open space and will be rare.
3. Use `/summon godzilla:godzilla` or the spawn egg to test quickly.
