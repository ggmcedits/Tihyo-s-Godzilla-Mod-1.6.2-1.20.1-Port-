package tihyo.godzilla.registry;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tihyo.godzilla.GodzillaMod;
import tihyo.godzilla.item.OxygenDestroyerItem;
import tihyo.godzilla.item.OxygenItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GodzillaMod.MODID);

    private static Item.Properties props() { return new Item.Properties(); }

    // --- materials
    public static final RegistryObject<Item> G_CELL = ITEMS.register("g_cell", () -> new Item(props()));
    public static final RegistryObject<Item> GODZILLA_BONE = ITEMS.register("godzilla_bone", () -> new Item(props()));
    public static final RegistryObject<Item> GODZILLA_SKULL = ITEMS.register("godzilla_skull", () -> new Item(props()));
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", () -> new Item(props()));
    public static final RegistryObject<Item> BOTTLE_OF_OXYGEN = ITEMS.register("bottle_of_oxygen", () -> new OxygenItem(props()));
    public static final RegistryObject<Item> MICRO_OXYGEN_CELL = ITEMS.register("micro_oxygen_cell", () -> new Item(props()));
    public static final RegistryObject<Item> MICRO_OXYGEN_BALL = ITEMS.register("micro_oxygen_ball", () -> new Item(props()));

    // --- weapons (sword base damage 3 + tier bonus, normal sword swing speed)
    public static final RegistryObject<Item> OXYGEN_DESTROYER = ITEMS.register("oxygen_destroyer",
            () -> new OxygenDestroyerItem(ModTiers.OXYGEN_DESTROYER, 3, -2.4F, props().stacksTo(1)));
    public static final RegistryObject<Item> G_SWORD = ITEMS.register("g_sword",
            () -> new SwordItem(ModTiers.G_SWORD, 3, -2.4F, props().stacksTo(1)));

    // --- armor
    public static final RegistryObject<Item> G_HELMET = ITEMS.register("g_helmet",
            () -> new ArmorItem(ModArmorMaterials.GODZILLA, ArmorItem.Type.HELMET, props()));
    public static final RegistryObject<Item> G_CHESTPLATE = ITEMS.register("g_chestplate",
            () -> new ArmorItem(ModArmorMaterials.GODZILLA, ArmorItem.Type.CHESTPLATE, props()));
    public static final RegistryObject<Item> G_LEGGINGS = ITEMS.register("g_leggings",
            () -> new ArmorItem(ModArmorMaterials.GODZILLA, ArmorItem.Type.LEGGINGS, props()));
    public static final RegistryObject<Item> G_BOOTS = ITEMS.register("g_boots",
            () -> new ArmorItem(ModArmorMaterials.GODZILLA, ArmorItem.Type.BOOTS, props()));

    // --- block item + spawn egg (egg colours 3050327 / 32768 from the original)
    public static final RegistryObject<Item> PLATINUM_ORE = ITEMS.register("platinum_ore",
            () -> new BlockItem(ModBlocks.PLATINUM_ORE.get(), props()));
    public static final RegistryObject<Item> GODZILLA_SPAWN_EGG = ITEMS.register("godzilla_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.GODZILLA, 3050327, 32768, props()));
}
