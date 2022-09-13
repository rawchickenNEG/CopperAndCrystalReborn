package io.github.rawchickenneg.copperandcrystalreborn.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import io.github.rawchickenneg.copperandcrystalreborn.common.item.CacrShieldItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.util.List;
import java.util.Objects;

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

public class CacrBEWLR extends BlockEntityWithoutLevelRenderer {
    private static CacrBEWLR instance;
    private final BlockEntityRenderDispatcher dispatcher;
    private final EntityModelSet modelSet;
    private ShieldModel shieldModel;
    
    /**
     * BEWLR instance should only be created once, please use {@link CacrBEWLR#getInstance()}
     */
    private CacrBEWLR(BlockEntityRenderDispatcher dispatcher, EntityModelSet modelSet) {
        super(dispatcher, modelSet);
        this.dispatcher = dispatcher;
        this.modelSet = modelSet;
        
    }
    
    public static CacrBEWLR getInstance() {
        if(instance == null) {
            Minecraft minecraft = Minecraft.getInstance();
            instance = new CacrBEWLR(minecraft.getBlockEntityRenderDispatcher(), minecraft.getEntityModels());
        }
        return instance;
    }
    
    public void onResourceManagerReload(ResourceManager resourceManager) {
        this.shieldModel = new ShieldModel(this.modelSet.bakeLayer(ModelLayers.SHIELD));
    }
    
    public void renderByItem(
        ItemStack stack,
        ItemTransforms.TransformType transformType,
        PoseStack poseStack,
        MultiBufferSource buffer,
        int light,
        int overlay)
    {
        Item item = stack.getItem();
        if(item instanceof CacrShieldItem) {
            boolean flag = BlockItem.getBlockEntityData(stack) != null;
            poseStack.pushPose();
            poseStack.scale(1.0F, -1.0F, -1.0F);
            Material material = flag
                ? CacrModelBakery.SHIELD_BASE_MATERIALS.get(item)
                : CacrModelBakery.NO_PATTERN_SHIELD_MATERIALS.get(item);
            Objects.requireNonNull(material);
            VertexConsumer vertexconsumer = material.sprite().wrap(ItemRenderer.getFoilBufferDirect(buffer, this.shieldModel.renderType(material.atlasLocation()), true, stack.hasFoil()));
            this.shieldModel.handle().render(poseStack, vertexconsumer, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
            if(flag) {
                List<Pair<BannerPattern, DyeColor>> list = BannerBlockEntity.createPatterns(ShieldItem.getColor(stack), BannerBlockEntity.getItemPatterns(stack));
                BannerRenderer.renderPatterns(poseStack, buffer, light, overlay, this.shieldModel.plate(), material, false, list, stack.hasFoil());
            } else {
                this.shieldModel.plate().render(poseStack, vertexconsumer, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
            }
            poseStack.popPose();
        }
    }
    
}