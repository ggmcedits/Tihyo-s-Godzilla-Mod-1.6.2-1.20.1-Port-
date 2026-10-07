package tihyo.godzilla.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import tihyo.godzilla.GodzillaMod;
import tihyo.godzilla.entity.GodzillaEntity;

/**
 * Port of the 1.6.2 Techne-exported ModelGodzilla (142 flat parts, 128x128 texture).
 * Box, pivot and rotation data were recovered directly from the original class file.
 */
public class GodzillaModel extends EntityModel<GodzillaEntity> {
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(new ResourceLocation(GodzillaMod.MODID, "godzilla"), "main");

    private static final String[] HEAD_PARTS = { "Head", "Mouth" };
    // Parts that swing in phase with the right leg
    private static final String[] RIGHT_PARTS = { "LegUpperPartRight", "LegLowerPartRight", "RightFoot", "RightLegClaw1", "RightLegClaw2", "RightLegClaw3", "RightLegClaw4" };
    // Parts that swing in opposite phase (left leg)
    private static final String[] LEFT_PARTS = { "LegUpperPartLeft", "LegLowerPartLeft", "LeftFoot", "LeftLegClaw1", "LeftLegClaw2", "LeftLegClaw3", "LeftLegClaw4" };

    private final ModelPart root;
    private final ModelPart[] head = new ModelPart[HEAD_PARTS.length];
    private final ModelPart[] right = new ModelPart[RIGHT_PARTS.length];
    private final ModelPart[] left = new ModelPart[LEFT_PARTS.length];

