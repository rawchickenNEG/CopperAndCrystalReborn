package io.github.rawchickenneg.copperandcrystalreborn.client;

import io.github.rawchickenneg.copperandcrystalreborn.client.render.CacrBEWLR;
import io.github.rawchickenneg.copperandcrystalreborn.common.registry.CacrItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class CacrClient {
    
    public CacrClient() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::setup);
        modBus.addListener(this::registerClientReloadListeners);
    }
    
    public void setup(FMLClientSetupEvent event) {
        event.enqueueWork(this::registerItemProperties);
    }
    
    public void registerClientReloadListeners(RegisterClientReloadListenersEvent event) {
        event.registerReloadListener(CacrBEWLR.getInstance());
    }
    
    public void registerItemProperties() {
        ItemProperties.register(CacrItems.COPPER_SHIELD.get(), new ResourceLocation("blocking"), (stack, level, entity, seed) ->
            entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F
        );
    }
    
}
