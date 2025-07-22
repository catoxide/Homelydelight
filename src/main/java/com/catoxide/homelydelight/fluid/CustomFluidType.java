package com.catoxide.homelydelight.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.common.SoundActions;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.fluids.FluidStack;
import org.joml.Vector3f;

public class CustomFluidType extends FluidType {
    private final ResourceLocation stillTexture;
    private final ResourceLocation flowingTexture;

    public CustomFluidType(Properties properties, ResourceLocation stillTexture, ResourceLocation flowingTexture) {
        super(properties);
        this.stillTexture = stillTexture;
        this.flowingTexture = flowingTexture;
    }

    public ResourceLocation getStillTexture() {
        return stillTexture;
    }

    public ResourceLocation getFlowingTexture() {
        return flowingTexture;
    }

    public Vector3f modifyFogColor(FluidStack stack, float partialTicks) {
        return new Vector3f(0.9f, 0.8f, 0.6f); // 油的颜色
    }
}