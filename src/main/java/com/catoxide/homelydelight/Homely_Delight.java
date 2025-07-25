package com.catoxide.homelydelight;
import com.catoxide.homelydelight.fluid.CookingOil;
import com.catoxide.homelydelight.lootmodify.piglootmodifier;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.level.block.Blocks;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import vectorwing.farmersdelight.common.block.WildCropBlock;


import java.util.function.Supplier;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Homely_Delight.MODID)
public class Homely_Delight {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "homelydelight";
    private static final Logger LOGGER = LogUtils.getLogger();


    //测试
    //public static final RegistryObject<Block> yatuifan = BLOCKS.register("yatuifan", () -> new Block(Properties.of().sound(SoundType.MUD).strength(1)));
    //public static final RegistryObject<Item> yatuifan_item = ITEMS.register("yatuifan", () -> new BlockItem(yatuifan.get(), new Item.Properties().food(new FoodProperties.Builder()
    //        .alwaysEat().nutrition(6).saturationMod(2f).build())));


    //盖饭代码（待分装）
    public static class BouilliBlock extends ToppingFeastBlock {
        protected static final VoxelShape PLATE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
        protected static final VoxelShape ROAST_SHAPE = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(4.0D, 2.0D, 4.0D, 12.0D, 9.0D, 12.0D), BooleanOp.OR);

        public BouilliBlock(Properties properties, Supplier<Item> servingItem, boolean hasLeftovers) {
            super(properties, servingItem, hasLeftovers);
        }

