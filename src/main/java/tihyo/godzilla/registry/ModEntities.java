package tihyo.godzilla.registry;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tihyo.godzilla.GodzillaMod;
import tihyo.godzilla.entity.GodzillaEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GodzillaMod.MODID);

    // Original hitbox: 4 wide x 150 tall, fire immune, tracked at 80 blocks, update every tick
    public static final RegistryObject<EntityType<GodzillaEntity>> GODZILLA = ENTITY_TYPES.register("godzilla",
            () -> EntityType.Builder.of(GodzillaEntity::new, MobCategory.CREATURE)
                    .sized(4.0F, 150.0F)
                    .fireImmune()
                    .clientTrackingRange(10)
                    .updateInterval(1)
                    .build("godzilla"));
}
