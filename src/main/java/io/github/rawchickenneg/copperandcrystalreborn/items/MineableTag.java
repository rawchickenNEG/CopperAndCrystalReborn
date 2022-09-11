package io.github.rawchickenneg.copperandcrystalreborn.items;

import io.github.rawchickenneg.copperandcrystalreborn.CopperAndCrystalReborn;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class MineableTag
{
    public static final TagKey<Block> MINEABLE_WITH_PAXEL = TagKey.create(Registry.BLOCK_REGISTRY,
            new ResourceLocation(CopperAndCrystalReborn.MOD_ID, "mineable_with_paxal"));
}