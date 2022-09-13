package io.github.rawchickenneg.copperandcrystalreborn.common.registry;

import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import io.github.rawchickenneg.copperandcrystalreborn.Cacr;
import io.github.rawchickenneg.copperandcrystalreborn.common.tag.CacrBlockTags;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;

public class CacrBlocks {
    
    private static final CacrRegistrate REGISTRATE = Cacr.REGISTRATE.get()
        .creativeModeTab(() -> CreativeModeTab.TAB_BUILDING_BLOCKS);
    
    public static final BlockEntry<SlabBlock> AMETHYST_SLAB = slab("amethyst",
        () -> Blocks.AMETHYST_BLOCK,
        BlockTags.MINEABLE_WITH_PICKAXE,
        Set.of(() -> Blocks.AMETHYST_BLOCK)
    ).build().register();
    
    public static final BlockEntry<StairBlock> AMETHYST_STAIRS = stair("amethyst",
        () -> Blocks.AMETHYST_BLOCK,
        BlockTags.MINEABLE_WITH_PICKAXE,
        Set.of(() -> Blocks.AMETHYST_BLOCK)
    ).build().register();
    
    public static final BlockEntry<WallBlock> AMETHYST_WALL = wall("amethyst",
        () -> Blocks.AMETHYST_BLOCK,
        BlockTags.MINEABLE_WITH_PICKAXE,
        Set.of(() -> Blocks.AMETHYST_BLOCK)
    ).build().register();
    
    public static final BlockEntry<Block> CUT_AMETHYST_BLOCK = REGISTRATE.block("cut_amethyst_block", Block::new)
        .initialProperties(() -> Blocks.AMETHYST_BLOCK)
        .properties(p -> p.requiresCorrectToolForDrops())
        .tag(BlockTags.MINEABLE_WITH_PICKAXE)
        .simpleItem()
        .register();
    
    public static final BlockEntry<SlabBlock> CUT_AMETHYST_SLAB = slab("cut_amethyst",
        CUT_AMETHYST_BLOCK,
        BlockTags.MINEABLE_WITH_PICKAXE,
        Set.of(
            () -> Blocks.AMETHYST_BLOCK,
            CUT_AMETHYST_BLOCK
        )).build().register();
    
    public static final BlockEntry<StairBlock> CUT_AMETHYST_STAIRS = stair("cut_amethyst",
        CUT_AMETHYST_BLOCK,
        BlockTags.MINEABLE_WITH_PICKAXE,
        Set.of(
            () -> Blocks.AMETHYST_BLOCK,
            CUT_AMETHYST_BLOCK
        )).build().register();
    
    public static final BlockEntry<WallBlock> CUT_AMETHYST_WALL = wall("cut_amethyst",
        CUT_AMETHYST_BLOCK,
        BlockTags.MINEABLE_WITH_PICKAXE,
        Set.of(
            () -> Blocks.AMETHYST_BLOCK,
            CUT_AMETHYST_BLOCK
        )).build().register();
    
    public static final BlockEntry<Block> POLISHED_AMETHYST_BLOCK = REGISTRATE.block("polished_amethyst_block", Block::new)
        .initialProperties(() -> Blocks.AMETHYST_BLOCK)
        .properties(p -> p.requiresCorrectToolForDrops())
        .tag(BlockTags.MINEABLE_WITH_PICKAXE)
        .simpleItem()
        .register();
    
    public static final BlockEntry<SlabBlock> POLISHED_AMETHYST_SLAB = slab("polished_amethyst",
        POLISHED_AMETHYST_BLOCK,
        BlockTags.MINEABLE_WITH_PICKAXE,
        Set.of(
            () -> Blocks.AMETHYST_BLOCK,
            POLISHED_AMETHYST_BLOCK
        )).build().register();
    
    public static final BlockEntry<StairBlock> POLISHED_AMETHYST_STAIRS = stair("polished_amethyst",
        POLISHED_AMETHYST_BLOCK,
        BlockTags.MINEABLE_WITH_PICKAXE,
        Set.of(
            () -> Blocks.AMETHYST_BLOCK,
            POLISHED_AMETHYST_BLOCK
        )).build().register();
    
