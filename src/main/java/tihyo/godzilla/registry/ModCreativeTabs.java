package tihyo.godzilla.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import tihyo.godzilla.GodzillaMod;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GodzillaMod.MODID);

    public static final RegistryObject<CreativeModeTab> GODZILLA_TAB = TABS.register("godzilla",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.godzilla"))
                    .icon(() -> new ItemStack(ModItems.OXYGEN_DESTROYER.get()))
                    .displayItems((params, output) ->
                            ModItems.ITEMS.getEntries().forEach(item -> output.accept(item.get())))
                    .build());
}
