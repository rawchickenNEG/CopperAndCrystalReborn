package io.github.rawchickenneg.copperandcrystalreborn.common.item.constant;

import io.github.rawchickenneg.copperandcrystalreborn.common.registry.CacrItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.util.Lazy;

import java.util.Locale;
import java.util.function.Supplier;

public enum CacrArmorMaterials implements ArmorMaterial {
    AMETHYST(15, new int[]{2, 5, 6, 2}, 25, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> Ingredient.of(Items.AMETHYST_BLOCK)),
    OBSIDIAN_STEEL(33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(CacrItems.OBSIDIAN_STEEL_INGOT.get())),
    GILDED_NETHERITE(37, new int[]{3, 6, 8, 3}, 20, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.of(Items.NETHERITE_INGOT));
    
    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredient;

    CacrArmorMaterials(int durabilityMultiplier,
                       int[] armorValues,
                       int enchantmentValue,
                       SoundEvent equipSound,
                       float armorToughness,
                       float knockbackResistance,
                       Supplier<Ingredient> repairIngredient)
    {
        this.durabilityMultiplier = durabilityMultiplier;
        this.slotProtections = armorValues;
        this.enchantmentValue = enchantmentValue;
        this.sound = equipSound;
        this.toughness = armorToughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = Lazy.of(repairIngredient);
    }

    public int getDurabilityForSlot(EquipmentSlot slot) {
        return HEALTH_PER_SLOT[slot.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.slotProtections[slot.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return name().toLowerCase(Locale.ROOT);
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
    
}

