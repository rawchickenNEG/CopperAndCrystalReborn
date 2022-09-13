package io.github.rawchickenneg.copperandcrystalreborn.common.registry;

import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import io.github.rawchickenneg.copperandcrystalreborn.Cacr;
import io.github.rawchickenneg.copperandcrystalreborn.client.render.CacrModelBakery;
import io.github.rawchickenneg.copperandcrystalreborn.common.item.CacrShieldItem;
import io.github.rawchickenneg.copperandcrystalreborn.common.item.GildedNetheriteArmorItem;
import io.github.rawchickenneg.copperandcrystalreborn.common.item.PaxelItem;
import io.github.rawchickenneg.copperandcrystalreborn.common.item.constant.CacrArmorMaterials;
import io.github.rawchickenneg.copperandcrystalreborn.common.item.constant.CacrTiers;
import io.github.rawchickenneg.copperandcrystalreborn.common.item.crafting.CacrShieldDecorationRecipe;
import io.github.rawchickenneg.copperandcrystalreborn.common.tag.CacrItemTags;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SpecialRecipeBuilder;
import net.minecraft.data.recipes.UpgradeRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;

public class CacrItems {
    
    private static final CacrRegistrate REGISTRATE = Cacr.REGISTRATE.get().creativeModeTab(() -> CreativeModeTab.TAB_MISC);
    
    //No EnumMap here because of its improper ordering
    public static final List<Pair<EquipmentSlot, String>> ARMOR_SUFFIXES = new LinkedList<>() {{
        add(Pair.of(EquipmentSlot.HEAD, "helmet"));
        add(Pair.of(EquipmentSlot.CHEST, "chestplate"));
        add(Pair.of(EquipmentSlot.LEGS, "leggings"));
        add(Pair.of(EquipmentSlot.FEET, "boots"));
    }};
    
    public static final ItemEntry<ShearsItem> COPPER_SHEARS = REGISTRATE.item("copper_shears", ShearsItem::new)
        .initialProperties(() -> new Item.Properties().durability(182))
        .properties(prop -> prop.tab(CreativeModeTab.TAB_TOOLS))
        .tag(CacrItemTags.TOOLS$SHEARS.tag)
        .recipe((ctx, prov) -> {
            DataIngredient c = DataIngredient.tag(CacrItemTags.INGOTS$COPPER.tag);
            ShapedRecipeBuilder.shaped(ctx.get())
                .define('c', c)
                .pattern("c ").pattern(" c")
                .unlockedBy("has_" + prov.safeName(c), c.getCritereon(prov))
                .save(prov, prov.safeId(ctx.getId()));
        })
        .register();
    
