package tihyo.godzilla.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tihyo.godzilla.GodzillaMod;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GodzillaMod.MODID);

    public static final RegistryObject<SoundEvent> GODZILLA_AMBIENT = register("entity.godzilla.ambient");
    public static final RegistryObject<SoundEvent> GODZILLA_HURT = register("entity.godzilla.hurt");
    public static final RegistryObject<SoundEvent> GODZILLA_DEATH = register("entity.godzilla.death");
    public static final RegistryObject<SoundEvent> GODZILLA_STEP = register("entity.godzilla.step");

    private static RegistryObject<SoundEvent> register(String name) {
        return SOUNDS.register(name,
                () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GodzillaMod.MODID, name)));
    }
}