    public static final BlockEntry<WallBlock> POLISHED_AMETHYST_WALL = wall("polished_amethyst",
        POLISHED_AMETHYST_BLOCK,
        BlockTags.MINEABLE_WITH_PICKAXE,
        Set.of(
            () -> Blocks.AMETHYST_BLOCK,
            POLISHED_AMETHYST_BLOCK
        )).build().register();
    
    public static final BlockEntry<Block> POLISHED_CUT_AMETHYST_BLOCK = REGISTRATE.block("polished_cut_amethyst_block", Block::new)
        .initialProperties(() -> Blocks.AMETHYST_BLOCK)
        .properties(p -> p.requiresCorrectToolForDrops())
        .tag(BlockTags.MINEABLE_WITH_PICKAXE)
        .simpleItem()
        .register();
    
    public static final BlockEntry<SlabBlock> POLISHED_CUT_AMETHYST_SLAB = slab("polished_cut_amethyst",
        POLISHED_CUT_AMETHYST_BLOCK,
        BlockTags.MINEABLE_WITH_PICKAXE,
        Set.of(
            () -> Blocks.AMETHYST_BLOCK,
            POLISHED_AMETHYST_BLOCK,
            CUT_AMETHYST_BLOCK,
            POLISHED_CUT_AMETHYST_BLOCK
        )).build().register();
    
    public static final BlockEntry<StairBlock> POLISHED_CUT_AMETHYST_STAIRS = stair("polished_cut_amethyst",
        POLISHED_CUT_AMETHYST_BLOCK,
        BlockTags.MINEABLE_WITH_PICKAXE,
        Set.of(
            () -> Blocks.AMETHYST_BLOCK,
            POLISHED_AMETHYST_BLOCK,
            CUT_AMETHYST_BLOCK,
            POLISHED_CUT_AMETHYST_BLOCK
        )).build().register();
    
    public static final BlockEntry<WallBlock> POLISHED_CUT_AMETHYST_WALL = wall("polished_cut_amethyst",
        POLISHED_CUT_AMETHYST_BLOCK,
        BlockTags.MINEABLE_WITH_PICKAXE,
        Set.of(
            () -> Blocks.AMETHYST_BLOCK,
            POLISHED_AMETHYST_BLOCK,
            CUT_AMETHYST_BLOCK,
            POLISHED_CUT_AMETHYST_BLOCK
        )).build().register();
    
    public static void registerAll() {
        CacrBlockTags.registerAll();
    }
    
    /**
     * For parsing block's registry name to resource location in assets
     * @param block Supplier of the block, useful for {@link BlockEntry}
     * @return The block's registry name with a prefix "block/" in the path
     */
    private static ResourceLocation blockAssets(NonNullSupplier<? extends Block> block) {
        ResourceLocation loc = ForgeRegistries.BLOCKS.getKey(block.get());
        if(loc == null) throw new IllegalStateException("Found unregistered Block when parsing resource location.");
        return new ResourceLocation(loc.getNamespace(), "block/" + loc.getPath());
    }
    
    /**
     * Generates a builder of a {@link SlabBlock}.
     * @param name The slab block's name, will be automatically suffixed with "_slab".
     * @param baseBlock The base block of the slab block, should always be simple cube block, the slab block will inherit its properties and appearance.
     * @param mineableTag The mineable tag which the slab block belongs.
     * @param stoneCuttingIngredients Blocks to use in the slab block's stone cutting recipes.
     * @return An {@link ItemBuilder}, allowing further modification on the item and block.
     */
    private static ItemBuilder<BlockItem, BlockBuilder<SlabBlock, CacrRegistrate>> slab(
        String name,
        NonNullSupplier<Block> baseBlock,
        TagKey<Block> mineableTag,
        Set<NonNullSupplier<Block>> stoneCuttingIngredients
    ) {
        return REGISTRATE.block(name + "_slab", SlabBlock::new)
            .initialProperties(baseBlock)
            .tag(mineableTag, BlockTags.SLABS)
            .blockstate((ctx, prov) -> {
                String slabName = ctx.getName();
                ResourceLocation baseBlockLoc = blockAssets(baseBlock);
                ModelFile bottom = prov.models().slab(slabName, baseBlockLoc, baseBlockLoc, baseBlockLoc);
                ModelFile top = prov.models().slabTop(slabName + "_top", baseBlockLoc, baseBlockLoc, baseBlockLoc);
                ModelFile doubleSlab = prov.models().getExistingFile(baseBlockLoc);
                prov.slabBlock(ctx.get(), bottom, top, doubleSlab);
            })
            .loot((lt, block) -> lt.add(block, RegistrateBlockLootTables.createSlabItemTable(block)))
            .item()
            .tag(ItemTags.SLABS)
            .recipe((ctx, prov) -> {
                prov.slab(DataIngredient.items(baseBlock), ctx, ctx.getName(), false);
                for(var ingredient : stoneCuttingIngredients) {
                    prov.stonecutting(DataIngredient.items(ingredient), ctx, 2);
                }
            });
    }
    
