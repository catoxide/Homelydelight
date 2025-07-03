package com.catoxide.homelydelight;

import com.mojang.logging.LogUtils;

import java.util.LinkedHashSet;
import java.util.Stack;
import java.util.function.Supplier;

import jdk.dynalink.beans.StaticClass;
import net.minecraft.client.Minecraft;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Homely_Delight.MODID)
public class Homely_Delight {}
        public static final DeferredRegister<Block> BLOCKS;
    public static LinkedHashSet<RegistryObject<Item>> CREATIVE_TAB_ITEMS;
    public static final RegistryObject<Item>

    // Define mod id in a common place for everything to reference
    public static final String MODID = "homelydelight";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace

    public static RegistryObject<Item> registerWithTab(String name, Supplier<Item> supplier) {
        RegistryObject<Item> block = ITEMS.register(name, supplier);
        CREATIVE_TAB_ITEMS.add(block);
        return block;

    public static final RegistryObject<Block> yatuifan = BLOCKS.register("yatuifan", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.MUD).strength(1)));
    public static final RegistryObject<Item> yatuifan_item = ITEMS.register("yatuifan", () -> new BlockItem(yatuifan.get(), new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEat().nutrition(6).saturationMod(2f).build())));
    public static final RegistryObject<Item> veggie_bisque = ITEMS.register("veggie_bisque", () -> new BowlFoodItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder()
            .alwaysEat().nutrition(6).saturationMod(2f).build())));


    public Homely_Delight(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
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
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }

}