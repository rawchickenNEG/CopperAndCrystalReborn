package io.github.rawchickenneg.copperandcrystalreborn;

import io.github.rawchickenneg.copperandcrystalreborn.blocks.BlockRegistry;
import io.github.rawchickenneg.copperandcrystalreborn.items.ItemRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CopperAndCrystalReborn.MOD_ID)
public class CopperAndCrystalReborn {
    public static final String MOD_ID = "copper_and_crystal_reborn";

    public CopperAndCrystalReborn() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemRegistry.REGISTRY.register(bus);
        BlockRegistry.BLOCKS.register(bus);
    }
}
