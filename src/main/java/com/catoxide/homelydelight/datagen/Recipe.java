package com.catoxide.homelydelight.datagen;

import com.catoxide.homelydelight.Homely_Delight;
import jdk.jshell.ImportSnippet;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.PackOutput;
import java.util.function.Consumer;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.antlr.v4.codegen.target.CppTarget;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.recipe.CookingRecipes;

public class Recipe extends RecipeProvider {
    public Recipe(PackOutput output) {
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

    }
}