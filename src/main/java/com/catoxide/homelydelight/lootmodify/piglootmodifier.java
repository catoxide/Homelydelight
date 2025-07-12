package com.catoxide.homelydelight.lootmodify;

import com.catoxide.homelydelight.Homely_Delight;
import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.security.PrivateKey;
import java.util.Map;
import java.util.function.Supplier;


public class piglootmodifier extends LootModifier {


    /**
     * Constructs a LootModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     */
    protected piglootmodifier(LootItemCondition[] conditionsIn,int dropnum) {
        super(conditionsIn);
        this.dropnum = dropnum;
    }
    private final int dropnum;
    public static final Supplier<Codec<piglootmodifier>> CODEC= Suppliers.memoize(
            ()-> RecordCodecBuilder.create(
                inst->LootModifier.codecStart(inst).and(
                        Codec.INT.fieldOf("dropnum").forGetter(
                                   m-> m.dropnum
                    )
                ).apply(inst,piglootmodifier::new)
            )
    );

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        generatedLoot.add(new ItemStack(Homely_Delight.lard.get(),dropnum));
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
