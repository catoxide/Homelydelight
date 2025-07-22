package com.catoxide.homelydelight.fluid;


import com.catoxide.homelydelight.Homely_Delight;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.catoxide.homelydelight.Homely_Delight.FLUIDS;
import static com.catoxide.homelydelight.Homely_Delight.MODID;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import java.util.function.Consumer;

public final class CookingOil {
        public static final DeferredRegister<FluidType> FLUID_TYPES =
                DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, MODID);

        public static final DeferredRegister<Fluid> FLUIDS =
                DeferredRegister.create(ForgeRegistries.FLUIDS, MODID);

        // 定义纹理路径
        private static final ResourceLocation STILL_TEXTURE =
                new ResourceLocation("homelydelight:block/cooking_oil_still");
        private static final ResourceLocation FLOWING_TEXTURE =
                new ResourceLocation("homelydelight:block/cooking_oil_flow");

        // 使用自定义 FluidType
        public static final RegistryObject<FluidType> COOKING_OIL_TYPE = FLUID_TYPES.register(
                "cooking_oil",
                () -> new FluidType(FluidType.Properties.create()
                        .descriptionId("fluid.homelydelight.cooking_oil")
                        .density(1000)
                        .viscosity(1000)
                        .temperature(300)) {

                        @Override
                        public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                                consumer.accept(new IClientFluidTypeExtensions() {
                                        @Override
                                        public ResourceLocation getStillTexture() {
                                                // 即使没有实际纹理，也要返回一个非空的虚拟路径
                                                return new ResourceLocation("homelydelight:block/cooking_oil_still");
                                        }

                                        @Override
                                        public ResourceLocation getFlowingTexture() {
                                                // 即使没有实际纹理，也要返回一个非空的虚拟路径
                                                return new ResourceLocation("homelydelight:block/cooking_oil_still");
                                        }

                                        @Override
                                        public int getTintColor() {
                                                return 0x80F8D86D; // 设置一个明显的颜色（这里是黄色）
                                        }
                                });
                        }
                }
        );


        // 简化流体类
        public static final RegistryObject<ForgeFlowingFluid.Source> COOKING_OIL = FLUIDS.register(
                "cooking_oil",
                () -> new ForgeFlowingFluid.Source(createProps())
        );

        public static final RegistryObject<ForgeFlowingFluid.Flowing> COOKING_OIL_FLOWING = FLUIDS.register(
                "cooking_oil_flowing",
                () -> new ForgeFlowingFluid.Flowing(createProps())
        );

        private static ForgeFlowingFluid.Properties createProps() {
                return new ForgeFlowingFluid.Properties(
                        COOKING_OIL_TYPE,
                        COOKING_OIL,
                        COOKING_OIL_FLOWING
                )
                        .bucket(Homely_Delight.COOKING_OIL_BUCKET)
                        .block(Homely_Delight.COOKING_OIL_BLOCK);
        }
}