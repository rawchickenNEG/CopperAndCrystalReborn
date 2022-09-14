package io.github.rawchickenneg.copperandcrystalreborn.common.registry;

import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.function.Supplier;

public class CacrRegistrate extends AbstractRegistrate<CacrRegistrate> {
    
    public CacrRegistrate(String id) {
        super(id);
    }
    
    public static NonNullSupplier<CacrRegistrate> lazy(String id) {
        return NonNullSupplier.lazy(() -> new CacrRegistrate(id)
            .registerEventListeners(FMLJavaModLoadingContext.get().getModEventBus())
        );
    }
    
    public void blockTagFromBlocks(TagKey<Block> tag, Block... blocks) {
        this.addDataGenerator(ProviderType.BLOCK_TAGS, prov -> prov.tag(tag).add(blocks));
    }
    
    @SafeVarargs
    public final void blockTagFromSuppliers(TagKey<Block> tag, Supplier<? extends Block>... blocks) {
        this.addDataGenerator(ProviderType.BLOCK_TAGS, prov -> {
            for(var block : blocks) prov.tag(tag).add(block.get());
        });
    }
    
    @SafeVarargs
    public final void blockTagFromTags(TagKey<Block> tag, TagKey<Block>... tags) {
        this.addDataGenerator(ProviderType.BLOCK_TAGS, prov -> prov.tag(tag).addTags(tags));
    }
    
    public void itemTagFromItems(TagKey<Item> tag, Item... items) {
        this.addDataGenerator(ProviderType.ITEM_TAGS, prov -> prov.tag(tag).add(items));
    }
    
    @SafeVarargs
    public final void itemTagFromSuppliers(TagKey<Item> tag, Supplier<? extends Item>... items) {
        this.addDataGenerator(ProviderType.ITEM_TAGS, prov -> {
            TagsProvider.TagAppender<Item> appender = prov.tag(tag);
            for(var item : items) appender.add(item.get());
        });
    }
    
    @SafeVarargs
    public final void itemTagFromTags(TagKey<Item> tag, TagKey<Item>... tags) {
        this.addDataGenerator(ProviderType.ITEM_TAGS, prov -> prov.tag(tag).addTags(tags));
    }
    
}