    public GodzillaModel(ModelPart root) {
        this.root = root;
        for (int i = 0; i < head.length; i++) head[i] = root.getChild(HEAD_PARTS[i]);
        for (int i = 0; i < right.length; i++) right[i] = root.getChild(RIGHT_PARTS[i]);
        for (int i = 0; i < left.length; i++) left[i] = root.getChild(LEFT_PARTS[i]);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(26, 0).addBox(-5.0F, -15.0F, 0.0F, 10.0F, 15.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 7.0F, -4.0F, 0.1115358F, 0.0F, 0.0F));
        root.addOrReplaceChild("TailPart7", CubeListBuilder.create().texOffs(27, 87).addBox(-2.0F, -1.5F, 0.0F, 4.0F, 2.0F, 9.0F), PartPose.offsetAndRotation(0.0F, -0.3F, 49.5F, -0.5030442F, 0.0F, 0.0F));
        root.addOrReplaceChild("TailPart6", CubeListBuilder.create().texOffs(27, 87).addBox(-2.966667F, -1.5F, 0.0F, 6.0F, 3.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 3.0F, 39.0F, 0.2777067F, 0.0F, 0.0F));
        root.addOrReplaceChild("TailPart5", CubeListBuilder.create().texOffs(27, 87).addBox(-3.5F, -1.5F, 0.0F, 7.0F, 3.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 10.0F, 35.0F, 1.021279F, 0.0F, 0.0F));
        root.addOrReplaceChild("TailPart3", CubeListBuilder.create().texOffs(27, 87).addBox(-4.5F, -2.0F, 0.0F, 8.0F, 5.0F, 13.0F), PartPose.offsetAndRotation(0.5F, 16.5F, 14.0F, -0.0197222F, 0.0F, 0.0F));
        root.addOrReplaceChild("TailPart1", CubeListBuilder.create().texOffs(32, 82).addBox(-4.0F, -2.5F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 2.0F, -1.07818F, 0.0F, 0.0F));
        root.addOrReplaceChild("TailPart2", CubeListBuilder.create().texOffs(27, 92).addBox(-4.5F, -2.0F, -1.333333F, 9.0F, 6.0F, 13.0F), PartPose.offsetAndRotation(0.0F, 11.53333F, 5.0F, -0.4089647F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike1", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -0.5F, -4.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike2", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -2.5F, -4.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike3", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -4.5F, -4.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.806985F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike4", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -7.5F, -2.0F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.286485F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike5", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -9.5F, -2.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.286485F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike7", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -13.5F, -3.7F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.286485F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike8", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -15.5F, -0.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.026234F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike9", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -17.5F, -1.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.026234F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike10", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -19.5F, -2.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.026234F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike11", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -21.5F, -3.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.026234F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike12", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -23.5F, -4.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.026234F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike13", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -18.5F, 15.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("TailPart4", CubeListBuilder.create().texOffs(27, 87).addBox(-4.5F, -2.0F, 0.0F, 8.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(0.5F, 17.0F, 26.0F, 0.6494928F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike6", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -11.5F, -3.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.286485F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike14", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -20.5F, 15.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike15", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -24.5F, 16.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 2.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike16", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -24.5F, 14.9F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike17", CubeListBuilder.create().texOffs(113, 87).addBox(3.5F, -0.5F, -3.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike18", CubeListBuilder.create().texOffs(113, 87).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike19", CubeListBuilder.create().texOffs(113, 87).addBox(3.5F, -2.5F, -3.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike20", CubeListBuilder.create().texOffs(113, 87).addBox(-0.5F, -2.5F, -3.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike21", CubeListBuilder.create().texOffs(113, 87).addBox(3.5F, -4.5F, -3.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.806985F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike22", CubeListBuilder.create().texOffs(113, 87).addBox(-0.5F, -4.5F, -3.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.806985F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike23", CubeListBuilder.create().texOffs(113, 87).addBox(3.5F, -7.5F, -1.0F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.286485F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike24", CubeListBuilder.create().texOffs(113, 87).addBox(-0.5F, -7.5F, -1.0F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.286485F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike25", CubeListBuilder.create().texOffs(113, 87).addBox(3.5F, -9.5F, -1.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.286485F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike26", CubeListBuilder.create().texOffs(113, 87).addBox(-0.5F, -9.5F, -1.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.286485F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike27", CubeListBuilder.create().texOffs(113, 87).addBox(3.5F, -11.5F, -2.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.286485F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike28", CubeListBuilder.create().texOffs(113, 87).addBox(-0.5F, -11.5F, -2.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.286485F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike29", CubeListBuilder.create().texOffs(113, 87).addBox(3.5F, -13.5F, -2.7F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.286485F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike30", CubeListBuilder.create().texOffs(113, 87).addBox(-0.5F, -13.5F, -2.7F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.286485F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike31", CubeListBuilder.create().texOffs(113, 87).addBox(3.5F, -15.5F, 0.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.026234F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike32", CubeListBuilder.create().texOffs(113, 87).addBox(-0.5F, -15.5F, 0.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.026234F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike33", CubeListBuilder.create().texOffs(113, 87).addBox(3.5F, -17.5F, -0.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.026234F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike36", CubeListBuilder.create().texOffs(113, 87).addBox(-0.5F, -19.5F, -1.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.026234F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike34", CubeListBuilder.create().texOffs(113, 87).addBox(-0.5F, -17.5F, -0.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.026234F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike35", CubeListBuilder.create().texOffs(113, 87).addBox(3.5F, -19.5F, -1.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.026234F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike37", CubeListBuilder.create().texOffs(113, 87).addBox(3.5F, -21.5F, -2.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.026234F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike38", CubeListBuilder.create().texOffs(113, 87).addBox(-0.5F, -21.5F, -2.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.026234F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike39", CubeListBuilder.create().texOffs(113, 87).addBox(3.5F, -23.5F, -3.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.026234F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike40", CubeListBuilder.create().texOffs(113, 87).addBox(-0.5F, -23.5F, -3.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -2.026234F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike41", CubeListBuilder.create().texOffs(113, 87).addBox(3.5F, -18.5F, 16.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike42", CubeListBuilder.create().texOffs(113, 87).addBox(-0.5F, -18.5F, 16.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike43", CubeListBuilder.create().texOffs(113, 87).addBox(3.5F, -20.5F, 16.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike44", CubeListBuilder.create().texOffs(113, 87).addBox(-0.5F, -20.5F, 16.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike45", CubeListBuilder.create().texOffs(113, 87).addBox(3.5F, -24.5F, 17.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 2.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike46", CubeListBuilder.create().texOffs(113, 87).addBox(-0.5F, -24.5F, 17.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 2.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike47", CubeListBuilder.create().texOffs(113, 87).addBox(3.5F, -24.5F, 15.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike48", CubeListBuilder.create().texOffs(113, 87).addBox(-0.5F, -24.5F, 15.5F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike49", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -26.5F, 14.9F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike50", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -28.5F, 13.9F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike51", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -30.5F, 12.9F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike52", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -32.5F, 11.9F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike53", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -34.5F, 11.9F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike54", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -38.5F, 5.9F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.245484F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike56", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -42.5F, 5.9F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.245484F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike55", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -40.5F, 5.9F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.245484F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike58", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -46.5F, 5.9F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.245484F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike57", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -44.5F, 5.9F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.245484F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike59", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -48.5F, -7.1F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.542912F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike60", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -43.5F, -26.3F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.989056F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike61", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -45.5F, -26.1F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.989056F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike62", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -47.5F, -25.8F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.989056F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike63", CubeListBuilder.create().texOffs(113, 87).addBox(-0.3F, -26.5F, 14.9F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike66", CubeListBuilder.create().texOffs(113, 87).addBox(3.0F, -28.5F, 13.9F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike67", CubeListBuilder.create().texOffs(113, 87).addBox(0.0F, -30.5F, 12.9F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike68", CubeListBuilder.create().texOffs(113, 87).addBox(3.0F, -30.5F, 12.9F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike69", CubeListBuilder.create().texOffs(113, 87).addBox(3.0F, -32.5F, 11.9F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike70", CubeListBuilder.create().texOffs(113, 87).addBox(0.0F, -32.5F, 11.9F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike71", CubeListBuilder.create().texOffs(113, 87).addBox(0.1F, -34.5F, 11.9F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike72", CubeListBuilder.create().texOffs(113, 87).addBox(2.8F, -34.5F, 11.9F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike64", CubeListBuilder.create().texOffs(113, 87).addBox(3.3F, -26.5F, 14.9F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("spike65", CubeListBuilder.create().texOffs(113, 87).addBox(0.0F, -28.5F, 13.9F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 4.0F, -1.05959F, 0.0F, 0.0F));
        root.addOrReplaceChild("RightLegClaw4", CubeListBuilder.create().texOffs(113, 87).addBox(3.2F, 17.0F, -7.0F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(5.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("RightLegClaw3", CubeListBuilder.create().texOffs(113, 87).addBox(2.0F, 17.0F, -7.0F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(5.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("RightLegClaw2", CubeListBuilder.create().texOffs(113, 87).addBox(0.7F, 17.0F, -7.0F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(5.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("RightLegClaw1", CubeListBuilder.create().texOffs(113, 87).addBox(-0.6F, 17.0F, -7.0F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(5.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("LegUpperPartRight", CubeListBuilder.create().texOffs(0, 53).addBox(-0.5F, -2.0F, -3.0F, 4.0F, 9.0F, 7.0F), PartPose.offsetAndRotation(5.0F, 6.0F, 0.0F, -0.2230717F, 0.0F, 0.0F));
        root.addOrReplaceChild("LegLowerPartRight", CubeListBuilder.create().texOffs(24, 53).addBox(-0.5F, 6.0F, -4.0F, 4.0F, 10.0F, 6.0F), PartPose.offsetAndRotation(5.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(17, 85).addBox(-0.8F, 16.0F, -5.0F, 5.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(5.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("LeftLegClaw4", CubeListBuilder.create().texOffs(113, 87).addBox(-4.3F, 17.0F, -7.0F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-5.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("LeftLegClaw3", CubeListBuilder.create().texOffs(113, 87).addBox(-3.1F, 17.0F, -7.0F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-5.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("LeftLegClaw2", CubeListBuilder.create().texOffs(113, 87).addBox(-1.8F, 17.0F, -7.0F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-5.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("LeftLegClaw1", CubeListBuilder.create().texOffs(113, 87).addBox(-0.5F, 17.0F, -7.0F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-5.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("LegUpperPartLeft", CubeListBuilder.create().texOffs(0, 32).addBox(-3.5F, -2.0F, -3.0F, 4.0F, 9.0F, 7.0F), PartPose.offsetAndRotation(-5.0F, 6.0F, 0.0F, -0.2230717F, 0.0F, 0.0F));
        root.addOrReplaceChild("LegLowerPartLeft", CubeListBuilder.create().texOffs(27, 31).addBox(-3.5F, 6.0F, -4.0F, 4.0F, 10.0F, 6.0F), PartPose.offsetAndRotation(-5.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(17, 85).addBox(-4.3F, 16.0F, -5.0F, 5.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(-5.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("NeckLowerPart", CubeListBuilder.create().texOffs(0, 17).addBox(-2.5F, -7.0F, -3.0F, 5.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -6.8F, -2.0F, 0.4089647F, 0.0F, 0.0F));
        root.addOrReplaceChild("NeckUpperPart", CubeListBuilder.create().texOffs(46, 56).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.0F, -11.5F, -4.5F, 0.8179294F, 0.0F, 0.0F));
        root.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(65, 5).addBox(-3.0F, -3.0F, -7.0F, 6.0F, 6.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -15.0F, -3.0F, 0.1115358F, 0.0F, 0.0F));
        root.addOrReplaceChild("LeftHandClaw4", CubeListBuilder.create().texOffs(113, 87).addBox(-1.0F, 0.5F, -12.0F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-5.0F, -2.0F, 1.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("LeftHandClaw3", CubeListBuilder.create().texOffs(113, 87).addBox(-2.5F, 0.5F, -12.0F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-5.0F, -2.0F, 1.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("LeftHandClaw1", CubeListBuilder.create().texOffs(113, 87).addBox(0.0F, 2.0F, -11.3F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-5.0F, -2.0F, 1.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("LeftArmPart3", CubeListBuilder.create().texOffs(27, 87).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(-6.3F, 0.5F, -9.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("LeftArmPart2", CubeListBuilder.create().texOffs(27, 87).addBox(-3.0F, 0.5F, -9.133333F, 3.0F, 3.0F, 8.0F), PartPose.offsetAndRotation(-5.0F, -2.0F, 1.0F, 0.054635F, 0.0F, 0.0F));
        root.addOrReplaceChild("LeftArmPart1", CubeListBuilder.create().texOffs(27, 87).addBox(-3.0F, -2.5F, -3.5F, 3.0F, 5.0F, 7.0F), PartPose.offsetAndRotation(-5.0F, -2.0F, 1.0F, -1.283795F, 0.0F, 0.0F));
        root.addOrReplaceChild("LeftHandClaw2", CubeListBuilder.create().texOffs(113, 87).addBox(-3.466667F, 1.0F, -11.3F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-5.0F, -2.0F, 1.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("RightHandClaw4", CubeListBuilder.create().texOffs(113, 87).addBox(0.5F, 0.5F, -13.0F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(5.0F, -2.0F, 1.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("RightHandClaw3", CubeListBuilder.create().texOffs(113, 87).addBox(2.0F, 0.5F, -13.0F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(5.0F, -2.0F, 1.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("RightHandClaw2", CubeListBuilder.create().texOffs(113, 87).addBox(3.0F, 1.5F, -12.3F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(5.0F, -2.0F, 1.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("RightHandClaw1", CubeListBuilder.create().texOffs(113, 87).addBox(-1.0F, 2.0F, -12.3F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(5.0F, -2.0F, 1.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("RightArmPart3", CubeListBuilder.create().texOffs(27, 87).addBox(-0.5F, 1.0F, -11.0F, 4.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(5.0F, -2.0F, 1.0F, 0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("RightArmPart2", CubeListBuilder.create().texOffs(27, 87).addBox(0.0F, 0.5F, -10.13333F, 3.0F, 3.0F, 8.0F), PartPose.offsetAndRotation(5.0F, -2.0F, 1.0F, 0.054635F, 0.0F, 0.0F));
        root.addOrReplaceChild("RightArmPart1", CubeListBuilder.create().texOffs(27, 87).addBox(0.0F, -2.5F, -3.5F, 3.0F, 5.0F, 7.0F), PartPose.offsetAndRotation(5.0F, -2.0F, 1.0F, -1.283795F, 0.0F, 0.0F));
        root.addOrReplaceChild("LeftBackThing3", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -3.5F, -5.0F, 1.0F, 2.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -1.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LeftBackThing2", CubeListBuilder.create().texOffs(113, 87).addBox(-1.5F, -0.5F, -6.0F, 2.0F, 1.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -3.0F, 3.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LeftBackThing1", CubeListBuilder.create().texOffs(110, 87).addBox(4.5F, -1.0F, -4.0F, 2.0F, 3.0F, 4.0F), PartPose.offsetAndRotation(-3.0F, -5.0F, 3.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("RightBackThing3", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -6.5F, -4.0F, 1.0F, 2.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -1.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("RightBackThing2", CubeListBuilder.create().texOffs(113, 87).addBox(3.5F, -0.5F, -6.0F, 2.0F, 1.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -3.0F, 3.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("RightBackThing1", CubeListBuilder.create().texOffs(109, 87).addBox(-1.5F, -1.0F, -4.0F, 2.0F, 3.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, -5.0F, 3.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("MiddleBackThing3", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -0.5F, -5.0F, 1.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(-2.0F, -1.0F, 5.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("MiddleBackThing2", CubeListBuilder.create().texOffs(110, 87).addBox(1.5F, 0.5F, -7.0F, 1.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(-2.0F, -3.0F, 3.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("MiddleBackThing1", CubeListBuilder.create().texOffs(113, 87).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, -5.0F, 3.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LowerMiddleBackThing14", CubeListBuilder.create().texOffs(112, 87).addBox(1.5F, 7.0F, -4.0F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-2.0F, -1.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LowerMiddleBackThing15", CubeListBuilder.create().texOffs(112, 87).addBox(3.0F, 8.5F, -3.0F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, -1.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LowerMiddleBackThing16", CubeListBuilder.create().texOffs(112, 87).addBox(0.0F, 8.5F, -3.0F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, -1.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LowerMiddleBackThing17", CubeListBuilder.create().texOffs(112, 87).addBox(1.5F, 8.5F, -3.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, -1.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LowerMiddleBackThing18", CubeListBuilder.create().texOffs(112, 87).addBox(1.5F, 10.5F, -2.0F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, -1.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LowerMiddleBackThing1", CubeListBuilder.create().texOffs(113, 87).addBox(1.5F, -2.5F, -5.0F, 1.0F, 1.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -5.0F, 3.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LowerMiddleBackThing2", CubeListBuilder.create().texOffs(113, 87).addBox(-0.5F, -2.5F, -5.0F, 1.0F, 1.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -3.0F, 3.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LowerMiddleBackThing3", CubeListBuilder.create().texOffs(113, 87).addBox(-0.5F, -4.5F, -3.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, -1.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LowerMiddleBackThing4", CubeListBuilder.create().texOffs(113, 87).addBox(3.5F, -6.5F, -3.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, -3.0F, 3.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LowerMiddleBackThing5", CubeListBuilder.create().texOffs(113, 87).addBox(-0.5F, -4.5F, -4.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, -3.0F, 3.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LowerMiddleBackThing6", CubeListBuilder.create().texOffs(113, 87).addBox(3.5F, -6.5F, -2.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, -1.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LowerMiddleBackThing7", CubeListBuilder.create().texOffs(112, 87).addBox(-0.5F, -6.5F, -2.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, -1.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LowerMiddleBackThing8", CubeListBuilder.create().texOffs(112, 87).addBox(3.5F, -0.5F, -4.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, -1.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LowerMiddleBackThing9", CubeListBuilder.create().texOffs(112, 87).addBox(3.5F, -2.5F, -3.0F, 1.0F, 1.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -1.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LowerMiddleBackThing10", CubeListBuilder.create().texOffs(112, 87).addBox(1.5F, 6.533333F, -7.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LowerMiddleBackThing11", CubeListBuilder.create().texOffs(112, 87).addBox(1.5F, 5.5F, -6.0F, 1.0F, 1.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -1.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LowerMiddleBackThing19", CubeListBuilder.create().texOffs(112, 87).addBox(1.5F, 12.5F, -0.5F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-2.0F, -1.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LowerMiddleBackThing20", CubeListBuilder.create().texOffs(112, 87).addBox(0.0F, 10.5F, -2.0F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, -1.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LowerMiddleBackThing21", CubeListBuilder.create().texOffs(112, 87).addBox(0.0F, 12.5F, -0.5F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-2.0F, -1.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LowerMiddleBackThing22", CubeListBuilder.create().texOffs(112, 87).addBox(3.0F, 10.5F, -2.0F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, -1.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("LowerMiddleBackThing23", CubeListBuilder.create().texOffs(112, 87).addBox(3.0F, 12.5F, -0.5F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-2.0F, -1.0F, 4.0F, -2.844164F, 0.0F, 0.0F));
        root.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -0.5F, -10.5F, 4.0F, 3.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -15.0F, -3.0F, 0.0743572F, 0.0F, 0.0F));
        return LayerDefinition.create(mesh, 128, 128);
    }

    @Override
    public void setupAnim(GodzillaEntity entity, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
        float yaw = netHeadYaw / 57.295776F;
        float pitch = headPitch / 57.295776F;
        for (ModelPart p : head) {
            p.yRot = yaw;
            p.xRot = pitch;
        }
        float swingR = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        float swingL = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        for (ModelPart p : right) {
            p.xRot = swingR;
            p.yRot = 0.0F;
        }
        for (ModelPart p : left) {
            p.xRot = swingL;
            p.yRot = 0.0F;
        }
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight,
                               int packedOverlay, float red, float green, float blue, float alpha) {
        root.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
