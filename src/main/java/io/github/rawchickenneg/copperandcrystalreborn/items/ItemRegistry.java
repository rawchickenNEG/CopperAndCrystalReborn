package io.github.rawchickenneg.copperandcrystalreborn.items;

import io.github.rawchickenneg.copperandcrystalreborn.CopperAndCrystalReborn;
import io.github.rawchickenneg.copperandcrystalreborn.blocks.BlockRegistry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraftforge.registries.ForgeRegistries.ITEMS;

public class ItemRegistry {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ITEMS, CopperAndCrystalReborn.MOD_ID);

    public static final RegistryObject<Item> OBSIDIAN_STEEL_HELMET = REGISTRY.register("obsidian_steel_helmet", () -> new ArmorItem(ArmorMaterials.OBSIDIANSTEEL, EquipmentSlot.HEAD, (new Item.Properties().tab(CreativeModeTab.TAB_COMBAT))));
    public static final RegistryObject<Item> OBSIDIAN_STEEL_CHESTPLATE = REGISTRY.register("obsidian_steel_chestplate", () -> new ArmorItem(ArmorMaterials.OBSIDIANSTEEL, EquipmentSlot.CHEST, (new Item.Properties().tab(CreativeModeTab.TAB_COMBAT))));
    public static final RegistryObject<Item> OBSIDIAN_STEEL_LEGGINGS = REGISTRY.register("obsidian_steel_leggings", () -> new ArmorItem(ArmorMaterials.OBSIDIANSTEEL, EquipmentSlot.LEGS, (new Item.Properties().tab(CreativeModeTab.TAB_COMBAT))));
    public static final RegistryObject<Item> OBSIDIAN_STEEL_BOOTS = REGISTRY.register("obsidian_steel_boots", () -> new ArmorItem(ArmorMaterials.OBSIDIANSTEEL, EquipmentSlot.FEET, (new Item.Properties().tab(CreativeModeTab.TAB_COMBAT))));
    public static final RegistryObject<Item> OBSIDIAN_STEEL_INGOT = REGISTRY.register("obsidian_steel_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> OBSIDIAN_COMPOUND = REGISTRY.register("obsidian_compound", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> OBSIDIAN_STEEL_SHOVEL = REGISTRY.register("obsidian_steel_shovel", () -> new ShovelItem(ItemTier.ObsidianSteel, 1, -3F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> OBSIDIAN_STEEL_PICKAXE = REGISTRY.register("obsidian_steel_pickaxe", () -> new PickaxeItem(ItemTier.ObsidianSteel, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> OBSIDIAN_STEEL_AXE = REGISTRY.register("obsidian_steel_axe", () -> new AxeItem(ItemTier.ObsidianSteel, 4, -3.1F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> OBSIDIAN_STEEL_HOE = REGISTRY.register("obsidian_steel_hoe", () -> new HoeItem(ItemTier.ObsidianSteel, -3, 0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> OBSIDIAN_STEEL_SWORD = REGISTRY.register("obsidian_steel_sword", () -> new SwordItem(ItemTier.ObsidianSteel, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> AMETHYST_HELMET = REGISTRY.register("amethyst_helmet", () -> new ArmorItem(ArmorMaterials.AMETHYST, EquipmentSlot.HEAD, (new Item.Properties().tab(CreativeModeTab.TAB_COMBAT))));
    public static final RegistryObject<Item> AMETHYST_CHESTPLATE = REGISTRY.register("amethyst_chestplate", () -> new ArmorItem(ArmorMaterials.AMETHYST, EquipmentSlot.CHEST, (new Item.Properties().tab(CreativeModeTab.TAB_COMBAT))));
    public static final RegistryObject<Item> AMETHYST_LEGGINGS = REGISTRY.register("amethyst_leggings", () -> new ArmorItem(ArmorMaterials.AMETHYST, EquipmentSlot.LEGS, (new Item.Properties().tab(CreativeModeTab.TAB_COMBAT))));
    public static final RegistryObject<Item> AMETHYST_BOOTS = REGISTRY.register("amethyst_boots", () -> new ArmorItem(ArmorMaterials.AMETHYST, EquipmentSlot.FEET, (new Item.Properties().tab(CreativeModeTab.TAB_COMBAT))));
    public static final RegistryObject<Item> AMETHYST_SHOVEL = REGISTRY.register("amethyst_shovel", () -> new ShovelItem(ItemTier.Amethyst, 1, -3F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> AMETHYST_PICKAXE = REGISTRY.register("amethyst_pickaxe", () -> new PickaxeItem(ItemTier.Amethyst, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> AMETHYST_AXE = REGISTRY.register("amethyst_axe", () -> new AxeItem(ItemTier.Amethyst, 4, -3.1F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> AMETHYST_HOE = REGISTRY.register("amethyst_hoe", () -> new HoeItem(ItemTier.Amethyst, -2, -1F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> AMETHYST_SWORD = REGISTRY.register("amethyst_sword", () -> new SwordItem(ItemTier.Amethyst, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> AMETHYST_PAXEL = REGISTRY.register("amethyst_paxel", () -> new PaxelItem(4, -3.1F,ItemTier. Amethyst, null, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> GILDED_NETHERITE_HELMET = REGISTRY.register("gilded_netherite_helmet", () -> new GildedNetheriteArmorItem(ArmorMaterials.GILDEDNETHRITE, EquipmentSlot.HEAD, (new Item.Properties().tab(CreativeModeTab.TAB_COMBAT))));
    public static final RegistryObject<Item> GILDED_NETHERITE_CHESTPLATE = REGISTRY.register("gilded_netherite_chestplate", () -> new GildedNetheriteArmorItem(ArmorMaterials.GILDEDNETHRITE, EquipmentSlot.CHEST, (new Item.Properties().tab(CreativeModeTab.TAB_COMBAT))));
    public static final RegistryObject<Item> GILDED_NETHERITE_LEGGINGS = REGISTRY.register("gilded_netherite_leggings", () -> new GildedNetheriteArmorItem(ArmorMaterials.GILDEDNETHRITE, EquipmentSlot.LEGS, (new Item.Properties().tab(CreativeModeTab.TAB_COMBAT))));
    public static final RegistryObject<Item> GILDED_NETHERITE_BOOTS = REGISTRY.register("gilded_netherite_boots", () -> new GildedNetheriteArmorItem(ArmorMaterials.GILDEDNETHRITE, EquipmentSlot.FEET, (new Item.Properties().tab(CreativeModeTab.TAB_COMBAT))));

    public static final RegistryObject<Item> COPPER_SHEARS = REGISTRY.register("copper_shears", () -> new ShearsItem( new Item.Properties().durability(182).tab(CreativeModeTab.TAB_TOOLS).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> COPPER_SHIELD = REGISTRY.register("copper_shield", () -> new ShieldItem( new Item.Properties().durability(255).tab(CreativeModeTab.TAB_TOOLS).rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> CUT_AMETHYST_BLOCK = REGISTRY.register("cut_amethyst_block", () -> new BlockItem(BlockRegistry.CUT_AMETHYST_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> POLISHED_AMETHYST_BLOCK = REGISTRY.register("polished_amethyst_block", () -> new BlockItem(BlockRegistry.POLISHED_AMETHYST_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> POLISHED_CUT_AMETHYST_BLOCK = REGISTRY.register("polished_cut_amethyst_block", () -> new BlockItem(BlockRegistry.POLISHED_CUT_AMETHYST_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
}
