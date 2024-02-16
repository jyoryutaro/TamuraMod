package com.Tamura.TamuraMod.world.item;

import com.Tamura.TamuraMod.TamuraMod;
import com.Tamura.TamuraMod.world.level.block.TamuraModBlocks;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TamuraModItems {
    public static final DeferredRegister<Item> ITEMS =//finalはクラスないの定数のことを指すらしい.書き換えできないということ
            DeferredRegister.create(ForgeRegistries.ITEMS, TamuraMod.MOD_ID);//アイテムの登録先

    public static final RegistryObject<Item> TAMURA_GALLSTONE =
            ITEMS.register("tamura_gallstone", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TAMURA_GALLSTONE_ORE =
            ITEMS.register("tamura_gallstone_ore", () -> new BlockItem(TamuraModBlocks.TAMURA_GALLSTONE_ORE.get()//自作ブロックにはget()がいるらしい
                    ,new Item.Properties()));

    public static final RegistryObject<Item> TAMURA_SPINALCORD_PICKAXE =
            ITEMS.register("tamura_spinalcord_pickaxe",
                    () -> new PickaxeItem(TamuraModTiers.TAMURA_GALLSTONE,1,-1.0F,
                            new Item.Properties()));


    public static final RegistryObject<Item> TAMURA_SPINALCORD_SWORD =
            ITEMS.register("tamura_spinalcord_sword",
                    () -> new TamuraSpinalCordSword(new Item.Properties()));



}
