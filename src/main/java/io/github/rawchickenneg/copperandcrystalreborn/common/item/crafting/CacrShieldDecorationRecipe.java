package io.github.rawchickenneg.copperandcrystalreborn.common.item.crafting;

import io.github.rawchickenneg.copperandcrystalreborn.Cacr;
import io.github.rawchickenneg.copperandcrystalreborn.common.item.CacrShieldItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CacrShieldDecorationRecipe extends CustomRecipe {
    public static final RegistryObject<SimpleRecipeSerializer<CacrShieldDecorationRecipe>> SERIALIZER =
        RegistryObject.create(Cacr.asResource("shield_decoration"), ForgeRegistries.RECIPE_SERIALIZERS);
    
    public CacrShieldDecorationRecipe(ResourceLocation id) {
        super(id);
    }
    
    public boolean matches(CraftingContainer container, Level level) {
        ItemStack banner = ItemStack.EMPTY;
        ItemStack shield = ItemStack.EMPTY;
        
        for(int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack slotStack = container.getItem(i);
            if(!slotStack.isEmpty()) {
                if(slotStack.getItem() instanceof BannerItem) {
                    if(!banner.isEmpty())
                        return false;
                    banner = slotStack;
                } else {
                    if(!shield.isEmpty() || !(slotStack.getItem() instanceof CacrShieldItem) || BlockItem.getBlockEntityData(slotStack) != null)
                        return false;
                    shield = slotStack;
                }
            }
        }
        
        return !shield.isEmpty() && !banner.isEmpty();
    }
    
    public ItemStack assemble(CraftingContainer container) {
        ItemStack banner = ItemStack.EMPTY;
        ItemStack shield = ItemStack.EMPTY;
        
        for(int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack slotStack = container.getItem(i);
            if(!slotStack.isEmpty()) {
                if(slotStack.getItem() instanceof BannerItem) {
                    banner = slotStack;
                } else if(slotStack.is(Items.SHIELD)) {
                    shield = slotStack.copy();
                }
            }
        }
        
        if(!shield.isEmpty()) {
            CompoundTag bannerTag = BlockItem.getBlockEntityData(banner);
            CompoundTag shieldTag = bannerTag == null ? new CompoundTag() : bannerTag.copy();
            shieldTag.putInt("Base", ((BannerItem) banner.getItem()).getColor().getId());
            BlockItem.setBlockEntityData(shield, BlockEntityType.BANNER, shieldTag);
        }
        
        return shield;
    }
    
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return pWidth * pHeight >= 2;
    }
    
    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializer.SHIELD_DECORATION;
    }
    
}