package io.github.rawchickenneg.copperandcrystalreborn.common.tag;

import io.github.rawchickenneg.copperandcrystalreborn.Cacr;
import io.github.rawchickenneg.copperandcrystalreborn.common.registry.CacrRegistrate;
import io.github.rawchickenneg.copperandcrystalreborn.util.FileUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITagManager;

import java.util.Set;

public enum CacrBlockTags {
    MINEABLE$PAXEL;
    
    private static final CacrRegistrate REGISTRATE = Cacr.REGISTRATE.get();
    
    public final TagKey<Block> tag;
    
    CacrBlockTags() {
        this(Cacr.ID);
    }
    
    CacrBlockTags(String namespace) {
        ITagManager<Block> manager = ForgeRegistries.BLOCKS.tags();
        assert manager != null;
        this.tag = manager.createOptionalTagKey(new ResourceLocation(namespace, FileUtils.toResourcePath(this.name())), Set.of());
    }
    
    public static void registerAll() {
        REGISTRATE.blockTagFromTags(MINEABLE$PAXEL.tag, BlockTags.MINEABLE_WITH_AXE, BlockTags.MINEABLE_WITH_SHOVEL, BlockTags.MINEABLE_WITH_PICKAXE);
    }
    
}