    public static final ItemEntry<CacrShieldItem> COPPER_SHIELD = REGISTRATE.item("copper_shield", CacrShieldItem::new)
        .initialProperties(() -> new Item.Properties().durability(255))
        .properties(prop -> prop.tab(CreativeModeTab.TAB_COMBAT))
        .tag(CacrItemTags.SHIELDS.tag)
        .recipe((ctx, prov) -> {
            DataIngredient c = DataIngredient.tag(CacrItemTags.INGOTS$COPPER.tag);
            DataIngredient p = DataIngredient.tag(ItemTags.PLANKS);
            ShapedRecipeBuilder.shaped(ctx.get())
                .define('c', c).define('p', p)
                .pattern("pcp").pattern("ppp").pattern(" p ")
                .unlockedBy("has_" + prov.safeName(c), c.getCritereon(prov))
                .unlockedBy("has_planks", p.getCritereon(prov))
                .save(prov, prov.safeId(ctx.getId()));
        })
        .model(NonNullBiConsumer.noop())
        .onRegister(shield -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> CacrModelBakery.registerShieldMaterial(shield)))
        .register();
    
    public static final ItemEntry<SwordItem> AMETHYST_SWORD =
        sword("amethyst", CacrTiers.AMETHYST, () -> Items.AMETHYST_BLOCK, null).register();
    
    public static final ItemEntry<ShovelItem> AMETHYST_SHOVEL =
        shovel("amethyst", CacrTiers.AMETHYST, () -> Items.AMETHYST_BLOCK, null).register();
    
    public static final ItemEntry<PickaxeItem> AMETHYST_PICKAXE =
        pickaxe("amethyst", CacrTiers.AMETHYST, () -> Items.AMETHYST_BLOCK, null).register();
    
    public static final ItemEntry<AxeItem> AMETHYST_AXE =
        axe("amethyst", CacrTiers.AMETHYST, 4, -3.1F, () -> Items.AMETHYST_BLOCK, null).register();
    
    public static final ItemEntry<HoeItem> AMETHYST_HOE =
        hoe("amethyst", CacrTiers.AMETHYST, -2, -1F, () -> Items.AMETHYST_BLOCK, null).register();
    
    public static final ItemEntry<PaxelItem> AMETHYST_PAXEL =
        paxel("amethyst", CacrTiers.AMETHYST, 4, -3.1F, AMETHYST_SHOVEL, AMETHYST_PICKAXE, AMETHYST_AXE, () -> Items.AMETHYST_BLOCK, null).register();
    
    public static EnumMap<EquipmentSlot, ItemEntry<ArmorItem>> AMETHYST_ARMORS =
        armors(CacrArmorMaterials.AMETHYST, () -> Blocks.AMETHYST_BLOCK);
    
    public static final ItemEntry<Item> OBSIDIAN_COMPOUND = material("obsidian_compound")
        .recipe((ctx, prov) -> {
            DataIngredient obsidian = DataIngredient.items(Items.OBSIDIAN);
            DataIngredient chorus = DataIngredient.items(Items.POPPED_CHORUS_FRUIT);
            DataIngredient amethyst = DataIngredient.items(Items.AMETHYST_SHARD);
            ShapelessRecipeBuilder.shapeless(ctx.get()).requires(obsidian).requires(chorus, 2).requires(amethyst)
                .unlockedBy("has_" + prov.safeName(obsidian), obsidian.getCritereon(prov))
                .unlockedBy("has_" + prov.safeName(chorus), chorus.getCritereon(prov))
                .unlockedBy("has_" + prov.safeName(amethyst), amethyst.getCritereon(prov))
                .save(prov, prov.safeId(ctx.getId()));
        })
        .register();
    
    public static final ItemEntry<Item> OBSIDIAN_STEEL_INGOT = ingot("obsidian_steel")
        .recipe((ctx, prov) -> {
            DataIngredient compound = DataIngredient.items(OBSIDIAN_COMPOUND);
            prov.blasting(compound, ctx, 4, 400);
            prov.smelting(compound, ctx, 4, 800);
        })
        .register();
    
    public static final ItemEntry<SwordItem> OBSIDIAN_STEEL_SWORD =
        sword("obsidian_steel", CacrTiers.OBSIDIAN_STEEL, OBSIDIAN_STEEL_INGOT, null).register();
    
    public static final ItemEntry<ShovelItem> OBSIDIAN_STEEL_SHOVEL =
        shovel("obsidian_steel", CacrTiers.OBSIDIAN_STEEL, OBSIDIAN_STEEL_INGOT, null).register();
    
    public static final ItemEntry<PickaxeItem> OBSIDIAN_STEEL_PICKAXE =
        pickaxe("obsidian_steel", CacrTiers.OBSIDIAN_STEEL, OBSIDIAN_STEEL_INGOT, null).register();
    
    public static final ItemEntry<AxeItem> OBSIDIAN_STEEL_AXE =
        axe("obsidian_steel", CacrTiers.OBSIDIAN_STEEL, 4, -3.1F, OBSIDIAN_STEEL_INGOT, null).register();
    
    public static final ItemEntry<HoeItem> OBSIDIAN_STEEL_HOE =
        hoe("obsidian_steel", CacrTiers.OBSIDIAN_STEEL, -2, -1F, OBSIDIAN_STEEL_INGOT, null).register();
    
    public static EnumMap<EquipmentSlot, ItemEntry<ArmorItem>> OBSIDIAN_STEEL_ARMORS =
        armors(CacrArmorMaterials.OBSIDIAN_STEEL, OBSIDIAN_STEEL_INGOT);
    
    public static EnumMap<EquipmentSlot, ItemEntry<GildedNetheriteArmorItem>> GILDED_NETHERITE_ARMORS = new EnumMap<>(EquipmentSlot.class) {{
        for(var entry : ARMOR_SUFFIXES) {
            EquipmentSlot slot = entry.getKey();
            put(slot, REGISTRATE
                .item("gilded_netherite_" + entry.getValue(),
                    prop -> new GildedNetheriteArmorItem(CacrArmorMaterials.GILDED_NETHERITE, slot, prop))
                .properties(prop -> prop.tab(CreativeModeTab.TAB_COMBAT))
                .recipe((ctx, prov) -> {
                    DataIngredient armor = switch(slot) {
                        case HEAD -> DataIngredient.items(Items.NETHERITE_HELMET);
                        case CHEST -> DataIngredient.items(Items.NETHERITE_CHESTPLATE);
                        case FEET -> DataIngredient.items(Items.NETHERITE_LEGGINGS);
                        case LEGS -> DataIngredient.items(Items.NETHERITE_BOOTS);
                        default -> throw new RuntimeException();
                    };
                    UpgradeRecipeBuilder.smithing(armor, Ingredient.of(Items.GOLD_INGOT), ctx.get())
                        .unlocks("has_" + prov.safeName(armor), armor.getCritereon(prov))
                        .save(prov, prov.safeId(ctx.getId()));
                })
                .register()
            );
        }
    }};
    
    
    public static void registerAll() {
        CacrItemTags.registerAll();
        REGISTRATE.addDataGenerator(ProviderType.RECIPE, prov -> SpecialRecipeBuilder
            .special(CacrShieldDecorationRecipe.SERIALIZER.get())
            .save(prov, Cacr.asResource("shield_decoration").toString())
        );
    }
    
    /**
     * Creates a material item, will be put into {@link CreativeModeTab#TAB_MATERIALS}.
     * @param name The name of the item.
     * @return An {@link ItemBuilder} for further modifications.
     */
    private static ItemBuilder<Item, CacrRegistrate> material(String name) {
        return REGISTRATE.item(name, Item::new).properties(properties -> properties.tab(CreativeModeTab.TAB_MATERIALS));
    }
    
    /**
     * Creates an ingot item, will be put into {@link CreativeModeTab#TAB_MATERIALS} and generate related forge tags.
     * @param name The name of the ingot, will be automatically suffixed with "_ingot".
     * @return An {@link ItemBuilder} for further modifications.
     */
    private static ItemBuilder<Item, CacrRegistrate> ingot(String name) {
        TagKey<Item> ingotTag = CacrItemTags.forge("ingots/" + name);
        REGISTRATE.itemTagFromTags(CacrItemTags.INGOTS.tag, ingotTag);
        return material(name + "_ingot").tag(ingotTag);
    }
    
    /**
     * Creates a standard sword item, will be put into {@link CreativeModeTab#TAB_COMBAT} and generate related forge tags.
     * @param name The name of the sword, will be automatically suffixed with "_sword".
     * @param tier The tier of the sword.
     * @param damageModifier The damage modifier of the sword.
     * @param attackSpeedModifier The attack speed modifier of the sword.
     * @param material The item that will be used in the sword's recipe (for the main part). <br>
     *                 If null, no recipes would be generated.
     * @param handle The item that will be used in the sword's recipe (for the handle part). <br>
     *               If null, will be using {@link Items#STICK} instead.
     * @return An {@link ItemBuilder} for further modifications.
     */
    private static <T extends ItemLike & IForgeRegistryEntry<?>> ItemBuilder<SwordItem, CacrRegistrate> sword(
        String name,
        Tier tier,
        int damageModifier,
        float attackSpeedModifier,
        @Nullable NonNullSupplier<? extends T> material,
        @Nullable NonNullSupplier<? extends T> handle)
    {
        var builder = REGISTRATE.item(name + "_sword", prop -> new SwordItem(tier, damageModifier, attackSpeedModifier, prop))
            .properties(properties -> properties.tab(CreativeModeTab.TAB_COMBAT))
            .tag(CacrItemTags.TOOLS$SWORDS.tag)
            .model((ctx, prov) -> prov.handheld(ctx));
        if(material == null) return builder;
        return builder.recipe((ctx, prov) -> {
            DataIngredient m = DataIngredient.items(material);
            DataIngredient h = handle == null ? DataIngredient.items(Items.STICK) : DataIngredient.items(handle);
            ShapedRecipeBuilder.shaped(ctx.get())
                    .define('m', m).define('h', h)
                    .pattern(" m ").pattern(" m ").pattern(" h ")
                    .unlockedBy("has_" + prov.safeName(m), m.getCritereon(prov))
                    .unlockedBy("has_" + prov.safeName(h), h.getCritereon(prov))
                    .save(prov, prov.safeId(ctx.getId()));
        });
    }
    
    /**
     * Delegating method for {@link CacrItems#sword(String, Tier, int, float, NonNullSupplier, NonNullSupplier)}. <br>
     * Uses the vanilla default damage and attack speed modifiers.
     */
    private static <T extends ItemLike & IForgeRegistryEntry<?>> ItemBuilder<SwordItem, CacrRegistrate> sword(
        String name,
        Tier tier,
        @Nullable NonNullSupplier<? extends T> material,
        @Nullable NonNullSupplier<? extends T> handle)
    {
        return sword(name, tier, 3, -2.4F, material, handle);
    }
    
    /**
     * Creates a standard shovel item, will be put into {@link CreativeModeTab#TAB_TOOLS} and generate related forge tags.
     * @param name The name of the shovel, will be automatically suffixed with "_shovel".
     * @param tier The tier of the shovel.
     * @param damageModifier The damage modifier of the shovel.
     * @param attackSpeedModifier The attack speed modifier of the shovel.
     * @param material The item that will be used in the shovel's recipe (for the main part). <br>
     *                 If null, no recipes would be generated.
     * @param handle The item that will be used in the shovel's recipe (for the handle part). <br>
     *               If null, will be using {@link Items#STICK} instead.
     * @return An {@link ItemBuilder} for further modifications.
     */
    private static <T extends ItemLike & IForgeRegistryEntry<?>> ItemBuilder<ShovelItem, CacrRegistrate> shovel(
        String name,
        Tier tier,
        float damageModifier,
        float attackSpeedModifier,
        @Nullable NonNullSupplier<? extends T> material,
        @Nullable NonNullSupplier<? extends T> handle)
    {
        var builder = REGISTRATE.item(name + "_shovel", prop -> new ShovelItem(tier, damageModifier, attackSpeedModifier, prop))
            .properties(properties -> properties.tab(CreativeModeTab.TAB_TOOLS))
            .tag(CacrItemTags.TOOLS$SHOVELS.tag)
            .model((ctx, prov) -> prov.handheld(ctx));
        if(material == null) return builder;
        return builder.recipe((ctx, prov) -> {
            DataIngredient m = DataIngredient.items(material);
            DataIngredient h = handle == null ? DataIngredient.items(Items.STICK) : DataIngredient.items(handle);
            ShapedRecipeBuilder.shaped(ctx.get())
                .define('m', m).define('h', h)
                .pattern(" m ").pattern(" h ").pattern(" h ")
                .unlockedBy("has_" + prov.safeName(m), m.getCritereon(prov))
                .unlockedBy("has_" + prov.safeName(h), h.getCritereon(prov))
                .save(prov, prov.safeId(ctx.getId()));
        });
    }
    
    /**
     * Delegating method for {@link CacrItems#shovel(String, Tier, float, float, NonNullSupplier, NonNullSupplier)}. <br>
     * Uses the vanilla default damage and attack speed modifiers.
     */
    private static <T extends ItemLike & IForgeRegistryEntry<?>> ItemBuilder<ShovelItem, CacrRegistrate> shovel(
        String name,
        Tier tier,
        @Nullable NonNullSupplier<? extends T> material,
        @Nullable NonNullSupplier<? extends T> handle)
    {
        return shovel(name, tier, 1.5F, -3.0F, material, handle);
    }
    
    /**
     * Creates a standard pickaxe item, will be put into {@link CreativeModeTab#TAB_TOOLS} and generate related forge tags.
     * @param name The name of the pickaxe, will be automatically suffixed with "_pickaxe".
     * @param tier The tier of the pickaxe.
     * @param damageModifier The damage modifier of the pickaxe.
     * @param attackSpeedModifier The attack speed modifier of the pickaxe.
     * @param material The item that will be used in the pickaxe's recipe (for the main part). <br>
     *                 If null, no recipes would be generated.
     * @param handle The item that will be used in the pickaxe's recipe (for the handle part). <br>
     *               If null, will be using {@link Items#STICK} instead.
     * @return An {@link ItemBuilder} for further modifications.
     */
    private static <T extends ItemLike & IForgeRegistryEntry<?>> ItemBuilder<PickaxeItem, CacrRegistrate> pickaxe(
        String name,
        Tier tier,
        int damageModifier,
        float attackSpeedModifier,
        @Nullable NonNullSupplier<? extends T> material,
        @Nullable NonNullSupplier<? extends T> handle)
    {
        var builder = REGISTRATE.item(name + "_pickaxe", prop -> new PickaxeItem(tier, damageModifier, attackSpeedModifier, prop))
            .properties(properties -> properties.tab(CreativeModeTab.TAB_TOOLS))
            .tag(CacrItemTags.TOOLS$PICKAXES.tag)
            .model((ctx, prov) -> prov.handheld(ctx));
        if(material == null) return builder;
        return builder.recipe((ctx, prov) -> {
            DataIngredient m = DataIngredient.items(material);
            DataIngredient h = handle == null ? DataIngredient.items(Items.STICK) : DataIngredient.items(handle);
            ShapedRecipeBuilder.shaped(ctx.get())
                .define('m', m).define('h', h)
                .pattern("mmm").pattern(" h ").pattern(" h ")
                .unlockedBy("has_" + prov.safeName(m), m.getCritereon(prov))
                .unlockedBy("has_" + prov.safeName(h), h.getCritereon(prov))
                .save(prov, prov.safeId(ctx.getId()));
        });
    }
    
    /**
     * Delegating method for {@link CacrItems#pickaxe(String, Tier, int, float, NonNullSupplier, NonNullSupplier)}. <br>
     * Uses the vanilla default damage and attack speed modifiers.
     */
    private static <T extends ItemLike & IForgeRegistryEntry<?>> ItemBuilder<PickaxeItem, CacrRegistrate> pickaxe(
        String name,
        Tier tier,
        @Nullable NonNullSupplier<? extends T> material,
        @Nullable NonNullSupplier<? extends T> handle)
    {
        return pickaxe(name, tier, 1, -2.8F, material, handle);
    }
    
    /**
     * Creates a standard axe item, will be put into {@link CreativeModeTab#TAB_TOOLS} and generate related forge tags.
     * @param name The name of the axe, will be automatically suffixed with "_axe".
     * @param tier The tier of the axe.
     * @param damageModifier The damage modifier of the axe.
     * @param attackSpeedModifier The attack speed modifier of the axe.
     * @param material The item that will be used in the axe's recipe (for the main part). <br>
     *                 If null, no recipes would be generated.
     * @param handle The item that will be used in the axe's recipe (for the handle part). <br>
     *               If null, will be using {@link Items#STICK} instead.
     * @return An {@link ItemBuilder} for further modifications.
     */
    private static <T extends ItemLike & IForgeRegistryEntry<?>> ItemBuilder<AxeItem, CacrRegistrate> axe(
        String name,
        Tier tier,
        float damageModifier,
        float attackSpeedModifier,
        @Nullable NonNullSupplier<? extends T> material,
        @Nullable NonNullSupplier<? extends T> handle)
    {
        var builder = REGISTRATE.item(name + "_axe", prop -> new AxeItem(tier, damageModifier, attackSpeedModifier, prop))
            .properties(properties -> properties.tab(CreativeModeTab.TAB_TOOLS))
            .tag(CacrItemTags.TOOLS$AXES.tag)
            .model((ctx, prov) -> prov.handheld(ctx));
        if(material == null) return builder;
        return builder.recipe((ctx, prov) -> {
            DataIngredient m = DataIngredient.items(material);
            DataIngredient h = handle == null ? DataIngredient.items(Items.STICK) : DataIngredient.items(handle);
            ShapedRecipeBuilder.shaped(ctx.get())
                .define('m', m).define('h', h)
                .pattern("mm ").pattern("mh ").pattern(" h ")
                .unlockedBy("has_" + prov.safeName(m), m.getCritereon(prov))
                .unlockedBy("has_" + prov.safeName(h), h.getCritereon(prov))
                .save(prov, prov.safeId(ctx.getId()));
        });
    }
    
    /**
     * Creates a standard hoe item, will be put into {@link CreativeModeTab#TAB_TOOLS} and generate related forge tags.
     * @param name The name of the hoe, will be automatically suffixed with "_hoe".
     * @param tier The tier of the hoe.
     * @param damageModifier The damage modifier of the hoe.
     * @param attackSpeedModifier The attack speed modifier of the hoe.
     * @param material The item that will be used in the hoe's recipe (for the main part). <br>
     *                 If null, no recipes would be generated.
     * @param handle The item that will be used in the hoe's recipe (for the handle part). <br>
     *               If null, will be using {@link Items#STICK} instead.
     * @return An {@link ItemBuilder} for further modifications.
     */
    private static <T extends ItemLike & IForgeRegistryEntry<?>> ItemBuilder<HoeItem, CacrRegistrate> hoe(
        String name,
        Tier tier,
        int damageModifier,
        float attackSpeedModifier,
        @Nullable NonNullSupplier<? extends T> material,
        @Nullable NonNullSupplier<? extends T> handle)
    {
        var builder = REGISTRATE.item(name + "_hoe", prop -> new HoeItem(tier, damageModifier, attackSpeedModifier, prop))
            .properties(properties -> properties.tab(CreativeModeTab.TAB_TOOLS))
            .tag(CacrItemTags.TOOLS$HOES.tag)
            .model((ctx, prov) -> prov.handheld(ctx));
        if(material == null) return builder;
        return builder.recipe((ctx, prov) -> {
            DataIngredient m = DataIngredient.items(material);
            DataIngredient h = handle == null ? DataIngredient.items(Items.STICK) : DataIngredient.items(handle);
            ShapedRecipeBuilder.shaped(ctx.get())
                .define('m', m).define('h', h)
                .pattern("mm ").pattern(" h ").pattern(" h ")
                .unlockedBy("has_" + prov.safeName(m), m.getCritereon(prov))
                .unlockedBy("has_" + prov.safeName(h), h.getCritereon(prov))
                .save(prov, prov.safeId(ctx.getId()));
        });
    }
    
    /**
     * Creates a standard paxel item, will be put into {@link CreativeModeTab#TAB_TOOLS} and generate related forge tags.
     * @param name The name of the paxel, will be automatically suffixed with "_paxel".
     * @param tier The tier of the paxel.
     * @param damageModifier The damage modifier of the paxel.
     * @param attackSpeedModifier The attack speed modifier of the paxel.
     * @param material The item that will be used in the paxel's recipe (for the main part). <br>
     *                 If null, no recipes would be generated.
     * @param handle The item that will be used in the paxel's recipe (for the handle part). <br>
     *               If null, will be using {@link Items#STICK} instead.
     * @return An {@link ItemBuilder} for further modifications.
     */
    private static <T extends ItemLike & IForgeRegistryEntry<?>> ItemBuilder<PaxelItem, CacrRegistrate> paxel(
        String name,
        Tier tier,
        int damageModifier,
        float attackSpeedModifier,
        NonNullSupplier<? extends ShovelItem> shovel,
        NonNullSupplier<? extends PickaxeItem> pickaxe,
        NonNullSupplier<? extends AxeItem> axe,
        @Nullable NonNullSupplier<? extends T> material,
        @Nullable NonNullSupplier<? extends T> handle
    ) {
        var builder = REGISTRATE.item(name + "_paxel", prop -> new PaxelItem(
            tier, damageModifier, attackSpeedModifier, prop, shovel, pickaxe, axe))
            .properties(prop -> prop.tab(CreativeModeTab.TAB_TOOLS))
            .tag(CacrItemTags.TOOLS$PAXELS.tag)
            .model((ctx, prov) -> prov.handheld(ctx));
        if(material == null) return builder;
        return builder.recipe((ctx, prov) -> {
            DataIngredient m = DataIngredient.items(material);
            DataIngredient h = handle == null ? DataIngredient.items(Items.STICK) : DataIngredient.items(handle);
            ShapedRecipeBuilder.shaped(ctx.get())
                .define('m', m).define('h', h)
                .pattern("mmm").pattern("mh ").pattern(" h ")
                .unlockedBy("has_" + prov.safeName(m), m.getCritereon(prov))
                .unlockedBy("has_" + prov.safeName(h), h.getCritereon(prov))
                .save(prov, prov.safeId(ctx.getId()));
        });
    }
    
    /**
     * Creates a set of armor from {@link ArmorMaterial}
     * @param armorMaterial The armors' material and where armors should inherit their names from.
     * @param material The item that will be used in the armor's recipe.
     * @return An {@link EnumMap} containing the armor item entries.
     */
    private static <T extends ItemLike & IForgeRegistryEntry<?>> EnumMap<EquipmentSlot, ItemEntry<ArmorItem>> armors(
        ArmorMaterial armorMaterial,
        NonNullSupplier<? extends T> material)
    {
        EnumMap<EquipmentSlot, ItemEntry<ArmorItem>> map = new EnumMap<>(EquipmentSlot.class);
        for(var entry : ARMOR_SUFFIXES) {
            EquipmentSlot slot = entry.getKey();
            map.put(slot, REGISTRATE
                .item(armorMaterial.getName() + "_" + entry.getValue(),
                    prop -> new ArmorItem(armorMaterial, slot, prop))
                .properties(prop -> prop.tab(CreativeModeTab.TAB_COMBAT))
                .recipe((ctx, prov) -> {
                    DataIngredient m = DataIngredient.items(material);
                    ShapedRecipeBuilder builder = ShapedRecipeBuilder.shaped(ctx.get()).define('m', m);
                    switch(slot) {
                        case HEAD -> builder.pattern("mmm").pattern("m m");
                        case CHEST -> builder.pattern("m m").pattern("mmm").pattern("mmm");
                        case LEGS -> builder.pattern("mmm").pattern("m m").pattern("m m");
                        case FEET -> builder.pattern("m m").pattern("m m");
                    }
                    builder
                        .unlockedBy("has_" + prov.safeName(m), m.getCritereon(prov))
                        .save(prov, prov.safeId(ctx.getId()));
                }).register()
            );
        }
        return map;
    }
    
}