    /**
     * Generates a builder of a {@link StairBlock}.
     * @param name The stairs block's name, will be automatically suffixed with "_stairs".
     * @param baseBlock The base block of the stairs block, should always be simple cube block, the stairs block will inherit its properties and look.
     * @param mineableTag The mineable tag which the stairs block belongs.
     * @param stoneCuttingIngredients Blocks to use in the stairs block's stone cutting recipes.
     * @return An {@link ItemBuilder}, allowing further modification on the item and block.
     */
    private static ItemBuilder<BlockItem, BlockBuilder<StairBlock, CacrRegistrate>> stair(
        String name,
        NonNullSupplier<Block> baseBlock,
        TagKey<Block> mineableTag,
        Set<NonNullSupplier<Block>> stoneCuttingIngredients
    ) {
        return REGISTRATE.block(name + "_stairs", prop -> new StairBlock(() -> baseBlock.get().defaultBlockState(), prop))
            .initialProperties(baseBlock)
            .tag(mineableTag, BlockTags.STAIRS)
            .blockstate((ctx, prov) -> prov.stairsBlock(ctx.getEntry(), blockAssets(baseBlock)))
            .item()
            .tag(ItemTags.STAIRS)
            .recipe((ctx, prov) -> {
                prov.stairs(DataIngredient.items(baseBlock), ctx, ctx.getName(), false);
                for(var ingredient : stoneCuttingIngredients) {
                    prov.stonecutting(DataIngredient.items(ingredient), ctx, 1);
                }
            });
    }
    
    /**
     * Generates a builder of a {@link WallBlock}
     * @param name The wall block's name, will be automatically suffixed with "_wall".
     * @param baseBlock The base block of the wall block, should always be simple cube block, the wall block will inherit its properties and look.
     * @param mineableTag The mineable tag which the wall block belongs.
     * @param stoneCuttingIngredients Blocks to use in the wall block's stone cutting recipes.
     * @return An {@link ItemBuilder}, allowing further modification on the item and block.
     */
    private static ItemBuilder<BlockItem, BlockBuilder<WallBlock, CacrRegistrate>> wall(
        String name,
        NonNullSupplier<Block> baseBlock,
        TagKey<Block> mineableTag,
        Set<NonNullSupplier<Block>> stoneCuttingIngredients
    ) {
        return REGISTRATE.block(name + "_wall", WallBlock::new)
            .initialProperties(baseBlock)
            .tag(mineableTag, BlockTags.WALLS)
            .blockstate((ctx, prov) -> prov.wallBlock(ctx.getEntry(), blockAssets(baseBlock)))
            .item()
            .tag(ItemTags.STAIRS)
            .recipe((ctx, prov) -> {
                DataIngredient baseIngredient = DataIngredient.items(baseBlock);
                ShapedRecipeBuilder.shaped(ctx.get(), 6)
                    .define('X', baseIngredient)
                    .pattern("XXX")
                    .pattern("XXX")
                    .unlockedBy("has_" + prov.safeName(baseIngredient), baseIngredient.getCritereon(prov))
                    .save(prov, prov.safeId(ctx.get()));
                for(var ingredient : stoneCuttingIngredients) {
                    prov.stonecutting(DataIngredient.items(ingredient), ctx, 1);
                }
            })
            .model((ctx, prov) -> prov.wallInventory(ctx.getName(), blockAssets(baseBlock)));
    }
    
}