        @Override
        public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
            return state.getValue(SERVINGS) == 0 ? PLATE_SHAPE : ROAST_SHAPE;
        }
    }
    public static Item.Properties foodItem(FoodProperties food) {
        return new Item.Properties().food(food);
    }
    //物品注册
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, MODID);
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIER = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS,MODID);

    //普通物品
    public static final RegistryObject<Item> amylum = ITEMS.register("amylum", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> cooking_oil_bottle = ITEMS.register("cooking_oil_bottle", () -> new BottleItem(foodItem(FoodValues.cooking_oil)));
    public static final RegistryObject<Item> soy_sauce_bottle = ITEMS.register("soy_sauce_bottle", () -> new BottleItem(foodItem(FoodValues.soy_sauce)));
    public static final RegistryObject<Item> soybean_milk_bottle = ITEMS.register("soybean_milk_bottle", () -> new BottleItem(foodItem(FoodValues.soybean_milk)));
    public static final RegistryObject<Item> lard = ITEMS.register("lard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> tofu = ITEMS.register("tofu", () -> new Item(foodItem(FoodValues.tofu)));
    public static final RegistryObject<Item> minced_pork = ITEMS.register("minced_pork", () -> new Item(foodItem(FoodValues.minced_pork)));
    public static final RegistryObject<Item> cooked_minced_pork = ITEMS.register("cooked_minced_pork", () -> new Item(foodItem(FoodValues.cooked_minced_pork)));
    public static final RegistryObject<Item> pork_ribs = ITEMS.register("pork_ribs", () -> new Item(foodItem(FoodValues.pork_ribs)));
    public static final RegistryObject<Item> cooked_pork_ribs = ITEMS.register("cooked_pork_ribs", () -> new Item(foodItem(FoodValues.cooked_pork_ribs)));
    public static final RegistryObject<Block> soybeans_crop = BLOCKS.register("soybeans", () -> new SoyBeanBlock(Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Item> soybeans = ITEMS.register("soybeans", () -> new ItemNameBlockItem(soybeans_crop.get(), new Item.Properties()));
    public static final RegistryObject<Block> wild_soilbeans_crop = BLOCKS.register("wild_soilbeans", () -> new WildCropBlock(MobEffects.LUCK, 2, Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Item> wild_soilbeans_crop_item = ITEMS.register("wild_soilbeans_crop_item", () -> new BlockItem(wild_soilbeans_crop.get(),new Item.Properties()));
    public static final RegistryObject<Block> soy_sauce_fermentation_barrel = BLOCKS.register("soy_sauce_fermentation_barrel",() -> new SoysaucefermentationbarrelBlock(Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Item> soy_sauce_fermentation_barrel_item = ITEMS.register("soy_sauce_fermentation_barrel", () -> new BlockItem(soy_sauce_fermentation_barrel.get(),new Item.Properties()));
    public static final RegistryObject<Block> soy_sauce_barrel = BLOCKS.register("soy_sauce_barrel",() -> new Block(Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Item> soy_sauce_barrel_item = ITEMS.register("soy_sauce_barrel", () -> new BlockItem(soy_sauce_barrel.get(),new Item.Properties()));

    //碗装食物
    public static final RegistryObject<Item> veggie_bisque = ITEMS.register("veggie_bisque", () -> new BowlFoodItem(foodItem(FoodValues.veggie_bisque).stacksTo(16)));
    public static final RegistryObject<Item> veggie_crabpaste = ITEMS.register("veggie_crabpaste", () -> new BowlFoodItem(foodItem(FoodValues.veggie_crabpaste).stacksTo(16)));
    public static final RegistryObject<Item> mashed_potato = ITEMS.register("mashed_potato", () -> new BowlFoodItem(foodItem(FoodValues.mashed_potato).stacksTo(16)));

    //盘装食物
    public static final RegistryObject<Block> bouilli_block = BLOCKS.register("bouilli_block", () -> new BouilliBlock(Properties.copy(Blocks.CAKE), Homely_Delight.bouilli_with_rice, true));
    public static final RegistryObject<Item> bouilli_block_item = ITEMS.register("bouilli_block", () -> new BlockItem(bouilli_block.get(), new Item.Properties()));
    public static final RegistryObject<Item> bouilli_with_rice = ITEMS.register("bouilli_with_rice", () -> new Item(foodItem(FoodValues.bouilli_with_rice)));

    public static final RegistryObject<Block> large_meatballs_block = BLOCKS.register("large_meatballs_block", () -> new ToppingFeastBlock(Properties.copy(Blocks.CAKE), Homely_Delight.large_meatballs_with_rice, true));
    public static final RegistryObject<Item> large_meatballs_block_item = ITEMS.register("large_meatballs_block", () -> new BlockItem(large_meatballs_block.get(), new Item.Properties()));
    public static final RegistryObject<Item> large_meatballs_with_rice = ITEMS.register("large_meatballs_with_rice", () -> new Item(foodItem(FoodValues.large_meatballs_with_rice)));

    public static final RegistryObject<Block> pork_with_preserved_vegetable_block = BLOCKS.register("pork_with_preserved_vegetable", () -> new ToppingFeastBlock(Properties.copy(Blocks.CAKE), Homely_Delight.pork_with_preserved_vegetable_with_rice, true));
    public static final RegistryObject<Item> pork_with_preserved_vegetable_block_item = ITEMS.register("pork_with_preserved_vegetable", () -> new BlockItem(pork_with_preserved_vegetable_block.get(), new Item.Properties()));
    public static final RegistryObject<Item> pork_with_preserved_vegetable_with_rice = ITEMS.register("pork_with_preserved_vegetable_with_rice", () -> new Item(foodItem(FoodValues.pork_with_preserved_vegetable)));

    //流体
    public static final RegistryObject<Item> COOKING_OIL_BUCKET = ITEMS.register("cooking_oil_bucket",
                    () -> new BucketItem(CookingOil.COOKING_OIL.get(),   // ① 提供流体
                            new Item.Properties()                // ② 物品属性
                                    .stacksTo(1)                 // 桶只能堆叠 1 个
                                    .craftRemainder(Items.BUCKET)));// 用完返还桶
    public static final RegistryObject<LiquidBlock> COOKING_OIL_BLOCK =
            BLOCKS.register("cooking_oil_block",
                    () -> new LiquidBlock(
                            CookingOil.COOKING_OIL.get(),               // ← 必须传 Source 流体
                            BlockBehaviour.Properties.of()
                                    .noCollission()
                                    .strength(100.0F)            // 流体硬度
                                    .noLootTable()               // 不掉落
                                    .replaceable()
                    ));



    public Homely_Delight(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
        CREATIVE_MODE_TABS.register(bus);
        GLOBAL_LOOT_MODIFIER.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
        CookingOil.FLUID_TYPES.register(bus);
        CookingOil.FLUIDS.register(bus);
    }
    //创造模式物品栏
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,MODID);
    public static final RegistryObject<CreativeModeTab> Homelydelightbar = CREATIVE_MODE_TABS.register("homelydelightbar",()->CreativeModeTab.builder()
            .title(Component.translatable("Homely Delight"))
            .icon(()->new ItemStack(bouilli_block_item.get()))
            .displayItems((parameters,output)->{
                    output.accept(amylum.get());
                    output.accept(cooking_oil_bottle.get());
                    //output.accept(cooking_oil_bucket.get());
                    output.accept(soybean_milk_bottle.get());
                    output.accept(soy_sauce_bottle.get());
                    output.accept(minced_pork.get());
                    output.accept(cooked_minced_pork.get());
                    output.accept(pork_ribs.get());
                    output.accept(cooked_pork_ribs.get());
                    output.accept(lard.get());
                    output.accept(tofu.get());
                    output.accept(veggie_crabpaste.get());
                    output.accept(soybeans.get());
                    output.accept(soy_sauce_fermentation_barrel_item.get());
                    output.accept(soy_sauce_barrel_item.get());
                    output.accept(veggie_bisque.get());
                    output.accept(bouilli_block_item.get());
                    output.accept(bouilli_with_rice.get());
                    output.accept(large_meatballs_block_item.get());
                    output.accept(large_meatballs_with_rice.get());
                    output.accept(pork_with_preserved_vegetable_block_item.get());
                    output.accept(pork_with_preserved_vegetable_with_rice.get());
                    }
            )
            .build()
    );

    //public static final RegistryObject<Codec<piglootmodifier>> piglootmodifier = GLOBAL_LOOT_MODIFIER.register("lard_by_pig", com.catoxide.homelydelight.lootmodify.piglootmodifier.CODEC);


}




    //public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // Creates a new Block with the id "examplemod:example_block", combining the namespace and path
    //public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    //public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()));

    // Creates a new food item with the id "examplemod:example_id", nutrition 1 and saturation 2
    //public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
    //       .alwaysEat().nutrition(1).saturationMod(2f).build())));

    // Creates a creative tab with the id "examplemod:example_tab" for the example item, that is placed after the combat tab
    //public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
    //        .withTabsBefore(CreativeModeTabs.COMBAT)
    //        .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
    //        .displayItems((parameters, output) -> {
    //            output.accept(EXAMPLE_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
    //        }).build());

    //public Homely_Delight(FMLJavaModLoadingContext context)
    //{
    //    IEventBus modEventBus = context.getModEventBus();
    //
    // Register the commonSetup method for modloading
    //    modEventBus.addListener(this::commonSetup);

    // Register the Deferred Register to the mod event bus so blocks get registered
    //    BLOCKS.register(modEventBus);
    // Register the Deferred Register to the mod event bus so items get registered
    //    ITEMS.register(modEventBus);
    // Register the Deferred Register to the mod event bus so tabs get registered
    //    CREATIVE_MODE_TABS.register(modEventBus);

    // Register ourselves for server and other game events we are interested in
    //    MinecraftForge.EVENT_BUS.register(this);

    // Register the item to a creative tab
    //    modEventBus.addListener(this::addCreative);

    // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
    //    context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    //}

    //private void commonSetup(final FMLCommonSetupEvent event)
    //{
    //    // Some common setup code
    //    LOGGER.info("HELLO FROM COMMON SETUP");

    //    if (Config.logDirtBlock)
    //        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

    //    LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

    //    Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    //}

    // Add the example block item to the building blocks tab
    //private void addCreative(BuildCreativeModeTabContentsEvent event)
    //{
    //    if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
    //        event.accept(EXAMPLE_BLOCK_ITEM);
    //}

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    //@SubscribeEvent
    //public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
    //    LOGGER.info("HELLO from server starting");
    //}

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    //@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    //public static class ClientModEvents {
    //    @SubscribeEvent
    //    public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
    //        LOGGER.info("HELLO FROM CLIENT SETUP");
    //        LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    //    }
    //}

//}