package io.github.rawchickenneg.copperandcrystalreborn.blocks;

import io.github.rawchickenneg.copperandcrystalreborn.CopperAndCrystalReborn;
import net.minecraft.world.level.block.Block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CopperAndCrystalReborn.MOD_ID);
    public static final RegistryObject<Block> CUT_AMETHYST_BLOCK = BLOCKS.register("cut_amethyst_block",
            () -> new Block((Block.Properties.copy(Blocks.AMETHYST_BLOCK))));
    public static final RegistryObject<Block> POLISHED_AMETHYST_BLOCK = BLOCKS.register("polished_amethyst_block",
            () -> new Block((Block.Properties.copy(Blocks.AMETHYST_BLOCK))));
    public static final RegistryObject<Block> POLISHED_CUT_AMETHYST_BLOCK = BLOCKS.register("polished_cut_amethyst_block",
            () -> new Block((Block.Properties.copy(Blocks.AMETHYST_BLOCK))));

}