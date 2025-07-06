package com.catoxide.homelydelight.datagen;

import com.catoxide.homelydelight.Homely_Delight;
import com.catoxide.homelydelight.resourcebuilder.CookingPotRecipeBuilder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.PackOutput;
import java.util.function.Consumer;

import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.tag.ForgeTags;

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
        CookingPotRecipeBuilder.cookingPotRecipe(Homely_Delight.bouilli_block_item.get(), 1, 200, 1.0F)
                .addIngredient(Homely_Delight.lard.get())
                .addIngredient(Homely_Delight.lard.get())
                .addIngredient(Items.PORKCHOP)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.HONEY_BOTTLE)
                .unlockedByAnyIngredient(Homely_Delight.lard.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer);
    }
}