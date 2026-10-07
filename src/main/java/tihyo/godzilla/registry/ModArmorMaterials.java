package tihyo.godzilla.registry;

import java.util.EnumMap;
import java.util.Map;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import tihyo.godzilla.GodzillaMod;

/**
 * G-Armor. Original: durability multiplier 100, enchantability 50 and protection values of
 * 450/5000/800/400 (effectively invulnerable). Modern armor is capped at 30 points, so the
 * defense values below simply saturate that cap and toughness is added to reach the same intent.
 */
public enum ModArmorMaterials implements ArmorMaterial {
    GODZILLA(GodzillaMod.MODID + ":garmor", 100, 50, 12.0F);

    private static final Map<ArmorItem.Type, Integer> BASE_DURABILITY = new EnumMap<>(ArmorItem.Type.class);
    private static final Map<ArmorItem.Type, Integer> DEFENSE = new EnumMap<>(ArmorItem.Type.class);

    static {
        BASE_DURABILITY.put(ArmorItem.Type.BOOTS, 13);
        BASE_DURABILITY.put(ArmorItem.Type.LEGGINGS, 15);
        BASE_DURABILITY.put(ArmorItem.Type.CHESTPLATE, 16);
        BASE_DURABILITY.put(ArmorItem.Type.HELMET, 11);
        DEFENSE.put(ArmorItem.Type.BOOTS, 6);
        DEFENSE.put(ArmorItem.Type.LEGGINGS, 10);
        DEFENSE.put(ArmorItem.Type.CHESTPLATE, 14);
        DEFENSE.put(ArmorItem.Type.HELMET, 8);
    }

    private final String name;
    private final int durabilityMultiplier;
    private final int enchantability;
    private final float toughness;

    ModArmorMaterials(String name, int durabilityMultiplier, int enchantability, float toughness) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.enchantability = enchantability;
        this.toughness = toughness;
    }

    @Override public int getDurabilityForType(ArmorItem.Type type) { return BASE_DURABILITY.get(type) * durabilityMultiplier; }
    @Override public int getDefenseForType(ArmorItem.Type type) { return DEFENSE.get(type); }
    @Override public int getEnchantmentValue() { return enchantability; }
    @Override public SoundEvent getEquipSound() { return SoundEvents.ARMOR_EQUIP_NETHERITE; }
    @Override public Ingredient getRepairIngredient() { return Ingredient.of(ModItems.G_CELL.get()); }
    @Override public String getName() { return name; }
    @Override public float getToughness() { return toughness; }
    @Override public float getKnockbackResistance() { return 0.0F; }
}
