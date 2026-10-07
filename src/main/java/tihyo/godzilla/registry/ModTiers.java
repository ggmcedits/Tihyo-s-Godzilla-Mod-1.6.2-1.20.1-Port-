package tihyo.godzilla.registry;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class ModTiers {
    // Original: harvest 5, 1000 uses, speed 30, damage 10000, enchantability 0.
    // Player attack damage is capped at 2048 in vanilla, so the bonus is trimmed to 2000.
    public static final Tier OXYGEN_DESTROYER = new ForgeTier(4, 1000, 30.0F, 2000.0F, 0,
            Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.EMPTY);

    // Original: harvest 8, 100 uses, speed 15, damage 1000, enchantability 30
    public static final Tier G_SWORD = new ForgeTier(4, 100, 15.0F, 1000.0F, 30,
            Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(ModItems.G_CELL.get()));
}
