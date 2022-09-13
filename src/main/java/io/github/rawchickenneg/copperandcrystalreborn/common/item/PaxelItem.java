package io.github.rawchickenneg.copperandcrystalreborn.common.item;

import com.tterrag.registrate.util.nullness.NonNullSupplier;
import io.github.rawchickenneg.copperandcrystalreborn.common.tag.CacrBlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.ToolAction;

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

public class PaxelItem extends DiggerItem {
    private final NonNullSupplier<? extends ShovelItem> shovel;
    private final NonNullSupplier<? extends PickaxeItem> pickaxe;
    private final NonNullSupplier<? extends AxeItem> axe;
    
    public PaxelItem(Tier tier, float damageModifier, float speedModifier, Properties prop,
                     NonNullSupplier<? extends ShovelItem> shovel,
                     NonNullSupplier<? extends PickaxeItem> pickaxe,
                     NonNullSupplier<? extends AxeItem> axe) {
        super(damageModifier, speedModifier, tier, CacrBlockTags.MINEABLE$PAXEL.tag, prop);
        this.shovel = shovel;
        this.pickaxe = pickaxe;
        this.axe = axe;
    }
    
    /**
     * Delegating constructor for paxel without existing tool set.
     */
    public PaxelItem(Tier tier, float damageModifier, float speedModifier, Properties prop) {
        this(tier, damageModifier, speedModifier, prop,
            () -> (ShovelItem) Items.DIAMOND_SHOVEL,
            () -> (PickaxeItem) Items.DIAMOND_PICKAXE,
            () -> (AxeItem) Items.DIAMOND_AXE
        );
    }
    
    public ShovelItem getShovel() {
        return shovel.get();
    }
    
    public PickaxeItem getPickaxe() {
        return pickaxe.get();
    }
    
    public AxeItem getAxe() {
        return axe.get();
    }
    
    @Override
    public InteractionResult useOn(UseOnContext context) {
        InteractionResult result = getAxe().useOn(context);
        if(!result.consumesAction()) result = getShovel().useOn(context);
        //PickaxeItem didn't override Item#useOn, but we should leave it just in case other mods may do their trick
        if(!result.consumesAction()) result = getPickaxe().useOn(context);
        return result;
    }
    
    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return super.canPerformAction(stack, toolAction) ||
            getAxe().canPerformAction(stack, toolAction) ||
            getShovel().canPerformAction(stack, toolAction) ||
            getPickaxe().canPerformAction(stack, toolAction);
    }
    
    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) ||
            getAxe().canApplyAtEnchantingTable(stack, enchantment) ||
            getShovel().canApplyAtEnchantingTable(stack, enchantment) ||
            getPickaxe().canApplyAtEnchantingTable(stack, enchantment);
    }
    
}
