package com.catoxide.homelydelight.datagen;

import com.catoxide.homelydelight.Homely_Delight;
import com.catoxide.homelydelight.SoyBeanBlock;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarrotBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.FunctionUserBuilder;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.RegistryObject;

import static com.ibm.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class Loottables extends VanillaBlockLoot {
    @Override
    protected Iterable<Block> getKnownBlocks(){
        return Homely_Delight.BLOCKS.getEntries().stream()
                .filter(block->block == Homely_Delight.soybeans_crop)
                .flatMap(RegistryObject::stream)
                ::iterator;
    }

    private StatePropertiesPredicate properties = StatePropertiesPredicate.ANY;
    private Loottables setProperties(StatePropertiesPredicate.Builder pStatePredicateBuilder) {
        this.properties = pStatePredicateBuilder.build();
        return this;
    }
    public void generate(){
        this.add(Homely_Delight.soybeans_crop.get(), this.applyExplosionDecay(Homely_Delight.soybeans.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(Homely_Delight.soybeans.get())))
                .withPool(LootPool.lootPool()
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(Homely_Delight.soybeans_crop.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SoyBeanBlock.AGE,7)))
                        .add(LootItem.lootTableItem(Homely_Delight.soybeans.get())
                                .apply(ApplyBonusCount
                                        .addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));

    }

}
