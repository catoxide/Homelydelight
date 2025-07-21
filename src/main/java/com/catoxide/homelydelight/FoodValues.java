package com.catoxide.homelydelight;

import com.google.gson.internal.NonNullElementWrapperList;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class FoodValues {
    public static final FoodProperties bouilli_with_rice = (new FoodProperties.Builder())
            .nutrition(14).saturationMod(0.6f).build();
    public static final FoodProperties large_meatballs_with_rice = (new FoodProperties.Builder())
            .nutrition(11).saturationMod(0.8f)
            .effect(new MobEffectInstance(ModEffects.COMFORT.get(), 200, 0), 1.0F).build();
    public static final FoodProperties pork_with_preserved_vegetable = (new FoodProperties.Builder())
            .nutrition(11).saturationMod(0.8f)
            .effect(new MobEffectInstance(ModEffects.COMFORT.get(), 200, 0), 1.0F).build();
    public static final FoodProperties tofu = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(0.8f).build();
    public static final FoodProperties minced_pork = (new FoodProperties.Builder())
            .nutrition(4).saturationMod(0.4f).build();
    public static final FoodProperties cooked_minced_pork = (new FoodProperties.Builder())
            .nutrition(7).saturationMod(0.6f).build();
    public static final FoodProperties pork_ribs = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(0.6f).build();
    public static final FoodProperties cooked_pork_ribs = (new FoodProperties.Builder())
            .nutrition(8).saturationMod(0.8f).build();
    public static final FoodProperties veggie_bisque = (new FoodProperties.Builder())
            .nutrition(12).saturationMod(0.4f).build();
    public static final FoodProperties veggie_crabpaste = (new FoodProperties.Builder())
            .nutrition(12).saturationMod(0.6f).build();
    public static final FoodProperties mashed_potato = (new FoodProperties.Builder())
            .nutrition(6).saturationMod(0.8f).build();
    public static final FoodProperties cooking_oil = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.1f)
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.WEAKNESS, 1200, 0), 1.0F).build();
    public static final FoodProperties soybean_milk = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(0.6f)
            .effect(new MobEffectInstance(MobEffects.LUCK, 1200, 0), 1.0F).build();
    public static final FoodProperties soy_sauce = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.1f)
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.HUNGER, 200, 0), 0.5F).build();
}
