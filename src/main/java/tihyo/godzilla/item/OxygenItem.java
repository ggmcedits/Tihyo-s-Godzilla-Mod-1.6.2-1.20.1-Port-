package tihyo.godzilla.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/** Bottle of Oxygen - always has the enchantment glint, like the original. */
public class OxygenItem extends Item {

    public OxygenItem(Item.Properties props) {
        super(props);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
