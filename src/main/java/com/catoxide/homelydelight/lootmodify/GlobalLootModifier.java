package com.catoxide.homelydelight.lootmodify;

import com.mojang.datafixers.optics.Forget;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.EntityTypePredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.lang.reflect.Type;

public class GlobalLootModifier extends GlobalLootModifierProvider {
    public GlobalLootModifier(PackOutput output,String modid) {
        super(output,modid);
    }
@Override
    protected void start(){
        add("piglootmodifier",new piglootmodifier(new LootItemCondition[]{
        //        LootItemEntityPropertyCondition.entityPresent(LootContext.EntityTarget.This).build(),
                MatchTool.toolMatches(ItemPredicate.Builder.item().of(ForgeTags.TOOLS_KNIVES)).build(),
                LootItemEntityPropertyCondition.hasProperties()
        }, 2));
}




}
