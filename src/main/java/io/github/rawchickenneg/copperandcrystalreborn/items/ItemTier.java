package io.github.rawchickenneg.copperandcrystalreborn.items;

import io.github.rawchickenneg.copperandcrystalreborn.CopperAndCrystalReborn;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ItemTier {
    public static final Tier ObsidianSteel = new ForgeTier(4, 1080, 8f,3f,10, BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ItemRegistry.OBSIDIAN_STEEL_INGOT.get()));
    public static final Tier Amethyst = new ForgeTier(2, 250, 4f,2f,25, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ItemRegistry.OBSIDIAN_STEEL_INGOT.get()));
}
