package io.github.rawchickenneg.copperandcrystalreborn.common.tag;

import io.github.rawchickenneg.copperandcrystalreborn.Cacr;
import io.github.rawchickenneg.copperandcrystalreborn.common.registry.CacrRegistrate;
import io.github.rawchickenneg.copperandcrystalreborn.util.FileUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITagManager;

import java.util.Set;

public enum CacrItemTags {
    INGOTS("forge"),
    INGOTS$COPPER("forge"),
    TOOLS$SWORDS("forge"),
    TOOLS$SHOVELS("forge"),
    TOOLS$PICKAXES("forge"),
    TOOLS$AXES("forge"),
    TOOLS$HOES("forge"),
    TOOLS$PAXELS("forge"),
    TOOLS$SHEARS("forge"),
    SHIELDS("forge");
    
    private static final CacrRegistrate REGISTRATE = Cacr.REGISTRATE.get();
    
    public final TagKey<Item> tag;
    
    CacrItemTags() {
        this(Cacr.ID);
    }
    
    CacrItemTags(String namespace) {
        ITagManager<Item> manager = ForgeRegistries.ITEMS.tags();
        assert manager != null;
        this.tag = manager.createOptionalTagKey(new ResourceLocation(namespace, FileUtils.toResourcePath(this.name())), Set.of());
    }
    
    public static TagKey<Item> forge(String name) {
        ITagManager<Item> manager = ForgeRegistries.ITEMS.tags();
        assert manager != null;
        return manager.createOptionalTagKey(new ResourceLocation("forge", name), Set.of());
    }
    
    public static void registerAll() {
    
    }
    
}
