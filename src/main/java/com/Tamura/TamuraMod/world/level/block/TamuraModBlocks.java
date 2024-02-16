package com.Tamura.TamuraMod.world.level.block;

import com.Tamura.TamuraMod.TamuraMod;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TamuraModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TamuraMod.MOD_ID);

    public static final RegistryObject<Block> TAMURA_GALLSTONE_ORE =
            BLOCKS.register("tamura_gallstone_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.
                    of(Material.STONE)
                    .requiresCorrectToolForDrops()//ツールが必要かどうか
                    .strength(3.0f,3.0f)//硬さ,爆発強度
                    ,UniformInt.of(3,7)//ランダム経験値の範囲
            ));
}
