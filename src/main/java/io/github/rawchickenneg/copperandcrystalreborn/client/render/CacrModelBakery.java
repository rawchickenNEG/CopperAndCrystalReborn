package io.github.rawchickenneg.copperandcrystalreborn.client.render;

import com.google.common.collect.ImmutableMap;
import io.github.rawchickenneg.copperandcrystalreborn.Cacr;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.Set;

/* MIT License
 *
 * Copyright (c) 2022 LimonBlaze
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

@Mod.EventBusSubscriber(modid = Cacr.ID, bus = Bus.MOD)
public class CacrModelBakery extends ModelBakery {
    private static final Set<ShieldItem> SHIELDS = new HashSet<>();
    public static ImmutableMap<Item, Material> SHIELD_BASE_MATERIALS = ImmutableMap.of();
    public static ImmutableMap<Item, Material> NO_PATTERN_SHIELD_MATERIALS = ImmutableMap.of();
    
    private CacrModelBakery(ResourceManager resourceManager, BlockColors blockColors) {
        super(resourceManager, blockColors, false);
    }
    
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void setup(FMLClientSetupEvent event) {
        event.enqueueWork(CacrModelBakery::setupShieldMaterials);
    }
    
    private static void setupShieldMaterials() {
        ImmutableMap.Builder<Item, Material> baseMap = ImmutableMap.builder();
        ImmutableMap.Builder<Item, Material> noPatternMap = ImmutableMap.builder();
        for(ShieldItem shield : SHIELDS) {
            ResourceLocation loc = ForgeRegistries.ITEMS.getKey(shield);
            assert loc != null;
            Material base = ForgeHooksClient.getBlockMaterial(new ResourceLocation(
                loc.getNamespace(),
                "entity/" + loc.getPath() + "_base"
            ));
            Material noPattern = ForgeHooksClient.getBlockMaterial(new ResourceLocation(
                loc.getNamespace(),
                "entity/" + loc.getPath() + "_base_nopattern"
            ));
            baseMap.put(shield, base);
            noPatternMap.put(shield, noPattern);
        }
        SHIELD_BASE_MATERIALS = baseMap.build();
        NO_PATTERN_SHIELD_MATERIALS = noPatternMap.build();
        UNREFERENCED_TEXTURES.addAll(SHIELD_BASE_MATERIALS.values());
        UNREFERENCED_TEXTURES.addAll(NO_PATTERN_SHIELD_MATERIALS.values());
    }
    
    public static void registerShieldMaterial(ShieldItem shield) {
        SHIELDS.add(shield);
    }
    
}
