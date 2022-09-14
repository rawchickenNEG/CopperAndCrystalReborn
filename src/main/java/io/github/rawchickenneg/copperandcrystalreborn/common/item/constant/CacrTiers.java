package io.github.rawchickenneg.copperandcrystalreborn.common.item.constant;

import io.github.rawchickenneg.copperandcrystalreborn.common.registry.CacrItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;

public class CacrTiers {
    
    public static final Tier AMETHYST = new ForgeTier(2, 250, 4F, 2F, 25,
        BlockTags.NEEDS_IRON_TOOL,
        () -> Ingredient.of(Items.AMETHYST_BLOCK)
    );
    
    public static final Tier OBSIDIAN_STEEL = new ForgeTier(4, 1080, 8F, 3F, 10,
        Tags.Blocks.NEEDS_NETHERITE_TOOL,
        () -> Ingredient.of(CacrItems.OBSIDIAN_STEEL_INGOT.get())
    );
    
}
