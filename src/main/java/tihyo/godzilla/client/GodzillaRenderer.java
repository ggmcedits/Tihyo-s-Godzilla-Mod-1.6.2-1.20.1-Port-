package tihyo.godzilla.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import tihyo.godzilla.GodzillaMod;
import tihyo.godzilla.entity.GodzillaEntity;

public class GodzillaRenderer extends MobRenderer<GodzillaEntity, GodzillaModel> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(GodzillaMod.MODID, "textures/entity/godzilla.png");

    public GodzillaRenderer(EntityRendererProvider.Context context) {
        // Original shadow size was 0.3 * 0 = 0
        super(context, new GodzillaModel(context.bakeLayer(GodzillaModel.LAYER_LOCATION)), 0.0F);
    }

    @Override
    protected void scale(GodzillaEntity entity, PoseStack poseStack, float partialTick) {
        poseStack.scale(8.0F, 8.0F, 8.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(GodzillaEntity entity) {
        return TEXTURE;
    }
}
