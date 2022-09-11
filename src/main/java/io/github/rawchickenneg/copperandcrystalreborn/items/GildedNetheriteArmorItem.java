package io.github.rawchickenneg.copperandcrystalreborn.items;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;

public class GildedNetheriteArmorItem extends ArmorItem {
    public GildedNetheriteArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties){
        super(material, slot, properties);
    }
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }
}
