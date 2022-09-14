package io.github.rawchickenneg.copperandcrystalreborn;

import com.tterrag.registrate.util.nullness.NonNullSupplier;
import io.github.rawchickenneg.copperandcrystalreborn.client.CacrClient;
import io.github.rawchickenneg.copperandcrystalreborn.common.item.crafting.CacrShieldDecorationRecipe;
import io.github.rawchickenneg.copperandcrystalreborn.common.registry.CacrBlocks;
import io.github.rawchickenneg.copperandcrystalreborn.common.registry.CacrItems;
import io.github.rawchickenneg.copperandcrystalreborn.common.registry.CacrRegistrate;
import io.github.rawchickenneg.copperandcrystalreborn.data.lang.PartialLangMerger;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(Cacr.ID)
public class Cacr {
    public static final String ID = "copper_and_crystal_reborn";
    public static final Logger LOGGER = LoggerFactory.getLogger("Copper & Crystal Reborn");
    public static final NonNullSupplier<CacrRegistrate> REGISTRATE = CacrRegistrate.lazy(ID);
    
    public Cacr() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        CacrBlocks.registerAll();
        CacrItems.registerAll();
        modBus.addGenericListener(RecipeSerializer.class, this::registerRecipeSerializers);
        modBus.addListener(EventPriority.LOWEST, this::registerDatagen);
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> CacrClient::new);
    }
    
    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(ID, path);
    }
    
    public void registerRecipeSerializers(RegistryEvent.Register<RecipeSerializer<?>> event) {
        SimpleRecipeSerializer<CacrShieldDecorationRecipe> shieldDeco =
            new SimpleRecipeSerializer<>(CacrShieldDecorationRecipe::new);
        shieldDeco.setRegistryName(asResource("shield_decoration"));
        event.getRegistry().register(shieldDeco);
    }
    
    public void registerDatagen(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();
        if(event.includeClient()) {
            generator.addProvider(new PartialLangMerger(generator));
        }
    }
    
}
