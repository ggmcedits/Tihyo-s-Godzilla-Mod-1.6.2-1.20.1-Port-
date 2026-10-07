package tihyo.godzilla;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import tihyo.godzilla.registry.ModBlocks;
import tihyo.godzilla.registry.ModCreativeTabs;
import tihyo.godzilla.registry.ModEntities;
import tihyo.godzilla.registry.ModItems;
import tihyo.godzilla.registry.ModSounds;

/**
 * Godzilla Mod, ported from the original 1.6.2 mod by Tihyo (Cody Lee) to 1.20.1 Forge.
 * Private port - see PORTING_NOTES.md.
 */
@Mod(GodzillaMod.MODID)
public class GodzillaMod {
    public static final String MODID = "godzilla";

    public GodzillaMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.BLOCKS.register(bus);
        ModItems.ITEMS.register(bus);
        ModEntities.ENTITY_TYPES.register(bus);
        ModSounds.SOUNDS.register(bus);
        ModCreativeTabs.TABS.register(bus);
    }
}
