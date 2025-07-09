package com.catoxide.homelydelight.datagen;

import com.catoxide.homelydelight.Homely_Delight;
import com.catoxide.homelydelight.resourcebuilder.CookingPotRecipeBuilder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.PackOutput;
import java.util.function.Consumer;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

public class Recipes extends RecipeProvider {
    public Recipes(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        CookingPotRecipeBuilder.cookingPotRecipe(Homely_Delight.veggie_bisque.get(), 1, 200, 1.0F)
                .addIngredient(Items.CARROT)
                .addIngredient(Items.POTATO)
                .addIngredient(ForgeTags.VEGETABLES)
                .unlockedByAnyIngredient(Items.CARROT, Items.POTATO)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer);
        CookingPotRecipeBuilder.cookingPotRecipe(Homely_Delight.bouilli_block_item.get(), 1, 400, 4.0F)
                .addIngredient(Homely_Delight.lard.get())
                .addIngredient(Homely_Delight.lard.get())
                .addIngredient(Items.PORKCHOP)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.HONEY_BOTTLE)
                .unlockedByAnyIngredient(Homely_Delight.lard.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer);
        CookingPotRecipeBuilder.cookingPotRecipe(Homely_Delight.large_meatballs_block_item.get(), 1, 400, 4.0F)
                .addIngredient(Homely_Delight.minced_pork.get())
                .addIngredient(Homely_Delight.minced_pork.get())
                .addIngredient(Homely_Delight.minced_pork.get())
                .addIngredient(Homely_Delight.soy_sauce_bottle.get())
                .unlockedByAnyIngredient(Homely_Delight.soy_sauce_bottle.get(),Homely_Delight.minced_pork.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer);
        CookingPotRecipeBuilder.cookingPotRecipe(Homely_Delight.lard.get(), 2, 400, 2.0F)
                .addIngredient(Items.PORKCHOP)
                .addIngredient(Items.PORKCHOP)
                .addIngredient(Items.PORKCHOP)
                .unlockedByItems("has_porkchop",Items.PORKCHOP)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(consumer);
        CookingPotRecipeBuilder.cookingPotRecipe(Homely_Delight.tofu.get(), 3, 400, 2.0F)
                .addIngredient(Homely_Delight.soybean_milk_bottle.get())
                .addIngredient(Homely_Delight.soybean_milk_bottle.get())
                .unlockedByItems("has_soybean_milk",Homely_Delight.soybean_milk_bottle.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(consumer);
    }
    private static void cuttingAnimalItems(Consumer<FinishedRecipe> consumer) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModItems.BACON.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), Homely_Delight.minced_pork.get(), 1)
                .addResultWithChance(Homely_Delight.minced_pork.get(), 0.2F)
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Homely_Delight.pork_ribs.get()), Ingredient.of(ForgeTags.TOOLS_AXES), Items.PORKCHOP, 2)
                .build(consumer);
    }
    protected static void cookRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer, String pCookingMethod, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, int pCookingTime) {
        simpleCookingRecipe(pFinishedRecipeConsumer, pCookingMethod, pCookingSerializer, pCookingTime,
                Homely_Delight.minced_pork.get(), Homely_Delight.cooked_minced_pork.get(), 0.35F);
        simpleCookingRecipe(pFinishedRecipeConsumer, pCookingMethod, pCookingSerializer, pCookingTime,
                Homely_Delight.pork_ribs.get(), Homely_Delight.cooked_pork_ribs.get(), 0.35F);
    }
}